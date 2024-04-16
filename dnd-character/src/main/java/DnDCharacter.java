import java.util.List;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
        strength     = ability(rollDice());
        dexterity    = ability(rollDice());
        constitution = ability(rollDice());
        intelligence = ability(rollDice());
        charisma     = ability(rollDice());
        wisdom       = ability(rollDice());
        hitpoints = 10 + modifier(getConstitution());
    }

    public int getStrength() { return strength; }
    public int getDexterity() { return dexterity; }
    public int getConstitution() { return constitution; }
    public int getIntelligence() { return intelligence; }
    public int getCharisma() { return charisma; }
    public int getWisdom() { return wisdom; }
    public int getHitpoints() { return hitpoints; }

    public List<Integer> rollDice() {
        return IntStream.range(0, 4)
                        .map(x -> (int) Math.floor(6 * Math.random()) + 1)
                        .boxed()
                        .collect(Collectors.toList());
    }

    public int ability(List<Integer> diceRolls) {
        int sum = diceRolls.stream().sorted()
                           .reduce(0, Integer::sum);
        return sum - Collections.min(diceRolls);
    }

    public int modifier(int input) {
        return Math.floorDiv(input - 10, 2);
    }

}
