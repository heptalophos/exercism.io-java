import java.util.OptionalLong;
import java.util.stream.IntStream;

class LargestSeriesProductCalculator {

    private String input;

    LargestSeriesProductCalculator(String inputNumber) {

        if (!inputNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }

        this.input = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        
        if (numberOfDigits > input.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        
        OptionalLong max = IntStream.rangeClosed(0, input.length() - numberOfDigits)
                                    .mapToLong(x -> input.substring(x, x + numberOfDigits)
                                                         .chars()
                                                         .map(y -> y - '0')
                                                         .reduce(1, (d1, d2) -> d1 * d2))
                                    .max();    
        return max.orElse(1);                                                     
    }
}