package duke.task;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    public String toString(){
        return "[T]" + super.toString();
    }

    public String toDataString() {
        return "T" + super.toDataString();
    }
}
