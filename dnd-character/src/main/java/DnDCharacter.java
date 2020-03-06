import java.util.stream.IntStream;

class DnDCharacter {

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int charisma;
    private int wisdom;
    private int hitpoints;

    DnDCharacter() {
        strength = ability();
        dexterity = ability();
        constitution = ability();
        intelligence = ability();
        charisma = ability();
        wisdom = ability();
        hitpoints = 10 + modifier(getConstitution());
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    private int rollDice() {
        return (int) (Math.floor(6 * Math.random()) + 1);
    }

    public int ability() {
        return IntStream.range(0, 4)
                        .map(x -> rollDice())
                        .sorted()
                        .limit(3)
                        .sum();
    }

    public int modifier(int input) {
        return Math.floorDiv(input - 10, 2);
    }

}
