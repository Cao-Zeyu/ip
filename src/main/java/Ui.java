import duke.task.Task;

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

    public static void printLine() {
        System.out.println("\t" + "___________________________________________");
    }

    public static void printAddMessage(Task task) {
        printLine();
        System.out.println("\tGot it. I've added this task: ");
        System.out.println("\t   " + task.toString());
        System.out.println("\tNow you have " + (TaskList.getSize()) + " tasks in the list. ");
        printLine();
    }

    public static void printDoneMessage(Task doneTask) {
        printLine();
        System.out.println("\tNice! I've marked this task as done: ");
        System.out.println("\t   " + doneTask.toString());
        printLine();
    }

    public static void printDeletedMessage(Task deletedTask) {
        printLine();
        System.out.println("\tNoted. I've removed this task: ");
        System.out.println("\t   " + deletedTask.toString());
        System.out.println("\tNow you have " + (TaskList.getSize()-1) + " tasks in the list.");
        printLine();
    }
}
