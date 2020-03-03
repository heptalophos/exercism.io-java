import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RunLengthEncoding {

    static String encode(String uncompressed) {

        StringBuffer compressed = new StringBuffer();

        for (int i = 0; i < uncompressed.length(); i++) {
            int runLength = 1;
            while (i + 1 < uncompressed.length() && 
                   uncompressed.charAt(i) == 
                   uncompressed.charAt(i + 1)) {
                runLength ++;
                i++;
            }
            if (runLength == 1) {
                compressed.append(uncompressed.charAt(i));
            } else {
                compressed.append(runLength);
                compressed.append(uncompressed.charAt(i));
            }
        }
        return compressed.toString();
    }

    static String decode(String compressed) {
        
        StringBuffer uncompressed = new StringBuffer();
        Pattern pattern = 
            Pattern.compile("[0-9]+|[a-zA-Z]|[ ]");
        Matcher matcher = pattern.matcher(compressed);

        while (matcher.find()) {
            if (matcher.group().matches("[0-9]+")) {
                int num = Integer.parseInt(matcher.group());
                matcher.find();
                while (num-- != 0) 
                    uncompressed.append(matcher.group());
            } else {
                uncompressed.append(matcher.group());
            }
        }
        return uncompressed.toString();
    }
}