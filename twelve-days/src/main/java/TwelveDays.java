import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.stream.IntStream;

class TwelveDays {
    
    private static final List<String> dayXmas = 
                asList("first", "second", "third", 
                       "fourth", "fifth", "sixth",
                       "seventh", "eighth", "ninth", 
                       "tenth", "eleventh", "twelfth");

    private static final List<String> gifts = 
                asList("twelve Drummers Drumming,",
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
        return format(
            "On the %s day of Christmas" + 
            " my true love gave to me: %s", 
            dayXmas.get(verseNumber - 1),
            IntStream.range(12 - verseNumber, 12)
                     .boxed()
                     .map(gifts::get)
                     .collect(joining(" "))
            );
    }

    String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse)
                        .mapToObj(this::verse)
                        .collect(joining("\n")); 
    }
    
    String sing() {
        return verses(1, 12);
    }
}
