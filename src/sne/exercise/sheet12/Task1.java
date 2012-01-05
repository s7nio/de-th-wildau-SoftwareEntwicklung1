package sne.exercise.sheet12;

import StdLib.StdStats;
import sne.utils.*;

/**
 * Schreiben Sie eine statische Methode, welche zwei Double-Werte ymin / ymax (mit ymin < ymax) 
 * und ein Double-Feld a als Argumente übergeben bekommt und mit Hilfe der StdStats-Bibliothek 
 * die Werte in a so linear skaliert, dass alle bei gleichem Verhältnis 
 * zwischen ymin und ymax liegen.
 * 
 * @author sne
 */
public class Task1 {

    public static void main(String[] foo) {
        
        
        double[] arr = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Out.printObjectArrayMessage("Orginal array", arr);
        Out.printObjectArrayMessage("Scale array", scaleMethod(0, 1, arr));
    }
    
    private static double[] scaleMethod(double min, double max, double[] a) {
        
        double[] mod_a = a;
        double dif = max - min;
        
        double org_min = StdStats.min(a);
        double org_max = StdStats.max(a);
        double org_dif = org_max - org_min;
        
        for (int i = 0; i < mod_a.length; i++) {
             mod_a[i] = min + (mod_a[i] - org_min) / org_dif * dif;
        }
        
        return mod_a;
    }
}
