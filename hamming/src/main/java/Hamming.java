import java.util.stream.IntStream;

public class Hamming {

    private final int hammingDistance;
    private static final String[] errors = { 
        "left strand must not be empty.",
        "right strand must not be empty.",
        "leftStrand and rightStrand must be of equal length."       
    };

    public Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.isEmpty() && !rightStrand.isEmpty())
            throw new IllegalArgumentException(errors[0]);

        if (rightStrand.isEmpty() && !leftStrand.isEmpty())
            throw new IllegalArgumentException(errors[1]);

        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException(errors[2]);
        
        hammingDistance = 
            computeHamming(leftStrand, rightStrand);
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