import duke.task.Task;

import java.util.ArrayList;

public class Ui {

    public static void printGreetings() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printLine();
        System.out.println("\t" + "Hello! I'm Duke\n" +
                "\t" + "What can I do for you?");
        printLine();
    }

    public static void printGoodbye() {
        printLine();
        System.out.println("\t" + "Bye. Hope to see you again soon!");
        printLine();
    }

    public static void showLoadingError() {
        printLine();
        System.out.println("\t" + "There is no existing data to load... ");
        printLine();
    }

    public static void printInvalidInputMessage(String input) {
        printLine();
        switch (input) {
        case "todo":
            System.out.println("\t" + "🙁 OOPS!!! The description of a todo cannot be empty.");
            break;
        case "deadline":
            System.out.println("\t" + "🙁 OOPS!!! The description of a deadline cannot be empty.");
            break;
        case "event":
            System.out.println("\t" + "🙁 OOPS!!! The description of a event cannot be empty.");
            break;
        case "done":
        case "delete":
            System.out.println("\t" + "🙁 OOPS!!! The index of the task cannot be empty.");
            break;
        case "find":
            System.out.println("\t" + "🙁 OOPS!!! The keyword for finding cannot be empty.");
            break;
        default:
            System.out.println("\t" + "🙁 OOPS!!! I'm sorry, but I don't know what that means :-(");
            break;
        }
        printLine();
    }

    public static void printLine() {
        System.out.println("\t" + "___________________________________________");
    }

    public static void printAddMessage(Task task) {
        printLine();
        System.out.println("\t" + "Got it. I've added this task: ");
        System.out.println("\t   " + task.toString());
        System.out.println("\t" + "Now you have " + (TaskList.getSize()) + " tasks in the list. ");
        printLine();
    }

    public static void printDoneMessage(Task doneTask) {
        printLine();
        System.out.println("\t" + "Nice! I've marked this task as done: ");
        System.out.println("\t   " + doneTask.toString());
        printLine();
    }

    public static void printDeletedMessage(Task deletedTask) {
        printLine();
        System.out.println("\t" + "Noted. I've removed this task: ");
        System.out.println("\t   " + deletedTask.toString());
        System.out.println("\tNow you have " + (TaskList.getSize()-1) + " tasks in the list.");
        printLine();
    }

    public static void printCompleteList(ArrayList<Task> completeList) {
        printLine();;
        System.out.println("\t" + "Here are the tasks in your list: ");
        displayList(completeList);
        printLine();
    }

    public static void printMatchingList(ArrayList<Task> matchingList) {
        printLine();
        System.out.println("\t" + "Here are the matching tasks in your list: ");
        displayList(matchingList);
        printLine();
    }

    public static void printNoMatchingMessage() {
        printLine();
        System.out.println("\t" + "There is no matching task... ");
        printLine();
    }

    public static void displayList(ArrayList<Task> list) {
        for(int i=1; i<=list.size(); i++) {
            System.out.println("\t" + i + ". " + list.get(i-1).toString());
        }
    }
}
