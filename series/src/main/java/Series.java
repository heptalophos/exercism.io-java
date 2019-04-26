import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


public class Series {

    public final String numberString;

    public Series(String numberString){
        this.numberString = numberString;
    }

    public List<String> slices(int subLen) {
        if (subLen <= 0) throw new IllegalArgumentException("Slice size is too small.");
        if (subLen > numberString.length()) throw new IllegalArgumentException("Slice size is too big.");
        return IntStream.rangeClosed(0, numberString.length() - subLen)
                        .mapToObj(x -> numberString.substring(x, x + subLen))
                        .collect(Collectors.toList());
    }
}