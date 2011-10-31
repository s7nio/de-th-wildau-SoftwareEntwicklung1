/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package derbasticom.exercise.sheet5;

import derbasticom.utils.Output;
import derbasticom.utils.Reader;
import java.math.BigDecimal;

/**
 * Schreiben sie ein Programm, dass die Reihenfolge der Werte eines 
 * eindimensionalen Feldes von Fließkommazahlen (mit theoretisch 
 * beliebiger Länge) reversiert. Benutzen Sie dafür kein zusätzliches Feld.
 * 
 * @author sne
 */
public class Task2 {

    public static void main(String[] foo) {

        int fieldLength = Reader.readInteger("Arraylänge");
        BigDecimal[] field = new BigDecimal[fieldLength];

        // random field init
        for (int i = 0; i < fieldLength; i++) {
            field[i] = BigDecimal.valueOf(Math.random());
        }

        Output.printObjectArrayHeadline("The random array", field);

        // reverse array with a two help var
        /*int tmpFieldLength = fieldLength;
        int tmpI = 0;
        BigDecimal tmpSwap;
        while (tmpI < tmpFieldLength) {
        tmpSwap = field[tmpI];
        field[tmpI] = field[tmpFieldLength - 1];
        field[tmpFieldLength - 1] = tmpSwap;
        
        tmpI++;
        tmpFieldLength--;
        }
        Output.printObjectArrayHeadline("Reverse array", field);*/

        // reverse array with a other array
        BigDecimal[] tmpField = new BigDecimal[fieldLength];
        int j = 0;
        for (int i = field.length - 1; i >= 0; i--) {
            tmpField[j++] = field[i];
        }
        field = tmpField;
        Output.printObjectArrayHeadline("Reverse array", field);

        // the easy and short way
        /*List<BigDecimal> list = Arrays.asList(field);
        Collections.reverse(list);
        field = list.toArray(new BigDecimal[fieldLength]);
        Output.printObjectArrayHeadline("Reverse array", field);*/
    }
}
