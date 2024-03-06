public class GameMaster {
    public String describe(Character character) {
        return String.format("You're a level %d %s with %s hit points.",
                             character.getLevel(),
                             character.getCharacterClass(),
                             character.getHitPoints());
    }

    public String describe(Destination destination) {
    
    }

    public String describe(TravelMethod travelMethod) {
    }

    public String describe(Character c, Destination d, TravelMethod tm) {
    }

    public String describe(Character chrctr, Destination dst) {
    }
}
