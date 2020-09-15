import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class FileSaver {
    public static final String filePath = "data/duke.txt";
    public static int dataNumber = 0;

    public static int loadData(Task[] list) throws FileNotFoundException {
        File dataFile = new File(filePath);
        Scanner dataScanner = new Scanner(dataFile);
        while(dataScanner.hasNext()) {
            String data = dataScanner.nextLine();
            String type = data.substring(0,1);
            boolean isDone = data.charAt(4) == '1';
            String content = data.substring(8);
            String description = content;
            String byTime;
            String atTime;
            int separateIndex = content.length()-1;
            if (content.contains("|")) {
                separateIndex = content.indexOf("|");
                description = content.substring(0,separateIndex-1);
            }
            switch(type) {
            case "T":
                fileAddTodo(list, description, isDone);
                break;
            case "D" :
                byTime = content.substring(separateIndex+2);
                fileAddDeadline(list, description, byTime, isDone);
                break;
            case "E":
                atTime = content.substring(separateIndex+2);
                fileAddEvent(list, description, atTime, isDone);
                break;
            default:
                break;
            }
            dataNumber++;
        }
        return dataNumber;
    }

    public static void saveData(Task[] list, int number) throws IOException {
        FileWriter dataWriter = new FileWriter(filePath);
        for (int i = 0; i < number; i++) {
            dataWriter.write(list[i].toDataString() + "\n");
        }
        dataWriter.close();
    }

    public static void fileAddTodo(Task[] list, String description, boolean isDone) {
        list[dataNumber] = new ToDo(description);
        list[dataNumber].setDone(isDone);
    }

    public static void fileAddDeadline(Task[] list, String description, String byTime, boolean isDone) {
        list[dataNumber] = new Deadline(description, byTime);
        list[dataNumber].setDone(isDone);
    }

    public static void fileAddEvent(Task[] list, String description, String atTime, boolean isDone) {
        list[dataNumber] = new Event(description, atTime);
        list[dataNumber].setDone(isDone);
    }
}
