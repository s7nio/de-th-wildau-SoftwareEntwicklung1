package sne.exercise.sheet9;

import StdLib.StdDraw;
import StdLib.StdIn;
import StdLib.StdOut;

/**
 * Spirale. Zeichnen Sie die abgebildete Spirale mittels eines Programms.
 * Ï
 * @author sne
 */
public class Task3 {

    public static void main(String[] foo) {

        StdOut.print("Window size (integer): ");
        int windowSize = StdIn.readInt();
        StdOut.print("Line width (integer): ");
        int lineWidth = StdIn.readInt();
        StdOut.print("Space width (integer): ");
        int spaceWidth = StdIn.readInt();

        // prepare canvas
        StdDraw.setCanvasSize(windowSize, windowSize);
        StdDraw.setXscale(-windowSize / 2, windowSize / 2);
        StdDraw.setYscale(-windowSize / 2, windowSize / 2);
        StdDraw.setPenRadius(lineWidth / 2 / 100.0); // XXX [sne] not correct scale

        int currentX = 0;
        int currentY = 0;
        int endX = 0;
        int endY = 0;

        byte quadrant = 0;
        final int DISTANCE = lineWidth + spaceWidth;

        while (Math.abs(currentX) + DISTANCE < windowSize || Math.abs(currentY) + DISTANCE < windowSize) {

            // set new end points
            endX = currentX;
            endY = currentY;
            
            quadrant++; // start by one
                    
            switch (quadrant) {
                case 1: // up
                    currentY = Math.abs(currentY) + DISTANCE; // positiv direction && add distance
                    break;
                case 2: // right
                    currentX = Math.abs(currentY); // positiv length from last currentY
                    break;
                case 3: // down
                    currentY = -1 * (currentY + DISTANCE); // negativ direction && add distance
                    break;
                case 4: // left
                    currentX = -1 * Math.abs(currentY); // negativ lendth from last currentY
                    quadrant = 0; // reset quadrant
                    break;
                default:
                    throw new IllegalStateException("Wrong quadrant");
            }

            //System.out.println(endX + " # " + endY + " # " + currentX + " # " + currentY);
            StdDraw.line(endX, endY, currentX, currentY);
        }
    }
}
