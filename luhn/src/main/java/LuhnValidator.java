// import java.util.Arrays;
import java.util.stream.IntStream;


class LuhnValidator {

    // private String[] digits;

    boolean isValid(String candidate) {
        candidate = candidate.replace(" ", "");
        if (candidate == null || candidate.length() <= 1 || !candidate.matches("[0-9]")) 
            return false;
        long zeros = candidate.chars().filter(ch -> ch == '0').count();  
        String[] digits = new StringBuilder(candidate).toString().split("");
        Integer sumLuhn = IntStream.rangeClosed(1, digits.length)
                                    .map (i -> { int index =  digits.length - i;
                                                 int digit = Integer.parseInt(digits[index]);
                                                 return index % 2 == 0 ?
                                                        2 * digit > 9 ? (2 * digit) - 9 : 2 * digit : 
                                                        digit;})
                                    .sum();
        return ((sumLuhn == 0 && zeros > 1) || (sumLuhn != 0 && sumLuhn % 10 == 0));
    }

    // public static void main(String [] args) {
    //     LuhnValidator luhnValidator = new LuhnValidator();
    //     System.out.println("0000 0");
    //     System.out.println(luhnValidator.isValid("0000 0"));
    // }
}

