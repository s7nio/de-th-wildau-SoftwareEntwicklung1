package sne.exercise.sheet13;

import StdLib.StdOut;

/**
 * Schreiben Sie ein rekursives Programm welches den natürlichen Logarithmus der 
 * Fakultät des Kommandozeilen-Argumentes n errechnet.
 * 
 * @author sne
 */
public class Task1 {

    public static int f(int n) {
        if (n == 0) {
            return 1;
        }
        return n * f(n - 1);
    }

    
    public static void main(String[] args) {
        /*Assert.assertEquals(1, f(0));
        Assert.assertEquals(1, f(1));
        Assert.assertEquals(2, f(2));
        Assert.assertEquals(6, f(3));
        Assert.assertEquals(24, f(4));
        Assert.assertEquals(120, f(5));*/
        StdOut.println("0! = " + f(0));
        StdOut.println("1! = " + f(1));
        StdOut.println("2! = " + f(2));
        StdOut.println("3! = " + f(3));
        StdOut.println("4! = " + f(4));
        StdOut.println("5! = " + f(5));
    }
}
