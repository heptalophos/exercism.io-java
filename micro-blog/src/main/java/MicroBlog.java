class MicroBlog {
    private static final int MAX_POST = 5;

    public String truncate(final String input) {
        return input.codePointCount(0, input.length()) < MAX_POST ? input :
               input.substring(0, input.offsetByCodePoints(0, MAX_POST));
    }
}
