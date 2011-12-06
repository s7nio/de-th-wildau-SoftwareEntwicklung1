package sne.exercise.sheet5;

import sne.utils.Out;
import sne.utils.In;
import java.util.Random;

/**
 * Würfel Simulation: Der folgende Code berechnet die genaue Wahrscheinlichkeits- 
 * verteilung für die Summe zweier Würfel.
double[] dist = new double[13];
for (int i = 1; i <= 6; i++)
for (int j = 1; j <= 6; j++)
dist[i+j] += 1.0;
for (int k = 1; k <= 12; k++)
dist[k] /= 36.0;
 * Der Wert dist[k] ist dabei die Wahrscheinlichkeit, dass die gewürfelten 
 * Werte in Summe k ergeben. Programmieren Sie eine Simulation, um diese 
 * Wahrscheinlichkeiten mit N Würfen der Würfel (Kommandozeilen-Parameter) 
 * zu überprüfen. Merken Sie sich dafür die Häufigkeit des Auftretens der 
 * einzelnen Summen von zwei ganzzahligen Zufallszahlen zwischen 1 und 6.
 * 
 * Wie viele Würfe benötigen Sie, bis Ihre empirisch gewonnenen Resultate 
 * die genauen Werte bis zur dritten Nachkommastelle bestätigen?
 * 
 * @author sne
 */
public class Task4 {

    public static void main(String[] foo) {

        Double[] dist = new Double[13];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = new Double(0);
        }
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                dist[i + j] += 1.0;
            }
        }
        for (int k = 1; k <= 12; k++) {
            dist[k] = round(dist[k] / 36.0);
        }

        Out.printObjectArrayMessage("Kontrolle", dist);

        int n = In.readInt("Anzahl der Würfe");

        // create field
        Integer[] field = new Integer[13];
        Double[] resultField = new Double[13];
        for (int i = 0; i < field.length; i++) {
            field[i] = new Integer(0);
            resultField[i] = new Double(0);
        }

        Random generator = new Random();
        int x, y;

        // simulation counter
        for (int i = 0; i < n; i++) {

            do {
                x = generator.nextInt(7);
                y = generator.nextInt(7);
            } while (x + y < 2);

            field[x + y] += 1;
        }

        //Output.printObjectArray(field);

        // calculate result
        for (int i = 2; i <= 12; i++) {
            resultField[i] = round(field[i].doubleValue() / 36.);
        }

        Out.printObjectArrayMessage("Kontrolle", resultField);
    }

    private static Double round(Double d) {
        return Double.valueOf(Math.rint(d.doubleValue() * 1000.) / 1000.);
    }
}
