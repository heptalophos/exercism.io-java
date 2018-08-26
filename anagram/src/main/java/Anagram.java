import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Anagram {
    private String anagram;
    private final char[] normalized;

    private boolean duplicate(String s) {
        return this.anagram.equalsIgnoreCase(s);
    }

    private char [] normalize(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return chars;
    }

    public Anagram(String anagram) {
        this.anagram = anagram;
        this.normalized = normalize(anagram);
    } 

    public List<String> match(List<String> candidates) {
        List<String> anagrams = new ArrayList<String>();

        // char[] aChars = this.anagram.toLowerCase().toCharArray();
        for (String word: candidates) {
            char[] wChars = word.toLowerCase().toCharArray();
            Arrays.sort(wChars);
            if (!duplicate(word) && Arrays.equals(normalized, normalize(word)))
                anagrams.add(word);
        }
        return anagrams; 
    }

}
