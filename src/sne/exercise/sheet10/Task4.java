package sne.exercise.sheet10;

import StdLib.StdIn;
import StdLib.StdOut;
import sne.utils.*;

/**
 * Schreiben Sie ein Programm, welches von der Standardeingabe eine Menge an 
 * Double-Werten einlesen kann und diese Werte danach mit Hilfe einer Methode 
 * auf den Zahlenbereich von 0 bis 1 skaliert. Das heißt, alle Werte des Feldes 
 * liegen nach der Skalierung zwischen 0 und 1. Sie skalieren ein Feld indem 
 * Sie von jedem Wert das Minimum des Feldes abziehen und das Ergebnis dann 
 * durch die Differenz zwischen dem Minimum und dem Maximum des Feldes dividieren. 
 * Ermitteln Sie das Minimum und das Maximum ebenfalls mittels eigener Methoden.
 * 
 * Geben Sie danach die ursprünglichen Werte als auch die skalierten Ergebnisse 
 * auf dem Bildschirm aus.
 * 
 * Testen Sie Ihr Programm mit einer Menge von 100 Zufallszahlen.
 * 
 * @author sne
 */
public class Task4 {
    
    // static is not so good, because they exist from class load
    private static double min = Double.MAX_VALUE;
    private static double max = Double.MIN_VALUE;
    
    public static void main(String[] foo) {

        StdOut.print("Wieviele Werte möchten Sie eingeben: ");
        int count = StdIn.readInt();

        double[] input = new double[count];

        for (int i = 0; i < count; i++) {
            // read values
            StdOut.print((i + 1) + "/" + (count) + ": ");
            input[i] = StdIn.readDouble();
            // for best performance - find here min and max value
            if (min > input[i]) min = input[i];
            if (max < input[i]) max = input[i];
        }

        Out.printObjectArrayMessage("Orginal", input);
        StdOut.println("Min: " + min);
        StdOut.println("Max: " + max);
        Out.printObjectArrayMessage("Scale", scale(input));
    }

    /**
     * Scale double array between 0 .. 1.
     * 
     * @param values double array
     * @param min value
     * @param max value
     * @return scale double array
     */
    private static double[] scale(double[] values, double min, double max) {

        for (int i = 0; i < values.length; i++) {
            values[i] = (values[i] - min) / Math.abs(min - max);
        }
        return values;
    }

    /**
     * @see #scale(double[], double, double)
     * 
     * @param values
     * @return scale double array
     */
    private static double[] scale(double[] values) {

        // for better performance - find here min and max value
        return scale(values, findMin(values), findMax(values));
    }
    
    /**
     * Find the minimum value of an double array.
     * 
     * @param values
     * @return min value
     */
    private static double findMin(double[] values) {
        double _min = Double.MAX_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < _min) {
                _min = values[i];
            }
        }
        return _min;
    }
    
    /**
     * Find the maximum value of an double array.
     * 
     * @param values
     * @return max value
     */
    private static double findMax(double[] values) {
        double _max = Double.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > _max) {
                _max = values[i];
            }
        }
        return _max;
    }
}
