/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package derbasticom.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Help method...
 * 
 * @author sne
 */
public class Out {

    private static BufferedWriter bufferedWriter;
    
    public static void headline(String headline) {
        System.out.println(headline);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < headline.length(); i++) {
            sb.append("=");
        }
        System.out.println(headline);
    }

    public static void printObjectArrayHeadline(String headline, Object[] objectArray) {
        System.out.print(headline + ": ");
        printObjectArray(objectArray);
    }

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
     * You find the file in your programm call path.
     * 
     * Don's forget to close the file!
     * 
     * @param fileName 
     */
    public static void fileBegin(String fileName) {

        if (fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("Missing file name");
        }

        try {
            FileWriter fw = new FileWriter(fileName);
            bufferedWriter = new BufferedWriter(fw);
        } catch (IOException ex) {
            System.err.println("File error: " + ex.getMessage());
        }
    }

    public static void fileClose() {

        if (bufferedWriter != null) {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException ex) {
                System.err.println("File error: " + ex.getMessage());
            }
        }
    }

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

    public static void fileAppend(Object messsage) {

        if (bufferedWriter != null) {
            try {
                bufferedWriter.append(messsage.toString());
            } catch (IOException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }
    
    public static void fileNewLine() {

        if (bufferedWriter != null) {
            try {
                bufferedWriter.newLine();
            } catch (IOException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }
}
