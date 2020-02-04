public class Bob {

    public String hey (String greeting) {
        final String response;
        greeting = greeting.trim();
        response = silent(greeting)   ? "Fine. Be that way!"                :
                   emphatic(greeting) ? "Calm down, I know what I'm doing!" :
                   shouting(greeting) ? "Whoa, chill out!"                  :
                   querying(greeting) ? "Sure." : "Whatever.";
        return response;
    }

    private static boolean silent (String greeting) {
        return greeting.isEmpty();
    }

    private static boolean querying (String greeting) {
        return greeting.endsWith("?");
    }
    
    private static boolean shouting (String greeting) {
        final String uppers = greeting.toUpperCase();
        final String lowers = greeting.toLowerCase();
        final boolean someLetters = !lowers.equals(uppers);
        final boolean allUppercase = greeting.equals(uppers);
        return (someLetters && allUppercase);
    }
    
    private static boolean emphatic (String greeting) {
        return shouting(greeting) && querying(greeting);
    }
}