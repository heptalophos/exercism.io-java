import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


public class Series {

    public final String numberString;
    
    private static final String TOO_SMALL = "Slice size is too small.";

    private static final String TOO_LARGE = "Slice size is too big.";

    public Series(String numberString){
        this.numberString = numberString;
    }

    public List<String> slices(int subLen) {
        if (subLen <= 0) 
            throw new IllegalArgumentException(TOO_SMALL);
        if (subLen > numberString.length()) 
            throw new IllegalArgumentException(TOO_LARGE);
        return IntStream
               .rangeClosed(0, numberString.length() - subLen)
               .mapToObj(x -> numberString.substring(x, x + subLen))
               .collect(Collectors.toList());
    }
}