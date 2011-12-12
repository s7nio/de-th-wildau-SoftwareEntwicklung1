/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet11;

/**
 *
 * @author david
 */
public class exercise1_triangle {
    
    public static boolean triangle (double a, double b, double c) {
        if ((a + b < c) || (a + c < b) || (b + c < a)) {
            return false;
        }
        return true;
    }
    
    
    public static void main (String[] args) {
        
        System.out.println(triangle(2, 5, 2));
    }
}

