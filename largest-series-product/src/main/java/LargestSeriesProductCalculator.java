import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.IntStream;

class LargestSeriesProductCalculator {

    private String input;
    private final List<String> errors =
        Arrays.asList(new String[]{
            "String to search may only contain digits.",
            "Series length must be less than or equal to " + 
            "the length of the string to search.",
            "Series length must be non-negative."});

    LargestSeriesProductCalculator(String inputNumber) {

        if (!inputNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(errors.get(0));
        }

        this.input = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        
        if (numberOfDigits > input.length()) {
            throw new IllegalArgumentException(errors.get(1));
        }

        if (numberOfDigits < 0) {
            throw new IllegalArgumentException(errors.get(2));
        }
        
        OptionalLong max = 
            IntStream.rangeClosed(0, input.length() - numberOfDigits)
                     .mapToLong(x -> input
                                     .substring(x, x + numberOfDigits)
                                     .chars()
                                     .map(y -> y - '0')
                                     .reduce(1, (d1, d2) -> d1 * d2))
                     .max();    
                     
        return max.orElse(1);                                                     
    }
}