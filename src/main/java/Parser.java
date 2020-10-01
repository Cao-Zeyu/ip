import java.time.LocalDate;
import java.time.LocalTime;

public class Parser {

    /**
     * Parses the input command into a format that can be recognized by the program.
     * Except "help", "list" and "bye" commands, all other commands must be followed by further information.
     * If there is no followings, or the input is not a command for this program, it will throw a DukeException.
     *
     * @param userInput the string that user inputs as command
     * @throws DukeException an exception that occurs when an invalid command is input
     */
    public static void parseCommand(String userInput) throws DukeException {
        int lengthOfCommandKeyWord = 0;
        String commandKeyWord;
        if (userInput.equals("help") || userInput.equals("list") || userInput.equals("bye") ) {
            commandKeyWord = userInput;
        } else if (!userInput.contains(" ")) {
            throw new DukeException();
        } else {
            lengthOfCommandKeyWord = userInput.indexOf(' ');
            commandKeyWord = userInput.substring(0, lengthOfCommandKeyWord);
        }
        String commandMessage = userInput.substring(lengthOfCommandKeyWord+1);
        switch (commandKeyWord) {
        case "todo":
            parseTodoCommand(commandMessage);
            break;
        case "deadline":
            parseDeadlineCommand(commandMessage);
            break;
        case "event":
            parseEventCommand(commandMessage);
            break;
        case "help":
            parseHelpCommand();
            break;
        case "list":
            parseListCommand();
            break;
        case "done":
            parseDoneCommand(commandMessage);
            break;
        case "delete":
            parseDeleteCommand(commandMessage);
            break;
        case "find":
            parseFindCommand(commandMessage);
            break;
        default:
            break;
        }
    }

    private static void parseTodoCommand(String description) {
        TaskList.addTodo(description);
    }

    private static void parseDeadlineCommand(String commandMessage) {
        int byDatePosition = commandMessage.indexOf("/")+4;
        int byTimePosition = commandMessage.indexOf(" ", byDatePosition)+1;
        String description = commandMessage.substring(0, byDatePosition-5);
        LocalDate byDate = LocalDate.parse(commandMessage.substring(byDatePosition, byTimePosition-1));
        LocalTime byTime = LocalTime.parse(commandMessage.substring(byTimePosition));
        TaskList.addDeadline(description, byDate, byTime);
    }

    private static void parseEventCommand(String commandMessage) {
        int atDatePosition = commandMessage.indexOf("/")+4;
        int atTimePosition = commandMessage.indexOf(" ", atDatePosition)+1;
        String description = commandMessage.substring(0, atDatePosition-5);
        LocalDate atDate = LocalDate.parse(commandMessage.substring(atDatePosition, atTimePosition-1));
        LocalTime atTime = LocalTime.parse(commandMessage.substring(atTimePosition));
        TaskList.addEvent(description, atDate, atTime);
    }

    private  static void parseHelpCommand() {
        Ui.printHelp();
    }

    private static void parseListCommand() {
        TaskList.getWholeList();
    }

    private static void parseDoneCommand(String commandMessage) {
        int doneIndex = Integer.parseInt(commandMessage);
        TaskList.setDone(doneIndex);
    }

    private static void parseDeleteCommand(String commandMessage) {
        int deletedIndex = Integer.parseInt(commandMessage);
        TaskList.delete(deletedIndex);
    }

    private static void parseFindCommand(String commandMessage) {
        TaskList.getMatchingTask(commandMessage);
    }
}
