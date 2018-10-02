import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;


public class NucleotideCounter {

    private final String sequence;
    private final Map<Character, Integer> tally;

    public NucleotideCounter(String seq) {
        sequence = seq;
        tally = new HashMap<>();
        "CGAT".chars().forEach(ch -> tally.put((char) ch, 0));
        this.nucleotideCounts();
    }

    public Integer count(Character nuc) {
        if (!"GCAT".contains(Character.toString(nuc))) 
            throw new IllegalArgumentException(); 
        return (int) sequence.chars().filter(ch -> (char) ch == nuc).count();
    }

    public Map<Character, Integer> nucleotideCounts() {
        for (Character ch : sequence.chars().mapToObj(x -> (char) x).collect(Collectors.toSet())) {
            tally.put(ch, count(ch));
        };
        return tally;
    }
}