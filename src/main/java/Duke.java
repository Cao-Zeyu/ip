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
        String[] list = new String[100];
        int number = 0;

        while (!command.equals("bye")) {
            if (command.equals("list")) {
                Duke.displayList(list, number);
            } else {
                Duke.add(list, command, number);
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

    public static void displayList(String[] list, int number) {
        Duke.printLine();
        for(int i=1; i<=number; i++) {
            System.out.println("\t" + i + ". " + list[i-1]);
        }
        Duke.printLine();
    }

    public static void add(String[] list, String text, int number) {
        list[number] = text;
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
