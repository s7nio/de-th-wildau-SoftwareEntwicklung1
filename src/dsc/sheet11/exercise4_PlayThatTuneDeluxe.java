/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet11;

import StdLib.*;

/**
 * Modifizieren Sie das Programm PlayThatTuneDeluxe so, dass sie zusätzlich Harmonien in zwei 
 * Oktaven Entfernung von jeder Note mit der halben Gewichtung hinzufügen.
 *
 * @author david
 */
public class exercise4_PlayThatTuneDeluxe {

    public static double[] sum(double[] a, double[] b, double awt, double bwt) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * awt + b[i] * bwt;
        }
        return c;
    }

    public static double[] note(int pitch, double duration) {
        double hz = 440.0 * Math.pow(2, pitch / 12.0);
        double[] a = tone(1.0 * hz, duration);
        double[] uhi = tone(4.0 * hz, duration); 
        double[] hi = tone(2.0 * hz, duration);
        double[] lo = tone(0.5 * hz, duration);
        double[] ulo = tone(0.25 * hz, duration);
        double[] h = sum(hi, lo, .5, .5);
        double[] uh = sum(uhi, ulo, .5, .5);
        double[] help = sum(h, uh, .75, .25);
        return sum(a, help, .5, .5);
    }

    public static double[] tone(double hz, double seconds) {
        int SAMPLE_RATE = 44100;
        int N = (int) (seconds * SAMPLE_RATE);
        double[] a = new double[N + 1];

        for (int i = 0; i <= N; i++) {
            a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLE_RATE);
        }
        return a;
    }

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            double[] a = note(pitch, duration);
            StdAudio.play(a);
        }
    }
}