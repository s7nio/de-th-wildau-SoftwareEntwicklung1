/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package derbasticom.utils;

/**
 * Help method...
 * 
 * @author sne
 */
public class Output {
    
    public static void printObjectArrayHeadline(String headline, Object[] objectArray) {
        System.out.print(headline + ": ");
        printObjectArray(objectArray);
    }
    
    public static void printObjectArray(Object[] objectArray) {
        for (int i = 0; i < objectArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(objectArray[i].toString());
        }
        System.out.println();
    }
}
