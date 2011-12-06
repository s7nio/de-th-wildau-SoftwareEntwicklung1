/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet08;

import StdLib.*;

/**
 *
 * @author david
 */
public class exercise1 {

    /*Schreiben Sie ein Programm, welches die folgenden Formen grafisch darstellt. 
     *Wählen Sie eine geeignete Abstraktion zur Vereinfachung der Zeichnung, 
     * z.B. können Sie ein Herz aus einer Verbindung von Rhombus und zwei Kreisen erstellen.
     */
    public static void main(String[] args) {
        
        
        // diamonds
        double[] xdiamonds = {0.2, 0.35, 0.2, 0.05};
        double[] ydiamonds = {0.4, 0.2, 0.0, 0.2};
        
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledPolygon(xdiamonds, ydiamonds);
        

        // hearts
        double[] xhearts = {0.8, 0.95, 0.8, 0.65};
        double[] yhearts = {0.9, 0.7, 0.5, 0.7};
        
        StdDraw.filledPolygon(xhearts, yhearts);
        StdDraw.filledCircle(0.725, 0.8, 0.123);
        StdDraw.filledCircle(0.875, 0.8, 0.123);
        
        StdDraw.setPenColor(StdDraw.BLACK);
        
        
        // spades
        double[] xspades = {0.2, 0.3, 0.2, 0.1};
        double[] yspades = {0.9, 0.75, 0.6, 0.75};
        StdDraw.filledPolygon(xspades, yspades);

        StdDraw.filledCircle(0.25, 0.675, 0.088);
        StdDraw.filledCircle(0.15, 0.675, 0.088);
        
        double[] xspadestriangle = {0.05, 0.35, 0.2,};
        double[] yspadestriangle = {0.5, 0.5, 0.58,};
        StdDraw.filledPolygon(xspadestriangle, yspadestriangle);
        
        
        // clubs
        double[] xclubstriangle = {0.65, 0.95, 0.8,};
        double[] yclubstriangle = {0.0, 0.0, 0.08,};
        StdDraw.filledPolygon(xclubstriangle, yclubstriangle);
        
        StdDraw.filledCircle(0.88, 0.175, 0.088);
        StdDraw.filledCircle(0.72, 0.175, 0.088);
        StdDraw.filledCircle(0.8, 0.3, 0.088);
    }
}
