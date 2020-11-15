import java.util.stream.Collectors;

public class RotationalCipher {

    private final int shiftKey;

    public RotationalCipher(int shiftKey) {
        
        this.shiftKey = shiftKey ;
    }

    private char shift(char ch) {

        if (!Character.isAlphabetic((int) ch))
            return ch;
        
        int base = Character.isLowerCase(ch) ? 'a' : 'A';

        return (char) (base + 
                       ((int) ch - base + shiftKey) % 26);
    }

    public String rotate(String data) {
        
        return data.chars()
                   .mapToObj(x -> shift((char) x))
                   .map(x -> x.toString())
                   .collect(Collectors.joining(""));
    }
}
