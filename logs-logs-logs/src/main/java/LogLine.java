public class LogLine {
    private final String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        int codixEnd = logLine.indexOf(':') - 1;
        String codix = logLine.substring(1, codixEnd);
        return LogLevel.codixToLevel(codix);
    }

    public String getOutputForShortLog() {
        LogLevel level = this.getLogLevel();
        int lvl = level.getLevel(), 
            msgStart = logLine.indexOf(':') + 2;
        String msg = logLine.substring(msgStart);
        return "%d:%s".formatted(lvl, msg);
    }
}
