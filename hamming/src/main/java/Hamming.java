import java.util.stream.IntStream;

public class Hamming {

    private final int hammingDistance;
    private final String NOT_EQ = 
        "leftStrand and rightStrand must be of equal length.";

    public Hamming(String leftStrand, String rightStrand) {
        hammingDistance = 
            computeHamming(leftStrand, rightStrand);
    }

    int getHammingDistance() {
        return hammingDistance;
    }

    int computeHamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException(NOT_EQ);

        char[]  left = leftStrand.toCharArray();
        char[]  right = rightStrand.toCharArray();

        return IntStream
               .range(0, left.length)
               .mapToObj(i -> left[i] == right[i] ? 0 : 1)
               .reduce(0, Integer::sum);
    }
}