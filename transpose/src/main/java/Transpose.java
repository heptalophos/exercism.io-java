import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Transpose {

	private static List<String> normalize(List<String> strings, int match) {

		int i = strings.size() - 1;

        for (; i >= 0; --i) {

			String str = strings.get(i);
			Matcher m = Pattern.compile("\\s+$").matcher(str);
	
			if (m.find(match)) {
				match = m.start();
				strings.set(i, str.substring(0, match));
			} else {
				break;
			}
		}
		return strings;
    }

    public String transpose(final String input) {

		List<String> rows = Arrays.stream(input.split("\n"))
								  .collect(Collectors.toList());

		int maxRowLen = rows.stream()
						 	.mapToInt(String::length)
						 	.max()
						 	.orElse(0);

		List<String> transposedRows = 
					IntStream
					.range(0, maxRowLen)
					.mapToObj(i -> rows
					               .stream()
								   .map(row -> i >= row.length() ? 
									    " " :
										Character.toString(row.charAt(i)))
						           .collect(Collectors.joining("")))
					.collect(Collectors.toList());
							 
		return String.join("\n", normalize(transposedRows, 0));
    }
}