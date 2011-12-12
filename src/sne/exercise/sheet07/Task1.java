package sne.exercise.sheet07;

import sne.utils.In;
import sne.utils.Out;
import java.util.Random;

/**
 * Schreiben Sie ein Programm, welches den Integer-Wert N als Kommandozeilen- 
 * Parameter bekommt, anschließend N Integer-Werte zwischen 0 und 100 auf dem Bildschirm ausgibt.
 * 
 * Erstellen Sie eine Datei WERTE.TXT mit 10.000 Zufallszahlen zwischen 0 und 100.
 * @author sne
 */
public class Task1 {

    public static void main(String[] foo) {

        int n = In.readInt("Anzahl der Werte").intValue();

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            System.out.println(random.nextInt(101));
        }

        Out.fileBegin("sne_sheet7task1.txt");
        for (int i = 0; i < 10000; i++) {
            Out.fileWrite(random.nextInt(101));
        }
        Out.fileClose();
    }
}
