import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class School {
    private Map<Integer, List<String>> roster;

    public School() {
        roster = new HashMap<Integer, List<String>>();
    }

    public Map<Integer, List<String>> roster() {
        return roster;
    }

    public void add(String name, Integer grade) {
        List<String> names = roster.containsKey(grade) ?
                             roster.get(grade) :
                            new ArrayList<String>();
        names.add(name);
        names.sort(Comparator.naturalOrder());
        roster.put(grade, names);
    }

    List<String> grade(Integer grade) {
        return roster.getOrDefault(grade, new ArrayList<>());
    }

}
