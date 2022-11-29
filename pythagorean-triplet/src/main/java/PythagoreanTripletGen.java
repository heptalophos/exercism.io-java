import java.util.List;
import java.util.ArrayList;

public class PythagoreanTripletGen {
    private int minFactor = 2;
    private int maxFactor;
    private int sumTo;
    
    public List<PythagoreanTriplet> build() {
        List<PythagoreanTriplet> triplets = new ArrayList<>();
        for (int x = 3; x <= maxFactor && x < sumTo / 3; x++) {
            int y = ((sumTo * sumTo) - (2 * sumTo * x)) / (2 * (sumTo - x));
            if (y > maxFactor) continue;
            int r = ((sumTo * sumTo) - (2 * sumTo * x)) % (2 * (sumTo - x));
            int z = sumTo - x - y;
            if (z > maxFactor) continue;
            if (r == 0 && x < y) {
                triplets.add(new PythagoreanTriplet(x, y, z));
            }
        }
        return triplets;
    }
    
    PythagoreanTripletGen withFactorsLessThanOrEqualTo(int val){
        maxFactor = val;
        return this;
    }
    
    PythagoreanTripletGen thatSumTo(int val) {
        sumTo = val;
        if (maxFactor == 0) {
            maxFactor = val;
        }
        return this;
    }
}
