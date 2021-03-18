import java.util.stream.Stream;
import java.time.LocalDate;
import java.time.DayOfWeek;

import static java.util.stream.IntStream.rangeClosed;
import static java.util.stream.Collectors.toList;

public class Meetup {

    private final int month;
    private final int year;

    public Meetup(int month, int year) {
        this.month = month;
        this.year = year;
    }



}