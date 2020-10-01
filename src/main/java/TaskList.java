import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.time.LocalTime;
import java.util.ArrayList;

import java.time.LocalDate;

public class TaskList {
    public static ArrayList<Task> list;

    /**
     * Constructs a new task list if there is no data stored in the given address.
     */
    public TaskList() {
        list = new ArrayList<>();
    }

    /**
     * Constructs a task list by reading from the file content in the given address.
     *
     * @param list the task list that is read from the file in the given address
     */
    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    /**
     * Adds a todo task into the task list and confirms the adding bu printing a message.
     *
     * @param description the description for this added todo task obtained by parsing the input command
     */
    public static void addTodo (String description) {
        list.add(new ToDo(description));
        Ui.printAddMessage(list.get(list.size()-1));
    }

    /**
     * Adds a deadline task into the task list and confirms the adding bu printing a message.
     *
     * @param description the description for this added deadline task obtained by parsing the input command
     * @param byTime the deadline for this added deadline task obtained by parsing the input command
     */
    public static void addDeadline(String description, LocalDate byDate, LocalTime byTime) {
        list.add(new Deadline(description, byDate, byTime));
        Ui.printAddMessage(list.get(list.size()-1));
    }

    /**
     * Adds a event task into the task list and confirms the adding bu printing a message.
     *
     * @param description the description for this added event task obtained by parsing the input command
     * @param atDate the occur dat for this added event task obtained by parsing the input command
     * @param atTime the occur time for this added event task obtained by parsing the input command
     */
    public static void addEvent(String description, LocalDate atDate, LocalTime atTime) {
        list.add(new Event(description, atDate, atTime));
        Ui.printAddMessage(list.get(list.size()-1));
    }

    public static void getWholeList() {
        Ui.printCompleteList(list);
    }

    /**
     * Gets the tasks that contains the keyword that the user inputs and print them in another task list.
     *
     * @param taskKeyword the keyword that the user want all the matching tasks to contain
     */
    public static void getMatchingTask(String taskKeyword) {
        ArrayList<Task> matchingTaskList = new ArrayList<>();
        for(Task task : list) {
            if (task.getDescription().contains(taskKeyword)) {
                matchingTaskList.add(task);
            }
        }
        if (matchingTaskList.size() != 0) {
            Ui.printMatchingList(matchingTaskList);
        } else {
            Ui.printNoMatchingMessage();
        }
    }

    /**
     * Sets the task indicated by the user as done and confirms the marking by printing a message.
     *
     * @param doneIndex the index of the task that the user input to be marked as done
     */
    public static void setDone(int doneIndex) {
        Task doneTask = list.get(doneIndex-1);
        doneTask.setDone(true);
        list.set(doneIndex-1, doneTask);
        Ui.printDoneMessage(doneTask);
    }

    /**
     * Deletes the task indicated by the user and confirms the deletion by printing a message.
     *
     * @param deletedIndex the index of the task that the user input to be deleted
     */
    public static void delete(int deletedIndex) {
        Task deletedTask = list.get(deletedIndex-1);
        Ui.printDeletedMessage(deletedTask);
        list.remove(deletedIndex-1);
    }

    public static int getSize() {
        return list.size();
    }

    public static ArrayList<Task> getList() {
        return list;
    }

}
