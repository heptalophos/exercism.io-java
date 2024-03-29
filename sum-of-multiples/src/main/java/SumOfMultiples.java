import java.util.stream.IntStream;

public class SumOfMultiples {
    private int number;
    private int[] set;

    public SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    public int getSum() {
        return IntStream.range(1, number)
                        .filter(n -> IntStream.of(set)
                                              .filter(i -> i != 0)
                                              .anyMatch(i -> n % i == 0))
                        .sum();
    }
}
