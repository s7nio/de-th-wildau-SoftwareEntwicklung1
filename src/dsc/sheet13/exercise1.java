/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet13;

/**
 *
 * @author david
 */
public class exercise1 {
    
    public static int fact(int n) {
        if (n == 0) return 1;
        else return n * fact(n - 1);
    }
    
    public static void main(String[] args) {
        
        int n = Integer.parseInt(args[0]);
       
        double log = Math.log(fact(n));
        
        System.out.print(log);
    }
}
