import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private final LocalDateTime date;
    
    private static final int GIGASEC = 1_000_000_000;

    public Gigasecond(LocalDate birthDate) {
        this(birthDate.atStartOfDay());
    }

    public Gigasecond(LocalDateTime birthDateTime) {
        this.date = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return date.plusSeconds(GIGASEC);
    }
}
