/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scramble.swing.panel;

import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import scramble.Presionable;
import scramble.swing.Dado;

/**
 *
 * @author Manuel Aguirre <programador.manuel@gmail.com>
 */
public class Dados extends JPanel {

    public Dados(List<Presionable> dados) {
        super(new GridLayout(4, 4));

        for (Presionable d : dados) {
            add((Dado) d);
        }
    }

}
