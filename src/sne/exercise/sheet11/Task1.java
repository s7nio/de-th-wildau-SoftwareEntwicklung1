package sne.exercise.sheet11;

import StdLib.StdIn;
import StdLib.StdOut;

/**
 * Schreiben Sie eine statische Methode, welche drei Double-Argumente übergeben bekommt 
 * und Wahr zurückliefert, wenn diese drei Werte die Seitenlängen eines Dreieckes 
 * beschreiben könnten. Ansonsten soll die Methode Falsch zurückgeben.
 * 
 * @author sne
 */
public class Task1 {

    public static void main(String[] foo) {
        
//        if (foo.length != 3) {
//            throw new IllegalArgumentException("Three parameter are required.");
//        }
        
        StdOut.print("Länge der Dreiecksseite a: ");
        double a = StdIn.readDouble();
        StdOut.print("Länge der Dreiecksseite b: ");
        double b = StdIn.readDouble();
        StdOut.print("Länge der Dreiecksseite c: ");
        double c = StdIn.readDouble();
        
        StdOut.println("Ist dies ein Dreieck? => " + isTriangle(a, b, c));
    }
    
    /**
     * Check side of the triangle.
     * 
     * @param a side
     * @param b side
     * @param c side
     * @return boolean is that a triangle
     */
    private static boolean isTriangle(double a, double b, double c) {
        
        if (a+b >= c || a+c >= b || b+c >= a) {
            return false;
        }
        return true;
    }
}
