public final class Queen {

    static final int MINPOS = 0;
    static final int MAXPOS = 7;

    private final int file;
    private final int rank;

    Queen(int rank, int file) throws IllegalArgumentException{

        if (rank < MINPOS) 
            throw new IllegalArgumentException("Queen position must have positive row.");
        if (file < MINPOS) 
            throw new IllegalArgumentException("Queen position must have positive column.");
        if (rank > MAXPOS) 
            throw new IllegalArgumentException("Queen position must have row <= 7.");
        if (file > MAXPOS) 
            throw new IllegalArgumentException("Queen position must have column <= 7.");

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