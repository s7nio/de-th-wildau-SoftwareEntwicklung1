package sne.exercise.sheet07;

import sne.utils.*;

/**
 * Schreiben Sie ein Programm, welches den Integer-Wert N als Kommandozeilen- 
 * Parameter bekommt, anschließend N Double-Werte vom Benutzer eingeben lässt 
 * und für diese Eingaben dann das Maximum, das Minimum, den Mittelwert und 
 * die Standardabweichung (siehe Wikipedia) auf dem Bildschirm ausgibt.
 * 
 * @author sne
 */
public class Task2 {

    public static void main(String[] foo) {

        Integer n = In.readInt("Wieviel Werte möchten Sie eingeben");

        Double[] field = new Double[n];
        for (int i = 0; i < n; i++) {
            field[i] = In.readDouble(i + 1 + ""); // ugly
        }
        
        MathStatistics stati = new MathStatistics();
        for (int i = 0; i < n; i++) {
            stati.update(field[i].doubleValue());
        }
        
        System.out.println(stati.toString());
    }
}
