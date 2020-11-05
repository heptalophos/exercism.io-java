import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PangramChecker {

    private static IntPredicate present(String sentence) {
        return alpha -> sentence
                        .toLowerCase()
                        .chars()
                        .filter(letter -> 
                                letter == alpha)
                        .findFirst()
                        .isPresent();
    }

    private static boolean entireAlphabet(String sentence) {
        return IntStream.rangeClosed('a', 'z')
                        .allMatch(present(sentence));
    }

    public boolean isPangram(String sentence) {
        return entireAlphabet(sentence);
    }

}