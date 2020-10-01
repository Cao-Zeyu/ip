import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

import java.time.LocalDate;

public class Storage {
    public static String filePath;
    public static ArrayList<Task> list = new ArrayList<>();

    /**
     * Constructs a Storage object to access the data in the given address.
     *
     * @param filePath the String given to indicate the desired address
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads the data stored in the given file address and re-formats them into a task list.
     * The stored data may contain todo, deadline, and event tasks with their corresponding task status.
     *
     * @return the task list that read from the file
     * @throws IOException an exception occurs when encountered with problems reading into the file
     */
    public static ArrayList<Task> loadData() throws IOException {
        File dataFile = new File(filePath);
        if (dataFile.createNewFile()) {
            Ui.printLine();
            System.out.println("\tSince the file does not exist, I have created a file for you.");
            Ui.printLine();
        }
        Scanner dataScanner = new Scanner(dataFile);
        while (dataScanner.hasNext()) {
            String data = dataScanner.nextLine();
            String type = data.substring(0, 1);//task type length = 1
            boolean isDone = data.charAt(4) == '1';//status index = 4
            String content = data.substring(8);//description starts index = 8
            String description = content;
            String dateAndTime = "";
            LocalDate byDate;
            LocalTime byTime;
            LocalDate atDate;
            LocalTime atTime;
            int dateAndTimeIndex;
            if (content.contains("|")) {//have date and time
                dateAndTimeIndex = content.indexOf("|") + 2;
                description = content.substring(0, dateAndTimeIndex - 3);
                dateAndTime = content.substring(dateAndTimeIndex);
            }
            switch (type) {
            case "T":
                fileAddTodo(list, description, isDone);
                break;
            case "D":
                int byTimeIndex = dateAndTime.indexOf(" ")+1;
                byDate = LocalDate.parse(dateAndTime.substring(0, byTimeIndex-1));
                byTime = LocalTime.parse(dateAndTime.substring(byTimeIndex));
                fileAddDeadline(list, description, byDate, byTime, isDone);
                break;
            case "E":
                int atTimeIndex = dateAndTime.indexOf(" ")+1;
                atDate = LocalDate.parse(dateAndTime.substring(0, atTimeIndex-1));
                atTime = LocalTime.parse(dateAndTime.substring(atTimeIndex));
                fileAddEvent(list, description, atDate, atTime, isDone);
                break;
            default:
                break;
            }
        }
        return list;
    }

    /**
     * Saves the updated task list as data back to the give file address whenever the task list changes.
     *
     * @param tasks the TaskList object that contains the tasks in the list
     * @throws IOException an exception occurs when encountered with problems writing to the file
     */
    public static void saveData(TaskList tasks) throws IOException {
        FileWriter dataWriter = new FileWriter(filePath);
        for (int i = 0; i < tasks.getSize(); i++) {
            dataWriter.write(tasks.getList().get(i).toDataString() + "\n");
        }
        dataWriter.close();
    }

    /**
     * Adds a todo task read from the file to the task list.
     *
     * @param list the list that stores all the tasks
     * @param description the string that describe this todo task
     * @param isDone the status of this todo tasks
     */
    public static void fileAddTodo(ArrayList<Task> list, String description, boolean isDone) {
        list.add(new ToDo(description));
        list.get(list.size()-1).setDone(isDone);
    }

    /**
     * Adds a deadline task read from the file to the task list.
     *
     * @param list the list that stores all the tasks
     * @param description the string that describe this deadline task
     * @param byDate the data when this deadline task ends
     * @param byTime the time when this deadline task ends
     * @param isDone the status of this deadline tasks
     */
    public static void fileAddDeadline(ArrayList<Task> list, String description,
                                       LocalDate byDate, LocalTime byTime, boolean isDone) {
        list.add(new Deadline(description, byDate, byTime));
        list.get(list.size()-1).setDone(isDone);
    }

    /**
     * Adds a event task read from the file to the task list.
     *
     * @param list the list that stores all the tasks
     * @param description the string that describe this event task
     * @param atDate the data when this event task occurs
     * @param atTime the time when this event task occurs
     * @param isDone the status of this event tasks
     */
    public static void fileAddEvent(ArrayList<Task> list, String description,
                                    LocalDate atDate, LocalTime atTime, boolean isDone) {
        list.add(new Event(description, atDate, atTime));
        list.get(list.size()-1).setDone(isDone);
    }
}
