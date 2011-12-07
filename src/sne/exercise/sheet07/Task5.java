package sne.exercise.sheet07;

import sne.utils.In;

/**
 * Caesar Chiffre. Julius Caesar schickte eine geheime Nachricht an Cicero in einer Kodierung 
 * welche heute als Caesar Chiffre bekannt ist. Jeder Buchstabe wird dabei durch den Buchstaben 
 * ersetzt, welcher k Positionen danach im Alphabet folgt. Am Ende des Alphabetes wird von 
 * Vorn begonnen. Die nachfolgende Tabelle beschreibt das Caesar Chiffre mit k = 3:
 * 
 * Original: ABCDEFGHIJKLMNOPQRSTUVWXYZ
 * Caesar: DEFGHIJKLMNOPQRSTUVWXYZABC
 * 
 * So wird zum Beispiel die Nachricht "VENI, VIDI, VICI" zu “YHQL, YLGL, YLFL".
 * Schreiben Sie ein Programm, welches k als Kommandozeilen-Parameter einliest, und das Caesar 
 * Chiffre auf einen beliebig langen Text von der Standardeingabe anwendet und diesen 
 * danach auf dem Bildschirm ausgibt. Wenn ein Zeichen kein Buchstabe ist, geben 
 * Sie ihn einfach unverändert aus.
 * 
 * @author sne
 */
public class Task5 {

    public static void main(String[] foo) {

        int k = In.readInt("Verschiebung");
        String orginal = In.readStr("Ihr Orginal Text");

        char[] copy = new char[orginal.length()];

        // copy text to char array
        for (int i = 0; i < copy.length; i++) {
            copy[i] = orginal.charAt(i);
        }

        //versionOkay(k, orginal, copy.clone());
        versionBetter(k, copy.clone());
    }

    private static void versionOkay(int k, String orginal, char[] copy) {

        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (int i = 0; i < copy.length; i++) {

            // check is in array
            boolean tmp_check = false;
            for (int j = 0; j < alphabet.length; j++) {
                if (alphabet[j] == copy[i]) {
                    tmp_check = true;
                }
            }
            if (!tmp_check) {
                continue;
            }

            // ....
            for (int j = 0; j < alphabet.length; j++) {

                if (alphabet[j] == orginal.charAt(i)) {

                    if (j + k > alphabet.length) {
                        int rest = (j + k) % alphabet.length;
                        copy[i] = alphabet[rest];
                    } else if (j + k < 0) {
                        int rest = (j + k) % alphabet.length + alphabet.length;
                    } else {
                        copy[i] = alphabet[j + k];
                    }
                }
            }
        }
        System.out.println(copy);
    }

    /**
     * This version use the asci table.
     */
    private static void versionBetter(int k, char[] copy) {

        for (int i = 0; i < copy.length; i++) {

            int asciiCode = (int) copy[i];
            boolean isUpperChar = asciiCode >= 65 && asciiCode <= 90;
            boolean isLowwerChar = asciiCode >= 97 && asciiCode <= 122;

            // check, is this char to convert (Chiffre)
            if (isUpperChar || isLowwerChar) {

                int shift = asciiCode + k;

                if (isUpperChar && shift > 90) {
                    // shift bounced
                    copy[i] = (char) (65 + k - (91 - asciiCode));
                } else if (isLowwerChar && shift > 122) {
                    // shift bounced
                    copy[i] = (char) (97 + (asciiCode % k));
                } else {
                    // normal shift
                    copy[i] = (char) (shift);
                }
            }
        }
        System.out.println(copy);
    }
}
