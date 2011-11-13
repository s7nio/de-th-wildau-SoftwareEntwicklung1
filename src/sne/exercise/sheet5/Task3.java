/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sne.exercise.sheet5;

import sne.utils.In;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Modifizieren Sie das Programm „Shuffle Deck“ so, dass Sie mit Hilfe des 
 * neuen Kommandozeilen-Parameters N festlegen können, wie viele Poker 
 * Blätter (bestehend aus jeweils 5 Karten) aus den gemischten Karten 
 * gegeben (Bildschirmanzeige getrennt durch Leerzeilen) werden sollen.
 * 
 * @author sne
 */
public class Task3 {

    public static void main(String[] foo) {

        String[] rank = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
        };
        String[] suit = {
            "Clubs", "Diamonds", "Hearts", "Spades"
        };

        // create a deck of playing cards
        String[] deck = new String[52];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                deck[4 * i + j] = rank[i] + " of " + suit[j];
            }
        }

        // shuffling the deck
        List<String> shuffleDeck = Arrays.asList(deck);
        Collections.shuffle(shuffleDeck);

        int N = In.readInt("Wie viele Poker Blätter werden benötigt");
        
        /*int tmpGiver = 0;
        for (int i = 0; i < N; i++) {
        
        System.out.println("==== Poker-Blatt " + (i + 1) + " ===="); // or empty line
        
        for (int j = 0; j < 5; j++) {
        
        // check if the deck stack empty
        if (tmpGiver >= 52) {
        System.out.println("The deck stack is empty!");
        //break; // need a second check and break in the outside loop
        Runtime.getRuntime().exit(0);
        }
        
        System.out.println(shuffleDeck.get(tmpGiver));
        tmpGiver++;
        }
        }*/

        for (int i = 0; i < (N * 5); i++) {
            if (i >= 52) {
                System.out.println("The deck stack is empty!");
                break;
            } else if (i % 5 == 0) {
                System.out.println();
            }
            System.out.println(shuffleDeck.get(i));
        }
        
        // TODO [sne] implement romme output
    }
}
