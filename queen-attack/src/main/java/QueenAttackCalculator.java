import java.util.Arrays;
import java.util.List;

public final class QueenAttackCalculator {

    private final Queen white;
    private final Queen black;
    private final List<String> errors =
        Arrays.asList(new String[]{
            "You must supply valid positions for both Queens.", 
            "Queens cannot occupy the same position."});

    QueenAttackCalculator(Queen white, Queen black) {

        if (black == null || white == null) 
            throw new IllegalArgumentException(errors.get(0));
        if (white.rank() == black.rank() 
            && 
            white.file() == black.file())
            throw new IllegalArgumentException(errors.get(1));

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