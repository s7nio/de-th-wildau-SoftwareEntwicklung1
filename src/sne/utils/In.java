/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sne.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Help method for input stuff.
 * 
 * @author sne
 */
public class In {

    /**
     * Read from the default system input (console) and parse that to an String.
     * Return null in error cases.
     * 
     * @param message which is displayed befor an input
     * @return Input string
     */
    public static String readStr(String message) {
        System.out.print(message + ": ");
        try {
            // TODO [sne] use #read();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
            return null;
        }
    }

    /**
     * Read from the default system input (console) and parse that to an Integer.
     * Return null in error cases.
     * 
     * @param message which is displayed befor an input
     * @return Parsed input
     */
    public static Integer readInt(String message) {
        try {
            return Integer.parseInt(read(message));
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
            return null;
        }
    }

    /**
     * Read from the default system input (console) and parse that to an Double.
     * Return null in error cases.
     * 
     * @param message which is displayed befor an input
     * @return Parsed input
     */
    public static Double readDouble(String message) {
        try {
            return Double.parseDouble(read(message));
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
            return null;
        }
    }

    /**
     * Help method which read from the default input (console).
     * 
     * @param message which display in front of the input
     */
    private static String read(String message) throws IOException {
        System.out.print(message + ": ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    /**
     * Return null in error cases.
     * 
     * @param fileName
     * @return String[] which is splitted by line
     */
    public static String[] readFileByLine(String fileName) {

        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));

            String strLine;
            List<String> resultList = new ArrayList<String>();

            // read line by line
            while ((strLine = br.readLine()) != null) {
                resultList.add(strLine);
            }

            dis.close();
            
            // convert list to an array
            return resultList.toArray(new String[resultList.size()]);
        } catch (Exception ex) {
            System.err.println("File error: " + ex.getMessage());
            return null;
        }
    }

    /**
     * This method read a file (by fileName parameter) and split the content 
     * by the committed separator parameter.
     * Return null in error cases.
     * 
     * @param fileName String
     * @param separator String
     * @return String[] which is splitted by the separator
     */
    public static String[] readFile(String fileName, String separator) {

        // TODO [sne] place for refacortings
        try {
            /*FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            // read first line
            line = br.readLine();
            // line and line, baby
            while (line != null){
            // do...
            line = br.readLine();
            }
            br.close();*/

            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));

            String strLine;
            List<String> resultList = new ArrayList<String>();

            // read line by line
            while ((strLine = br.readLine()) != null) {
                resultList.addAll(Arrays.asList(strLine.split(separator)));
            }

            dis.close();
            
            // convert list to an array
            return resultList.toArray(new String[resultList.size()]);
        } catch (Exception ex) {
            System.err.println("File error: " + ex.getMessage());
            return null;
        }
    }
}
