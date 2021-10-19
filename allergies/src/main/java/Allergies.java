import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Allergies {

    private List<Allergen> allergies;

    public Allergies (int score) {
        allergies = Stream.of(Allergen.values())
                    .filter(allergen -> (score & allergen.getScore()) > 0)
                    .collect(toList());
    }

    public boolean isAllergicTo(Allergen allergen) {
        return allergies.contains(allergen);
    }

    public List<Allergen> getList() {
        return allergies;
    }
}

