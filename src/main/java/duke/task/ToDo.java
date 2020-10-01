package duke.task;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    public String toOutputString(){
        return "[T]" + super.toOutputString();
    }

    public String toDataString() {
        return "T" + super.toDataString();
    }
}
