/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scramble.swing.panel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Manuel Aguirre <programador.manuel@gmail.com>
 */
public class Botones extends JPanel {

    protected JButton confirmar = new JButton("Confirmar");
    protected JButton cancelar = new JButton("Cancelar");

    public Botones() {
        super(new GridLayout());

        add(confirmar);
        add(cancelar);
    }

    public void setConfirmarClick(ActionListener listener) {
        confirmar.addActionListener(listener);
    }

    public void setCancelarClick(ActionListener listener) {
        cancelar.addActionListener(listener);
    }

}
