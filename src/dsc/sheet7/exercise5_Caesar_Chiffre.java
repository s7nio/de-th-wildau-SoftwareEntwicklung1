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
        String original = StdIn.readLine();
        original = original.toUpperCase();
        char a = ' ';

        for (int i = 0; i < original.length(); i++) {
            a = original.charAt(i);


            for (int j = 0; j < alphabet.length; j++) {
                if (a == alphabet[j]) {
                    StdOut.print(alphabet[j + k]);
                    break;
                }
            }
        }


        /* while (!StdIn.isEmpty()) {
        char a = StdIn.readChar();
        
        for (int i = 0; i < alphabet.length; i++) {
        if (a == alphabet[i]) {
        StdOut.print(alphabet[i + k]);
        } else {
        StdOut.print(a);
        }
        }
        if (a == ' ') {
        StdOut.print(' ');
        
        }
        } */
    }
}