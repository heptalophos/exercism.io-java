import java.util.stream.IntStream;

public class Hamming {

    private final int hammingDistance;
    private final String NOT_EQ = 
        "leftStrand and rightStrand must be of equal length.";

    public Hamming(String leftStr, String rightStr) {
        hammingDistance = 
            computeHamming(leftStr, rightStr);
    }

    int getHammingDistance() {
        return hammingDistance;
    }

    int computeHamming(String leftStr, String rightStr) {

        if (leftStr.length() != rightStr.length())
            throw new IllegalArgumentException(NOT_EQ);

        char[]  left = leftStr.toCharArray();
        char[]  right = rightStr.toCharArray();

        return IntStream
               .range(0, left.length)
               .mapToObj(i -> left[i] == right[i] ? 0 : 1)
               .reduce(0, Integer::sum);
    }
}