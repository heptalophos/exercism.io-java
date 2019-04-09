import java.util.List;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Sieve {

    private List<Integer> primes;

    public Sieve(int limit) {

        boolean[] notPrime = new boolean[limit + 1];

        // IntStream.rangeClosed(2, (int) Math.sqrt(lim))
        //          .filter(x -> !notPrime[x])
        //          .flatMap(x -> Stream.iterate(x * x, m -> m <= lim, m -> m + x)) 
        //  // this works in java9 but not in java 8
        //          .forEach(x -> notPrime[x] = true);
        // // Also .flatMap(x -> Stream.iterate(x * x, m -> m + x).takeWhile(m -> m <= lim))
        // // only works in java9 yet, so: 

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