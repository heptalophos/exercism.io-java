import java.util.HashMap;

public class Scrabble {

    private final String word;
    private static final HashMap<Integer, Integer> Scores = 
            new HashMap<>('Z' - 'A');

    static {
        "AEIOULNRST".chars()
                    .forEach(letter -> 
                                Scores.put(letter, 1));
        "DG".chars()
            .forEach(letter -> 
                        Scores.put(letter, 2));
        "BCMP".chars()
              .forEach(letter -> 
                            Scores.put(letter, 3));
        "FHVWY".chars()
               .forEach(letter -> 
                            Scores.put(letter, 4));
        "K".chars()
           .forEach(letter -> 
                        Scores.put(letter, 5));
        "JX".chars()
            .forEach(letter -> 
                        Scores.put(letter, 8));
        "QZ".chars()
            .forEach(letter -> 
                        Scores.put(letter, 10));
    }

    public Scrabble(String word) {
        this.word = word;
    }

    public int getScore() {
        if (word == null) return 0;
        return word
               .toUpperCase()
               .chars()
               .reduce(0, (a, b) -> 
                            a + Scores.get(b));
    }
}
