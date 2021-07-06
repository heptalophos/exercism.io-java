public class Acronym {

    private final String phrase;

    Acronym(String phrase) {
        this.phrase = 
            phrase.replaceAll("[^A-Za-z -]+","");
    }

    public String get() {
        String acronym = "";
        for (String word : phrase.split("(\\s|[-])+")) {
            acronym += word.toUpperCase().charAt(0);
        }
        return acronym;
    }
}
