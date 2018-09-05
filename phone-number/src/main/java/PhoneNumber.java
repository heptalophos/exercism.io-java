public class PhoneNumber {

    private String phoneNumber;

    public PhoneNumber(String strNumber) {
        this.phoneNumber = validate(strNumber);
    }
    
    public String getNumber() {
        return phoneNumber;
    }

    private String validate(String number) {
        StringBuilder num = new StringBuilder();
        String strNumber;
        char digit;
        for (int i = 0; i < number.length(); i++) {
            digit = number.charAt(i);
            if (digit >= '0' && digit <= '9') {
                num.append(digit);
            } 
            if ((digit >= 'a' && digit <= 'z') || digit == '@' || digit == ':' || digit == '!' ) {
                throw new IllegalArgumentException("Illegal character in phone number. " 
                + "Only digits, spaces, parentheses, hyphens or dots accepted.");
            }
        }
        strNumber = num.toString();
        if (strNumber.length() == 11 && strNumber.charAt(0) == '1') {
            strNumber = strNumber.substring(1);                        
        } else if (strNumber.length() == 11) {
            throw new IllegalArgumentException("Can only have 11 digits if number starts with '1'");
        }
        if (strNumber.length() != 10) {
            throw new IllegalArgumentException("Number must be 10 or 11 digits");
        }
        if (strNumber.startsWith("0") || strNumber.startsWith("1")) {
            throw new IllegalArgumentException("Illegal Area Or Exchange Code. "
                    + "Only 2-9 are valid digits");
        } else if (strNumber.charAt(3) == '0' || strNumber.charAt(3) == '1') {
            throw new IllegalArgumentException("Illegal Area Or Exchange Code. "
                    + "Only 2-9 are valid digits");
        } 
        return strNumber;
    } 
}