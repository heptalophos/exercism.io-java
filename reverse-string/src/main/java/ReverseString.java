public class ReverseString {

    public static String reverse(String inputString) {
        return !inputString.equals("") ? 
               reverse(inputString.substring(1)) + inputString.charAt(0) : 
               inputString;
    }
  
}