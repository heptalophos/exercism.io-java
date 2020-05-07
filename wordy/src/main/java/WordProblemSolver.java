import java.util.Iterator;
import java.util.stream.Stream;

public class WordProblemSolver {

    static final String EMsg = 
            "I'm sorry, I don't understand the question!";

    private char lexOp (String op) {
        switch (op) {
            case "plus": return '+';
            case "minus": return '-';
            case "multiplied": return '*';
            case "divided": return '/';
            default: throw new IllegalArgumentException(EMsg);
        }
    }

    private int applyOp (int acc, char op, int argument) {
        switch (op) {
            case '+': acc += argument; break;
            case '-': acc -= argument; break;
            case '*': acc *= argument; break;
            case '/': acc /= argument; break;
        }
        return acc;
    }

    public int solve(String question) {
        String onToken = 
            "[^0-9+-|plus|minus|multiplied|divided]+";
        Iterator<String> tokens = 
            Stream
            .of(question.replaceAll("What is ", "")
                        .replaceAll(" by ", " ")
                        .replaceAll("\\?$", "")
                        .split(onToken))
            .filter(x -> x.length() > 0)
            .iterator();
        try {
            int result = 
                Integer.parseInt(tokens.next());
            if (!tokens.hasNext())
               return result;
            do {
                result = 
                    applyOp(result, lexOp(tokens.next()), 
                            Integer.parseInt(tokens.next()));
                } while (tokens.hasNext());
                return result;
        }
        catch (Exception e) {
            throw new IllegalArgumentException(EMsg);
        }
    }
}