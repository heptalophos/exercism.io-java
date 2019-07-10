import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Transpose {

	private static List<String> normalize(List<String> input, int i) {

		List<String> rowz = input;

		int len = rowz.size() - 1;
		
        for (; len >= 0; --len) {
			String str = rowz.get(len);
        	Matcher m = Pattern.compile("\\s+$").matcher(str);
            if (m.find(i)) {
				i = m.start();
				rowz.set(len, str.substring(0, i));
			} else {
				break;
			}
		}
		return rowz;
    }

    public String transpose(final String input) {

        if (input == "") return "";

		List<String> rows = Arrays.stream(input.split("\n"))
								  .collect(Collectors.toList());

		int maxRowLen = rows.stream()
						 	.mapToInt(String::length)
						 	.max()
						 	.orElse(0);

		List<String> tRows = IntStream
							 .range(0, maxRowLen)
							 .mapToObj(i -> rows.stream()
                                           		.map(row -> i >= row.length() ? " " :
                                                       		Character.toString(row.charAt(i)))
							               		.collect(Collectors.joining("")))
							 .collect(Collectors.toList());
							 
		return String.join("\n", normalize(tRows, 0));
    }
}