/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package derbasticom.exercise.sheet5;

/**
 * Würfel Simulation: Der folgende Code berechnet die genaue Wahrscheinlichkeits- 
 * verteilung1 für die Summe zweier Würfel.
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
        
    }
}
