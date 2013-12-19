/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scramble.swing.panel;

import java.awt.BorderLayout;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import scramble.util.Utils;

/**
 *
 * @author Manuel Aguirre <programador.manuel@gmail.com>
 */
public class PalabrasAcertadas extends JPanel {

    protected JList palabrasList = new JList();
    protected DefaultListModel<String> palabras = new DefaultListModel();
    protected JLabel totalPuntos = new JLabel("Total: 0");
    protected int acumulado = 0;

    public PalabrasAcertadas() {
        super(new BorderLayout(5, 5));

        palabrasList.setModel(this.palabras);

        add(new JLabel("Palabras Encontradas:"), BorderLayout.NORTH);
        add(palabrasList, BorderLayout.CENTER);
        add(totalPuntos, BorderLayout.SOUTH);
    }

    public void addPalabra(String palabra) {
        int valor = Utils.getPuntos(palabra);
        palabras.addElement(palabra + " (" + valor + ")");
        acumulado += valor;
        totalPuntos.setText("Total: " + acumulado);
    }
}
