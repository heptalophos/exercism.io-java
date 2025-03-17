import static java.util.stream.Stream.of;
import static java.util.stream.IntStream.range;
import static java.util.stream.Collectors.joining;

class ResistorColorTrio {
    private static final String[] COLORS = { 
        "black", "brown", "red", "orange", "yellow", 
        "green", "blue", "violet", "grey", "white" 
    };

    String label(final String[] colors) {
        String band1 = colors[0];
        String band2 = colors[1];
        int zeros = colorCode(colors[2]);
        int value = value(new String[] {band1, band2});
        long resistance = value * (long) Math.pow(10, zeros);
        long ohms;
        String magn = "";
        if (resistance > 1e9) {
            ohms = resistance / (long) 1e9;
            magn = "giga";
        } else
        if (resistance > 1e6) {
            ohms = resistance / (long) 1e6;
            magn = "mega";
        } else
        if (resistance > 1e3) {
            ohms = resistance / (long) 1e3;
            magn = "kilo";
        } else 
        if (resistance > 1e0) {
            ohms = resistance;
        } else {
            ohms = 0;
        }
        return String.format("%s %sohms", ohms, magn);
    }

    // The value(..) method from resistor-color-duo
    private int value(final String[] colors) {
        if (colors.length < 2) {
            return 0;
        }
        try {
            String duo =  of(colors)
                         .map(this::colorCode)
                         .map(String::valueOf).limit(2)
                         .collect(joining());
            return Integer.parseUnsignedInt(duo);             
        } 
        catch (NumberFormatException e) {
            System.out.println("Illegal color in strip");
            return -1;
        }
    }

    // The colorCode(..) and colors() methods from resistor-color
    private int colorCode(final String color) {
        return  range(0, colors().length)
               .filter(i -> colors()[i].equals(color))
               .findFirst().orElse(-1);
    }

    private String[] colors() {
        return COLORS;
    }
}
