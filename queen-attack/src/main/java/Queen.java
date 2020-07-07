import java.util.Arrays;
import java.util.List;

public final class Queen {

    static final int MINPOS = 0;
    static final int MAXPOS = 7;

    private final List<String> errors = 
        Arrays.asList(new String[]{
            "Queen position must have positive row.", 
            "Queen position must have positive column.",
            "Queen position must have row <= 7.",
            "Queen position must have column <= 7."});

    private final int file;
    private final int rank;

    Queen(int rank, int file) throws IllegalArgumentException{

        if (rank < MINPOS) 
            throw new IllegalArgumentException(errors.get(0));
        if (file < MINPOS) 
            throw new IllegalArgumentException(errors.get(1));
        if (rank > MAXPOS) 
            throw new IllegalArgumentException(errors.get(2));
        if (file > MAXPOS) 
            throw new IllegalArgumentException(errors.get(3));

        this.file = file;
        this.rank = rank;
    }

    public int rank() {
        return rank;
    }

    public int file() {
        return file;
    }

}