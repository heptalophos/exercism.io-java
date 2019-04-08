import java.util.List;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Sieve {

    private List<Integer> primes;

    public Sieve(int limit) {

        boolean[] notPrime = new boolean[limit + 1];

        Arrays.fill(notPrime, false);

        for (int p = 2; p * p <=limit; p++) {
            if (!notPrime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    notPrime[i] = true;
                }
            }
        }
        
        primes = IntStream.rangeClosed(2, limit)
                          .filter(x -> !notPrime[x])
                          .boxed()
                          .collect(Collectors.toList());
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}