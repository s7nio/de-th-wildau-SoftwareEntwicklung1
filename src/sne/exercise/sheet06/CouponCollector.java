package sne.exercise.sheet06;

import sne.utils.In;

/**
 * Coupon collector problem.
 * Given N different card types,how many do you have to 
 * collect before you have (at least) one of each type?
 * 
 * Simulation algorithm.
 * Repeatedly choose an integer i between 0 and N-1. 
 * Stop when we have at least one card of every type.
 * 
 */
public class CouponCollector {

    public static void main(String[] foo) {

        int N = In.readInt("Wie viele");
        // number of cards collected
        int cardcnt = 0;
        // number of distinct cards
        int valcnt = 0;

        // do simulation
        boolean[] found = new boolean[N];
        while (valcnt < N) {
            int val = (int) (Math.random() * N);
            cardcnt++;

            if (!found[val]) {
                valcnt++;
                found[val] = true;
            }
        }

        // all N distinct cards found
        System.out.println(cardcnt);
    }
}
