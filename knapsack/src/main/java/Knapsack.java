import java.util.List;
import java.util.stream.IntStream;

public class Knapsack {

    public int maximumValue(final int capacity, final List<Item> items) {
        return IntStream.range(0, items.size())
               .filter(x -> items.get(x).getWeight() <= capacity)
               .map(x -> { 
                    Item item = items.get(x);
                    int itemValue = item.getValue();
                    int itemWeight = item.getWeight();
                    List<Item> remainingItems = 
                            items.subList(x + 1, items.size());
                    return  itemValue + 
                            maximumValue(capacity - itemWeight, remainingItems);
                })
                .max()
                .orElse(0);
    }
}

public class Item {
    private final int value;
    private final int weight;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public int getWeight() {
        return weight;
    }
}