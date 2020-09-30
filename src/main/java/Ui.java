import duke.task.Task;

import java.util.ArrayList;

public class Ui {

    /**
     * Prints the Duke logo and greetings when the program starts to run.
     */
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

    /**
     * Prints the goodbye message before the program ends.
     */
    public static void printGoodbye() {
        printLine();
        System.out.println("\t" + "Bye. Hope to see you again soon!");
        printLine();
    }

    /**
     * Prints an error message when there is no data stored in the text file to be loaded.
     */
    public static void showLoadingError() {
        printLine();
        System.out.println("\t" + "There is no existing data to load... ");
        printLine();
    }

    /**
     * Prints the corresponding error message for different type of invalid inputs.
     *
     * @param input the invalid input which is not a command or does not provide enough information
     */
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

    /**
     * Prints a message to confirm the addition of a task by printing the formatted task
     * and the number of tasks in the updated task list.
     *
     * @param task the new task to be added into the task list
     */
    public static void printAddMessage(Task task) {
        printLine();
        System.out.println("\t" + "Got it. I've added this task: ");
        System.out.println("\t   " + task.toString());
        System.out.println("\t" + "Now you have " + (TaskList.getSize()) + " tasks in the list. ");
        printLine();
    }

    /**
     * Prints a message to confirm marking a task as done by printing the formatted task with
     * updated task status.
     *
     * @param doneTask the task to be marked as done
     */
    public static void printDoneMessage(Task doneTask) {
        printLine();
        System.out.println("\t" + "Nice! I've marked this task as done: ");
        System.out.println("\t   " + doneTask.toString());
        printLine();
    }

    /**
     * Prints a message to confirm deleting a task by reprinting the deleted task
     * and the number of tasks in the updated task list.
     *
     * @param deletedTask the task to be deleted
     */
    public static void printDeletedMessage(Task deletedTask) {
        printLine();
        System.out.println("\t" + "Noted. I've removed this task: ");
        System.out.println("\t   " + deletedTask.toString());
        System.out.println("\tNow you have " + (TaskList.getSize()-1) + " tasks in the list.");
        printLine();
    }

    /**
     * Displays all the tasks in the list in order.
     * This method is used in <printCompleteList></printCompleteList>
     * and <printMatchingList></printMatchingList> to display tasks stored in different list.
     *
     * @param list the task list to be displayed
     */
    public static void displayList(ArrayList<Task> list) {
        for(int i=1; i<=list.size(); i++) {
            System.out.println("\t" + i + ". " + list.get(i-1).toString());
        }
    }

    /**
     * Prints the complete task list which stores all the tasks.
     *
     * @param completeList the complete list
     */
    public static void printCompleteList(ArrayList<Task> completeList) {
        printLine();;
        System.out.println("\t" + "Here are the tasks in your list: ");
        displayList(completeList);
        printLine();
    }

    /**
     * Prints the list of tasks that matches the find input.
     *
     * @param matchingList the list of tasks that contains the finding keyword
     */
    public static void printMatchingList(ArrayList<Task> matchingList) {
        printLine();
        System.out.println("\t" + "Here are the matching tasks in your list: ");
        displayList(matchingList);
        printLine();
    }

    /**
     * Prints an error message if the task matches the find input cannot be found.
     */
    public static void printNoMatchingMessage() {
        printLine();
        System.out.println("\t" + "There is no matching task... ");
        printLine();
    }

    /**
     * Prints all the valid input commands for the user to understand how to use Duke.
     */
    public static void printHelp() {
        printLine();
        System.out.println("\t" + "Here are some available commands " +
                "and their corresponding input format: " + System.lineSeparator());
        System.out.println("\t" + "Listing all the tasks: `list` " +
                "\n\t" + "Format: `list`" + System.lineSeparator());
        System.out.println("\t" + "Adding a todo task: `todo` " +
                "\n\t" + "Format: `todo TASK`" + System.lineSeparator());
        System.out.println("\t" + "Adding a deadline task: `deadline` " +
                "\n\t" + "Format: `deadline TASK /by BYTIME`" + System.lineSeparator());
        System.out.println("\t" + "Adding an event task: `event` " +
                "\n\t" + "Format: `event TASK /by ATTIME`" + System.lineSeparator());
        System.out.println("\t" + "Marking a task as done: `done` " +
                "\n\t" + "Format: `done INDEX`" + System.lineSeparator());
        System.out.println("\t" + "Deleting a task: `delete` " +
                "\n\t" + "Format: `delete INDEX`" + System.lineSeparator());
        System.out.println("\t" + "Finding a task: `find` " +
                "\n\t" + "Format: `find KEYWORD`" + System.lineSeparator());
        System.out.println("\t" + "Exiting Duke: `bye` " + "\n\t" + "Format: `bye`");
        printLine();
    }
}
