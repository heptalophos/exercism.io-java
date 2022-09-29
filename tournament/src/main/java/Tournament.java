import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Tournament {
    private static final String MATCHES_FORMAT = 
        "%-30s | %2s | %2s | %2s | %2s | %2s\n";
    private Map<String, Team> roster = new HashMap<>();

    void applyResults(String matchesPlayed) {
        for (String match: matchesPlayed.split("\n")) {
            List<String> data = Arrays.asList(match.split(";"));

            if (data.size() != 3) {
                throw new IllegalArgumentException("Invalid match record");
            }
            Team home = roster.computeIfAbsent(data.get(0), Team::new);
            Team away = roster.computeIfAbsent(data.get(1), Team::new);
            String outcome = data.get(2);

            switch(outcome) {
                case "win" : home.win();  away.lose(); break;
                case "loss": home.lose(); away.win();  break;
                case "draw": home.draw(); away.draw(); break;
                default: throw new UnsupportedOperationException(outcome);
            }
        }
    }
    
    String printTable() {
        List<Team> teams = new ArrayList<>(roster.values());
        teams.sort(Team::compareTo);
        
        StringBuilder table = new StringBuilder();
        String header = String.format(MATCHES_FORMAT, 
                                      "Team", "MP", "W", "D", "L", "P");
        table.append(header);

        for (Team team: teams) {
            String teamLine = String.format(MATCHES_FORMAT, 
                                            team.getTeam(), 
                                            team.getMatches(),
                                            team.getWins(), 
                                            team.getDraws(),
                                            team.getLosses(), 
                                            team.getPoints());
            table.append(teamLine);
        } 
        return table.toString();
    }
}
