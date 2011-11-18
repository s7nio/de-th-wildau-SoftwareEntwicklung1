/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.sheet8;

import StdLib.*;

/**Modifizieren Sie das Programm BouncingBall so, dass es die Erdanziehung (mit einem kleinen, von
 *Ihnen willkürlich gewählten Faktor) in der Vertikale berücksichtigt und den Ball mittels einer 
 *Grafik darstellt. Fügen Sie zusätzlich mittels StdAudio.play() ein Geräusch ein, wenn der Ball 
 *die seitlichen Wände oder die Oberseite berührt. Ergänzen Sie ein weiteres, unterschiedliches 
 *Geräusch, wenn der Ball den Boden berührt.
 *
 * @author david
 */
public class exercise3_bouncingball {
     
    public static void main(String[] args) {
        
        double rx = .480, ry = .860;    // position
        double vx = .015, vy = 0.023;   // constant velocity
        double radius = .05;            // radius
        double gravity = 0.000981;      // gravity   
        double updateRate = 1.0 / 20;   // frames per second
        
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);  // rescale coordinates

        while (true) {
            
            vy = vy - gravity;
            
            
            if (Math.abs(rx + vx) + radius > 1.0) {
                vx = -vx;
                StdAudio.play("Clap.wav");
            }

            if (ry + vy + radius > 1.0) {
                StdAudio.play("Clap.wav");                
            }
            
            if (Math.abs(ry + vy) + radius > 1.0) {
                vy = -vy;
            }
            
            if (ry - vy - radius < -1.0) {
                StdAudio.play("DD_Crash20.wav");
                vy = vy * 0.85;
            }

            rx = rx + vx;
            ry = ry + vy;
            
            
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledSquare(0.0, 0.0, 1.0);
            StdDraw.picture(0.0, 0.0, "space2.jpg", 2.0, 2.0);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.picture(rx, ry, "basketball.gif", 2 * radius, 2 * radius);
//          StdDraw.filledCircle(rx, ry, radius);
            StdDraw.show(20);
        }
    }
}
