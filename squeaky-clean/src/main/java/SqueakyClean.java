class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder cleaned = new StringBuilder(identifier.length());
        boolean wordBoundary = false;
        for (char ch: identifier.toCharArray()) {
            if (isNotGreek(ch)) {
                if (wordBoundary) {
                    cleaned.append(Character.toUpperCase(ch));
                } else
                if (Character.isLetter(ch)) {
                    cleaned.append(ch);
                } else 
                if (Character.isWhitespace(ch)) {
                    cleaned.append('_');
                } else 
                if (Character.isISOControl(ch)) {
                    cleaned.append("CTRL");
                }
                wordBoundary = (ch == '-');
            }
            else continue;
        }
        return cleaned.toString();
    }

    private static boolean isNotGreek(char ch) {
        return (ch < 'α' || 'ω' < ch);
    }
}
