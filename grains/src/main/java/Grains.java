import java.math.BigInteger;

class Grains {
    private static final String error = "square must be between 1 and 64";

    BigInteger grainsOnSquare(final int square) {
        if (square < 1 || square > 64) {
            throw new IllegalArgumentException(error);
        }
        return BigInteger.ONE.shiftLeft(square - 1);
    }

    BigInteger grainsOnBoard() {
        return BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE);
    }
}
