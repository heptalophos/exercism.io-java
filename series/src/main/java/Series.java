import java.util.stream.IntStream;
import java.util.stream.Collectors;


public class Series {

    public final String numberString;

    public Series(String numberString){
        this.numberString = numberString;
    }

    // public List<Integer> digits() {
    //     return numberString.chars()
    //                        .mapToObj(x -> (char) x)
    //                        .map(Character::getNumericValue)
    //                        .collect(Collectors.toList());
    // }

    public List<List<Integer>> slices(int n) {
        if (n > numberString.length()) throw new IllegalArgumentException();
        char[] digits = numberString.toCharArray();
        return IntStream.range(0, numberString.length())
                        .mapToObj(x -> IntStream.range(x, x + n)
                                                .boxed()
                                                .map(i -> digits[i])
                                                .map(Character::getNumericValue)
                                                .collect(Collectors.toList()))
                        .collect(Collectors.toList());

    }
}