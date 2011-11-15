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
        String string = "";
        String[] a = new String[0];

        StdOut.println("Please enter a text and hit 'ctrl + d' when done.");

        while (!StdIn.isEmpty()) {
            string = StdIn.readAll();
            a = string.split(" ");

        }
        StdOut.println("The text consists of " + a.length + " words.");
        StdOut.println("The text consists of " + string.length() + " characters without spaces.");
    }
}
