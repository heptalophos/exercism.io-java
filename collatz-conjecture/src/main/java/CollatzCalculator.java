class CollatzCalculator {
    private static final String ERR = 
        "Only natural numbers are allowed";

    public int computeStepCount(final int start) {
        if (start <= 0) 
            throw new IllegalArgumentException(ERR);
        return computeStepCount(start, 0);
    }

    private int computeStepCount(int start, int steps) {
        if (start == 1) return steps;
        steps += 1;
        start = start % 2 == 1 ? (3 * start) + 1 : start / 2;
        return computeStepCount(start, steps);
    }
}
