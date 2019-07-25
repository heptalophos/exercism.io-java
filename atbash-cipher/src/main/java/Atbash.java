import java.util.Map;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Atbash {

    private static List<Character> alpha = 
        "abcdefghijklmnopqrstuvwxyz".chars()
                                    .mapToObj(x -> (char) x)
                                    .collect(Collectors.toList());
    
    private static List<Character> zeta = 
        "zyxwvutsrqponmlkjihgfedcba".chars()
                                    .mapToObj(x -> (char) x)
                                    .collect(Collectors.toList());

    private static final Map<Character, Character> cipherMap =
        IntStream.range(0, alpha.size())
                 .boxed()
                 .collect(Collectors.toMap(alpha::get, zeta::get));

    public static String encode (String phrase) {
        return phrase.codePoints()
                     .map ( Character::toLowerCase)
                     .filter ( Character::isLetterOrDigit )
                     .map ( i -> Character.isLetter(i)   ? 
                                 cipherMap.get((char) i) : i )
                     .collect( StringBuilder::new, 
                               StringBuilder::appendCodePoint, 
                               StringBuilder::append)
                     .toString()
                     .replaceAll(".{5}(?=.)", "$0 ");
    }

    public static String decode (String phrase) {
        return phrase.codePoints()
                     .filter ( Character::isLetterOrDigit )
                     .map ( i -> Character.isLetter(i)   ? 
                                 cipherMap.get((char) i) : i )
                     .collect( StringBuilder::new, 
                               StringBuilder::appendCodePoint, 
                               StringBuilder::append)
                     .toString();
    }
}
