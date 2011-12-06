/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet10;

import StdLib.*;

/**
 * Schreiben Sie ein Programm, welches von der Standardeingabe eine Menge an Double-Werten 
 * einlesen kann und diese Werte danach mit Hilfe einer Methode auf den Zahlenbereich von 
 * 0 bis 1 skaliert. Das heißt, alle Werte des Feldes liegen nach der Skalierung zwischen 0 und 1. 
 * Sie skalieren ein Feld indem Sie von jedem Wert das Minimum des Feldes abziehen und das 
 * Ergebnis dann durch die Differenz zwischen dem Minimum und dem Maximum des Feldes dividieren. 
 * Ermitteln Sie das Minimum und das Maximum ebenfalls mittels eigener Methoden.
 *
 * Geben Sie danach die ursprünglichen Werte als auch die skalierten Ergebnisse auf dem 
 * Bildschirm aus.
 *
 * Testen Sie Ihr Programm mit einer Menge von 100 Zufallszahlen.
 * 
 * @author david
 */
public class exercise4_ScalingDoubles {

    public static double maximum(double[] a) {
        double max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static double minimum(double[] a) {
        double min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public static double[] scale(double[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (a[i] - minimum(a)) / (maximum(a) - minimum(a));
        }
        return a;
    }

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);

        double[] values = new double[N];

        for (int i = 0; i < N; i++) {
            values[i] = StdIn.readDouble();
        }

        StdOut.println("Original");
        for (int i = 0; i < N; i++) {
            StdOut.println(values[i]);
        }
        
        scale(values);
        
        StdOut.println("Scaled:");
        for (int i = 0; i < N; i++) {
            StdOut.println(values[i]);
        }
    }
}