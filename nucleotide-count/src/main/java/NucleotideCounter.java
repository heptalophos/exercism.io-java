import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import static java.lang.Math.toIntExact;

public class NucleotideCounter {

    private final String sequence;
    private final Map<Character, Integer> tally;

    public NucleotideCounter(String seq) {
        sequence = seq;
        tally = new HashMap<>();
        "CGAT".chars().forEach(ch -> tally.put((char) ch, 0));
        nucleotideCounts();
    }

    public Integer count(Character nuc) {
        if ("GCAT".indexOf(nuc) < 0) {
            throw new IllegalArgumentException();
        } 
        return toIntExact(sequence.chars().filter(ch -> ch == nuc).count());
    }

    public Map<Character, Integer> nucleotideCounts() {
        for (Character ch : sequence.chars().mapToObj(x -> (char) x).collect(Collectors.toSet())) {
            tally.put(ch, count(ch));
        };
        return tally;
    }
}