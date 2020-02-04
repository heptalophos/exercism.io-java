import java.util.stream.IntStream;

public class ReverseString {
   
    public static String reverse(String inputString) {
        return IntStream
               .range(0, inputString.length())
               .map(i -> inputString
                         .charAt(inputString.length() - 1 - i))
               .collect(StringBuilder::new, 
                        (acc, c) -> acc.append((char)c), 
                        StringBuilder::append)
               .toString();
    }
}