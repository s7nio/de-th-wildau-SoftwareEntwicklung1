/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet9;

import StdLib.StdDraw;
import StdLib.StdIn;
import StdLib.StdOut;
import java.lang.reflect.Array;
import sne.utils.Out;

/**
 *
 * @author david
 */
public class exercise2_Histogramm {

    /* Histogramm. Schreiben Sie ein Programm, welches von der Standardeingabe eine
     * (nahezu) beliebige Menge an Double-Werten zwischen 0 und 100 einliest.
     * 
     * Zeichnen Sie dann mit Hilfe der als Kommandozeilen-Parameter übergebenen Werte N, l und r 
     * ein Histogramm für die Häufigkeitsverteilung. Die Variablen l und r beschreiben dabei den zu 
     * untersuchenden Zahlenbereich und die Variable N die Anzahl (N <= 10) der unterschiedlichen 
     * Intervalle gleicher Größe.
     * 
     * Testen Sie Ihr Programm mit einer Menge von mindestens 10.000 Zufallszahlen im Bereich 
     * 0 bis 100.
     */
    public static void main(String[] args) {

        // command line arguments
        int N = Integer.parseInt(args[0]);
        int l = Integer.parseInt(args[1]);
        int r = Integer.parseInt(args[2]);
        
        
        


        // array that counts frequency of values in N buckets
        int[] bucket = new int[N];
        
        // interval for each segment
        double interval = (r - l) / (double)N;
        
                System.out.print(interval);


        int valueCount = 0;
        int max = 0;


        // read values 
        while (!StdIn.isEmpty()) {

            double value = StdIn.readDouble();


            for (int i = 0; i < N; i++) {

                // value out of range
                if (value < l || value > r) {
                    break;
                }
                // increment respective segment
                if (value < l + interval * (i + 1)) {
                    bucket[i] = Array.getInt(bucket, i) + 1;
                    valueCount++;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (bucket[i] > max) {
                max = bucket[i];
            }
        }

        double yScale = max + max * 0.1;
        StdDraw.setXscale(l, r);
        StdDraw.setYscale(0 - yScale * 0.1, yScale);
        

        // draw x-axis
        StdDraw.line(l, 0, r, 0);
        double xScale = 0;

        for (int i = 0; i < N + 1; i++) {

            // draw scale and labels
            xScale = l + i * interval;
            StdDraw.line(xScale, 0, xScale, 0 - yScale * 0.01);
            StdDraw.text(xScale, 0 - yScale * 0.05, Out.round(xScale));

            // draw bars
            double bar = xScale + interval / 2;
            StdDraw.rectangle(bar, bucket[i] / 2, interval / 3, bucket[i] / 2);
            StdDraw.text(bar, bucket[i] + yScale * 0.05, String.valueOf(bucket[i]));
        }
    }
}
