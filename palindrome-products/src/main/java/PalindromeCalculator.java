import java.util.*;
import java.util.stream.*;

public class PalindromeCalculator {

    SortedMap<Long, List<List<Integer>>> 
        getPalindromeProductsWithFactors(int lo, int hi) {
            if (lo > hi) {
                throw new IllegalArgumentException(
                        "invalid input: min must be <= max"
                );
            }

        final var palindromes = products(lo, hi)
                                .stream()
                                .filter(PalindromeCalculator::isPalindrome)
                                .collect(Collectors.toList());
        
        if (palindromes.isEmpty()) {
            return new TreeMap<>();
        }

        final var min = palindromes.get(0);
        final var max = palindromes.get(palindromes.size() - 1);

        return new TreeMap<>(
            Map.of(min, factors(min, lo, hi),
                   max, factors(max, lo, hi))
        );
    }

    private List<Long> products(long lo, long hi) {
        return LongStream
               .rangeClosed(lo, hi)
               .flatMap(x -> LongStream
                             .rangeClosed(lo, hi)
                             .map(i -> x * i))
               .distinct()
               .sorted()
               .boxed()
               .collect(Collectors.toList());
    }

    private List<List<Integer>> factors(long num, int lo, int hi) {
        return LongStream
               .rangeClosed(lo, hi)
               .filter(x -> num % x == 0)
               .filter(x -> num / x >= lo && num / x <= hi)
               .mapToInt(x -> (int) x)
               .boxed()
               .map( x -> Stream.of(x, (int) num / x)
                                .sorted()
                                .collect(Collectors.toList()))
               .distinct()
               .collect(Collectors.toList());
    }

    private static boolean isPalindrome(long x) {
        return String
               .valueOf(x)
               .equals(new StringBuilder(String.valueOf(x))
                       .reverse()
                       .toString());
    }
}