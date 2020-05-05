import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseConverter {

    private int decimal;
    private final String BASE_INVALID =
                    "Bases must be at least 2.";
    private final String DIGIT_OVER_BASE =
        "All digits must be strictly less than the base.";
    private final String DIGIT_BELOW_ZERO =
                    "Digits may not be negative.";
    

    BaseConverter(int inBase, int[] digits) {

        if (inBase < 2) {
            throw new IllegalArgumentException(BASE_INVALID);
        }

        if (Arrays.stream(digits).anyMatch(d -> d >= inBase)) {
            throw new IllegalArgumentException(DIGIT_OVER_BASE);
        }

        if (Arrays.stream(digits).anyMatch(d -> d < 0)) {
            throw new IllegalArgumentException(DIGIT_BELOW_ZERO);
        }

        this.decimal = 0;
        int power = 1; 
        for (int i = digits.length - 1; i >= 0; i--) {
            this.decimal += digits[i] * power;
            power *= inBase; 
        }
    }

    int[] convertToBase(int outBase) {
        
        if (outBase < 2) {
            throw new IllegalArgumentException(BASE_INVALID);
        }

        int number = this.decimal;
        
        // if (number == 0)
        //     return null;

        List<Integer> representation = new ArrayList<>();
        while (number > 0) {
            representation.add(0, outBase % number);
            number /= outBase;
        }
        if (number == 0) {
            representation.add(0);
        }
        return representation
               .stream()
               .mapToInt(i -> i)
               .toArray();
    }   

}
