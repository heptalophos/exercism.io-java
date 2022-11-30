import java.util.List;
import java.util.Set;
import static java.util.Collections.emptySet;
import static java.util.stream.IntStream.range;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Matrix {
    private final List<List<Integer>> matrix;
    private List<Integer> maxRow;
    private List<Integer> minCol;

    Matrix(List<List<Integer>> values) {
        this.matrix = values;
    }

    public Set<MatrixCoordinate> getSaddlePoints() {
        if (!matrix.isEmpty()) {
            maxRow = matrix.stream()
                           .map(val -> val.stream()
                                          .max(Integer::compareTo)
                                          .get()
                            )
                           .collect(toList());
            
            minCol = range(0, matrix.get(0).size())
                    .mapToObj(this::getRow)
                    .collect(toList())
                    .stream()
                    .map(val -> val.stream()
                                   .min(Integer::compareTo)
                                   .get())
                    .collect(toList());          
            
            return   range(0, matrix.size())
                    .boxed()
                    .flatMap(r -> range(0, matrix.get(0).size())
                                 .mapToObj(x -> 
                                    new MatrixCoordinate(r + 1, x + 1)
                                 )
                            )
                    .filter(this::saddlePoint)
                    .collect(toSet());
        }
        return emptySet();
    }
    private List<Integer> getRow(int row) {
        return matrix.stream()
                     .map(r -> r.get(row))
                     .collect(toList());
    }
    private boolean saddlePoint(MatrixCoordinate p) {
        return matrix.get(p.row()).get(p.col()) >= maxRow.get(p.row())
            && matrix.get(p.row()).get(p.col()) <= minCol.get(p.col());
    } 
}