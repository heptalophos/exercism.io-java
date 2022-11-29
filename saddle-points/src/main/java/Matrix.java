import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;

public class Matrix {

    private final List<List<Integer>> matrix;
    private List<Integer> maxRow;
    private List<Integer> minCol;

    Matrix(List<List<Integer>> values) {
        
        matrix = values;

        if (!matrix.isEmpty()) {
            maxRow = matrix
                     .stream()
                     .map(val -> val
                                 .stream()
                                 .max(Integer::compareTo)
                                 .get())
                     .collect(toList());
            minCol = IntStream
                    .range(0, matrix.get(0).size())
                    .mapToObj(this::getRow)
                    .collect(toList())
                    .stream()
                    .map(val -> val
                                .stream()
                                .min(Integer::compareTo)
                                .get())
                    .collect(toList());
        }
        else {
            maxRow = emptyList();
            minCol = emptyList();
        }
    }

    public Set<MatrixCoordinate> getSaddlePoints() {
        
        if (!matrix.isEmpty()) {
            return IntStream
                   .range(0, matrix.size())
                   .boxed()
                   .flatMap(r -> 
                            IntStream
                            .range(0, matrix.get(0).size())
                            .mapToObj(c -> 
                               new MatrixCoordinate(r + 1, c + 1)))
                   .filter(this::saddlePoint)
                   .collect(toSet());
        }
        return emptySet();
    }

    private List<Integer> getRow(int row) {

        return matrix
               .stream()
               .map(r -> r.get(row))
               .collect(toList());
    }

    private boolean saddlePoint(MatrixCoordinate p) {

        return maxRow.get(p.getRow()) == minCol.get(p.getCol());
    } 
}

