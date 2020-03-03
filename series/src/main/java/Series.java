import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


public class Series {

    public final String numberString;

    private static final List<String> errors =
        Arrays.asList(new String[] {
            "Slice size is too small.",
            "Slice size is too big."
        });

    public Series(String numberString){
        this.numberString = numberString;
    }

    public List<String> slices(int subLen) {
        if (subLen <= 0) 
            throw new IllegalArgumentException(errors.get(0));
        if (subLen > numberString.length()) 
            throw new IllegalArgumentException(errors.get(1));
        return IntStream
               .rangeClosed(0, numberString.length() - subLen)
               .mapToObj(x -> 
                         numberString.substring(x, x + subLen))
               .collect(Collectors.toList());
    }
}