import java.util.ArrayList;
import java.util.List;

class HighScores {

    private final List<Integer> scores;

    public HighScores(List<Integer> highScores) {
        scores = highScores;
    }

    List<Integer> scores() {
        return this.scores;
    }

    Integer latest() {
        return scores.get(scores().size() - 1);    
    }

    Integer personalBest() {
        return scores().stream().max(Integer::compareTo).orElse(0);
    }

    List<Integer> personalTopThree() {
        List<Integer> tmp = new ArrayList<>(scores);
        tmp.sort((x, y) -> Integer.compare(y, x));
        return tmp.subList(0, tmp.size() < 3 ? tmp.size() : 3);
    }

}
