package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeNumber {

    public static List<Integer> enumeratePrimeNumber(int n) {
        List<Integer> primes = new ArrayList<>();
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n+1, true));

        isPrime.set(0, false);
        isPrime.set(1, false);
        for(int p = 2; p<n; p++) {
            if (isPrime.get(p)) {
                primes.add(p);
                for (int j = p; j<n; j+=p) {
                    isPrime.set(j, false);
                }
            }
        }
        return primes;
    }

    public static List<Integer> primeNumbersOpt(int n) {
        final int size = (int) Math.floor(0.5 * (n-3) + 1);
        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(size, true));

        for(int i = 0; i<size; ++i) {
            if(isPrime.get(i)) {
                int p = ((i*2) + 3);
                primes.add(p);
                // Sieving from p^2, whose value is (4i^2 + 12i + 9). The index of this
                // value in isPrime is (2i^2 + 6i + 3) because isPrime.get(i) represents
                // 2i + 3.
                //
                // Note that we need to use long type for j because p^2 might overflow.
                for(long j = ((i*i)*2+i*6+3); j<size; j += p) {
                    isPrime.set((int)j, false);
                }
            }
        }
        return primes;
    }
}
