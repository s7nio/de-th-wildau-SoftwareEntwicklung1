/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet10;

import StdLib.StdDraw;
import java.awt.Color;

/**
 * Modifizieren Sie das Ergebnis von Aufgabe 1 aus dem Übungsblatt 8 so, dass Sie vier Karo-Symbole 
 * auf dem Bildschirm anzeigen können, jedoch nur einmal den Code zum Zeichnen des Symbols schreiben
 * müssen.
 * 
 * @author david
 */
public class exercise2_diamonds {

    public static double[] diamondX(double x, double halfwidth) {
        return new double[]{x - halfwidth, x, x + halfwidth, x};
    }

    public static double[] diamondY(double y, double halfheight) {
        return new double[]{y, y + halfheight, y, y - halfheight};
    }
    
    public static void filledDiamond (double[] diamondX, double[] diamondY) {
        StdDraw.filledPolygon(diamondX, diamondY);
    }

    public static void main(String[] args) {

        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);

        StdDraw.setPenColor(Color.RED);

        filledDiamond(diamondX(25, 15), diamondY(25, 20));
        filledDiamond(diamondX(25, 15), diamondY(75, 20));
        filledDiamond(diamondX(75, 15), diamondY(25, 20));
        filledDiamond(diamondX(75, 15), diamondY(75, 20));

        
        
        /*
        StdDraw.filledPolygon(diamondX(25, 15), diamondY(25, 20));
        StdDraw.filledPolygon(diamondX(25, 15), diamondY(75, 20));
        StdDraw.filledPolygon(diamondX(75, 15), diamondY(25, 20));
        StdDraw.filledPolygon(diamondX(75, 15), diamondY(75, 20));
         */
    }
}