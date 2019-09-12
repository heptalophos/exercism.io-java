// import java.util.List;
// import java.util.Set;
// import java.util.HashSet ;
// import java.util.stream.Stream;
// import java.util.stream.IntStream;
// import java.util.stream.Collectors;
// import java.util.Collections;
// import java.util.Optional;


// class Matrix {

//     private final List<List<Integer>> matrix;
//     private final List<Integer> rowsMax;
//     private final List<Integer> colsMin;

//     Matrix(List<List<Integer>> values) {
//         int rows = values.size();
//         int cols = rows > 0 ? values.get(0).size() : 0;
        
//         colsMin = IntStream.range(0, cols)
//                            .map(x -> 0, rows)
                           

//     }

//     Set<MatrixCoordinate> getSaddlePoints() {
//         return IntStream
//                .range(0, matrix.size())
//                .boxed()
//                .flatMap(r -> Stream
//                              .of(0, matrix.get(0).size())
//                              .map(x -> new MatrixCoordinate(r + 1, x + 1)))
//                .filter(x, y -> saddlePoint(x, y))
//                .collect(Collectors.toSet());
//     }

//     private List<Integer> getRow(int row) {
//         return matrix.get(row);
//     }
//     private Integer maxRow(int row) {
//         return Collections.max(getRow(row));
//     }

//     private List<Integer> getCol(int col) {
//         return matrix.stream()
//                      .map(r -> r.get(col))
//                      .collect(Collectors.toList());
//     }

//     private Integer minCol(int col) {
//         return Collections.min(getCol(col));
//     }

//     public boolean saddlePoint(int row, int col) {
//         return matrix.get(row).get(col) == maxRow(row)
//             && matrix.get(row).get(col) == minCol(col);
//     } 
// }

import java.util.*;

class Matrix {

    List<List<Integer>> rows;
    List<List<Integer>> columns;
    Matrix(List<List<Integer>> values) {
        this.rows = values;
        columns = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            List<Integer> col = new ArrayList<>();
            for (List<Integer> row: this.rows) {
                col.add(row.get(i));
            }
            columns.add(col);
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {

        if (rows == null || rows.isEmpty()) return Collections.emptySet();

        Set<MatrixCoordinate> sets = new HashSet<>();

        for (int i = 0; i < rows.size(); i++) {
            List<Integer> row = rows.get(i);
            for (int j = 0; j < columns.size(); j++) {
                List<Integer> col = columns.get(j);

                if (isLargestInRow(row, row.get(j)) && isSmallestInColumn(col, row.get(j))) {

                    MatrixCoordinate matrixCoordinate = new MatrixCoordinate(i, j);
                    sets.add(matrixCoordinate);
                }
            }
        }
        return sets;
    }

    private boolean isLargestInRow(List<Integer> row, int num){
        for (int value: row) {
            if (value > num) return false;
        }
        return true;
    }
    private boolean isSmallestInColumn(List<Integer> row, int num){
        for (int value: row) {
            if (value < num) return false;
        }
        return true;
    }

}