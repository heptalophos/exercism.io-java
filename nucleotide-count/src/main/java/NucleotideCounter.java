import java.util.HashMap;


public class NucleotideCounter {

    private final String sequence;

    public NucleotideCounter(String seq) {
        sequence = seq;
    }

    public Integer count(Character nuc) {
        if("CGAT".indexOf(nuc) == -1) {
            throw new IllegalArgumentException();
        }
        return (int) sequence.chars().filter(ch -> (char) ch == nuc).count();
    }

    public HashMap<Character, Integer> nucleotideCounts() {
        final HashMap<Character, Integer> tally = new HashMap<>();
        "CGAT".chars().forEach(ch -> tally.put((char) ch, 0));
        sequence.chars().forEach(ch -> tally.put((char) ch, count((char) ch)));
        return tally;
    }
}