public class HelloWorld {
    
    public static String hello(String name) {
        String who = isBlank(name) ? "World" : name;
        return "Hello, " + who + "!";
    }

    public static boolean isBlank (String string) {
        return string == null || "".equals(string);
    }
}