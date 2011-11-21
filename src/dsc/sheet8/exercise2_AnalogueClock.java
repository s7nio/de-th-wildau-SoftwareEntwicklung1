/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet8;

import StdLib.*;
import java.util.Calendar;

/**
 *
 * @author david
 */
public class exercise2_AnalogueClock {

    /* Uhr. Schreiben Sie ein Programm, welches eine analoge Uhr mit Stunden, Minuten und Sekunden 
     * anzeigt und aktualisiert. Benutzen Sie StdDraw.show(1000) um eine Pause von zirka einer 
     * Sekunde zu erzeugen.
     * 
     * Tipp: Sie können den %-Operator auch mit Double-Werten verwenden.
     */
    public static void main(String[] args) {

        double Xsecond = 0;
        double Ysecond = 0;
        double Xminute = 0;
        double Yminute = 0;
        double Xhour = 0;
        double Yhour = 0;


        double angle = 2 * Math.PI / 60;
        double hourAngle = 2 * Math.PI / 12;

        // rescale
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);


        while (true) {

            Calendar calendar = Calendar.getInstance();

            int hours = calendar.get(Calendar.HOUR);
            int minutes = calendar.get(Calendar.MINUTE);
            int seconds = calendar.get(Calendar.SECOND);

            Xsecond = Math.sin(seconds * angle) * 0.95;
            Ysecond = Math.cos(seconds * angle) * 0.95;

            Xminute = Math.sin(minutes * angle) * 0.75;
            Yminute = Math.cos(minutes * angle) * 0.75;

            Xhour = Math.sin(hours * hourAngle) * 0.6;
            Yhour = Math.cos(hours * hourAngle) * 0.6;

            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(0, 0, 1);
            StdDraw.picture(0, 0, "clockface.png", 2.3, 2.3);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.002);
            StdDraw.line(0, 0, Xsecond, Ysecond);
            StdDraw.setPenRadius(0.005);
            StdDraw.line(0, 0, Xminute, Yminute);
            StdDraw.setPenRadius(0.008);
            StdDraw.line(0, 0, Xhour, Yhour);
            StdDraw.show(1000);
        }
    }
}