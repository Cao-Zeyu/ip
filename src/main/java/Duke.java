import java.io.IOException;
import java.util.Scanner;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

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

    public void run() throws DukeException, IOException {
        start();
        runUntilExit();
        exit();
    }

    private void start() {
        ui.printGreetings();
    }

    private void runUntilExit() throws DukeException, IOException {
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

        Storage.saveData(tasks);
    }

    private void exit() {
        ui.printGoodbye();
        System.exit(0);
    }

    public static void main(String[] args) throws DukeException, IOException {
        new Duke("duke.txt").run();
    }
}