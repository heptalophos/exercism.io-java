import java.util.List;
import java.util.Set;
import java.util.HashSet;

class GottaSnatchEmAll {
    static Set<String> newCollection(List<String> cards) {
        return new HashSet<String>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, 
                            Set<String> theirCollection) {
       return !myCollection.isEmpty() && 
              !myCollection.containsAll(theirCollection);
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> common = new HashSet<>(collections.get(0));
        for (Set<String> c : collections) common.retainAll(c);
        return common;
    }

    static Set<String> allCards(List<Set<String>> collections) {
       Set<String> all = new HashSet<>(collections.get(0));
       for (Set<String> c : collections) all.addAll(c);
       return all;
    }
}
