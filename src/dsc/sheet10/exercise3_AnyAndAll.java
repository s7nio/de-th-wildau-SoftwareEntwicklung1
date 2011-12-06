/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet10;

import StdLib.StdOut;

/**
 * Schreiben Sie eine Methode any() welche ein Feld von Boolean-Werten als Argument übergeben 
 * bekommt und Wahr zurückliefert, wenn einer der Werte im Feld Wahr ist. Schreiben Sie eine 
 * Methode all(), welche ein Feld von Boolean-Werten als Argument übergeben bekommt und Wahr 
 * zurückliefert, wenn alle der Werte des Feldes Wahr sind. Ansonsten sollen beide Methoden Falsch 
 * zurückgeben.
 *
 * Testen Sie Ihre Methode mit passenden Beispieldaten.
 * 
 * @author david
 */
public class exercise3_AnyAndAll {

    public static boolean any(boolean[] values) {

        for (int i = 0; i < values.length; i++) {

            if (values[i] == true) {
                return true;
            }
        }
        return false;
    }

    public static boolean all(boolean[] values) {

        for (int i = 0; i < values.length; i++) {

            if (values[i] != true) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        StdOut.println("true, true, true: " + any(new boolean[]{true, true, true}));
        StdOut.println("true, false, false: " + any(new boolean[]{true, false, false}));
        StdOut.println("false, true, false: " + any(new boolean[]{false, true, false}));
        StdOut.println("false, false, false: " + any(new boolean[]{false, false, false}));


        StdOut.println("true, true, true: " + all(new boolean[]{true, true, false}));
        StdOut.println("true, false, false: " + all(new boolean[]{true, false, false}));
        StdOut.println("false, false, false: " + all(new boolean[]{false, false, false}));
    }
}
