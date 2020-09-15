package duke.task;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public String getStatusData() {
        return (isDone ? "1" : "0");
    }

    public String toDataString() {
        return " | " + getStatusData() + " | " + description;
    }
}
