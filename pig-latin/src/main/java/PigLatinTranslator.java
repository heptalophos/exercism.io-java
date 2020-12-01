public class PigLatinTranslator {

    private static final String VOWEL = 
        "(?<head>^|\\s+)" + 
        "(?<vowel>[aeiou]|yt|xr)" +
        "(?<rest>\\w+)";
    private static final String CONSONANT = 
        "(?<head>^|\\s+)" +
        "(?<consonant>ch|thr|th|sch|rh|qu|[^aeiou]qu|[^aeiou])" +
        "(?<rest>\\w+)";
    

    public static String translate (String word) {
        return  (word.matches(VOWEL)) ? 
                word.replaceAll(VOWEL, 
                                "${head}${vowel}${rest}ay") : 
                word.replaceAll(CONSONANT,
                                "${head}${rest}${consonant}ay");
    }
}