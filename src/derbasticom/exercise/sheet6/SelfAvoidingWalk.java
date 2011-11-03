package derbasticom.exercise.sheet6;

import derbasticom.utils.Reader;

/**
 * The snake game.
 * 
 * @author sne
 */
public class SelfAvoidingWalk {

    public static void main(String[] foo) {

        /*int N = Reader.readInteger("Wie groß soll das Feld sein?");
        boolean[][] field = new boolean[N][N];*/

        // lattice size
        int N = Reader.readInteger("Feld-Größe");
        // number of trials
        int T = Reader.readInteger("Anzahl der Versuche");
        // trials resulting in dead end
        int deadEnds = 0;

        for (int t = 0; t < T; t++) {
            // intersections visited
            boolean[][] field = new boolean[N][N];

            // current position (center)
            int x = N / 2;
            int y = N / 2;

            while (x > 0 && x < N - 1 && y > 0 && y < N - 1) {
                if (field[x - 1][y] && field[x + 1][y] && field[x][y - 1] && field[x][y + 1]) {
                    deadEnds++;
                    break;
                }

                // mark as visited
                field[x][y] = true;

                double r = Math.random();
                if (r < 0.25) {
                    if (!field[x + 1][y]) {
                        x++;
                    }
                } else if (r < 0.50) {
                    if (!field[x - 1][y]) {
                        x--;
                    }
                } else if (r < 0.75) {
                    if (!field[x][y + 1]) {
                        y++;
                    }
                } else if (r < 1.00) {
                    if (!field[x][y - 1]) {
                        y--;
                    }
                }
            }
        }

        System.out.println(100 * deadEnds / T + "% dead ends");
    }
}
