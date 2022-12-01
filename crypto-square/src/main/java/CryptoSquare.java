import java.util.List;
import static java.util.Arrays.asList;
import static java.util.stream.IntStream.range;
import static java.util.stream.Collectors.joining;

public class CryptoSquare {
    
    private final String plaintext;
    private int squareSize;
    private List<String> chunks;

    public CryptoSquare(String input) {
        plaintext = input.toLowerCase().chars()
                         .mapToObj(x -> (char) x)
                         .filter(Character::isLetterOrDigit)
                         .map(Object::toString)
                         .collect(joining());
        squareSize = (int) Math.ceil((double) Math.sqrt(plaintext.length()));
        chunks = asList(plaintext.split("(?<=\\G.{" + squareSize + "})"));
    }

    public String getCiphertext() {
        return  range(0, squareSize)
               .mapToObj(x -> chunks.stream()
                                    .map(s -> s.length() > x 
                                              ? "" + s.charAt(x) 
                                              : " "
                                    )
                                    .collect(joining()))
               .collect(joining(" "));       
    }
}
