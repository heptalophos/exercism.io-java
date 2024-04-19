import java.util.List;
import static java.util.stream.IntStream.range;

public class Knapsack {

    public int maximumValue(final int capacity, final List<Item> items) {
        return range(0, items.size())
               .filter(x -> 
                    items.get(x).getWeight() <= capacity
                )
               .map(x -> { 
                    Item item = items.get(x);
                    int value = item.getValue();
                    int weight = item.getWeight();
                    List<Item> remainingItems = 
                            items.subList(x + 1, items.size());
                    return  value + 
                            maximumValue(capacity - weight, remainingItems);
                    }
                )
                .max().orElse(0);
    }
}
