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
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        return Arrays.stream(matrix)
                     .map(row -> row[columnNumber - 1])
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}