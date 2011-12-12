package sne.exercise.sheet09;

import StdLib.StdAudio;
import StdLib.StdIn;

/**
 * Modifizieren Sie das Programm „PlayThatTune.java” so, 
 * dass mit Hilfe von Kommandozeilen-Parametern (!!) 
 * die Lautstärke (Veränderung der Amplitude) und die 
 * Abspielgeschwindigkeit (Veränderung der Abspieldauer) kontrollieren können.
 * 
 * Testen Sie verschiedene Werte für die Parameter mittels der auf der eLearning-
 * Plattform bereitstehenden Dateien.
 * 
 * @author sne
 */
public class Task1 {

    /**
     * Terminal parameters must be integers and the scale is in percent (100 for original).
     * 
     * @param foo 1. volume 2. speed
     */
    public static void main(String[] foo) {
        
        int rateVolume = 100;
        int rateSpeed = 100;
        
        // parameter check, without an additional exception handling
        if (foo != null) {
            if (foo.length == 2) {
                rateVolume = Integer.parseInt(foo[0]);
                rateSpeed = Integer.parseInt(foo[1]);
                if (rateVolume < 0 || rateSpeed < 0) {
                    throw new IllegalArgumentException("Volume/Speed can not be less than 0.");
                }
            } else {
                throw new IllegalArgumentException("You have not two terminal parameter.");
            }
        } else {
            throw new IllegalArgumentException("Missing volume and speed parameter.");
        }

        // the PlayTheTune
        int pitch;
        double seconds;
        double hz;
        int SAMPLE_RATE;
        double[] a;
        while (!StdIn.isEmpty()) {
            pitch = StdIn.readInt();
            seconds = StdIn.readDouble() / 100;
            hz = 440.0 * Math.pow(2, pitch / 12.0);
            SAMPLE_RATE = 44100 / 100 * rateSpeed;
            int N = (int) (seconds * SAMPLE_RATE);
            a = new double[N + 1];
            for (int i = 0; i <= N; i++) {
                a[i] = Math.sin(2 * Math.PI * i * hz) * rateVolume;
            }
            StdAudio.play(a);
        }
    }
}
