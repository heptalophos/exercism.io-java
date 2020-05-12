import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WordCount {

    public Map<String, Integer> phrase(String phrase) {
        String[] words = phrase.toLowerCase().split("\\W+");
        return Stream
               .of(words)
               .collect(Collectors.groupingBy(
                            Function.identity(), 
                            Collectors.collectingAndThen(
                                Collectors.counting(), 
                                Long::intValue)));
    }
}
