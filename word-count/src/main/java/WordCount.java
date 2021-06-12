import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;


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
              .map(w -> 
                   w.replaceAll("^\\p{Punct}+|\\p{Punct}+$", 
                                ""))
              .collect(
                  groupingBy(Function.identity(), 
                             collectingAndThen(
                                counting(), Long::intValue)));
    }
}
