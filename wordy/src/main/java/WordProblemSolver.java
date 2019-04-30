import java.util.Iterator;
import java.util.stream.Stream;

public class WordProblemSolver {

    public char lexOp (String op) {
        switch (op) {
            case "plus": return '+';
            case "minus": return '-';
            case "multiplied": return '*';
            case "divided": return '/';
            default : throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }
    }

    private int applyOp (int total, char op, int argument) {
        switch (op) {
            case '+': total += argument; break;
            case '-': total -= argument; break;
            case '*': total *= argument; break;
            case '/': total /= argument; break;
            default : throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }
        return total;
    }

    public int solve(String question) {

        Iterator<Integer> numbers = Stream.of(question.split("[^0-9+-]+"))
                              .filter(x -> x.length() > 0)
                              .mapToInt(Integer::parseInt)
                              .iterator();

        Iterator<Character> operations = Stream.of(question.replaceAll("What is ", "")
                                                .replaceAll(" by ", "")
                                                .split("[^plus|minus|multiplied|divided]"))
                                  .filter(x -> x.length() > 0)
                                  .map(x -> lexOp(x))
                                  .iterator();

        int result = numbers.next();

        if (!numbers.hasNext()) {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        } 

        while (numbers.hasNext()) {
            result = applyOp(result, operations.next(), numbers.next());
        }
        
        return result;
    }
}