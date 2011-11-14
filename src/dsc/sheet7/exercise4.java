/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet7;

import StdLib.*;

/**
 *
 * @author david
 */
public class exercise4 {

    /*
     * Schreiben Sie ein Programm, welches einen beliebig langen Text von der Standardeingabe 
     * einliest und die Anzahl der Zeichen und Wörter in diesem ermittelt.
     * Aus wie vielen Wörtern und Zeichen besteht der Roman „Tom Sawyer“? 
     * (siehe e- Learning Plattform)
     */
    public static void main(String[] args) {
        int countString = 0;
        int countChar = 0;
        String string = "";
        
        StdOut.println("Please enter a text and hit 'ctrl + d' when done.");

        while (!StdIn.isEmpty()) {
            string = StdIn.readString();
            countString++;
            countChar = countChar + string.length();
        }
 
        StdOut.println("The text consists of " + countString + " words.");
        StdOut.println("The text consists of " + countChar + " characters without spaces.");
    }
}
