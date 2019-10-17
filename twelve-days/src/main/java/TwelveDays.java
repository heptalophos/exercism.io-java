import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwelveDays {
    
    private static final List<String> dayXmas = 
                Arrays.asList("first", "second", "third", 
                              "fourth", "fifth", "sixth",
                              "seventh", "eighth", "ninth", 
                              "tenth", "eleventh", "twelfth");

    private static final List<String> gifts = 
            Arrays.asList("twelve Drummers Drumming,",
                          "eleven Pipers Piping,",
                          "ten Lords-a-Leaping,",
                          "nine Ladies Dancing,",
                          "eight Maids-a-Milking,",
                          "seven Swans-a-Swimming,",
                          "six Geese-a-Laying,",
                          "five Gold Rings,",
                          "four Calling Birds,",
                          "three French Hens,",
                          "two Turtle Doves, and",
                          "a Partridge in a Pear Tree.\n");

    String verse(int verseNumber) {
        return String.format("On the %s day of Christmas my true love gave to me: %s", 
                             dayXmas.get(verseNumber - 1),
                             IntStream.range(12 - verseNumber, 12)
                                      .boxed()
                                      .map(gifts::get)
                                      .collect(Collectors.joining(" ")));
    }

    String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse)
                        .mapToObj(this::verse)
                        .collect(Collectors.joining("\n")); 
    }
    
    String sing() {
        return verses(1, 12);
    }
}
