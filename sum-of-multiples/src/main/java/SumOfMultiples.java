import java.util.stream.IntStream;

class SumOfMultiples {

    private int number;
    private int[] set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        return IntStream.range(1, number)
                        .filter(n -> IntStream.of(set)
                                              .filter(i -> i != 0)
                                              .anyMatch(i -> n % i == 0))
                        .sum();
    }
}
