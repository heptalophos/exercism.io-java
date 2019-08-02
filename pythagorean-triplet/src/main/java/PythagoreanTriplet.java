// import java.util.List;
// import java.util.stream.IntStream;
// import java.util.stream.Collectors;
// import java.util.ArrayList;
import java.util.Objects;


public class PythagoreanTriplet {

    private final int alpha;
    private final int bravo;
    private final int charlie;


    PythagoreanTriplet(int a, int b, int c) {
        this.alpha = a;
        this.bravo = b;
        this.charlie = c;
    }

    // public int calculateSum() {
    //     return alpha + bravo + charlie;
    // }

    // public int calculateProduct() {
    //     return alpha * bravo * charlie;
    // }

    // public boolean isPythagorean() {
    //     if (alpha * alpha + bravo * bravo == charlie * charlie)
    //         return true;
    //     return false;
    // }
    
    public static PythagoreanTripletGen makeTripletsList() {
        return new PythagoreanTripletGen();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PythagoreanTriplet)) return false;
        PythagoreanTriplet other = (PythagoreanTriplet) o;
        return alpha == other.alpha &&
               bravo == other.bravo &&
               charlie == other.charlie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alpha, bravo, charlie);
    }
}