class Acronym {

    String phrase;

    Acronym(String phrase) {
        this.phrase = phrase ;
    }

    String get() {
        StringBuilder  sb = new StringBuilder();
        for (String w : phrase.split("[ -]")) {
            sb.append(w.toUpperCase().charAt(0))
        }
    }
}
