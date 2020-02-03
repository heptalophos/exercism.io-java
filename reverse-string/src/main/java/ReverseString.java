import java.util.stream.IntStream;

public class ReverseString {
   
    public static String reverse(String inputString) {
        return IntStream.range(0, inputString.length())
               .map(i -> inputString
                         .charAt(inputString.length() - i - 1))
               .collect(StringBuilder::new, 
                        (acc, c) -> acc.append((char)c), 
                        StringBuilder::append)
               .toString();
    }
}