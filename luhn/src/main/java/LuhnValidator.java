public class LuhnValidator {

    boolean isValid(String candidate) {
        
        int length = 0, sumLuhn = 0;
        boolean flip = false;
        
        for (int i = candidate.length() - 1; i >= 0; i--) {
            char current = candidate.charAt(i);
            if (current == ' ') 
                continue;
            if (current < '0' || current > '9') 
                return false;
            int digit = 
                Integer.parseInt(Character.toString(current));
            if (flip) {
                digit *= 2;
                if (digit > 9) 
                    digit -= 9;
            }
            sumLuhn += digit;
            length++;
            flip = !flip;
        }
        return (length > 1) && (sumLuhn % 10 == 0);
    }
}