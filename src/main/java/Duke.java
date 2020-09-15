import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static final int SKIP_DEADLINE_NUMBER = 9;
    public static final int SKIP_EVENT_NUMBER = 6;
    public static final int SKIP_DONE_NUMBER = 5;
    public static final int SKIP_SEPARATION_NUMBER = 4;

    //public static Task[] list = new Task[100];
    public static ArrayList<Task> list = new ArrayList<>();
    //public static int number = 0;

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
                    Duke.displayList(list);
                } else if (command.startsWith("done")) {
                    Duke.done(list, command);
                } else if (command.startsWith("delete")) {
                    Duke.delete(command);
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

    public static void displayList(ArrayList<Task> list) {
        Duke.printLine();
        System.out.println("\tHere are the tasks in your list:");
//        for(int i=1; i<=number; i++) {
//            System.out.println("\t" + i + ". " + list[i-1].toString());
//        }
//        int i = 1;
//        for(Task task : list) {
//            System.out.println("\t" + (i++) +". " + task.toString());
//        }
        for(int i=1; i<=list.size(); i++) {
            System.out.println("\t" + i + ". " + list.get(i-1).toString());
        }
        Duke.printLine();
    }

    public static void printAdd(Task task) {
        Duke.printLine();
        System.out.println("\tGot it. I've added this task: ");
        System.out.println("\t   " + task.toString());
        System.out.println("\tNow you have " + (list.size()) + " tasks in the list. ");
        Duke.printLine();
    }

    public static void addTodo (String command) throws DukeException {
        if(command.equals("todo")) {
            throw new DukeException();
        }
//        list[number] = new ToDo(command.substring(5));
//        number = Duke.add(list[number], number);

        list.add(new ToDo(command.substring(5)));
        Duke.printAdd(list.get(list.size()-1));
    }

    public static void addDeadline(String command) throws DukeException{
        if(command.equals("deadline")) {
            throw new DukeException();
        }
        int separatePosition = command.indexOf('/');
        String description = command.substring(SKIP_DEADLINE_NUMBER, separatePosition-1);
        String byTime = command.substring(separatePosition+SKIP_SEPARATION_NUMBER);
//        list[number] = new Deadline(description, byTime);
//        number = Duke.add(list[number], number);

        list.add(new Deadline(description, byTime));
        //number = Duke.add(list.get(number), number);//need to check code quality later
        Duke.printAdd(list.get(list.size()-1));
    }

    public static void addEvent(String command) throws DukeException{
        if(command.equals("event")) {
            throw new DukeException();
        }
        int separatePosition = command.indexOf('/');
        String description = command.substring(SKIP_EVENT_NUMBER, separatePosition-1);
        String atTime = command.substring(separatePosition+SKIP_SEPARATION_NUMBER);
//        list[number] = new Event(description, atTime);
//        number = Duke.add(list[number], number);

        list.add(new Event(description, atTime));
        //number = Duke.add(list.get(number), number);
        Duke.printAdd(list.get(list.size()-1));
    }


    public static void done(ArrayList<Task> list, String command) {
        int doneNumber = Integer.parseInt(command.substring(SKIP_DONE_NUMBER));
//        list[doneNumber-1].setDone(true);
        Task doneTask = list.get(doneNumber-1);
        doneTask.setDone(true);
        list.set(doneNumber-1, doneTask);
        Duke.printLine();
        System.out.println("\tNice! I've marked this task as done: ");
        System.out.println("\t   " + doneTask.toString());
        Duke.printLine();
    }

    public static void delete(String command) {
        int deleteIndex = Integer.parseInt(command.substring(7));
        Task deletedTask = list.get(deleteIndex-1);
        Duke.printLine();
        System.out.println("\tNoted. I've removed this task: ");
        System.out.println("\t   " + deletedTask.toString());
        list.remove(deleteIndex-1);
        System.out.println("\tNow you have " + list.size() + " tasks in the list.");
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
