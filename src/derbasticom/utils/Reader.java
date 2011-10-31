/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package derbasticom.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Help method...
 * 
 * @author sne
 */
public class Reader {

    /**
     * Return the input from the default input (console).
     * @param message text
     * @return Input string
     */
    public static String readString(String message) {
        System.out.print(message + ": ");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * Use {@link #readString(java.lang.String)}
     * @param message text
     * @return Parsed input
     */
    public static Integer readInteger(String message) {
        try {
            return Integer.parseInt(read(message));
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
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

    public static void headline(String headline) {
        System.out.println(headline);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < headline.length(); i++) {
            sb.append("=");
        }
        System.out.println(headline);
    }
}
