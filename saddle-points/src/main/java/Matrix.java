import java.util.List;
import java.util.Set;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Matrix {

    private final List<List<Integer>> matrix;
    private List<Integer> maxRow;
    private List<Integer> minCol;

    Matrix(List<List<Integer>> values) {
        matrix = values;

        if (!matrix.isEmpty()) {
            maxRow = matrix.stream()
                           .map(val -> val.stream()
                                          .max(Integer::compareTo)
                                          .get())
                           .collect(Collectors.toList());
            minCol = IntStream.range(0, matrix.get(0).size())
                              .mapToObj(this::getRow)
                              .collect(Collectors.toList())
                              .stream()
                              .map(val -> val.stream()
                                             .min(Integer::compareTo)
                                             .get())
                              .collect(Collectors.toList());
        }
        else {
            maxRow = Collections.emptyList();
            minCol = Collections.emptyList();
        }
    }

    public Set<MatrixCoordinate> getSaddlePoints() {
        if (!matrix.isEmpty()) {
        //     maxRow = matrix.stream()
        //                    .map(val -> val.stream()
        //                                   .max(Integer::compareTo)
        //                                   .get())
        //                    .collect(Collectors.toList());
        //     minCol = IntStream.range(0, matrix.get(0).size())
        //                       .mapToObj(this::getRow)
        //                       .collect(Collectors.toList())
        //                       .stream()
        //                       .map(val -> val.stream()
        //                                      .min(Integer::compareTo)
        //                                      .get())
        //                       .collect(Collectors.toList());
                              
            return IntStream
                .range(0, matrix.size())
                .boxed()
                .flatMap(r -> 
                            IntStream.range(0, matrix.get(0).size())
                                     .mapToObj(x -> 
                                        new MatrixCoordinate(r + 1, x + 1)))
                .filter(this::saddlePoint)
                .collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }

    private List<Integer> getRow(int row) {
        return matrix.stream()
                     .map(r -> r.get(row))
                     .collect(Collectors.toList());
    }

    private boolean saddlePoint(MatrixCoordinate p) {
        return maxRow.get(p.row()) == minCol.get(p.col());
    } 
}

