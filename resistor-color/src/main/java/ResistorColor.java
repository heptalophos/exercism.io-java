import java.util.stream.IntStream;

class ResistorColor {

    private final String[] colors = 
        { "black", "brown", "red", "orange", 
          "yellow", "green", "blue", 
          "violet", "grey", "white" };

    int colorCode(String color) {
        return IntStream.range(0, colors.length)
                        .filter(i -> colors[i].equals(color))
                        .findFirst()
                        .orElse(-1);
    }

    String[] colors() {
        return colors;
    }
}
