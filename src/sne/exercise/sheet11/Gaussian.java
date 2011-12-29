package sne.exercise.sheet11;

import sne.utils.Out;

public class Gaussian {

    /**
     * 
     * @param x
     * @return y
     */
    public static double phi(double x) {
        
        return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
    }

    /**
     * 
     * @param x
     * @param mu
     * @param sigma
     * @return y
     */
    public static double phi(double x, double mu, double sigma) {
        
        return phi((x - mu) / sigma) / sigma;
    }

    /**
     * 
     * @param z
     * @return Fläche unter der Kurve
     */
    public static double Phi(double z) {
        
        if (z < -8.0) {
            return 0.0;
        }
        if (z > 8.0) {
            return 1.0;
        }
        double sum = 0.0, term = z;
        for (int i = 3; sum + term != sum; i += 2) {
            sum = sum + term;
            term = term * z * z / i;
        }
        return 0.5 + sum * phi(z);
    }

    /**
     * 
     * @param z
     * @param mu
     * @param sigma
     * @return y
     */
    public static double Phi(double z, double mu, double sigma) {
        
        return Phi((z - mu) / sigma);
    }
    
    public static double PhiInverse(double mu, double sigma, double y) {
        
        return PhiInverse(mu, sigma, y, 4);
    }
    
    public static double PhiInverse(double mu, double sigma, double y, int epsilon) {
        
        double z = 0.5;
        while (Out.round(Phi(z, mu, sigma), epsilon) != Out.round(y, epsilon)) {
            
            //StdOut.println(Out.round(Phi(z, mu, sigma), epsilon) + " " + Out.round(y, epsilon));
            if (y < Phi(z, mu, sigma)) {
                z = z / 2;
            } else {
                z = z + z / 2;
            }
        }
        
        return z;
    }
}
