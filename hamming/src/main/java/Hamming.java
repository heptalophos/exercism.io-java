import java.util.stream.IntStream;

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

        char[]  left = leftStrand.toCharArray();
        char[]  right = rightStrand.toCharArray();

        return IntStream
               .range(0, Math.min(left.length, right.length))
               .mapToObj(i -> left[i] == right[i] ? 0 : 1)
               .reduce(0, Integer::sum);
    }
}