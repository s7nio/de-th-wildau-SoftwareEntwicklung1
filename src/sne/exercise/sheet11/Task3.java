package sne.exercise.sheet11;

/**
 * Binäre Suche. Schreiben Sie ein Programm zur Ermittlung des Inverswertes x0 der 
 * kumulierten Verteilungsfunktion Phi() an der Stelle y0.
 * 
 * Um den Wert von x0, bei dem Phi(x0)=y0 ist, zu ermitteln, beginnen Sie mit der 
 * Berechnung von f(0,5). Ist dieser Wert größer als y0 dann liegt x0 zwischen 
 * 0 und 0,5. Andernfalls muss der Wert zwischen 0,5 und 1 liegen. 
 * Halbieren Sie nunmehr den entsprechenden Intervall in welchem sich x0 befinden muss 
 * und berechnen Sie diesen mittleren Wert, z.B. f(0,25). Durch die Wiederholung 
 * dieser Schritte lässt sich x0 bis zu einer definierten Genauigkeit (epsilon=0,1*10-7) ermitteln. 
 * Implementieren Sie diese Funktionalität in der Methode PhiInverse() und 
 * verändern Sie das Hauptprogramm so, dass für die drei in der Kommandozeile übergebenen 
 * Parameter Mittelwert, Standardabweichung und y0 den Wert für x0 auf dem Bildschirm ausgibt.
 * 
 * Wieviele Punkte müsste ein Student erreichen, um zu dem besten 10% des Jahrgangs zu gehören, 
 * wenn die Testergebnisse der Abschlussklausur normal verteilt wären mit einem Mittelwert 
 * von 500 und einer Standardabweichung von 100.
 * 
 * @author sne
 */
public class Task3 {

    public static void main(String[] foo) {
        
    }
}
