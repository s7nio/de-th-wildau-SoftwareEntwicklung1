package sne.exercise.sheet8;

import StdLib.StdAudio;
import StdLib.StdDraw;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Uhr. Schreiben Sie ein Programm, welches eine analoge Uhr mit Stunden, Minuten 
 * und Sekunden anzeigt und aktualisiert. Benutzen Sie StdDraw.show(1000) um eine 
 * Pause von zirka einer Sekunde zu erzeugen.
 * Tipp: Sie können den %-Operator auch mit Double-Werten verwenden.
 * 
 * Sound from http://www.durchzug.info/
 * 
 * @author sne
 */
public class Task2 {

    // 90, 30, 6
    private static double[] cos90;
    private static double[] sin90;
    private static double[] cos30;
    private static double[] sin30;
    private static double[] cos6;
    private static double[] sin6;
    private static double diameter;
    private static Calendar cal;

    public static void main(String[] foo) {

        prepare();

        int tmp_m = cal.get(Calendar.MINUTE);

        while (true) {

            clear();
            clockFace(diameter);

            cal = GregorianCalendar.getInstance(Locale.GERMANY);

            if (tmp_m != cal.get(Calendar.MINUTE)) {
                //StdAudio.play("sounds/02Signal-de-eng.wav");
                //StdDraw.show(16000);
            }

            // 360°/12h = 30°/h
            int hours = cal.get(Calendar.HOUR_OF_DAY);
            // 360°/60min = 6°/min
            int minutes = cal.get(Calendar.MINUTE);
            // 360°/3600s = 0.5°/s
            int seconds = cal.get(Calendar.SECOND);
            // 360°/ = °/ms
            int milliseconds = cal.get(Calendar.MILLISECOND);

            milliseconds += 49;
            milliseconds /= 100;

            tmp_m = minutes;

            // Stunden
            if (hours < 12) {
                StdDraw.line(0, 0, ((60 * Math.cos(Math.toRadians(hours % 12 * 30 + minutes / 2.0 - 90)))),
                        -((60 * Math.sin(Math.toRadians(hours % 12 * 30 + minutes / 2.0 - 90)))));
            } else {
                StdDraw.line(0, 0, ((60 * Math.cos(Math.toRadians(hours % 12 * 30 + minutes / 2.0 - 90)))),
                        ((60 * Math.sin(Math.toRadians(hours % 12 * 30 + minutes / 2.0 - 90)))));
            }
            // Minuten
            StdDraw.line(0, 0, (80 * Math.cos(Math.toRadians(minutes * 6 - 90))),
                    -(80 * Math.sin(Math.toRadians(minutes * 6 - 90))));
            // Sekunden
            StdDraw.setPenColor(Color.RED);
            StdDraw.line(0, 0, (90 * Math.cos(Math.toRadians(seconds * 6 - 90 + milliseconds / 2.0))),
                    -(90 * Math.sin(Math.toRadians(seconds * 6 - 90 + milliseconds / 2.0))));

            double h = -(hours + minutes) / 12.0;
            //double h = 30. * hours - 90. + minutes / 2.0;
            double m = -(minutes + seconds) / 60.0;
            //double m = 6. * minutes - 90.;
            double s = -(seconds + (double) milliseconds / 1000) / 60.0;
            //double s = 6. * seconds - 90.;
            /*clockHand(h, 60);
            clockHand(m, 80);
            clockHand(s, 90);*/

            StdDraw.show(10);
        }
    }

    private static void prepare() {

        // init draw scale
        StdDraw.setXscale(-100, 100);
        StdDraw.setYscale(-100, 100);

        diameter = 100;

        cal = GregorianCalendar.getInstance(Locale.GERMANY);

        // pre calculation
        cos90 = new double[4];
        sin90 = new double[4];
        cos30 = new double[12];
        sin30 = new double[12];
        cos6 = new double[60];
        sin6 = new double[60];

        // calculate h, min and s clock lines
        for (int i = 0; i < 60; i++) {
            if (i < 4) {
                cos90[i] = Math.cos(Math.toRadians(90 * i));
                sin90[i] = Math.sin(Math.toRadians(90 * i));
            }
            if (i < 12) {
                cos30[i] = Math.cos(Math.toRadians(30 * i));
                sin30[i] = Math.sin(Math.toRadians(30 * i));
            }
            cos6[i] = Math.cos(Math.toRadians(6 * i));
            sin6[i] = Math.sin(Math.toRadians(6 * i));
        }
    }

    private static void clear() {

        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledSquare(0, 0, diameter);
        //StdDraw.filledCircle(0, 0, diameter - 11);
        StdDraw.setPenColor(StdDraw.BLACK);
    }

    private static void clockFace(double diameter) {

        for (int i = 0; i < 60; i++) {

            int size = 0;
            if (i < 4) {
                // line at 3, 6, 9 and 12
                size = 7;
                StdDraw.line(
                        ((diameter - size) * cos90[i]),
                        ((diameter - size) * sin90[i]),
                        (diameter * cos90[i]),
                        (diameter * sin90[i]));
            }
            if (i < 12) {
                // line at every hour
                size = 5;
                StdDraw.line(
                        ((diameter - size) * cos30[i]),
                        ((diameter - size) * sin30[i]),
                        (diameter * cos30[i]),
                        (diameter * sin30[i]));
            }
            // line at every minute
            size = 2;
            StdDraw.line(
                    ((diameter - size) * cos6[i]),
                    ((diameter - size) * sin6[i]),
                    (diameter * cos6[i]),
                    (diameter * sin6[i]));
        }

        /*/ clock text
        StdDraw.text(0, 88, "12");
        StdDraw.text(0, -90, "6");
        StdDraw.text(90, 0, "3");
        StdDraw.text(-90, 0, "9");*/

        StdDraw.text(0, 10, new SimpleDateFormat("dd.MM.yyyy").format(cal.getTime()));
        StdDraw.text(0, -10, new SimpleDateFormat("HH:mm:ss").format(cal.getTime()));
    }

    private static void clockHand(double value, int handSize) {

        double radians = 2.0 * Math.PI * (0.5 - value);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);

        int dxmin = 0;
        int dymin = 0;
        int dxmax = (int) (handSize * sin);
        int dymax = (int) (handSize * cos);
        StdDraw.line(dxmin, dymin, dxmax, dymax);
    }
}
