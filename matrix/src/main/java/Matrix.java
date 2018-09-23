import java.util.Arrays;
import java.util.stream.Stream;


class Matrix {

    private final int matrix[][];

    Matrix(String matrixAsString) {
        matrix = Stream.of(matrixAsString.split("\\n"))
                       .map(row -> Stream.of(row.split("\\s"))
                                         .mapToInt(Integer::valueOf)
                                         .toArray())
                       .toArray(int[][]::new);
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber];
    }

    int[] getColumn(int columnNumber) {
        return Arrays.stream(matrix)
                     .map(row -> row[columnNumber])
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}