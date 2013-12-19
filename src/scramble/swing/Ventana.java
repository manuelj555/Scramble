/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scramble.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import scramble.Presionable;
import scramble.Seleccion;
import scramble.bd.BdPalabras;
import scramble.swing.panel.Botones;
import scramble.swing.panel.Dados;
import scramble.swing.panel.PalabrasAcertadas;
import scramble.util.Utils;

/**
 *
 * @author Manuel Aguirre <programador.manuel@gmail.com>
 */
public class Ventana extends JFrame {

    private static final Logger LOG = Logger.getLogger(Dado.class.getName());
    protected Seleccion seleccion = new Seleccion();
    protected ArrayList<String> palabras = new ArrayList();
    protected ArrayList<Presionable> dados = new ArrayList(16);
    protected PalabrasAcertadas lateral = new PalabrasAcertadas();

    public Ventana() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponentes();
    }

    protected void initComponentes() {
        Container content = getContentPane();
        JPanel panelDados = new Dados(crearDados());
        Botones botones = new Botones();

        content.setLayout(new BorderLayout(5, 5));
        content.add(panelDados, BorderLayout.CENTER);
        content.add(botones, BorderLayout.SOUTH);
        content.add(lateral, BorderLayout.EAST);

        botones.setConfirmarClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nueva = seleccion.toString();
                if (seleccion.isUsable() && !palabras.contains(nueva) && BdPalabras.exists(nueva)) {
                    palabras.add(nueva);
                    lateral.addPalabra(nueva);
                } else {
                    LOG.log(Level.INFO, "Palabra no válida: {0}", nueva);
                }
                quitarSelecciones();
                seleccion.clear();
            }
        });

        botones.setCancelarClick(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion.clear();
                quitarSelecciones();
            }
        });

        setSize(500, 400);
        setVisible(true);
    }

    protected ArrayList<Presionable> crearDados() {

        dados.add(new Dado('A', 'B', 'C', 'D', 'E', 'F'));
        dados.add(new Dado('G', 'H', 'I', 'J', 'K', 'L'));
        dados.add(new Dado('M', 'N', 'Ñ', 'O', 'P', 'Q'));
        dados.add(new Dado('R', 'S', 'T', 'U', 'V', 'W'));
        dados.add(new Dado('X', 'Y', 'Z', 'A', 'E', 'I'));
        dados.add(new Dado('O', 'U', 'A', 'B', 'C', 'D'));
        dados.add(new Dado('E', 'F', 'G', 'H', 'I', 'J'));
        dados.add(new Dado('A', 'L', 'M', 'N', 'O', 'P'));
        dados.add(new Dado('A', 'R', 'S', 'T', 'U', 'V'));
        dados.add(new Dado('O', 'Y', 'Z', 'A', 'E', 'I'));
        dados.add(new Dado('O', 'U', 'A', 'B', 'C', 'D'));
        dados.add(new Dado('E', 'F', 'G', 'H', 'I', 'J'));
        dados.add(new Dado('E', 'L', 'M', 'N', 'O', 'P'));
        dados.add(new Dado('I', 'R', 'S', 'T', 'U', 'V'));
        dados.add(new Dado('A', 'Y', 'Z', 'A', 'B', 'C'));
        dados.add(new Dado('S', 'R', 'N', 'M', 'C', 'D'));

        Collections.shuffle(dados);

        MouseAdapter adaptador;
        adaptador = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Dado d = (Dado) e.getComponent();
                if (!d.isPresionado()) {
                    if (d.puedePresionarse(seleccion.getUltimo())) {//si lo podemos presionar
                        d.presionar();//lo presionamos
                        seleccion.add(d);
                        mostrarPresionables(d);
                    }
                } else if (d.equals(seleccion.getUltimo())) {
                    d.soltar();
                    seleccion.quitar(d);
                    mostrarPresionables(seleccion.getUltimo());
                }
                setTitle(seleccion.toString());
            }

        };

        for (Presionable d : dados) {
            d.setPosition(dados.indexOf(d) + 1);
            d.setClickListener(adaptador);
        }

        return dados;
    }

    protected void quitarSelecciones() {
        for (Presionable d : dados) {
            d.soltar();
        }
        setTitle(seleccion.toString());
    }

    protected void mostrarPresionables(Dado ultimo) {
        if (ultimo != null) {
            for (Presionable d : dados) {//recorremos todos los dados
                if (!d.equals(ultimo) && !d.isPresionado()) {
                    if (d.puedePresionarse(ultimo)) {//si puede presionarse
                        d.setPresionable();
                    } else {
                        d.soltar();
                    }
                }
            }
        }else{
            quitarSelecciones();
        }
    }

}
