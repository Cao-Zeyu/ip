import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.util.ArrayList;

public class TaskList {
    public static ArrayList<Task> list;

    public TaskList() {
        list = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    public static void addTodo (String description) {
        list.add(new ToDo(description));
        Ui.printAddMessage(list.get(list.size()-1));
    }

    public static void addDeadline(String description, String byTime) {
        list.add(new Deadline(description, byTime));
        Ui.printAddMessage(list.get(list.size()-1));
    }

    public static void addEvent(String description, String atTime) {
        list.add(new Event(description, atTime));
        Ui.printAddMessage(list.get(list.size()-1));
    }

    public static void getWholeList() {
        Ui.printCompleteList(list);
    }

    public static void setDone(int doneIndex) {
        Task doneTask = list.get(doneIndex-1);
        doneTask.setDone(true);
        list.set(doneIndex-1, doneTask);
        Ui.printDoneMessage(doneTask);
    }

    public static void delete(int deletedIndex) {
        Task deletedTask = list.get(deletedIndex-1);
        Ui.printDeletedMessage(deletedTask);
        list.remove(deletedIndex-1);
    }

    public static void getMatchingTask(String taskKeyword) {
        ArrayList<Task> matchingTaskList = new ArrayList<>();
        for(Task task : list) {
            if (task.getDescription().contains(taskKeyword)) {
                matchingTaskList.add(task);
            }
        }
        Ui.printMatchingList(matchingTaskList);
    }

    public static int getSize() {
        return list.size();
    }

    public static ArrayList<Task> getList() {
        return list;
    }

}
