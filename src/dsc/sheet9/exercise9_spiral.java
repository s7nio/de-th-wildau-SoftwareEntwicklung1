/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet9;

import StdLib.*;

/**
 *
 * @author david
 */
public class exercise9_spiral {
    
    public static void main(String[] args) {

        int d = Integer.parseInt(args[0]);
        int l = Integer.parseInt(args[1]);

        double x1 = 0;
        double x2 = 0;
        double y1 = 0;
        double y2 = 0;

        StdDraw.setXscale(-100, 100);
        StdDraw.setYscale(-100, 100);

        while (x2 < 100) {
            
            y2 = y1 + d;
            StdDraw.line(x1, y1, x2, y2);
            
            if (y2 > y1 + d) {
                x2 = x1 + d;
            }
            StdDraw.line(x1, y1, x2, y2);
            
            if (x2 > x1 + d) {
                y2 = 0;
            }
            
            
            x2 = x1 + d;
            StdDraw.line(x1, y1, x2, y2);
            x1 = x2;
            if (x2 > d) {
                x2 = -x2;
            }
            y2 = y1 + d;
            y2 = y1;
            y2 = -y2;
            StdDraw.line(x1, y1, x2, y2);
        }
    }
}
