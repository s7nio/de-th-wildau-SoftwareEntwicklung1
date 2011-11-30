package sne.exercise.sheet8;

import StdLib.StdAudio;
import StdLib.StdDraw;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Modifizieren Sie das Programm BouncingBall so, dass es die Erdanziehung 
 * (mit einem kleinen, von Ihnen willkürlich gewählten Faktor) in der Vertikale 
 * berücksichtigt und den Ball mittels einer Grafik darstellt. Fügen Sie 
 * zusätzlich mittels StdAudio.play() ein Geräusch ein, wenn der Ball die 
 * seitlichen Wände oder die Oberseite berührt. Ergänzen Sie ein weiteres, 
 * unterschiedliches Geräusch, wenn der Ball den Boden berührt.
 * 
 * Sound source http://freesound.org/, http://free-loops.com/, http://soundjax.com/.
 * 
 * @author sne
 */
public class Task3 {

    public static void main(String[] args) {

        double rx = .480, ry = .860; // position
        double vx = .015, vy = .023; // constant velocity
        double radius = .08; // radius
        double gravityIndex = .0005;

        int r = 50;
        int g = 50;
        int b = 50;

        double maxBounceY = 0;
        boolean bounceX = false;
        boolean bounceY = false;

        // rescale coordinates
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

        while (true) {

            // bounce
            if (Math.abs(rx + vx) + radius > 1.0) {
                vx = -vx;
                bounceX = true;
            }
            if (Math.abs(ry + vy) + radius > 1.0) { // +maxBounceY
                vy = -vy;
                bounceY = true;
            }

            if (bounceX) {
                //StdAudio.play("sounds/cmputers.wav");
                bounceX = false;
            } else if (bounceY) {
                //StdAudio.play("sounds/cmputers.wav");
                bounceY = false;
            }

            //System.out.println("rX:" + round(rx) + "; rY:" + round(ry));
            //System.out.println("vX:" + round(vx) + "; vY:" + round(vy));
            System.out.println("rX:" + round(rx) + "\t rY:" + round(ry)
                    + "\t vX:" + round(vx) + "\t vY:" + round(vy));

            // gravity
            if (Math.abs(rx + vx) + radius > 1.0) {
                // Aufprall
                System.out.println("Aufprall");
                vy -= .001;
                //maxBounceY += .005;
            }
            //                          vv: don't go in the underground
            if (vy > 0 || vy > -1 || ry + radius >= -1) {
                vy -= .004;
                maxBounceY += .008;
            } else {
                vy += .002;
            }

            // update position
            rx = rx + vx;
            ry = ry + vy;

            // change color (random)
            r = randomColor(r);
            g = randomColor(g);
            b = randomColor(b);

            StdDraw.setPenColor(new Color(r, g, b));
            StdDraw.filledSquare(0.0, 0.0, 1.0);
            StdDraw.picture(rx, ry, "images/45px-Emblem-cool.png");

            StdDraw.show(50);
        }
    }

    private static String round(double value) {
        DecimalFormat df = new DecimalFormat("0.000000");
        return df.format(value);
    }

    private static int randomColor(int color) {

        int random = new Random().nextInt(5);
        if (color + random > 255) {
            color -= 1;
        } else if (color - random < 1) {
            color += 1;
        } else if (new Random().nextBoolean()) {
            color += random;
        } else {
            color -= random;
        }
        return color;
    }
}
