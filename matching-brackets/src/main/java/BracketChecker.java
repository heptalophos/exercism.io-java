public class BracketChecker {
    
    private final String bracketsOnly;
    
    public BracketChecker(String input) {
        bracketsOnly = 
            input
            .replaceAll("[^\\[\\]\\{\\}\\(\\)]+", "");
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {

        String brackets  = bracketsOnly;         
        String pairedOff = bracketsOnly
                           .replaceAll("\\(\\)", "")
                           .replaceAll("\\{\\}", "")
                           .replaceAll("\\[\\]", "");

        while (pairedOff.length() < brackets.length()) {
            brackets  = pairedOff;
            pairedOff = pairedOff
                        .replaceAll("\\(\\)", "")
                        .replaceAll("\\{\\}", "")
                        .replaceAll("\\[\\]", "");
        }
        return pairedOff.isEmpty();
    }
 }
