package sne.exercise.sheet10;

/**
 * Schreiben Sie eine Methode any() welche ein Feld von Boolean-Werten als 
 * Argument übergeben bekommt und Wahr zurückliefert, wenn einer der Werte 
 * im Feld Wahr ist. Schreiben Sie eine Methode all(), welche ein Feld 
 * von Boolean-Werten als Argument übergeben bekommt und Wahr zurückliefert, 
 * wenn alle der Werte des Feldes Wahr sind. Ansonsten sollen beide 
 * Methoden Falsch zurückgeben.
 * 
 * Testen Sie Ihre Methode mit passenden Beispieldaten.
 * 
 * @author sne
 */
public class Task3 {

    private static final boolean T = true;
    private static final boolean F = false;
    
    private static double min = Double.MAX_VALUE;
    private static double max = Double.MIN_VALUE;

    public static void main(String[] foo) {

        System.out.println("f f f = any " + any(new boolean[] {F, F, F}));
        System.out.println("f t f = any " + any(new boolean[] {F, T, F}));
        System.out.println("t t t = any " + any(new boolean[] {T, T, T}));
        System.out.println("f f f f f = all " + all(new boolean[] {F, F, F, F, F}));
        System.out.println("f t t t t = all " + all(new boolean[] {F, T, T, T, T}));
        System.out.println("t t t t t = all " + all(new boolean[] {T, T, T, T, T}));
    }
    
    private static boolean any(boolean[] values, boolean bool) {
        
        for (int i = 0; i < values.length; i++) {
            if (values[i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean any(boolean[] values) {

        return any(values, true);
    }

    private static boolean all(boolean[] values) {

        return !any(values, false);
    }
}
