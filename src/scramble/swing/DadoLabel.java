package scramble.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import scramble.interfaces.Dado;
import scramble.interfaces.Posicionable;
import scramble.interfaces.Presionable;
import scramble.util.Utils;

/**
 *
 * @author Manuel Aguirre <programador.manuel@gmail.com>
 */
public class DadoLabel extends JLabel implements Dado {

    protected char letra;
    protected int position;
    protected boolean presionado = false;
    protected char[] letras;

    public DadoLabel(char l1, char l2, char l3, char l4, char l5, char l6) {
        super("");
        
        letras = new char[]{l1, l2, l3, l4, l5, l6};

        Font fuente = new Font("dados", Font.BOLD, 20);
        setFont(fuente);
        setBorder(LineBorder.createGrayLineBorder());
        setHorizontalAlignment(CENTER);        
        setOpaque(true);
        
        estadoNormal();
        setText(lanzar());
    }

    @Override
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
        return position;
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
        this.position = pos;
    }

    @Override
    public void setPresionable() {
        setBackground(Color.decode("#D1D1D1"));        
    }

    @Override
    public void setClickListener(MouseAdapter adapter) {
        addMouseListener(adapter);
    }

    @Override
    public String lanzar() {
        int index = new Random().nextInt(letras.length);
        letra = letras[index];
        return getValor();
    }

    @Override
    public String getValor() {
        return String.valueOf(letra);
    }

}
