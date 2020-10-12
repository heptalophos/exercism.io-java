import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WordCount {

    public Map<String, Integer> phrase(String sentence) {

        if (sentence == null || sentence.isEmpty())
            return Collections.emptyMap();
        
        return Stream
              .of(sentence
                  .replaceAll("[^\\w\\d']+", " ")
                  .trim()
                  .toLowerCase()
                  .split("\\s+"))
              .map(w -> w.replaceAll("^\\p{Punct}+|\\p{Punct}+$", 
                                     ""))
              .collect(Collectors.groupingBy(
                                    Function.identity(), 
                                    Collectors.collectingAndThen(
                                    Collectors.counting(), 
                                    Long::intValue)));
    }
}
