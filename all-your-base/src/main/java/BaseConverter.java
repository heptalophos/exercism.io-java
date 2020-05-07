import java.util.Arrays;

public class BaseConverter {

    private int inputNumber;

    private final String BASE_INVALID =
                    "Bases must be at least 2.";
    private final String DIGIT_OVER_BASE =
        "All digits must be strictly less than the base.";
    private final String DIGIT_BELOW_ZERO =
                    "Digits may not be negative.";
    

    BaseConverter(int inBase, int[] digits) {
        if (inBase < 2) {
            throw 
                new IllegalArgumentException(BASE_INVALID);
        }
        if (Arrays.stream(digits).anyMatch(d -> d >= inBase)) {
            throw 
                new IllegalArgumentException(DIGIT_OVER_BASE);
        }
        if (Arrays.stream(digits).anyMatch(d -> d < 0)) {
            throw 
                new IllegalArgumentException(DIGIT_BELOW_ZERO);
        }
        this.inputNumber = 0;
        int power = 1; 
        for (int i = digits.length - 1; i >= 0; i--) {
            this.inputNumber += digits[i] * power;
            power *= inBase; 
        }
    }

    int[] convertToBase(int outBase) {
        if (outBase < 2) {
            throw 
                new IllegalArgumentException(BASE_INVALID);
        }
        int number = this.inputNumber;
        if (number == 0)
            return new int[]{0};
        int numDigits = 0;
        while (number > 0) {
            number /= outBase;
            numDigits++;
        }
        number = this.inputNumber;
        int[] representation = 
            new int[numDigits];
        int index = 
            numDigits - 1;
        while (number > 0) {
            representation[index--] = 
                number % outBase;
            number /= outBase;
        } 
        return representation;
    }   
}
