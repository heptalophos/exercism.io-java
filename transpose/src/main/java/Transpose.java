import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Transpose {

    public String transpose(final String input) {

        if (input == "") return "";

        List<String> rows = Arrays.stream(input.split("\n")).collect(Collectors.toList());

        int maxRow = rows.stream().mapToInt(String::length).max().orElse(0);

        return IntStream.range(0, maxRow)
               .mapToObj(i -> rows.stream()
                              .map(row -> { 
                                       return i >= row.length() ? " " :
                                       Character.toString(row.charAt(i)) ;
                                  })
                              .collect(Collectors.joining("")))
                .collect(Collectors.joining("\n"))
                .trim();
    }
}
