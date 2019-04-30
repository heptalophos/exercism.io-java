import java.util.Iterator;
import java.util.stream.Stream;
import java.util.NoSuchElementException;

public class WordProblemSolver {

    private char lexOp (String op) {
        switch (op) {
            case "plus": return '+';
            case "minus": return '-';
            case "multiplied": return '*';
            case "divided": return '/';
            default : throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }
    }

    private int applyOp (int acc, char op, int argument) {
        switch (op) {
            case '+': acc += argument; break;
            case '-': acc -= argument; break;
            case '*': acc *= argument; break;
            case '/': acc /= argument; break;
            default : throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }
        return acc;
    }

    public int solve(String question) {

        try {

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
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }
    }
}