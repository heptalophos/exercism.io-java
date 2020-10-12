import java.util.List;
import java.util.Map;
import java.util.HashMap;
import static java.util.stream.Collectors.toMap;

class Etl {
    
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        
        return old.entrySet()
                  .stream()
                  .map(letters -> 
                       letters.getValue()
                              .stream()
                              .collect(toMap(String::toLowerCase, 
                                             l -> letters.getKey())))
                  .collect(HashMap::new, Map::putAll, Map::putAll);
        
    }
}
