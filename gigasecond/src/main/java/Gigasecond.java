import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigInteger;

public class Gigasecond {

    private final LocalDateTime date;
    private static final Long GIGASEC = BigInteger.valueOf(10).pow(9).longValue();

    public Gigasecond(LocalDate birthDate) {
        this(birthDate.atStartOfDay());
    }

    public Gigasecond(LocalDateTime birthDateTime) {
        this.date = birthDateTime;
    }

    LocalDateTime getDate() {
        return date.plusSeconds(GIGASEC);
    }
}
