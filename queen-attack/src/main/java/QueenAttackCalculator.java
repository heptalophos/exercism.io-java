public final class QueenAttackCalculator {

    private final Queen white;
    private final Queen black;

    QueenAttackCalculator(Queen white, Queen black) {

        if (black == null || white == null) 
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        if (white.rank() == black.rank() && white.file() == black.file())
            throw new IllegalArgumentException("Queens cannot occupy the same position.");

        this.white = white;
        this.black = black;

    }

    boolean canQueensAttackOneAnother() {
        int deltaRank = Math.abs(white.rank() - black.rank());
        int deltaFile = Math.abs(white.file() - black.file());
        return deltaRank * deltaFile == 0 || 
               deltaRank / deltaFile == 1 ;
    }
}