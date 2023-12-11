public enum LogLevel {
    TRACE   (1,  "TRC"),
    DEBUG   (2,  "DBG"),
    INFO    (4,  "INF"),
    WARNING (5,  "WRN"),
    ERROR   (6,  "ERR"),
    FATAL   (42, "FTL"),
    UNKNOWN (0,  "___");

    private final int level;
    private final String codix;

    LogLevel(int level, String codix) {
        this.level = level;
        this.codix = codix;
    }

    public int getLevel() { return level; }
    public String getCodix() { return codix; }

    public static LogLevel codixToLevel(String codix) {
        for (LogLevel level : values())
            if(codix.equals(level.getCodix())) return level;
        return LogLevel.UNKNOWN;
    }
}
