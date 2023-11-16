class CollatzCalculator {
    private static final String NATURALS_ONLY = 
        "Only positive integers are allowed";

    public int computeStepCount(final int start) {
        if (start <= 0) 
            throw new IllegalArgumentException(NATURALS_ONLY);
        return computeStepCount(start, 0);
    }

    private int computeStepCount(int start, int steps) {
        if (start == 1) 
            return steps;
        steps += 1;
        if ((start & 1) == 1) {
            start *= 3;
            start += 1;
        }
        else {
            start >>= 1;
        }
        return computeStepCount(start, steps);
    }
}
