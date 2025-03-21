import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import static java.util.Comparator.naturalOrder;


class School {
    private Map<Integer, List<String>> roster;

    public School() {
        roster = new HashMap<>();
    }

    public List<String> roster() {
        List<String> students = new ArrayList<>();
        for (int grade : roster.keySet()) {
            students.addAll(roster.get(grade));
        }
        return students;
    }

    public boolean add(String name, Integer grade) {
        List<String> names = roster.containsKey(grade) 
                             ? roster.get(grade) 
                             : new ArrayList<>();
        if (roster().contains(name)) return false;
        names.add(name);
        names.sort(naturalOrder());
        roster.put(grade, names);
        return true;
    }

    List<String> grade(Integer grade) {
        return roster.getOrDefault(grade, new ArrayList<>());
    }

}
