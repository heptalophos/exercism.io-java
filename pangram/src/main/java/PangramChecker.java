import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PangramChecker {

    private static IntPredicate containsLetter(String sentence) {
        return alpha -> sentence
                        .toLowerCase()
                        .chars()
                        .filter(letter -> letter == alpha)
                        .findFirst()
                        .isPresent();
    }

    private static boolean allAlphabetLetters(String sentence) {
        return IntStream.rangeClosed('a', 'z')
                        .allMatch(containsLetter(sentence));
    }

    public boolean isPangram(String sentence) {
        return allAlphabetLetters(sentence);
    }

}