import static java.lang.String.format;

public class FoodChain {

    private static final String[] ANIMALS = 
        {"fly", "spider", "bird", "cat", "dog", "goat", "cow"};
    private static final String PROLOGUE = 
        "I know an old lady who swallowed a";
    private static final String[] CONSEQUENCES = {
        "It wriggled and jiggled and tickled inside her.\n",
        "How absurd to swallow a bird!\n",
        "Imagine that, to swallow a cat!\n",
        "What a hog, to swallow a dog!\n",
        "Just opened her throat and swallowed a goat!\n",
        "I don't know how she swallowed a cow!\n",
        "She's dead, of course!"
    };
    private static final String PREMISE = "She swallowed the ";
    private static final String CONCLUSION = " to catch the ";

    String verse(int n) {
        if (n == 8) {
            return format("%s %s.\n%s", PROLOGUE, "horse", "She's dead, of course!");
        }
        n--;
        String chain = format("%s %s.\n%s", PROLOGUE, ANIMALS[n], CONSEQUENCES[n]);
        while (n-- > 0) {
            chain += format("%s%s%s%s.", PREMISE, ANIMALS[n+1], CONCLUSION, ANIMALS[n]);
            if (n == 1) {
                chain += " that wriggled and jiggled and tickled inside her.";
            }
            chain += "\n";
        }
        return chain + "I don't know why she swallowed the fly. Perhaps she'll die.";
    }

    String verses(int start, int end) {
		String chain = "";

		while (start++ <= end)
			chain += verse(start - 1) + "\n\n";

		return chain.trim();
	}

    String wholeSong() {
        return verses(1, 8);
    }

}