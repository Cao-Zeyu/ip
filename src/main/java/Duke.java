import java.util.Scanner;

public class Duke {
    public static final int SKIP_DEADLINE_NUMBER = 9;
    public static final int SKIP_EVENT_NUMBER = 6;
    public static final int SKIP_DONE_NUMBER = 5;
    public static final int SKIP_SEPARATION_NUMBER = 4;

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
        String description;
        String time;
        Task[] list = new Task[100];
        int separatePosition;
        int number = 0;
        while (!command.equals("bye")) {
            if (command.equals("list")) {
                Duke.displayList(list, number);
            } else if (command.startsWith("done")) {
                Duke.done(list, command, number);
            } else if (command.startsWith("todo")) {
                list[number] = new ToDo(command.substring(5));
                number = Duke.add(list[number], number);
            } else if (command.startsWith("deadline")) {
                separatePosition = command.indexOf('/');
                description = command.substring(SKIP_DEADLINE_NUMBER, separatePosition-1);
                time = command.substring(separatePosition+SKIP_SEPARATION_NUMBER);
                list[number] = new Deadline(description, time);
                number = Duke.add(list[number], number);
            } else if (command.startsWith("event")) {
                separatePosition = command.indexOf('/');
                description = command.substring(SKIP_EVENT_NUMBER, separatePosition-1);
                time = command.substring(separatePosition+SKIP_SEPARATION_NUMBER);
                list[number] = new Event(description, time);
                number = Duke.add(list[number], number);
            } else {
                Duke.commandAgain();
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

    public static void commandAgain() {
        Duke.printLine();
        System.out.println("\tPlease give a valid command!");
        Duke.printLine();
    }

    public static void displayList(Task[] list, int number) {
        Duke.printLine();
        System.out.println("\tHere are the tasks in your list:");
        for(int i=1; i<=number; i++) {
            System.out.println("\t" + i + ". " + list[i-1].toString());
        }
        Duke.printLine();
    }

    public static int add(Task task, int number) {
        Duke.printLine();
        System.out.println("\tGot it. I've added this task: ");
        System.out.println("\t   " + task.toString());
        System.out.println("\tNow you have " + (number+1) + " tasks in the list. ");
        Duke.printLine();
        return number+1;
    }

    public static void done(Task[] list, String command, int number) {
        int doneNumber = Integer.parseInt(command.substring(SKIP_DONE_NUMBER));
        list[doneNumber-1].setDone(true);
        Duke.printLine();
        System.out.println("\tNice! I've marked this task as done: ");
        System.out.println("\t   " + list[doneNumber-1].toString());
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
