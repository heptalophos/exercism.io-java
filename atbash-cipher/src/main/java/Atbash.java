import java.util.Map;
import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Atbash {

    private static final List<Character> alpha = 
        "abcdefghijklmnopqrstuvwxyz".chars()
        .mapToObj(x -> (char) x)
        .collect(toList());
    
    private static final List<Character> zeta = 
        "zyxwvutsrqponmlkjihgfedcba".chars()
        .mapToObj(x -> (char) x)
        .collect(toList());

    private static final Map<Character, Character> cipherMap =
        IntStream.range(0, alpha.size())
                 .boxed()
                 .collect(toMap(alpha::get, zeta::get));

    private static String invert(String phrase) {
        return phrase.codePoints()
               .map (Character::toLowerCase)
               .filter (Character::isLetterOrDigit )
               .map ( i -> Character.isLetter(i) 
                           ? cipherMap.get((char) i) 
                           : i )
               .collect(StringBuilder::new, 
                        StringBuilder::appendCodePoint, 
                        StringBuilder::append)
               .toString();
    }

    public static String encode (String phrase) {
        return invert(phrase).replaceAll(".{5}(?=.)", "$0 ");
    }

    public static String decode (String phrase) {
        return invert(phrase);
    }
}
