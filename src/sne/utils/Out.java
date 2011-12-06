/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sne.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Help method for output stuff.
 * 
 * @author sne
 */
public class Out {

    private static BufferedWriter bufferedWriter;

    /**
     * Print the headline to the default system output (console).
     * @param headline your headline text
     */
    public static void headline(String headline) {
        System.out.println(headline);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < headline.length(); i++) {
            sb.append("=");
        }
        System.out.println(headline);
    }
    
    public static void printObjectArrayMessage(String message, double... doubleArray) {
        System.out.print(message + ": ");
        
        // convert
        Object[] objectArray = new Object[doubleArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            objectArray[i] = doubleArray[i];
        }
        
        printObjectArray(objectArray);
    }

    /**
     * Print the message and object array in a well form to the default system output (console).
     * 
     * @param message String
     * @param objectArray Object[]
     */
    public static void printObjectArrayMessage(String message, Object[] objectArray) {
        System.out.print(message + ": ");
        printObjectArray(objectArray);
    }

    /**
     * Print object array in a well form.
     * 
     * @param objectArray Object[]
     */
    public static void printObjectArray(Object[] objectArray) {
        for (int i = 0; i < objectArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            if (objectArray[i] != null) {
                System.out.print(objectArray[i].toString());
            } else {
                System.out.print("> null <");
            }
        }
        System.out.println();
    }

    /**
     * Begin to write an file to your local file system.
     * e.g. {@see #fileWrite(java.lang.Object)}, {@see #fileAppend(java.lang.Object)}, {@see #fileNewLine()}
     * 
     * You find the file in your programm call path.
     * 
     * Don's forget to close the file!
     * {@see #fileClose()}
     * 
     * Limitation: you can not write more files concurrent.
     * 
     * @param fileName 
     */
    public static void fileBegin(String fileName) {

        if (fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("Missing file name.");
        }
        if (bufferedWriter != null) {
            throw new IllegalStateException("you can not write more files concurrent.");
        }

        try {
            FileWriter fw = new FileWriter(fileName);
            bufferedWriter = new BufferedWriter(fw);
        } catch (IOException ex) {
            System.err.println("File error: " + ex.getMessage());
        }
    }

    /**
     * Close the file, which you write.
     */
    public static void fileClose() {

        if (bufferedWriter == null) {
            System.err.print("Call first method beginFile(String fileName)");
            return;
        }

        try {
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedWriter = null;
        } catch (IOException ex) {
            System.err.println("File error: " + ex.getMessage());
        }
    }

    /**
     * Write a message to the current file-line. After that, they make a line break.
     * 
     * @param messsage 
     */
    public static void fileWrite(Object messsage) {

        if (bufferedWriter == null) {
            System.err.print("Call first method beginFile(String fileName)");
            return;
        }

        try {
            bufferedWriter.write(messsage.toString());
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.err.println("File error: " + ex.getMessage());
        }
    }

    /**
     * Append the text in the opened file.
     * 
     * @param messsage 
     */
    public static void fileAppend(Object messsage) {

        if (bufferedWriter == null) {
            System.err.print("Call first method beginFile(String fileName)");
            return;
        }

        try {
            bufferedWriter.append(messsage.toString());
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    /**
     * Generate a line break.
     */
    public static void fileNewLine() {

        if (bufferedWriter == null) {
            System.err.print("Call first method beginFile(String fileName)");
            return;
        }

        try {
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
  
    
    public static String round(double a) {
        BigDecimal bd = new BigDecimal(a);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        System.out.println(bd);
        return bd.toString();
    }
}
