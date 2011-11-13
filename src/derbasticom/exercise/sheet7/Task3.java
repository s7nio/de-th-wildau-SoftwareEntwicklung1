package derbasticom.exercise.sheet7;

import derbasticom.utils.*;

/**
 * Modifizieren Sie Ihr Programm aus Aufgabe 2 so, dass es alle Werte aus der 
 * Datei WERTE.TXT einliest und die beschriebenen Statistiken dafür ermittelt.
 * 
 * @author sne
 */
public class Task3 {

    public static void main(String[] foo) {
        
        String fileName = In.readStr("Dateiname (file in launch path - sne_sheet7task1.txt)");

        String[] field = In.readFileByLine(fileName);

        MathStatistics stati = new MathStatistics();
        for (int i = 0; i < field.length; i++) {
            stati.update(Double.parseDouble(field[i]));
        }

        System.out.println(stati.toString());
    }
}
