public class Acronym {

    private final String phrase;


    Acronym(String phrase) {
        
        this.phrase = phrase;
    }

    
    public String get() {

        String acro = "";
        
        for (String word : phrase.split("[ -]")) {
            acro += word.toUpperCase().charAt(0);
        }
        
        return acro;
    }
}
