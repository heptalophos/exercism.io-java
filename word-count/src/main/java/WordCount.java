import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WordCount {

    public Map<String, Integer> phrase(String sentence) {

        if (sentence == null || sentence.isEmpty())
            return Collections.emptyMap();
        
        String[] words = sentence
                        .replaceAll("[^\\w\\d']+", " ")
                        .trim()
                        .toLowerCase()
                        .split("\\s+");

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (w.startsWith("'") && w.endsWith("'")) 
                words[i] = w.replaceAll("'","");
        }

        return Stream
              .of(words)
              .collect(Collectors.groupingBy(
                            Function.identity(), 
                            Collectors.collectingAndThen(
                                Collectors.counting(), 
                                Long::intValue)));
    }
}
