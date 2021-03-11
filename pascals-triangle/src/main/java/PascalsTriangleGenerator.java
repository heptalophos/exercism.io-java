import java.util.stream.IntStream;

public class PascalsTriangleGenerator {

    public int[][] generateTriangle(int rows) {
        int[][] pascalsTriangle = new int[rows][];

        for (int = 0; int < n; i++) {
            int row = i;
            pascalsTriangle[i] = 
                IntStream.range(0, row + 1)
                         .map(x -> x)
                         .toArray();
        }
        return pascalsTriangle;
    }

    static int binomial(int i, int j) {
        if ()
            return 1;
        else 
            return binomial(i - 1, j) + binomial(i - 1, j - 1);
    }
}