import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java.util.Arrays;

class KindergartenGarden {

    private final List<List<Plant>> plants;

    private static final List<String> _KIDS = 
        Arrays.asList(  
            "Alice",
            "Bob",
            "Charlie",
            "David",
            "Eve",
            "Fred",
            "Ginny",
            "Harriet",
            "Ileana",
            "Joseph",
            "Kincaid",
            "Larry"
        );

    KindergartenGarden(String garden) {
        plants = Arrays
                 .stream(garden.split("\n"))
                 .map(row -> row.chars()
                                .mapToObj(p -> ((char) p))
                                .map(Plant::getPlant)
                                .collect(Collectors.toList()))
                 .collect(Collectors.toList());    
    }

    List<Plant> getPlantsOfStudent(String kid) {
        int idx = 2 * _KIDS.indexOf(kid);
        return plants.stream()
                     .flatMap(x -> x.stream()
                                    .skip(idx)
                                    .limit(2))
                     .collect(Collectors.toList()); 
    }
}
