import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Sieve {

    private List<Integer> primes = new ArrayList<Integer>();

    private static boolean isPrime(int num) {
        return IntStream.rangeClosed(2, (int)Math.sqrt(num))
                        .filter(x -> (x & 0x1) != 0)
                        .allMatch(x -> num % x != 0);    
    } 

    // Sieve(int maxPrime) {
    //     primes = IntStream.rangeClosed(2, maxPrime)
    //                       .filter(x -> isPrime(x)).boxed()
    //                       .collect(Collectors.toList());
    // }

    public List<Integer> getPrimes(int limit) {
        return IntStream.rangeClosed(2, limit)
                        .filter(x -> isPrime(x)).boxed()
                        .collect(Collectors.toList());
    }
}