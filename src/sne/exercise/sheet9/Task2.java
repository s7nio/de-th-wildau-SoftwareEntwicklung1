package sne.exercise.sheet9;

import StdLib.StdDraw;
import StdLib.StdIn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sne.utils.Out;

/**
 * Histogramm. Schreiben Sie ein Programm, welches von der Standardeingabe eine
 * (nahezu) beliebige Menge an Double-Werten zwischen 0 und 100 einliest.
 * 
 * Zeichnen Sie dann mit Hilfe der als Kommandozeilen-Parameter übergebenen 
 * Werte N, l und r ein Histogramm für die Häufigkeitsverteilung. 
 * Die Variablen l und r beschreiben dabei den zu untersuchenden Zahlenbereich 
 * und die Variable N die Anzahl (N <= 10) der unterschiedlichen Intervalle gleicher Größe.
 * Testen Sie Ihr Programm mit einer Menge von mindestens 10.000 Zufallszahlen im Bereich 0 bis 100.
 * 
 * @author sne
 */
public class Task2 {
    
    public static void main(String[] foo) {
        
        int N = 0;
        int l = 0;
        int r = 0;
        
        // primitiv input control
        if (foo != null && foo.length == 3) {
            N = Integer.parseInt(foo[0]);
            if (N <= 0 || N > 10) {
                Out.exit("Your N is incorrect.");
            }
            l = Integer.parseInt(foo[1]);
            r = Integer.parseInt(foo[2]);
            if (l >= r){
                Out.exit("Your l is >= r.");
            } 
        } else {
            Out.exit("You fail!");
        }
        
        int step = (r - l) / N;
        System.out.println("step " + step);
        /*if ((r-l)%N != 0)
            step++;*/
        
        System.out.println("step " + step);
        
        int[] hix = new int[N];
        int numberCount = 0;

        int i, myValue, checkValue;
        while(!StdIn.isEmpty()) {
            
            myValue = StdIn.readInt();
            numberCount++;
            
            // check, is myValue not in the range of l & r
            if (myValue < l || myValue > r) {
                continue;
            }
            
            for (i = 0; i < N; i++) {
                checkValue = l + (step * i);
                if (myValue >= checkValue && myValue <= (checkValue + step)) {
                    hix[i]++;
                    break;
                }
            }
        }
        
        System.out.println("number count " + numberCount);
        for (i = 0; i < N; i++) {
            System.out.println("hix " + i + ". " + (l + (step*i)) + " to " +(l + (step*i) + step)
                    + " - count " + hix[i]);
        }
        
        //printHix(hix, N, l, r, step);
    }
    
    /**
     * Print the histogram.
     * 
     * @param value
     * @param x 
     */
    private static void printHix(int[] hix, int N, int l, int r, int step) {
        
        final int HIX_WIDTH = 10;
        
        StdDraw.setXscale(0, 50 + (HIX_WIDTH * N));
        StdDraw.setXscale(0, 50 + (r-l));
        //StdDraw.setXscale(0,150);
        //StdDraw.setYscale(0, 100);
        
        // axes
        StdDraw.line(0, 0, 10, 0);
        StdDraw.text(HIX_WIDTH * N, 0, "x");
        StdDraw.line(0, 0, 0, 10);
        StdDraw.text(0, r-l, "y");
        
        
        for (int i = 0; i<N; i++)
        {
            //StdDraw.filledRectangle(5*i+10*i, (Feld[i]/Anzahl*100)/2 , 5, (Feld[i]/Anzahl*100)/2);
            //StdDraw.filledRectangle(5, 10, 5, 10);  (Feld[i]/Anzahl)*100)/2
            StdDraw.filledRectangle(0, HIX_WIDTH, step, hix[i]);
        }
    }
}
