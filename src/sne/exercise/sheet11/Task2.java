package sne.exercise.sheet11;

import StdLib.StdIn;
import StdLib.StdOut;
import java.util.regex.Pattern;
import sne.utils.*;

/**
 * Die folgende Formel wird z.B. von Banken und Kreditkartenfirmen verwendet, um die 
 * Gültigkeit von Kundennummern zu überprüfen:
 * 
 * (d0 +f(d1) + d2 + f(d3) + d4 + f(d5) + d6 + ...) mod 10 = 0
 * 
 * Die Werte di stehen dabei für einzelnen Ziffern der Kundennummer und f(d) 
 * ist die Summe der Ziffern des Ergebnisses von 2*d. Zum Beispiel ist f(7)=5 
 * weil 2*7=14 und 1+4=5 ist. Daher ist die Kundennummer 17327 gültig 
 * weil 1+5+3+4+7=20 und ein Vielfaches von 10 ist. 
 * Implementieren Sie die Funktion f(d) und eine Methode zur Überprüfung einer Kundennummer. 
 * Schreiben Sie ein Programm welches eine Ganzzahl aus 10 Ziffern als Kommandozeilen-Parameter 
 * übergeben bekommt und eine gültige Kundennummer mit 11 Ziffern auf dem Bildschirm ausgibt. 
 * Die ersten 10 Ziffern sind dabei die übergebene Ganzzahl und die letzte Ziffer 
 * ist die Checksumme, um aus dieser Zahl eine gültige Kundennummer zu machen.
 * 
 * Welche Kundennummer erhalten Sie für die Ganzzahl 3524573248?
 * 
 * @author sne
 */
public class Task2 {

    public static void main(String[] foo) {

        StdOut.print("Ihre Kundennummer: ");
        String input = StdIn.readString();

        StdOut.println("Ist diese Kundenummer valid? => " + isCustomerNumber(input));
    }
    
    private static boolean isValidCustomerNumber(String numberString) {
        
        /*
         * .	Any character (may or may not match line terminators)
         * \d	A digit: [0-9]
         * \D	A non-digit: [^0-9]
         * \s	A whitespace character: [ \t\n\x0B\f\r]
         * \S	A non-whitespace character: [^\s]
         * \w	A word character: [a-zA-Z_0-9]
         * \W	A non-word character: [^\w]
         */
        String regEx = "\\d+";
        if (!numberString.matches(regEx)) { // Pattern.matches(regEx, input)
            //throw new IllegalStateException("This is not a customer number.");
            return false;
        }
        return true;
    }
    
    private static boolean isCustomerNumber(String numberString) {
     
        int sum = 0;
        boolean addChange = false;
        // sum over fields
        for (int i = 0; i < numberString.length(); i++) {
            
            if (addChange) {
                sum += numberString.charAt(i); // FIXME [sne] check
                addChange = false;
            } else {
                //sum += Math.qs(2*d);
                addChange = true;
            }
        }
        
        // validate
        if (sum % 10 == 0) {
            
        } else {
            
        }
        
        return false;
    }
    
    private static void digitSum() {
        
    }
}
