package sne.exercise.sheet09;

import StdLib.StdDraw;
import StdLib.StdIn;

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
                throw new IllegalArgumentException("N is incorrect");
            }
            l = Integer.parseInt(foo[1]);
            r = Integer.parseInt(foo[2]);
            if (l >= r){
                throw new IllegalStateException("l is >= r");
            } 
        } else {
            throw new IllegalArgumentException("Missing arguments. Look jvadoc");
        }
        
        double step = (r - l) / (double) N;
        
        int[] hix = new int[N];

        int value;
        double checkValue;
        while(!StdIn.isEmpty()) {
            
            value = StdIn.readInt();
            
            // check, is value not in the range of l & r
            if (value <= l || value >= r) {
                continue;
            }
            
            // sort value
            for (int i = 0; i < N; i++) {
                checkValue = l + (step * i);
                // check    vv: lower limit     vv: upper limit
                if (value >= checkValue && value <= (checkValue + step)) {
                    hix[i]++;
                    break;
                }
            }
        }
        
        // test print
        for (int i = 0; i < N; i++) {
            System.out.println("hix " + i + ". " + (l + (step*i)) + " to " +(l + (step*i) + step)
                    + " - count " + hix[i]);
        }
        
        printHix(hix, N, l, r, step);
    }
    
    /**
     * FIXME [sne] Print histogram.
     */
    private static void printHix(int[] hix, int N, int l, int r, double step) {
        
        final int HIX_WIDTH = 10;
        
        StdDraw.setXscale(0, r - l);
        StdDraw.setYscale(0, HIX_WIDTH * N);
        
        // axes
        StdDraw.line(0, 0, HIX_WIDTH * N, 0);
        StdDraw.text(HIX_WIDTH * N, 0, "x");
        StdDraw.line(0, 0, 0, r - l);
        StdDraw.text(0, r - l , "y");
        
        
        for (int i = 0; i < N; i++)
        {
            StdDraw.filledRectangle(step * i, (r - l) / 2, i * N / 3, hix[i] / 2);
            StdDraw.text(step * i, r-l-10, String.valueOf(hix[i]));
        }
    }
}
