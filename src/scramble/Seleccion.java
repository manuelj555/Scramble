/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scramble;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import scramble.interfaces.Dado;
import scramble.swing.DadoLabel;

/**
 *
 * @author Manuel Aguirre <programador.manuel@gmail.com>
 */
public class Seleccion {

    protected LinkedList<Dado> dados = new LinkedList();

    public void add(Dado dado) {
        dados.add(dado);
    }

    public void clear() {
        dados.clear();
    }

    public void quitar(Dado d) {
        dados.remove(d);
    }

    public Dado getUltimo() {
        try {
            return dados.getLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        String palabra = "";

        for (Dado d : dados) {
            palabra = palabra.concat(d.getValor());
        }

        return palabra;
    }

    public boolean isUsable() {
        return dados.size() >= 3;
    }
}
