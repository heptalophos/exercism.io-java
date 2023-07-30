import java.util.List;
import java.util.Set;
import java.util.Collections;
import static java.util.stream.IntStream.range;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

class Matrix {
    private final List<List<Integer>> matrix;
    private List<Integer> rowMax;
    private List<Integer> colMin;
    
    Matrix(List<List<Integer>> values) {
        matrix = values;
        if (!matrix.isEmpty()) {
            rowMax = matrix.stream()
                           .map(val -> val.stream()
                                          .max(Integer::compareTo)
                                          .get())
                           .collect(toList());
            colMin = range(0, matrix.get(0).size())
                    .mapToObj(this::getRow)
                    .collect(toList())
                    .stream()
                    .map(val -> val.stream()
                                    .min(Integer::compareTo)
                                    .get())
                    .collect(toList());
        }   
    }
    
    public Set<MatrixCoordinate> getSaddlePoints() {    
        if (!matrix.isEmpty()) {
            return range(0, matrix.size())
                   .boxed()
                   .flatMap(
                        r ->
                          range(0, matrix.get(0).size())
                          .filter(c -> saddlePoint(new MatrixCoordinate(r, c)))
                          .mapToObj(x -> new MatrixCoordinate(r + 1, x + 1))
                        
                    )
                   .collect(toSet());
        }
        return Collections.emptySet();
    }
    
    private List<Integer> getRow(int row) {
        return matrix.stream().map(r -> r.get(row)).collect(toList());
    }
    
    private boolean saddlePoint(MatrixCoordinate p) {
        return rowMax.get((int) p.row()) == colMin.get((int) p.col());
    } 
}