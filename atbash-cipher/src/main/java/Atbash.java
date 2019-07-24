import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.Optional;

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

    private <T> List<List<T>> collate( List<T> list, int size, int step ) {
        return Stream.iterate( 0, i -> i + step )
                     .limit( ( list.size() / step ) + 1 )
                     .map( i -> list.stream()
                                    .skip( i )
                                    .limit( size )
                                    .collect( Collectors.toList() ) )
                     .filter( i -> !i.isEmpty() )
                     .collect( Collectors.toList() ) ;
    }

    public static String encode (String phrase) {
        return phrase.chars()
                     .filter ( Character::isLetterOrDigit )
                     .map ( Character::toLowerCase)
                     .map ( cipherMap::get )
                     .collect( StringBuilder::new, 
                               StringBuilder::appendCodePoint, 
                               StringBuilder::append)
                     .toString()
                     .replaceAll(".{5}(?=.)", "$0 ");
    }

    // public static String decode (String phrase) {
    //     return phrase.chars()
    //                  .filter ( c -> Character.isLetterOrDigit(c) )
    //                  .map ( v -> cipherMap.entrySet()
    //                                       .stream()
    //                                       .filter(e -> v == e.getValue())
    //                                       .map(Map.Entry::getKey))
    //                  .toString();
    // }
}
