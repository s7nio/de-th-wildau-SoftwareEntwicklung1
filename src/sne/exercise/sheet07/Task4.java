package sne.exercise.sheet07;

import sne.utils.*;

/**
 * Schreiben Sie ein Programm, welches einen beliebig langen Text von der 
 * Standardeingabe einliest und die Anzahl der Zeichen und Wörter in diesem ermittelt.
 * 
 * Aus wie vielen Wörtern und Zeichen besteht der Roman „Tom Sawyer“? (siehe e- Learning Plattform)
 * 
 * @author sne
 */
public class Task4 {
    
    public static void main(String[] foo) {
        
        String fileName = In.readStr("Dateiname (file in launch path - TomSawyer.txt)");

        String[] lines = In.readFileByLine(fileName);
        int charCount = 0;
        int wordCound = 0;
        for (int i = 0; i < lines.length; i++) {
            charCount += lines[i].length();
            wordCound += lines[i].split(" ").length;
        }

        System.out.println("char count: " + charCount);
        System.out.println("word count: " + wordCound);
    }
}
