/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet11;

import StdLib.*;

/**
 *
 * @author david
 */
public class exercise2_CustomerID {

    // digit sum
    public static int f(int d) {
        d = 2 * d;
        return (d / 10) + (d % 10);
    }

    public static int calculateSumOfID(int[] IDArray) {
        int sumOfID = 0;
        for (int i = 0; i < IDArray.length; i++) {
            if (i % 2 == 0) {
                sumOfID = sumOfID + IDArray[i];
            } else {
                sumOfID = sumOfID + f(IDArray[i]);
            }
        }
        return sumOfID;
    }

    public static boolean checkID(int[] IDArray) {
        if (calculateSumOfID(IDArray) % 10 == 0) {
            return true;
        }
        return false;
    }

    public static String createLastDigit(int[] IDArray) {
        int lastDigit = 10 - calculateSumOfID(IDArray) % 10;
        return Integer.toString(lastDigit);
    }

    public static String createValidID(int[] IDArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < IDArray.length; i++) {
            sb.append(IDArray[i]);
        }
        sb.append(createLastDigit(IDArray));
        return sb.toString();
    }

    
    
    public static int[] StringToIntArray(String s) {
        int[] intArray = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            intArray[i] = Character.getNumericValue(s.charAt(i));    // Charactoer.digit(s.charAt(i), 10);
        }
        return intArray;
    }
    
    
    
    
    
    
    
      
    

    public static void main(String[] args) {

        // parse ID from command line
        long ID = Long.parseLong(args[0]);

        // convert ID to an int array
        int[] CustomerID = StringToIntArray(Long.toString(ID));

        // print original ID
        StdOut.println("Original ID: " + ID);

        // print valid ID
        StdOut.println("   Valid ID: " + createValidID(CustomerID));
    }
}