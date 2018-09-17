import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Matrix {

    private final List<List<Integer>> matrix;

    Matrix(String matrixAsString) {
        matrix = Arrays.asList(matrixAsString.split("\n"))
                       .stream()
                       .map( row -> Arrays.asList(row.split(" "))
                                          .stream()
                                          .map(x -> Integer.parseInt(x))
                                          .collect(Collectors.toList())
                       )
                       .collect(Collectors.toList());
    }

    int[] getRow(int rowNumber) {
        return matrix.get(rowNumber)
                     .stream()
                     .mapToInt(x -> x.intValue())
                     .toArray();
    }

    int[] getColumn(int columnNumber) {
        return matrix.stream()
                     .map(row -> row.get(columnNumber))
                     .mapToInt(x -> x.intValue())
                     .toArray();
    }
}
