import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Duke {
    public static final int SKIP_DEADLINE_NUMBER = 9;
    public static final int SKIP_EVENT_NUMBER = 6;
    public static final int SKIP_DONE_NUMBER = 5;
    public static final int SKIP_SEPARATION_NUMBER = 4;

    public static Task[] list = new Task[100];
    public static int number = 0;

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        Duke.greet();

        try {
            number = FileSaver.loadData(list);
        } catch (FileNotFoundException e) {
            Duke.printLine();
            System.out.println("\t🙁 OOPS!!! The file data.txt cannot be found.");
            Duke.printLine();
        }

        Scanner in = new Scanner(System.in);
        String command = in.nextLine();

        while (!command.equals("bye")) {
            try {
                if (command.equals("list")) {
                    Duke.displayList(list, number);
                } else if (command.startsWith("done")) {
                    Duke.done(list, command, number);
                } else if (command.startsWith("todo")) {
                    Duke.addTodo(command);
                } else if (command.startsWith("deadline")) {
                    Duke.addDeadline(command);
                } else if (command.startsWith("event")) {
                    Duke.addEvent(command);
                } else {
                    throw new DukeException();
                }
                FileSaver.saveData(list, number);
            } catch(DukeException e) {
                    Duke.commandAgain(command);
            } catch (IOException e) {
                Duke.printLine();
                System.out.println("\t🙁 OOPS!!! IOException occurs.");
                Duke.printLine();
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

    public static void commandAgain(String command) {
        Duke.printLine();
        switch(command) {
        case "todo":
            System.out.println("\t🙁 OOPS!!! The description of a todo cannot be empty.");
            break;
        case "deadline":
            System.out.println("\t🙁 OOPS!!! The description of a deadline cannot be empty.");
            break;
        case "event":
            System.out.println("\t🙁 OOPS!!! The description of a event cannot be empty.");
            break;
        default:
            System.out.println("\t🙁 OOPS!!! I'm sorry, but I don't know what that means :-(");
            break;
        }
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

    public static void addTodo (String command) throws DukeException {
        if(command.equals("todo")) {
            throw new DukeException();
        }
        list[number] = new ToDo(command.substring(5));
        number = Duke.add(list[number], number);
    }

    public static void addDeadline(String command) throws DukeException{
        if(command.equals("deadline")) {
            throw new DukeException();
        }
        int separatePosition = command.indexOf('/');
        String description = command.substring(SKIP_DEADLINE_NUMBER, separatePosition-1);
        String byTime = command.substring(separatePosition+SKIP_SEPARATION_NUMBER);
        list[number] = new Deadline(description, byTime);
        number = Duke.add(list[number], number);
    }

    public static void addEvent(String command) throws DukeException{
        if(command.equals("event")) {
            throw new DukeException();
        }
        int separatePosition = command.indexOf('/');
        String description = command.substring(SKIP_EVENT_NUMBER, separatePosition-1);
        String atTime = command.substring(separatePosition+SKIP_SEPARATION_NUMBER);
        list[number] = new Event(description, atTime);
        number = Duke.add(list[number], number);
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
