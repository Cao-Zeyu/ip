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
        int separatePosition;
        int number = 0;
        while (!command.equals("bye")) {
            if (command.equals("list")) {
                Duke.displayList(list, number);
            } else if (command.startsWith("done")) {
                Duke.done(list, command, number);
            } else if (command.startsWith("todo")) {
                list[number] = new ToDo(command.substring(5));
                Duke.add(list[number], number+1);
                number++;
            } else if (command.startsWith("deadline")) {
                separatePosition = command.indexOf('/');
                list[number] = new Deadline(command.substring(9, separatePosition-1),
                        command.substring(separatePosition+4));
                Duke.add(list[number], number+1);
                number++;
            } else if (command.startsWith("event")) {
                separatePosition = command.indexOf('/');
                list[number] = new Event(command.substring(6, separatePosition-1),
                        command.substring(separatePosition+4));
                Duke.add(list[number], number+1);
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
            System.out.println("\t" + i + ". " + list[i-1].toString());
        }
        Duke.printLine();
    }

    public static void done(Task[] list, String command, int number) {
        int doneNumber = Integer.parseInt(command.substring(5));
        list[doneNumber-1].setDone(true);
        Duke.printLine();
        System.out.println("\tNice! I've marked this task as done: ");
        System.out.println("\t   " + list[doneNumber-1].toString());
        Duke.printLine();
    }

    public static void add(Task task, int number) {
        Duke.printLine();
        System.out.println("\tGot it. I've added this task: ");
        System.out.println("\t   " + task.toString());
        System.out.println("\tNow you have " + number + " tasks in the list. ");
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
