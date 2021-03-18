import java.time.LocalDate;
import java.time.DayOfWeek;

public class Meetup {

    private final int month;
    private final int year;

    public Meetup(int month, int year) {
        this.month = month;
        this.year = year;
    }

    private LocalDate scheduled(int wday, int first, int last) {
        LocalDate day = LocalDate.of(year, month, first);
        while (day.getDayOfMonth() != last + 1) {
            if (day.getDayOfWeek().getValue() == wday) break;
            day = day.plusDays(1);
        }
        return day;
    }

    public LocalDate day(DayOfWeek wday, MeetupSchedule m) {

        switch (m) {
            case FIRST: 
                return scheduled(wday.getValue(), 1, 7);
            case SECOND: 
                return scheduled(wday.getValue(), 8, 14);
            case THIRD: 
                return scheduled(wday.getValue(), 15, 21);
            case FOURTH: 
                return scheduled(wday.getValue(), 22, 28);
            case LAST:
                int lastDay =   
                    LocalDate.of(year, month, 1)
                    .lengthOfMonth();
                return scheduled(wday.getValue(), lastDay - 6, lastDay);
            case TEENTH: 
                return scheduled(wday.getValue(), 13, 19);
            default:
                throw 
                    new IllegalArgumentException("something went wrong");
        }
    }

}