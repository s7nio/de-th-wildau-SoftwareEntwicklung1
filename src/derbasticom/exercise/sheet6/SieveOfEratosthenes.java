package derbasticom.exercise.sheet6;

import derbasticom.utils.Reader;

/**
 * Prime sieve.
 * 
 * @author sne
 */
public class SieveOfEratosthenes {

    public static void main(String[] foo) {

        int N = Reader.readInteger("Eingabe");
        // initially assume all integers are prime
        boolean[] isPrime = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i; i * j <= N; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes++;
            }
        }
        
        System.out.println("The number of primes <= " + N + " is " + primes);
    }
}
