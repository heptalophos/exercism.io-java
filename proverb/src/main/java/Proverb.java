import java.util.stream.IntStream;

public class Proverb {

    private final String[] words;

    private static final String premises = 
                "For want of a %s the %s was lost.\n";
    
    private static final String conclusion = 
                    "And all for the want of a %s.";

    Proverb(String[] words) {
        this.words = words;
    }

    public String recite() {

        if (words.length == 0) 
            return "" ;

        String epilogue = 
            String.format(conclusion, words[0]);

        return IntStream
               .range(1, words.length)
               .mapToObj(i -> 
                         String.format(premises, 
                                       words[i - 1], 
                                       words[i]))
               .reduce("", (line, stanza) -> 
                            line + stanza) 
               + epilogue ;
    }

}

