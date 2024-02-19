import java.util.Locale;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    private static final DateTimeFormatter DESC = DateTimeFormatter.ofPattern(
        "'You have an appointment on 'EEEE, MMMM d, yyyy, 'at' h:mm a'.'", 
        Locale.US
    );
    private static final DateTimeFormatter APPT = DateTimeFormatter.ofPattern(
        "MM/dd/yyyy HH:mm:ss"
    );

    public LocalDateTime schedule(String appointmentDateDescription) {
        return LocalDateTime.parse(appointmentDateDescription, APPT);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return LocalDateTime.now().isAfter(appointmentDate);
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int time = appointmentDate.getHour();
        return time >= 12 && time < 18;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        return appointmentDate.format(DESC);
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDateTime.now().getYear(), 9, 15);
    }
}
