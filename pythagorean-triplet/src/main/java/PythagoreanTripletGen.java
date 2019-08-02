import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class PythagoreanTripletGen {

    private int factorsLTE;
    private int factorsGTE;
    private int sumTo;

    PythagoreanTripletGen withFactorsLessThanOrEqualTo(int val) {
        factorsLTE = val;
        return this;
    }

    PythagoreanTripletGen withFactorsGreaterThanOrEqualTo(int val) {
        factorsGTE = val;
        return this;
    }

    PythagoreanTripletGen thatSumTo(int val) {
        sumTo = val;
        return this;
    }

    public List<PythagoreanTriplet> build() {
        return IntStream
              .rangeClosed(1, factorsLTE / 2)
              .boxed()
              .flatMap(a -> IntStream
                           .rangeClosed(a + 1, (factorsLTE - a) / 2)
                           .filter(b -> b != a)
                           .boxed()
                           .flatMap(b -> IntStream
                                        .of(sumTo - (a + b))
                                        .filter(c -> c != b)
                                        .filter(c -> a * a + b * b == c * c)
                                        .mapToObj(c -> new PythagoreanTriplet(a, b, c))
                                   )
                      )
              .collect(Collectors.toList());
        // final List<PythagoreanTriplet> triplets = new ArrayList<>();
        // for (int a = 1; a <= factorsLTE / 2; a++) 
        //     for (int b = a + 1; b <= (factorsLTE - a) / 2; b++)
        //         if (b != a) {
        //             int c = sumTo - (a + b);
        //             PythagoreanTriplet triplet = new PythagoreanTriplet(a, b, c);
        //             if (c != b) 
        //              if (a * a + b * b == c * c)
        //              //   if (triplet.isPythagorean() && !triplets.contains(triplet))
        //                     triplets.add(triplet);
        //         }
        // return triplets;
    }
}
