package duke.task;

import duke.task.Task;

public class Event extends Task {
    protected String atTime;

    public Event(String description, String atTime) {
        super(description);
        this.atTime = atTime;
    }

    public String toString(){
        return "[E]" + super.toString() + " (at: " + atTime + ")";
    }
}
