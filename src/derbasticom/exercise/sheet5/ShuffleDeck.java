/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package derbasticom.exercise.sheet5;

public class ShuffleDeck {

    public static void main(String[] foo) {

        // Print a random card
        System.out.println("Print a random card");
        
        String[] rank = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
        };
        String[] suit = {
            "Clubs", "Diamonds", "Hearts", "Spades"
        };

        // between 0 and 12
        int randomi = (int) (Math.random() * 13);
        // between 0 and 3 
        int randomj = (int) (Math.random() * 4);

        System.out.println(rank[randomi] + " of " + suit[randomj]);

        // Create a deck of playing cards and print them out
        System.out.println("Create a deck of playing cards and print them out");

        String[] deck = new String[52];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                deck[4 * i + j] = rank[i] + " of " + suit[j];
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println(deck[i]);
        }

        // Shuffling
        System.out.println("Shuffling");

        int N = deck.length;
        for (int i = 0; i < N; i++) {
            int r = i + (int) (Math.random() * (N - i));
            String t = deck[r];
            deck[r] = deck[i];
            deck[i] = t;
            // System.out.println(t);
        }
    }
}
