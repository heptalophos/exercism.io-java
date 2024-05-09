import java.util.List;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.Collectors.joining;

class BottleSong {
    private static final List<String> HOW_MANY = List.of(
        "no", "one", "two", "three", "four", "five", 
        "six", "seven", "eight", "nine", "ten"
    );

    String recite(int startBottles, int takeDown) {
        return iterate(startBottles, b -> b - 1)
               .limit(takeDown)
               .mapToObj(x -> stanza(x))
               .collect(joining("\n"));
    }

    private String stanza(int n) {
        String prologue = 
            String.format("%s hanging on the wall,\n", bottles(n, true));
        String again = prologue;
        String premise = 
            String.format("And if %s should accidentally fall,\n", 
                          bottles(1, false));
        String conclusion = 
            String.format("There\'ll be %s hanging on the wall.\n", 
                          bottles(n - 1, false)); 
        return prologue + again + premise + conclusion;
    }

    private String bottles(int n, boolean cap) {
        String s = n != 1 ? "s" : "";
        String thisMany = !cap ? HOW_MANY.get(n) 
                               : capitalize(HOW_MANY.get(n));
        return  String.format("%s green bottle%s", thisMany, s);
    }

    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}