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
 * Help method...
 * 
 * @author sne
 */
public class In {

    /**
     * Return the input from the default input (console).
     * @param message text
     * @return Input string
     */
    public static String readStr(String message) {
        System.out.print(message + ": ");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
            return null;
        }
    }

    /**
     * Use {@link #readStr(java.lang.String)}
     * @param message text
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
     * Use {@link #readStr(java.lang.String)}
     * @param message text
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
     * @param message text
     */
    private static String read(String message) throws IOException {
        System.out.print(message + ": ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static String[] readFileByLine(String fileName) {

        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));

            String strLine;
            List<String> resultList = new ArrayList<String>();

            // line by line baby
            while ((strLine = br.readLine()) != null) {
                resultList.add(strLine);
            }

            dis.close();
            return resultList.toArray(new String[resultList.size()]);
        } catch (Exception ex) {
            System.err.println("File error: " + ex.getMessage());
            return null;
        }
    }

    // TODO [sne] place for refacortings
    public static String[] readFile(String fileName, String separator) {

        try {
            /*FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            // read first line
            line = br.readLine();
            // line and line, baby
            while (line != null){
            System.out.println(line);
            line = br.readLine();
            }
            br.close();*/

            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));

            String strLine;
            List<String> resultList = new ArrayList<String>();

            // line by line baby
            while ((strLine = br.readLine()) != null) {
                resultList.addAll(Arrays.asList(strLine.split(separator)));
            }

            dis.close();
            return resultList.toArray(new String[resultList.size()]);
        } catch (Exception ex) {
            System.err.println("File error: " + ex.getMessage());
            return null;
        }
    }
}
