import java.io.IOException;
import java.util.Scanner;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructs a Duke object containing tasks stored at a certain address.
     *
     * @param filePath the address of the file containing a list of tasks
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadData());
        } catch (IOException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Runs the Duke program.
     *
     * @throws IOException the exception that occurs when encountered with problems in writing to
     * or reading from a file
     */
    public void run() throws IOException {
        start();
        runUntilExit();
        exit();
    }

    /**
     * Starts the program by printing greeting lines.
     */
    private void start() {
        ui.printGreetings();
    }

    /**
     * Keeps looping the program to receive commands from user until the user inputs to exit the program.
     *
     * @throws IOException the exception that occurs when encountered with problems in writing to
     * or reading from a file
     */
    private void runUntilExit() throws IOException {
        Scanner in = new Scanner(System.in);
        String commandText;

        do {
            commandText = in.nextLine();
            try {
                Parser.parseCommand(commandText);
            } catch (DukeException e) {
                ui.printInvalidInputMessage(commandText);
            }
        } while (!commandText.equals("bye"));

        storage.saveData(tasks);
    }

    /**
     * Exits the program by printing goodbye message.
     */
    private void exit() {
        ui.printGoodbye();
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        new Duke("duke.txt").run();
    }
}