public class PhoneNumber {

    private final String phoneNumber;

    private static final String[] errors = {
            "letters not permitted",
            "punctuations not permitted",
            "incorrect number of digits",
            "more than 11 digits",
            "11 digits must start with 1",
            "area code cannot start with zero",
            "area code cannot start with one", 
            "exchange code cannot start with zero",
            "exchange code cannot start with one"
    };

    public PhoneNumber(String strNumber) {
        
        this.phoneNumber = validate(strNumber);
    }
    
    public String getNumber() {
        
        return phoneNumber;
    }

    private String validate(String number) {
    
        if (number.codePoints()
                  .anyMatch(Character::isAlphabetic))
            throw new IllegalArgumentException(errors[0]);

        if (number.codePoints()
                  .anyMatch(c -> "@:!".contains(""+(char)c)))
            throw new IllegalArgumentException(errors[1]); 
        
        String sanitized = 
            number.codePoints()
                  .filter(Character::isDigit)
                  .collect(StringBuilder::new,
                           StringBuilder::appendCodePoint,
                           StringBuilder::append)
                  .toString();

        if (sanitized.length() < 10)
            throw new IllegalArgumentException(errors[2]);
        
        if (sanitized.length() > 11)
            throw new IllegalArgumentException(errors[3]);

        if (sanitized.length() == 11) 
            if (sanitized.charAt(0) != '1')
                throw new IllegalArgumentException(errors[4]);
            else 
                sanitized = sanitized.substring(1);

        if (sanitized.charAt(0) == '0')
            throw new IllegalArgumentException(errors[5]);
      
        if (sanitized.charAt(0) == '1')
            throw new IllegalArgumentException(errors[6]);

        if (sanitized.charAt(3) == '0')
            throw new IllegalArgumentException(errors[7]);

        if (sanitized.charAt(3) == '1')
            throw new IllegalArgumentException(errors[8]);

        return sanitized;
    } 
}