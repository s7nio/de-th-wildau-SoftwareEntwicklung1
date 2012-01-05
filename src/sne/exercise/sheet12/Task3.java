package sne.exercise.sheet12;

import StdLib.StdOut;
import StdLib.StdRandom;
import StdLib.StdStats;
import sne.utils.*;

/**
 * Schreiben Sie einen Test-Client für die Bibliotheken StdStats und StdRandom, um die 
 * korrekte Funktionalität aller Methoden zu prüfen.
 * 
 * Verwenden Sie dazu einen Kommandozeilen-Parameter N, um dann mit jeder Methode in 
 * StdRandom N Zufallszahlen zu generieren und für diese alle Statistiken aus StdStats auszugeben.
 * 
 * Entsprechen die Ergebnisse Ihren Erwartungen?
 * 
 * @author sne
 */
public class Task3 {

    public static void main(String[] foo) {
        
        int N = In.readInt("N");
        
        boolean[] _bernoulli = new boolean[N];
        double[] _cauchy = new double[N];
        double[] _gaussian = new double[N];
        double[] _random = new double[N];
        double[] _uniform = new double[N];
        
        for (int i = 0; i < N; i++) {
            _bernoulli[i] = StdRandom.bernoulli();
            _cauchy[i] = StdRandom.cauchy();
            _gaussian[i] = StdRandom.gaussian();
            _random[i] = StdRandom.random();
            _uniform[i] = StdRandom.uniform();
        }
        
        double[] _bernoulliHelpArr = new double[_bernoulli.length];
        for (int i = 0; i < _bernoulli.length; i++) {
            if (_bernoulli[i])
                _bernoulliHelpArr[i] = 1;
            else
                _bernoulliHelpArr[i] = 0;
        }
        
        callStats("Bernoulli", _bernoulliHelpArr);
        callStats("Cauchy", _cauchy);
        callStats("Gaussian", _gaussian);
        callStats("Random", _random);
        callStats("Uniform", _uniform);
        
        //StdOut.println("mean:" + mean + " stddev:" + stddev + " =" + StdRandom.gaussian(mean, stddev);
    }
    
    private static void callStats(String msg, double[] arr) {
        
        callStats(msg, arr, 4);
    }
    
    
    private static void callStats(String msg, double[] arr, int rounding) {
        
        Out.headline(msg);
        StdOut.print("min: " + Out.round(StdStats.min(arr), rounding));
        StdOut.println(" max: " + Out.round(StdStats.max(arr), rounding));
        StdOut.print(" sum: " + Out.round(StdStats.sum(arr), rounding));
        StdOut.println(" mean: " + Out.round(StdStats.mean(arr), rounding));
        StdOut.print(" stddev: " + Out.round(StdStats.stddev(arr), rounding));
        StdOut.println(" var: " + Out.round(StdStats.var(arr), rounding));
    }
}