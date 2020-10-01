package duke.task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDate byDate;
    protected LocalTime byTime;

    public Deadline(String description, LocalDate byDate, LocalTime byTime) {
        super(description);
        this.byDate = byDate;
        this.byTime = byTime;
    }

    public String toOutputString(){
        return "[D]" + super.toOutputString() +
                " (by: " + byDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))
                + " " + byTime + ")";
    }

    public String toDataString() {
        return "D" + super.toDataString() + " | " + byDate + " " + byTime;
    }
}
