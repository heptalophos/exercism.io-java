import java.util.stream.IntStream;

public class PascalsTriangleGenerator {

    public int[][] generateTriangle(int rows) {
        return  IntStream.range(0, rows)
                         .mapToObj(this::row)
                         .toArray(int[][]::new);
    }

    private int[] row(int n) {
        return IntStream.range(0, n + 1)
                        .map(x -> binomial(n, x))
                        .toArray();
    }

    private int binomial(int i, int j) {
        return factorial(i) / factorial(j) / factorial(i - j);
    }

    private int factorial(int n) {
        return IntStream.range(1, n + 1)
                        .reduce(1, (x, y) -> x * y);
    }
}