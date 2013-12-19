package scramble.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import scramble.Presionable;
import scramble.util.Utils;

/**
 *
 * @author Manuel Aguirre <programador.manuel@gmail.com>
 */
public class Dado extends JLabel implements Presionable {

    protected char letra;
    protected int pos;
    protected boolean presionado = false;

    public Dado(char l1, char l2, char l3, char l4, char l5, char l6) {
        super("");

        Font fuente = new Font("dados", Font.BOLD, 20);

        setFont(fuente);
        setBorder(LineBorder.createGrayLineBorder());
        setHorizontalAlignment(CENTER);
        setTextoAleatorio(l1, l2, l3, l4, l5, l6);
        setOpaque(true);
        estadoNormal();
    }

    protected void setTextoAleatorio(char l1, char l2, char l3, char l4, char l5, char l6) {

        char[] letras = new char[]{l1, l2, l3, l4, l5, l6};

        int index = new Random().nextInt(letras.length);

        setText(String.valueOf(letra = letras[index]));
    }

    public char getLetra() {
        return letra;
    }

    public boolean isPresionado() {
        return presionado;
    }

    public void setPresionado(boolean presionado) {
        this.presionado = presionado;
    }

    @Override
    public boolean puedePresionarse(Presionable actualPresionado) {

        if (isPresionado() || this.equals(actualPresionado)) {
            //si se encuentra presionado no se puede volver a presionar
            //o si es el mismo objeto
            return false;
        }

        if (actualPresionado == null) {
            return true;
        }

        for (int pos : Utils.getPosPresionables(actualPresionado)) {
            if (pos == getPosition()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int getPosition() {
        return pos;
    }

    public void estadoNormal() {
        setBackground(Color.decode("#E8F2DE"));
    }

    public void estadoPresionado() {
        setBackground(Color.decode("#B2C69D"));
    }

    public void estadoPresionable() {
    }

    @Override
    public void presionar() {
        estadoPresionado();
        setPresionado(true);
    }

    @Override
    public void soltar() {
        estadoNormal();
        setPresionado(false);
    }

    @Override
    public void setPosition(int pos) {
        this.pos = pos;
    }

    @Override
    public void setPresionable() {
        setBackground(Color.decode("#D1D1D1"));        
    }

    @Override
    public void setClickListener(MouseAdapter adapter) {
        this.addMouseListener(adapter);
    }

}
