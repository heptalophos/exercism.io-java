// import com.google.guava.Stream;
import com.codepoetics.protonpack.StreamUtils;
import java.util.stream.Stream;

public class Hamming {

    private final int hammingDistance;

    public Hamming(String leftStrand, String rightStrand) {
        hammingDistance = computeHamming(leftStrand, rightStrand);
    }

    int getHammingDistance() {
        return hammingDistance;
    }

    private int computeHamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        Stream<Character> leftStream = leftStrand.chars().mapToObj(i -> (char) i);
        Stream<Character> rightStream = rightStrand.chars().mapToObj(i -> (char) i);

        return StreamUtils
               .zip(leftStream, rightStream, (left, right) -> left.equals(right) ? 0 : 1)
               .reduce(0, Integer::sum);
    }

}
