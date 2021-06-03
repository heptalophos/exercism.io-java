import java.util.List;
import java.util.stream.Collectors;

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
        plants = stream(garden.split("\n"))
                 .map(KindergartenGarden::row)
                 .collect(Collectors.toList());    
    }

    // KindergartenGarden(String garden, String student) {
        
    // }

    List<Plant> getPlantsOfStudent(String student) {
        var idx = 2 * _KIDS.indexOf(student);
        return plants.stream()
                     .flatMap(x -> x.stream().skip(idx).limit(2))
                     .collect(Collectors.toList()); 
    }

    private static List<Plant> row(String plants) {
        return plants.chars()
                     .mapToObj(x -> Plant.getPlant((char) x))
                     .collect(Collectors.toList());
    } 

}
