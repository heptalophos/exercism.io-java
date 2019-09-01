import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Optional;


class Matrix {

    private final List<List<Integer>> matrix;
    private final int rows;
    private final int cols;

    Matrix(List<List<Integer>> values) {
        matrix = values;
        if (!matrix.isEmpty()) {
            rows = matrix.size();
            cols = matrix.get(0).size();
        } else {
            rows = cols = 0;
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return IntStream
               .range(0, matrix.size())
               .boxed()
               .flatMap(r -> Stream
                             .of(0, matrix.get(0).size())
                             .map(x -> new MatrixCoordinate(r + 1, x + 1)))
               .filter(x, y -> saddlePoint(x, y))
               .collect(Collectors.toSet());
    }

    private List<Integer> getRow(int row) {
        return matrix.get(row);
    }
    private Integer maxRow(int row) {
        return Collections.max(getRow(row));
    }

    private List<Integer> getCol(int col) {
        return matrix.stream()
                     .map(r -> r.get(col))
                     .collect(Collectors.toList());
    }

    private Integer minCol(int col) {
        return Collections.min(getCol(col));
    }

    public boolean saddlePoint(int row, int col) {
        return matrix.get(row).get(col) == maxRow(row)
            && matrix.get(row).get(col) == minCol(col);
    } 
}
