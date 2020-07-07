import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Sieve {

    private List<Integer> primes;

    public Sieve(int limit) {

        boolean[] notPrime = new boolean[limit + 1];

        // this only works with java9 and above
        IntStream.rangeClosed(2, (int) Math.sqrt(limit))
                 .filter(x -> !notPrime[x])
                 .flatMap(x -> IntStream
                               .iterate(x * 2, m -> m + x)
                               .takeWhile(m -> m <= limit)) 
                 // or:
                 // .flatMap(x -> IntStream
                 //               .iterate(x * x, 
                 //                        m -> m <= limit, 
                 //                        m -> m + x))
                 .forEach(x -> notPrime[x] = true);
        
        primes = IntStream.rangeClosed(2, limit)
                          .filter(x -> !notPrime[x])
                          .boxed()
                          .collect(Collectors.toList());
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}