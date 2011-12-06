/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet7;

import StdLib.*;
import java.util.Arrays;

/**
 *
 * @author david
 */
public class exercise3 {

    /*
     * Modifizieren Sie Ihr Programm aus Aufgabe 2 so, dass es alle Werte aus der 
     * Datei WERTE.TXT einliest und die beschriebenen Statistiken dafür ermittelt.
     */
    public static void main(String[] args) {
        double a = 0.0;
        double max = 0.0;
        double min = 100.0;
        double sum = 0.0;
        double avg = 0.0;
        double stdev = 0.0;
        int count = 0;
        
        

        // user input
        while (!StdIn.isEmpty()) {
            a = StdIn.readDouble();
            count++;
            
            // maximum
            if (a > max) {
                max = a;
            }
            // minimun
            if (a < min) {
                min = a;
            }
            sum = sum + a;
        }
        // average
        avg = sum / count;
        
        

        
//        for (int i = 0; i < N; i++) {
//            a[i] = StdIn.readDouble();
//        }
//
//        // min and max value
//        Arrays.sort(a);
//        double max = a[a.length - 1];
//        double min = a[0];
//
//        // average
//        for (int i = 0; i < a.length; i++) {
//            sum = sum + a[i];
//        }
//        avg = sum / a.length;
//
//        // standard deviation
//        for (int i = 0; i < a.length; i++) {
//            stdev = Math.sqrt(((avg - a[i]) * (avg - a[i])) / a.length);
//        }

        // output
        StdOut.println("The maximum is: " + max);
        StdOut.println("THe minimum is: " + min);
        StdOut.println("The average is: " + avg);
        StdOut.println("The standard deviation is: " + stdev);
    }
}
