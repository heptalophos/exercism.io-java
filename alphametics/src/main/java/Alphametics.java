import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.IntStream.range;


public class Alphametics {
    List<Character> letters;
    List<String> words;

    public Alphametics(String puzzle) {
        letters = puzzle.chars().filter( Character::isAlphabetic )
                        .mapToObj( c -> (char) c ).distinct()
                        .collect( toList() );
        words   = Arrays.asList( puzzle.split("\\W+") );
    }

    public Map<Character, Integer> solve() throws UnsolvablePuzzleException {
        List<Integer> numbers = range(0, 10).boxed().collect( toList() );
        Map<Character, Integer> solver = solution( letters, numbers, 0 );
        if (solver.isEmpty()) { 
            throw new UnsolvablePuzzleException();
        }
        return solver;
    }

    private Map<Character, Integer> solution(List<Character> letters, List<Integer> numbers, int depth) {
        if (letters.isEmpty()) {
            return Map.of();
        } 
        if (depth == letters.size()) {
            Map<Character, Integer> mapping = 
                range(0, letters.size())
                .boxed()
                .collect( toMap(letters::get, numbers::get) );
                return isItASolution( mapping ) ? mapping : Map.of();
        }
        for (int i = depth; i < numbers.size(); i++) {
            exchange(numbers, i, depth);
            Map<Character, Integer> mapping = solution(letters, numbers, depth + 1);
            if (!mapping.isEmpty()) {
                return mapping;
            }
            exchange(numbers, i, depth);
        }
        return Map.of();
    }

    private void exchange(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private boolean isItASolution(Map<Character, Integer> mapping) {
        int[] values = new int[words.size()];
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() > 1 && 
                mapping.get(words.get(i).charAt(0)) == 0) {
                return false;
            }
            for (char c : words.get(i).toCharArray()) {
                values[i] *= 10;
                values[i] += mapping.get(c);
            }
        }
        int sum = 0;
        for (int i = 0; i < values.length - 1; i++) {
            sum += values[i];
        }
        return sum - values[values.length - 1] == 0;
    }
}
