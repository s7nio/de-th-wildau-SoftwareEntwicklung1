package sne.exercise.sheet12;

import StdLib.StdDraw;
import StdLib.StdRandom;
import StdLib.StdStats;
import sne.exercise.sheet11.Gaussian;
import sne.utils.In;

/**
 * Modifizieren Sie das Programm Bernoulli.java aus der Vorlesung so, dass das Histogramm 
 * nach jedem Experiment neu gezeichnet wird, um die Annäherung an die Normalverteilung 
 * beobachten zu können. Fügen Sie nachfolgend ein zusätzliches 
 * Kommandozeilen-Argument p hinzu und überladen Sie die Methode binomial() derart, 
 * dass p die Wahrscheinlichkeit angibt, mit welcher das Ergebnis „Kopf“ erzielt wird. 
 * Prüfen Sie den übergebenen Wert für p auf Korrektheit und geben Sie entsprechende 
 * Fehlermeldungen aus.
 * 
 * Welches Verhalten zeigt das Histogramm für p nahe 0 und nahe 1?
 * 
 * @author sne
 */
public class Task2 {

    public static void main(String[] args) {

        int N = In.readInt("N (e.g. 20)");
        int T = In.readInt("T (e.g. 1000)");
        double likelihood = In.readDouble("Likelihood (e.g. 0.5)");
        
        if (likelihood < 0 || likelihood > 1) {
            throw new IllegalArgumentException("The likelihood must be between 0 and 1.");
        }
        
        int[] freq = new int[N + 1];
        for (int i = 0; i < T; i++) {
            freq[binomial(N, likelihood)]++;
        }

        double[] normalized = new double[N + 1];
        for (int i = 0; i <= N; i++) {
            normalized[i] = (double) freq[i] / T;
            StdDraw.clear();
            StdStats.plotBars(normalized);
            StdDraw.show(50);
        }

        /*double mean = N / 2.0, stddev = Math.sqrt(N) / 2.0;
        double[] phi = new double[N + 1];
        for (int i = 0; i <= N; i++) {
            phi[i] = Gaussian.phi(i, mean, stddev);
        }
        StdStats.plotLines(phi);*/
    }
    
    /**
     * 
     * @param N number of cycles
     * @param k likelihood
     * @return count
     */
    private static int binomial(int N, double k) {
        
        int heads = 0;
        for (int j = 0; j < N; j++) {
            if (StdRandom.bernoulli(k)) {
                heads++;
            }
        }
        return heads;
    }
}
