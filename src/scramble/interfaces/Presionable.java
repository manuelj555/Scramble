/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scramble.interfaces;

import java.awt.event.MouseAdapter;

/**
 *
 * @author Manuel Aguirre <programador.manuel@gmail.com>
 */
public interface Presionable extends Posicionable{

    public boolean isPresionado();

    public boolean puedePresionarse(Presionable actualPresionado);

    public void presionar();

    public void soltar();
    
    public void setPresionable();
    public void setClickListener(MouseAdapter adapter);
}
