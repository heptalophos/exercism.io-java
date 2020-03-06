import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum = IntStream
                 .rangeClosed(1, input)
                 .reduce(0, (x, y) -> x + y);
        
        return sum * sum;
    }

    int computeSumOfSquaresTo(int input) {
        return IntStream
              .rangeClosed(1, input)
              .reduce(0, (x, y) -> x + (y * y));
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - 
               computeSumOfSquaresTo(input);
    }

}
