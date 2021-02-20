public class FoodChain {

    private static final String SPIDER = 
        "wriggled and jiggled and tickled inside her";

    private static final String[] EDIBLES = 
        {"fly", "spider", "bird", "cat", "dog", "goat", "cow"};

    private static final String PROLOGUE =
        "I know an old lady who swallowed a";
    
    private static final String[] PERPLEXITIES =
        { "How absurd to swallow a bird!",
          "Imagine that, to swallow a cat!",
          "What a hog, to swallow a dog!",
          "Just opened her throat and swallowed a goat!",
          "I don\'t know how she swallowed a cow!" };

    private static final String PREMISE = "She swallowed the ";

    private static final String CONCLUSION = " to catch the "; 
    
    private static final String[] EPILOGUE = 
        { "I don't know why she swallowed the fly. Perhaps she'll die.", 
          "I know an old lady who swallowed a horse.\nShe's dead, of course!" };

    private String firstLine(int verseNum) {
        String line = "";
        if (verseNum >= 1 && verseNum < 8) {
            line += 
                PROLOGUE + " " + EDIBLES[verseNum - 1] + ".\n";
            if (verseNum == 2)
                line += "It " + SPIDER + ".\n";
        } else if (verseNum == 8) {
            line = "";
        } else {
            throw new IllegalArgumentException(
                "invalid first line"
            );
        }
        return line;
    }

    private String secondLine(int verseNum) {
        if (verseNum <= 2 || verseNum >= 8) {
            return "";
        }
        return PERPLEXITIES[verseNum - 3] + "\n";
    }

    private String stemLines(int verseNum) {
        String lines = "";
        if (verseNum >= 2 && verseNum <= 7)
            while (verseNum-- > 1) {
                lines += PREMISE + EDIBLES[verseNum] + 
                         CONCLUSION + EDIBLES[verseNum - 1];
                if (verseNum == 2)
                    lines += " that " + SPIDER;                
                lines += ".\n";
            }
        else if (verseNum <= 1 || verseNum >= 8)
            lines = "";
        else
            throw new IllegalArgumentException(
                "invalid stem lines"
            );
        return lines;
    }

    private String closingLine(int verseNum) {
        if (verseNum >= 1 && verseNum <= 7)
            return EPILOGUE[0];
        else if (verseNum == 8) 
            return EPILOGUE[1];
        else
            throw new IllegalArgumentException(
                    "invalid closing line"
            );
    }

    private boolean validVerseNum (int verseNum) {
        return verseNum >= 1 && verseNum <= 8;
    }

    private boolean validVerseRange (int start, int end) {
        return start <= end && end >= 1 && end <= 8  &&
               start >= 1 && start <= 8;
    }

    public String verse(int verseNum) {
        String recite = "";
        if (validVerseNum(verseNum))
            recite += 
                firstLine(verseNum) + secondLine(verseNum) +
                stemLines(verseNum) + closingLine(verseNum);
        else
            throw new IllegalArgumentException(
                    "invalid verse"
            );
        return recite.trim();
    }

    public String verses(int start, int end) {
        String recite = "";
        if (validVerseRange(start, end))
            while (start++ <= end) 
                recite += verse(start - 1) + "\n\n";
        else
            throw new IllegalArgumentException(
                    "invalid verse range"
            );
        return recite.trim();
    }

    public String wholeSong() {
        return verses(1, 8);
    }
}