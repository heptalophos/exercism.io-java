public class Team implements Comparable<Team> {
    private int wins, draws, losses;
    private final String teamName;

    Team (String name) {
        this.teamName = name;
        this. wins = this.draws = this.losses = 0;
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
        int rankdiff = Integer.compare(that.getPoints(), this.getPoints());
        // if teams' points are the same, sort them alphabetically 
        return rankdiff == 0 
               ? this.getTeam().compareTo(that.getTeam())
               : rankdiff;
        }   
}
