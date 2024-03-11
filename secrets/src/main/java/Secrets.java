public class Secrets {
    public static int shiftBack(int value, int amount) {
        value >>>= amount;
        return value;
    }

    public static int setBits(int value, int mask) {
        value |= mask;
        return value;
    }

    public static int flipBits(int value, int mask) {
        value ^= mask;
        return value;
    }

    public static int clearBits(int value, int mask) {
        value &= ~mask;
        return value;
    }
}