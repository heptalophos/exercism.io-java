import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Yacht {

    private final YachtCategory yachtCategory;
    private final int[] dice;
    private Map<Integer, Long> occurenceCount;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        this.yachtCategory = yachtCategory;
        this.occurenceCount = 
            // IntStream
            // .of(this.dice)
            // .mapToObj(Integer::new)
            Arrays
            .stream(dice)
            .boxed()
            .collect(Collectors
                     .groupingBy(
                           Function.identity(),
                           Collectors.counting()
                    ));
    }

    int score() {
        switch (yachtCategory) {
            case ONES -> {
                return occurenceCount
                       .getOrDefault(1, 0L)
                       .intValue();
            }
            case TWOS -> {
                return 2 * occurenceCount
                           .getOrDefault(2, 0L)
                           .intValue();
            }
            case THREES -> {
                return 3 * occurenceCount
                           .getOrDefault(3, 0L)
                           .intValue();
            }
            case FOURS -> {
                return 4 * occurenceCount
                           .getOrDefault(4, 0L)
                           .intValue();
            }
            case FIVES -> {
                return 5 * occurenceCount
                           .getOrDefault(5, 0L)
                           .intValue();
            }
            case SIXES -> {
                return 6 * occurenceCount
                           .getOrDefault(6, 0L)
                           .intValue();
            }
            case CHOICE -> {
                int res = 0;
                for (Map.Entry<Integer, Long> d : occurenceCount.entrySet())
                    res += d.getKey() * d.getValue();
                return res;
            }
            case FULL_HOUSE -> {
                int res = 0;
                if (occurenceCount.isEmpty() || occurenceCount.size() != 2 || 
                    occurenceCount.containsValue(1L)) {
                        return res;
                    }
                for (Map.Entry<Integer, Long> d : occurenceCount.entrySet())
                    res += d.getKey() * d.getValue();
                return res;
            }
            case FOUR_OF_A_KIND -> {
                if (occurenceCount.isEmpty() || occurenceCount.size() >= 3) {
                    return 0;
                } else {
                    return occurenceCount
                           .entrySet()
                           .stream()
                           .filter(d -> d.getValue() > 3)
                           .map(Entry::getKey)
                           .reduce((d1, d2) -> d1)
                           .orElse(0) * 4;
                }
            }
            case LITTLE_STRAIGHT -> {
                if (occurenceCount.isEmpty() || occurenceCount.size() <= 4 ||
                    occurenceCount.containsKey(6)) {
                        return 0;
                    }  else {
                        return 30;
                    }
            }
            case BIG_STRAIGHT -> {
                if (occurenceCount.isEmpty() || occurenceCount.size() <= 4 ||
                occurenceCount.containsKey(1)) {
                    return 0;
                }  else {
                    return 30;
                }
            }
            case YACHT -> {
                if (occurenceCount.isEmpty() || occurenceCount.size() >= 2) {
                    return 0;
                }  else {
                    return 50;
                }
            }
            default -> {
                throw new IllegalArgumentException(
                    "Strange Category"
                );
            }
        }
    }
}
