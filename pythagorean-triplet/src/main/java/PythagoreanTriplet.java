import java.util.Arrays;
import java.util.Objects;

public class PythagoreanTriplet {
    private final int sideA;
    private final int sideB;
    private final int sideC;

    PythagoreanTriplet(int a, int b, int c) {
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    public int calculateSum() {
        return sideA + sideB + sideC;
    }
    
    public boolean isPythagorean() {
        int[] sides = {this.sideA, this.sideB, this.sideC};
        return 2 * Arrays.stream(sides).max().getAsInt() == this.calculateSum();
    }
    
    public static PythagoreanTripletGen makeTripletsList() {
        return new PythagoreanTripletGen();
    }
    
    @Override
    public boolean equals(Object that) {
        if (that == null || !(that instanceof PythagoreanTriplet)) 
            return false;
        return sideA == ((PythagoreanTriplet) that).sideA &&
               sideB == ((PythagoreanTriplet) that).sideB &&
               sideC == ((PythagoreanTriplet) that).sideC;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB, sideC);
    }

    @Override
    public String toString() {
        return String.format("Triplet(A: %s, B: %s, C: %s)", sideA, sideB, sideC);
    }
}