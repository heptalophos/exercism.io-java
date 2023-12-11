import java.util.stream.IntStream;

public class Hamming {

    private final int hammingDistance;
    private static final String NOT_SAME_LENGTH = 
        "leftStrand and rightStrand must be of equal length.";
    private static final String LEFT_STRAND_EMPTY =    
                    "left strand must not be empty.";
    private static final String RIGHT_STRAND_EMPTY =
                    "right strand must not be empty.";

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty())
            throw new IllegalArgumentException(LEFT_STRAND_EMPTY);
        if (rightStrand.isEmpty() && !leftStrand.isEmpty())
            throw new IllegalArgumentException(RIGHT_STRAND_EMPTY);
        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException(NOT_SAME_LENGTH);
        hammingDistance = computeHamming(leftStrand, rightStrand);
    }

    int getHammingDistance() {
        return hammingDistance;
    }

    int computeHamming(String left, String right) {
        return (int) IntStream
               .range(0, left.length())
               .filter(i -> left.charAt(i) != right.charAt(i))
               .count();
    }
}