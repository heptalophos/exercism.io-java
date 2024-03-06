public class GameMaster {
    public String describe(Character character) {
        return String.format(
            "You're a level %d %s with %s hit points.",
            character.getLevel(),
            character.getCharacterClass(),
            character.getHitPoints());
    }

    public String describe(Destination destination) {
        return String.format(
            "You've arrived at %s, which has %d inhabitants.",
            destination.getName(),
            destination.getInhabitants());
    }

    public String describe(TravelMethod travelMethod) {
        return String.format(
            "You're traveling to your destination %s.",
            switch (travelMethod) {
                case WALKING -> "by walking";
                case HORSEBACK -> "on horseback";
                default -> "by unknown means";
            });
    }

    public String describe(Character c, Destination d, TravelMethod tm) {
        return String.join(" ", describe(c), describe(tm), describe(d));
    }

    public String describe(Character chrctr, Destination dst) {
        return describe(chrctr, dst, TravelMethod.WALKING);
    }
}
