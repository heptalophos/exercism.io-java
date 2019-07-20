class CollatzCalculator {

    public int computeStepCount(int start) {
        
        if (start <= 0)
            throw new IllegalArgumentException("Only natural numbers are allowed");
       
        return computeStepCount(start, 0);
    }

    private int computeStepCount(int start, int steps) {

        if (start == 1) return steps;

        steps += 1;
        
        start = start % 2 == 0 ? start / 2 : (3 * start) + 1;

        return computeStepCount(start, steps);
    }
}
