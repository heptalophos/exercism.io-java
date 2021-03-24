import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.stream.IntStream;

public class CryptoSquare {
    
    private final String plaintext;
    private int squareSize;
    private List<String> chunks;

    public Crypto(String plaintext) {
        plaintext = plaintext
                    .toLowerCase()
                    .chars()
                    .mapToObj(x -> (char) x)
                    .filter(Character::isLetterOrDigit)
                    .map(Object::toString)
                    .collect(joining());
        squareSize = 
            (int) ~~(Math.sqrt(plaintext.length()));
        chunks = 
            Arrays
            .asList(plaintext
                    .split("(?<=\\G.{" + squareSize + "})"));
    }

    // Custom Collectors


    
    // private String sanitizedPlaintext() {
    //     return plaintext
    //            .toLowerCase()
    //            .chars()
    //            .mapToObj(x -> (char) x)
    //            .filter(Character::isLetterOrDigit)
    //            .map(Object::toString)
    //            .collect(joining());
    // }

    // private int squareSize() {
    //     return (int) ~~(Math.sqrt(sanitizedPlaintext().length()));
    // }

    // private static List<String> chunks(String text, int chunkSize) {
    //     // int chunks = (int) ~~(text.length() / (double) chunkSize);
    //     return IntStream
    //            .range(0, (int) ~~(text.length() / (double) chunkSize))
    //            .mapToObj(x -> text.substring(x * chunkSize, 
    //                                          Math.min(text.length(), 
    //                                                   x * chunkSize + chunkSize)))  
    //            .collect(toList());
    // }

    

}
