import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class PythagoreanTripletGen {

    private int minFactor;
    private int sumTo;

    PythagoreanTripletGen withFactorsLessThanOrEqualTo(int val) {
        minFactor = val;
        return this;
    }

    PythagoreanTripletGen thatSumTo(int val) {
        sumTo = val;
        return this;
    }

    public List<PythagoreanTriplet> build() {
        return IntStream
              .rangeClosed(1, minFactor / 2)
              .boxed()
              .flatMap(sideA-> IntStream
                           .rangeClosed(sideA+ 1, (minFactor - sideA) / 2)
                           .filter(sideB -> sideB != sideA )
                           .boxed()
                           .flatMap(sideB -> IntStream
                                        .of(sumTo - (sideA + sideB))
                                        .filter(sideC -> sideC != sideB)
                                        .filter(sideC -> 
                                            sideA * sideA + sideB * sideB == sideC * sideC)
                                        .mapToObj(sideC -> 
                                            new PythagoreanTriplet(sideA, sideB, sideC))
                                   )
                      )
              .collect(Collectors.toList());
    }
}
