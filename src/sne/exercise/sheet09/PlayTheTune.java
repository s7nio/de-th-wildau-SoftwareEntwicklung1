package sne.exercise.sheet09;

import StdLib.StdAudio;
import StdLib.StdIn;

public class PlayTheTune {

    public static void main(String[] foo) {
        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();
            double seconds = StdIn.readDouble();
            double hz = 440.0 * Math.pow(2, pitch / 12.0);
            int SAMPLE_RATE = 44100;
            int N = (int) (seconds * SAMPLE_RATE);
            double[] a = new double[N + 1];
            for (int i = 0; i <= N; i++) {
                a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLE_RATE);
            }
            StdAudio.play(a);
        }
    }
}
