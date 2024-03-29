public class RomanNumerals {
    private String roman;

    public RomanNumerals(int arabic) {
        roman = "";
        while (arabic> 0)
            if (arabic >= 1000) { 
                roman += "M";
                arabic -= 1000;
            } 
            else if (arabic >= 900) {
                roman += "CM";
                arabic -= 900;
            } 
            else if (arabic >= 500) {
                roman += "D";
                arabic -= 500;
            } 
            else if (arabic >= 400) {
                roman += "CD";
                arabic -= 400;
            } 
            else if (arabic >= 100) {
                roman += "C";
                arabic -= 100;
            } 
            else if (arabic >= 90) {
                roman += "XC";
                arabic -= 90;
            } 
            else if (arabic >= 50) {
                roman += "L";
                arabic -= 50;
            } 
            else if (arabic >= 40) {
                roman += "XL";
                arabic -= 40;
            } 
            else if (arabic >= 10) {
                roman += "X";
                arabic -= 10;
            } 
            else if (arabic == 9) {
                roman += "IX";
                arabic = 0;
            } 
            else if (arabic >= 5) {
                roman += "V";
                arabic -= 5;
            } 
            else if (arabic == 4) {
                roman += "IV";
                arabic = 0;
            } 
            else {
                roman += "I";
                arabic--;
            }
    }

    public String getRomanNumeral() {
        return roman;
    }
}
