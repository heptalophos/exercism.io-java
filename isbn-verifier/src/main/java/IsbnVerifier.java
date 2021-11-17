class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        String normal = stringToVerify.replace("-", "");
        int sum = 0; 
        if (normal.length() != 10) { return false; }
        for (int i = 0, j = 10; i < normal.length() - 1; i++, j--) {
            if (Character.isDigit(normal.charAt(i)))
                sum += j * Character.getNumericValue(normal.charAt(i));
            else return false;
        }
        char checkDig = normal.charAt(normal.length() - 1);
        if (!Character.isDigit(checkDig))
            if (checkDig != 'X') return false;
        sum += checkDig == 'X' ? 10 : Character.getNumericValue(checkDig);
        return sum % 11 == 0;
    }
}
