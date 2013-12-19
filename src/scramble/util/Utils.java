/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scramble.util;

import scramble.Presionable;

/**
 *
 * @author Manuel Aguirre <programador.manuel@gmail.com>
 */
public class Utils {

    public static int[] getPosPresionables(Presionable el) {

        switch (el.getPosition()) {
            case 1:
                return new int[]{2, 5, 6};
            case 2:
                return new int[]{1, 3, 5, 6, 7};
            case 3:
                return new int[]{2, 4, 6, 7, 8};
            case 4:
                return new int[]{3, 7, 8};
            case 5:
                return new int[]{1, 2, 6, 9, 10};
            case 6:
                return new int[]{1, 2, 3, 5, 7, 9, 10, 11};
            case 7:
                return new int[]{2, 3, 4, 6, 8, 10, 11, 12};
            case 8:
                return new int[]{3, 4, 7, 11, 12};
            case 9:
                return new int[]{5, 6, 10, 13, 14};
            case 10:
                return new int[]{5, 6, 7, 9, 10, 11, 13, 14, 15};
            case 11:
                return new int[]{6, 7, 8, 10, 12, 14, 15, 16};
            case 12:
                return new int[]{7, 8, 11, 15, 16};
            case 13:
                return new int[]{9, 10, 14};
            case 14:
                return new int[]{9, 10, 11, 13, 15};
            case 15:
                return new int[]{10, 11, 12, 14, 16};
            case 16:
                return new int[]{11, 12, 15};
        }

        return null;
    }

    public static int getPuntos(String palabra) {

        if (palabra.length() < 3) {
            return 0;
        }

        switch (palabra.length()) {
            case 3:
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 4;
            case 7:
                return 6;
            default:
                return 8;
        }

    }
}
