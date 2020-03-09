import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;


public class ResistorColorDuo {

    private static final String[] colors = 
        { "black", "brown", "red", "orange", 
          "yellow", "green", "blue", 
          "violet", "grey", "white" };

    private int colorCode(final String color) {
        return IntStream.range(0, colors().length)
                        .filter(i -> colors()[i]
                                     .equals(color))
                        .findFirst()
                        .orElse(-1);
    }

    public String[] colors() {
        return colors;
    }

    public int value(final String[] colors) {
        if (colors.length < 2) {
            return 0;
        }
        try {
            String duo = 
                Stream.of(colors)
                      .map(this::colorCode)
                      .map(String::valueOf)
                      .limit(2)
                      .collect(Collectors.joining());

            return Integer.parseUnsignedInt(duo);             
        } 
        catch (NumberFormatException e) {
            System.out.println("Illegal color in strip");
            return -1;
        }
    }
}
