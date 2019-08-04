import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class PythagoreanTripletGen {

    private int minFactor = 2;
    private int maxFactor;
    private int sumTo;

    PythagoreanTripletGen withFactorsLessThanOrEqualTo(int val) {
        maxFactor = val;
        return this;
    }

    PythagoreanTripletGen thatSumTo(int val) {
        sumTo = val;
        return this;
    }

    public List<PythagoreanTriplet> build() {
        return IntStream
              .rangeClosed(minFactor, maxFactor / 2)
              .boxed()
              .flatMap(sideA -> 
                        IntStream
                        .range(sideA + 1, maxFactor - sideA)
                        .boxed()
                        .flatMap(sideB -> 
                                    IntStream
                                    .of(sumTo - sideA - sideB)
                                    .boxed()
                                    .map(sideC -> new PythagoreanTriplet(sideA, 
                                                                         sideB, 
                                                                         sideC))
                                    .filter(PythagoreanTriplet::isPythagorean)
                                    .filter(triplet -> sumTo == triplet.calculateSum() 
                                                       || sumTo == 0)))
              .collect(Collectors.toList());
    }
}
