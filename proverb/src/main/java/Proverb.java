import java.util.stream.IntStream;

public class Proverb {

    private final String[] words;

    private static String premise = "For want of a %s the %s was lost.\n";
    private static String conclusion = "And all for the want of a %s.";

    Proverb(String[] words) {
        this.words = words;
    }

    public String recite() {

        if (words.length == 0) 
            return "" ;

        return IntStream.range(1, words.length)
                        .mapToObj(i -> String.format(premise, words[i - 1], words[i]))
                        .reduce("", (line, acc) -> line + acc) + String.format(conclusion, words[0]) ;
    }

}
