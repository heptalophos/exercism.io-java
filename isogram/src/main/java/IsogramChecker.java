class IsogramChecker {

    boolean isIsogram(String phrase) {

        phrase = phrase
                 .replace("-", "")
                 .replace(" ", "")
                 .toLowerCase();
        
        return (phrase.isEmpty())
               ? true
               : phrase.chars()
                       .distinct()
                       .count() == phrase.length();
    }
}
