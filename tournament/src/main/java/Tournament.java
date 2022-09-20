import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Tournament {
    private static final String MATCHES_FORMAT = 
        "%-30s | %2s | %2s | %2s | %2s | %2s\n";
    private Map<String, Team> teams = new HashMap<>();

    void applyResults(String matchesPlayed) {
        for (String match: matchesPlayed.split("\n")) {
            String data[] = match.split(";");
            if (data.length != 3) {
                throw new IllegalArgumentException("Invalid match data");
            }
            Team home = teams.computeIfAbsent(data[0], Team::new);
            Team away = teams.computeIfAbsent(data[1], Team::new);
            String outcome = data[2].toUpperCase();

            switch(outcome) {
                case "WIN": home.win(); away.lose(); break;
                case "LOSS": home.lose(); away.win(); break;
                case "DRAW": home.draw(); away.draw(); break;
                default: throw new UnsupportedOperationException(outcome);
            }
        }
    }
    

}
