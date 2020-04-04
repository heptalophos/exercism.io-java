import java.util.stream.IntStream;

public class Hamming {

    private final int hammingDistance;
    private final String NOT_EQ = 
        "leftStrand and rightStrand must be of equal length.";

    public Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException(NOT_EQ);
        
        hammingDistance = 
            computeHamming(leftStrand, rightStrand);
    }

    int getHammingDistance() {
        
        return hammingDistance;
    }

    int computeHamming(String left, String right) {

        return IntStream
               .range(0, left.length())
               .mapToObj(i -> left.charAt(i) == right.charAt(i)
                              ? 0 : 1)
               .reduce(0, Integer::sum);
    }
}