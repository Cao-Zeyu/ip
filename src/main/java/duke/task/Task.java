package duke.task;

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a Task object with a given description and a default task status of undone.
     *
     * @param description the string given to describe this task
     */
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

    /**
     * Returns the status icon when outputting the tasks.
     *
     * @return a cross if the task is undone, a tick if the task is done
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Returns the status icon when writing the tasks into the text file.
     *
     * @return a "0" if the task is undone, a "1" if the task is done
     */
    public String getStatusData() {
        return (isDone ? "1" : "0");
    }

    /**
     * Returns the string format of the task to output the task when the program is running.
     *
     * @return the string format of this task with its status and description for output
     */
    public String toOutputString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Returns the string format of the task to write the task into the file.
     *
     * @return the string format of this task with its status and description for data saving
     */
    public String toDataString() {
        return " | " + getStatusData() + " | " + description;
    }
}
