public class Parser {

    public static void parseCommand(String userInput) throws DukeException {
        int lengthOfCommandKeyWord = 0;
        String commandKeyWord;
        if (userInput.equals("list") || userInput.equals("bye") ) {
            commandKeyWord = userInput;
        } else if (!userInput.contains(" ")) { //if the user input is not "list" or "bye", but there is no further message
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
        int byTimePosition = commandMessage.indexOf("/")+4;
        String description = commandMessage.substring(0, byTimePosition-5);
        String byTime = commandMessage.substring(byTimePosition);
        TaskList.addDeadline(description, byTime);
    }

    private static void parseEventCommand(String commandMessage) {
        int atTimePosition = commandMessage.indexOf("/")+4;
        String description = commandMessage.substring(0, atTimePosition-5);
        String atTime = commandMessage.substring(atTimePosition);
        TaskList.addEvent(description, atTime);
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
