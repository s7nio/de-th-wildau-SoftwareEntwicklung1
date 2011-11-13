package sne.exercise.sheet7;

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

        String[] fieldLine = In.readFileByLine(fileName);
        int charCount = 0;
        for (int i = 0; i < fieldLine.length; i++) {
            charCount += fieldLine[i].length();
        }

        System.out.println("char count: " + charCount);
        System.out.println("word count: " + In.readFile(fileName, " ").length); // performance ugly, but short
    }
}
