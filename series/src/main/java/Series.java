import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


public class Series {

    public final String numberString;

    private static final String EMPTY = 
                        "series cannot be empty";
    
    private static final String TOO_SMALL = 
                    "slice length cannot be negative or zero";

    private static final String TOO_LARGE = 
                    "slice length cannot be greater than series length";

    public Series(String numberString){
        if (numberString == "")
            throw new IllegalArgumentException(EMPTY);
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