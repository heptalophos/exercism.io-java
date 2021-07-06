import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Anagram {

    private String anagram;
    private final char[] normalized;

    public Anagram(String anagram) {
        this.anagram = anagram;
        this.normalized = normalize(anagram);
    } 

    public List<String> match(List<String> candidates) {
        
        List<String> anagrams = new ArrayList<String>();

        for (String word: candidates) {
            char[] wChars = 
                word.toLowerCase().toCharArray();

            Arrays.sort(wChars);
            
            if (!duplicate(word) && normal(word))
                   anagrams.add(word);
        }
        return anagrams; 
    }

    private boolean duplicate(String s) {
        return anagram.equalsIgnoreCase(s);
    }

    private char [] normalize(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return chars;
    }

    private boolean normal(String s) {
        return Arrays.equals(normalized, normalize(s));
    }

}
