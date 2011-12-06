package sne.exercise.sheet10;

import StdLib.StdDraw;
import java.awt.Color;
import java.math.BigDecimal;

/**
 * Modifizieren Sie das Ergebnis von Aufgabe 1 aus dem Übungsblatt 8 so, dass Sie 
 * vier Karo-Symbole auf dem Bildschirm anzeigen können, jedoch nur einmal den 
 * Code zum Zeichnen des Symbols schreiben müssen.
 * 
 * @author sne
 */
public class Task2 {

    public static void main(String[] foo) {
        
        StdDraw.setXscale(-2, 2);
        StdDraw.setYscale(-2, 2);
        
        diamond(1, 1, 1, .8);
        diamond(-1, 1, 1, .8);
        diamond(1, -1, 1, .8);
        diamond(-1, -1, 1, .8);
    }

    public static void diamond(double xCoordinate, double yCoordinate, double height, double width) {
        Color oldColor = StdDraw.getPenColor();
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledPolygon(calcXValues(new BigDecimal(xCoordinate), new BigDecimal(width)), 
                calcYValues(new BigDecimal(yCoordinate), new BigDecimal(height)));
        StdDraw.setPenColor(oldColor);
    }
    
    /**
     * {@see #diamond(double, double, double, double)}
     * 
     * @param xCoordinate
     * @param yCoordinate
     * @param height
     * @param width 
     */
    public static void diamond(int xCoordinate, int yCoordinate, int height, int width) {
        diamond(xCoordinate, yCoordinate, height, width);
    }

    /**
     * Help method, which calculate x coordinates.
     * 
     * @param x coordinate
     * @param width
     * @return x coordinates
     */
    private static double[] calcXValues(BigDecimal x, BigDecimal width) {
        BigDecimal halfWidth = width.divide(new BigDecimal(2));
        return new double[]{x.doubleValue(), x.add(halfWidth).doubleValue(), 
            x.doubleValue(), x.subtract(halfWidth).doubleValue()};
    }

    /**
     * Help method, which calculate y coordinates.
     * 
     * @param y coordinate
     * @param width
     * @return y coordinates
     */
    private static double[] calcYValues(BigDecimal y, BigDecimal height) {
        BigDecimal halfHeight = height.divide(new BigDecimal(2));
        return new double[]{y.subtract(halfHeight).doubleValue(), y.doubleValue(), 
            y.add(halfHeight).doubleValue(), y.doubleValue()};
    }

    /**
     * Get the other sign value.
     * 
     * @param value
     * @return BigDecimal other sign value
     */
    private static BigDecimal otherSign(BigDecimal value) {
        BigDecimal negativ = BigDecimal.ONE.subtract(BigDecimal.ONE);
        return value.multiply(negativ);
    }
}
