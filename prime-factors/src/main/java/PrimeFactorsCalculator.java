import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsCalculator {

    public List<Long> calculatePrimeFactorsOf(long number) {

        List<Long> factors = new ArrayList<>();

        long factor = 2;
        
        while (factor <= Math.sqrt(number)) {

            if (number % factor == 0) {
                factors.add(factor);
                number /= factor;
            } else {
                ++factor;
            }
        }

        if (number > 1) factors.add(number);
        
        return factors;
    }
}
