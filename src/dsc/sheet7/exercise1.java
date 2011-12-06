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
public class exercise1 {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        for (int i = 0; i < N; i++) {
            StdOut.print((int) (Math.random() * 100) + " ");
        }
    }
}
