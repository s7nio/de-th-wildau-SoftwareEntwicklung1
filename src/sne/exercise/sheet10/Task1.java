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

        if (x1 || x2 || x3 || x1 && x2 && x3) {
            return true;
        }
        return false;
    }
}
