/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet07;

import StdLib.*;
import java.util.Arrays;

/**
 *
 * @author david
 */
public class exercise2 {
    
    /*Schreiben Sie ein Programm, welches den Integer-Wert N als Kommandozeilen- Parameter 
     *bekommt, anschließend N Double-Werte vom Benutzer eingeben lässt und für diese Eingaben 
     *dann das Maximum, das Minimum, den Mittelwert und die Standardabweichung (siehe Wikipedia) 
     *auf dem Bildschirm ausgibt.
     */

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = new double[N];
        double sum = 0.0;
        double avg = 0.0;
        double stdev = 0.0;
        
        
        StdOut.println("This program computes the maximum, minumum, average and standard deviation of " + N + " doubles.");
        // user input
        for (int i = 0; i < N; i++) {
            StdOut.print("Type in a double: ");
            a[i] = StdIn.readDouble();
        }
        
        // min and max value
        Arrays.sort(a);
        double max = a[a.length - 1];
        double min = a[0];
        
        // average
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        avg = sum / a.length;
        
        // standard deviation
        for (int i = 0; i < a.length; i++) {
            stdev = stdev + ((avg - a[i]) * (avg - a[i]));
        }
        stdev = Math.sqrt(stdev / (a.length - 1));
        
        // output
        StdOut.println("The maximum is: " + max);
        StdOut.println("THe minimum is: " + min);
        StdOut.println("The average is: " + avg);
        StdOut.println("The standard deviation is: " + stdev);
    }
}
