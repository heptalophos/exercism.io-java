import java.util.stream.IntStream;

class PrimeCalculator {

    private boolean isPrime(int n) {

        return IntStream
               .rangeClosed(2, (int) Math.sqrt(n))
               .allMatch(x -> n % x != 0);
    }

    public int nth(int nth) {
        
        return IntStream
               .iterate(2, i -> i + 1)
               .filter(this::isPrime)
               .limit(nth)
               .max()
               .orElseThrow(() -> 
                    new IllegalArgumentException("bad_arg"));
    }
}
