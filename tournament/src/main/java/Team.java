public class Team implements Comparable<Team> {
    private int wins, draws, losses;
    private final String teamName;

    Team (String name) {
        teamName = name;
        wins = draws = losses = 0;
    }

    String getTeam() { 
        return teamName; 
    }
    int getWins() { 
        return wins; 
    }
    int getDraws() { 
        return draws; 
    }
    int getLosses() { 
        return losses; 
    }

    int getMatches() {
        return wins + losses + draws;
    }
    int getPoints() {
        return 3 * wins + draws;
    }

    void win() {
        wins += 1;
    }
    void draw() {
        draws += 1;
    }
    void lose() {
        losses += 1;
    }

    public int compareTo(Team this, Team that) {
        int rankDiff = Integer.compare(that.getPoints(), this.getPoints());
        // if 2 teams have the same points, sort them alphabetically, 
        // else sort them by rank (descending points) 
        return rankDiff == 0 
               ? this.getTeam().compareTo(that.getTeam())
               : rankDiff;
        }   
}
