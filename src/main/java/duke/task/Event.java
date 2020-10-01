package duke.task;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate atDate;
    protected LocalTime atTime;

    public Event(String description, LocalDate atDate, LocalTime atTime) {
        super(description);
        this.atDate = atDate;
        this.atTime = atTime;
    }

    public String toOutputString(){
        return "[E]" + super.toOutputString()
                + " (at: " + atDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))
                + " " + atTime + ")";
    }

    public String toDataString() {
        return "E" + super.toDataString() + " | " + atDate + " " + atTime;
    }
}
