package sne.exercise.sheet7;

import sne.utils.In;

/**
 *
 * @author sne
 */
public class Task5 {

    public static void main(String[] foo) {
        
        //ugly();
        // TODO [sne] use asci table
    }

    private static void ugly() {
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        int k = In.readInt("Verschiebung");

        String orginal = In.readStr("Ihr Orginal Text");

        char[] org = new char[orginal.length()];
        // copy text to char array
        for (int i = 0; i < org.length; i++) {
            org[i] = orginal.charAt(i);
        }

        for (int i = 0; i < org.length; i++) {

            // check is in array
            boolean tmp_check = false;
            for (int j = 0; j < alphabet.length; j++) {
                if (alphabet[j] == org[i]) {
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
                        org[i] = alphabet[rest];
                    } else if (j + k < 0) {
                        int rest = (j + k) % alphabet.length + alphabet.length;
                    } else {
                        org[i] = alphabet[j + k];
                    }
                }
            }
        }

        System.out.println(orginal);
        System.out.println(org);
    }
}
