import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Duke.greet();

        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        Task[] list = new Task[100];
        int number = 0;

        while (!command.equals("bye")) {
            if (command.equals("list")) {
                Duke.displayList(list, number);
            } else if (command.startsWith("done")){
                Duke.done(list, command, number);
            } else {
                list[number] = new Task(command);
                Duke.add(command);
                number++;
            }
            command = in.nextLine();
        }

        Duke.exit();
    }

    public static void greet() {
        Duke.printLine();
        System.out.println("\t" + "Hello! I'm Duke\n" +
                "\t" + "What can I do for you?");
        Duke.printLine();
    }

    public static void displayList(Task[] list, int number) {
        Duke.printLine();
        System.out.println("\tHere are the tasks in your list:");
        for(int i=1; i<=number; i++) {
            System.out.println("\t" + i + ". "
                    + "[" + list[i-1].getStatusIcon() + "] "
                    + list[i-1].description);
        }
        Duke.printLine();
    }

    public static void done(Task[] list, String command, int number) {
        int doneNumber = Integer.parseInt(command.substring(5));
        list[doneNumber-1].isDone = true;
        Duke.printLine();
        System.out.println("\tNice! I've marked this task as done: ");
        System.out.println("\t   "+ "[" + list[doneNumber-1].getStatusIcon() + "] "
                + list[doneNumber-1].description);
        Duke.printLine();
    }

    public static void add(String text) {
        Duke.printLine();
        System.out.println("\t" + "added: " + text);
        Duke.printLine();
    }

    public static void exit() {
        Duke.printLine();
        System.out.println("\t" + "Bye. Hope to see you again soon!");
        Duke.printLine();
    }

    public static void printLine() {
        System.out.println("\t" + "___________________________________________");
    }
}
