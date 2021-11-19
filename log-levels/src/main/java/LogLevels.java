import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLevels {

    private static Map<String, String> logLineParts(String logLine) {
        Pattern pattern = Pattern.compile("\\[(\\w+)\\]:\\s*(.+)");
        Matcher matcher = pattern.matcher(logLine);
        matcher.find();
        return Map.of(":message", matcher.group(2), ":log-level", matcher.group(1));
    }
    
    public static String message(String logLine) {
        return logLineParts(logLine).get(":message").trim();
    }

    public static String logLevel(String logLine) {
        return logLineParts(logLine).get(":log-level").toLowerCase();
    }

    public static String reformat(String logLine) {
        return String.format("%s (%s)", message(logLine), logLevel(logLine));
    }
}
