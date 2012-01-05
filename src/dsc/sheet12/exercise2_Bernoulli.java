/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet12;

import StdLib.*;
import dsc.utils.Gaussian;

/**
 * Modifizieren Sie das Programm Bernoulli.java aus der Vorlesung so, dass das Histogramm nach jedem 
 * Experiment neu gezeichnet wird, um die Annäherung an die Normalverteilung beobachten zu können. 
 * Fügen Sie nachfolgend ein zusätzliches Kommandozeilen-Argument p hinzu und überladen Sie die 
 * Methode binomial() derart, dass p die Wahrscheinlichkeit angibt, mit welcher das Ergebnis 
 * „Kopf“ erzielt wird. Prüfen Sie den übergebenen Wert für p auf Korrektheit und geben Sie 
 * entsprechende Fehlermeldungen aus.
 *  
 * Welches Verhalten zeigt das Histogramm für p nahe 0 und nahe 1?
 * 
 * @author david
 */
public class exercise2_Bernoulli {

    // flip N fair coins; return # heads
    public static int binomial(int N) {
        int heads = 0;
        for (int j = 0; j < N; j++) {
            if (StdRandom.bernoulli(0.5)) {
                heads++;
            }
        }
        return heads;
    }

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        // perform T trials of N coin flips each
        int[] freq = new int[N + 1];
        for (int i = 0; i < T; i++) {
            freq[binomial(N)]++;
        }

        // plot histogram of number of heads
        double[] normalized = new double[N + 1];
        for (int i = 0; i < N; i++) {
            normalized[i] = (double) freq[i] / T;
        }
        StdStats.plotBars(normalized);
        
        double mean = N / 2.0;
        double stdev = Math.sqrt(N) / 2.0;
        double[] phi = new double[N + 1];
        for (int i = 0; i < N; i++) {
            phi[i] = Gaussian.phi(i, mean, stdev);
        }
        StdStats.plotLines(phi);
    }
}
