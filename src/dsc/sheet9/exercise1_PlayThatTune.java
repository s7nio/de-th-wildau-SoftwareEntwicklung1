/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet9;

import StdLib.*;

/**
 *
 * @author david
 */
public class exercise1_PlayThatTune {
    
    /* 
     * Modifizieren Sie das Programm „PlayThatTune.java” so, dass mit Hilfe von 
     * Kommandozeilen-Parametern (!!) die Lautstärke (Veränderung der Amplitude) und die 
     * Abspielgeschwindigkeit (Veränderung der Abspieldauer) kontrollieren können.
     * Testen Sie verschiedene Werte für die Parameter mittels der auf der eLearning- Plattform 
     * bereitstehenden Dateien.
     * 
     */

    public static void main(String[] args) {
        double Volume = Double.parseDouble(args[0]);
        double Speed = Double.parseDouble(args[1]);
        
        Volume /= 100;


        while (!StdIn.isEmpty()) {

            int pitch = StdIn.readInt();
            double seconds = StdIn.readDouble();
            double hz = 440.0 * Math.pow(2, pitch / 12.0);

            int SAMPLE_RATE = 44100;
            int N = (int) ((seconds * SAMPLE_RATE) * Speed);
            double[] a = new double[N + 1];
            for (int i = 0; i <= N; i++) {
                a[i] = (Math.sin(2 * Math.PI * i * hz / SAMPLE_RATE)) * Volume;
            }
            StdAudio.play(a);
        }
    }
}
