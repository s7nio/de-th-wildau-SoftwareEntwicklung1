/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet7;

import StdLib.StdIn;
import StdLib.StdOut;

/**
 *
 * @author david
 */
public class exercise5_Caesar_Chiffre {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        StdOut.println("Type in a text:");

        while (!StdIn.isEmpty()) {
            char a = StdIn.readChar();

            for (int i = 0; i < alphabet.length; i++) {
                if (a == alphabet[i]) {
                    StdOut.print(alphabet[i + k]);
                }  else if (a == ' ') {
                    StdOut.print(' '); 
                } /*else {
                    StdOut.print(alphabet[i]);
                } */
            }
        }
    }
}