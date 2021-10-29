import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class PalindromeCalculator {

    public SortedMap<Long, List<List<Integer>>> 
        getPalindromeProductsWithFactors(int min, int max) {
            if (min > max) {
                throw new IllegalArgumentException(
                        "invalid input: min must be <= max"
                );
            }

        final List<Long> palindromes = 
                        palindromeProducts(min, max)
                        .stream()
                        .collect(toList());
        
        if (palindromes.isEmpty()) { 
            return new TreeMap<>();
        }

        final long first = palindromes.get(0);
        final long last = palindromes.get(palindromes.size() - 1);

        return new TreeMap<>(                       // doesn't work below java9
            Map.of(first, factors(first, min, max),
                   last, factors(last, min, max))
        );
    }

    private List<Long> palindromeProducts(long min, long max) {
        return LongStream
               .rangeClosed(min, max)
               .flatMap(x -> LongStream.rangeClosed(min, max)
                                       .map(i -> x * i)
                                       .filter(i -> isPalindrome(i))                             )
               .distinct()
               .sorted()
               .boxed()
               .collect(toList());
    }

    private List<List<Integer>> 
        factors(long num, int min, int max) {
            return LongStream
                   .rangeClosed(min, max)
                   .filter(x -> num / x >= min && 
                                num / x <= max)
                   .filter(x -> num % x == 0)
                   .mapToInt(x -> (int) x)
                   .boxed()
                   .map( x -> Stream.of(x, (int) num / x)
                                    .sorted()
                                    .collect(toList()))
                   .distinct()
                   .collect(toList());
    }

    private boolean isPalindrome(long num) {
        return String
               .valueOf(num)
               .equals(
                   new StringBuilder(String.valueOf(num)).reverse()
                                                         .toString()
                );
    }
}