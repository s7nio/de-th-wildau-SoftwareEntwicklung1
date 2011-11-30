/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet9;

import StdLib.StdOut;

/**
 *
 * @author david
 */
public class Random {
    
     public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        for (int i = 0; i < N; i++) {
            StdOut.print((Math.random() * 100) + " ");
        }
    }
}
