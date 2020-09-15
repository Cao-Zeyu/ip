import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class FileSaver {
    public static final String filePath = "duke.txt";

    public static void loadData(ArrayList<Task> list) throws IOException {
        File dataFile = new File(filePath);
        if(dataFile.createNewFile()) {
            Duke.printLine();
            System.out.println("\tSince the file does not exist, I have created a file for you.");
            Duke.printLine();
        }
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
        }
    }

    public static void saveData(ArrayList<Task> list) throws IOException {
        FileWriter dataWriter = new FileWriter(filePath);
        for (int i = 0; i < list.size(); i++) {
            dataWriter.write(list.get(i).toDataString() + "\n");
        }
        dataWriter.close();
    }

    public static void fileAddTodo(ArrayList<Task> list, String description, boolean isDone) {
        list.add(new ToDo(description));
        list.get(list.size()-1).setDone(isDone);
    }

    public static void fileAddDeadline(ArrayList<Task> list, String description, String byTime, boolean isDone) {
        list.add(new Deadline(description, byTime));
        list.get(list.size()-1).setDone(isDone);
    }

    public static void fileAddEvent(ArrayList<Task> list, String description, String atTime, boolean isDone) {
        list.add(new Event(description, atTime));
        list.get(list.size()-1).setDone(isDone);
    }
}
