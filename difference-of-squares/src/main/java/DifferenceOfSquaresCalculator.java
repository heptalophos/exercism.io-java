import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        return (int) Math.pow(IntStream.rangeClosed(1, input)
                    .reduce(0, (x, y) -> x + y), 2);
    }

    int computeSumOfSquaresTo(int input) {
        return IntStream.rangeClosed(1, input)
              .map( i -> i * i)
              .reduce(0, (x, y) -> x + y);
    }

    int computeDifferenceOfSquares(int input) {
       return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
