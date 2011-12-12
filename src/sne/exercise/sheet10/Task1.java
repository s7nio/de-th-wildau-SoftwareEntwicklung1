package sne.exercise.sheet10;

/**
 * Schreiben Sie eine Methode, welche drei Boolean-Argumente übergeben bekommt und 
 * Wahr zurückliefert, wenn eine ungerade Anzahl von Argumenten Wahr ist. 
 * Ansonsten soll die Methode Falsch zurückgeben.
 * 
 * @author sne
 */
public class Task1 {

    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    public static void main(String[] foo) {

        System.out.println("TRUE, TRUE, TRUE = " + check(TRUE, TRUE, TRUE));
        System.out.println("FALSE, TRUE, TRUE = " + check(FALSE, TRUE, TRUE));
        System.out.println("TRUE, FALSE, TRUE = " + check(TRUE, FALSE, TRUE));
        System.out.println("TRUE, TRUE, FALSE = " + check(TRUE, TRUE, FALSE));
        System.out.println("FALSE, FALSE, TRUE = " + check(FALSE, FALSE, TRUE));
        System.out.println("TRUE, FALSE, FALSE = " + check(TRUE, FALSE, FALSE));
        System.out.println("FALSE, TRUE, FALSE = " + check(FALSE, TRUE, FALSE));
        System.out.println("FALSE, FALSE, FALSE = " + check(FALSE, FALSE, FALSE));
    }
    
    private static boolean check(boolean x1, boolean x2, boolean x3) {

        int counter = 0;
        
        if (x1) counter++;
        if (x2) counter++;
        if (x3) counter++;
        
        if (counter % 2 != 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Dynamic alternative to {@link #check(boolean, boolean, boolean)}.
     * 
     * @param trueValues count of true boolean
     * @param values boolean collection
     * @return boolean has this count of the values
     */
    private static boolean check(int trueValues, boolean... values) {

        int count = 0;
        for (int i = 0; i < values.length; i++) {

            if (count >= trueValues) {
                return true;
            }
            if (values[i]) {
                count++;
            }
        }
        return false;
    }
}
