import java.util.stream.Collectors;

class RotationalCipher {

    private final int shiftKey;

    public RotationalCipher(int shiftKey) {
        
        this.shiftKey = shiftKey ;
    }

    private char shift(int ch) {
        
        int alpha = ch < 'a' ? 'A' : 'a';

        return (!Character.isAlphabetic(ch)) ? (char) ch :
               (char) (alpha + ((ch - alpha + shiftKey) % 26)) ;
    }

    public String rotate(String data) {
        
        return data.chars()
                   .mapToObj(x -> shift(x))
                   .map(x -> x.toString())
                   .collect(Collectors.reducing("", (x, y) -> x + "" + y));
    }
}
