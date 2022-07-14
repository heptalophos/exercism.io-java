import java.util.List;
import static java.util.stream.IntStream.range;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MinesweeperBoard {
    private List<String> board;
    private static final String MINE = "*";
    private int rows;
    private int cols;
    
    public MinesweeperBoard(List<String> inputBoard) {
        this.board = inputBoard;
        this.rows  = this.board.size();
        this.cols  = this.rows == 0 ? 0 : board.get(0).length();
    }

    public List<String> withNumbers() {
        return  
            range(0, this.rows)
            .mapToObj(r -> range(0, this.cols)
                           .mapToObj(c -> tileValue(r, c))
                           .collect(joining()))
            .collect(toList());
    }

    private String tileValue(int row, int col) {
        if (tile(row, col) == '*') {
            return MINE;
        }
        int mineCount = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    if (tile(row + i, col + j) == '*') {
                        mineCount++;
                    }
                } catch (IndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
        return mineCount == 0 ? " " : String.valueOf(mineCount);
    }
    
    private char tile(int r, int c) {
        return board.get(r).charAt(c);
    }
}