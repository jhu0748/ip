import java.io.*;
import java.util.ArrayList;

public class Storage {
    private final String FILE_PATH;
    private final ArrayList<Task> tasks;

    public Storage(String filePath) {
        this.FILE_PATH = filePath;
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> loadTasks() throws NovaException{
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("\t No saved tasks found. Starting fresh...");
            return tasks;
        }

        System.out.println("\t Loading in saved tasks...");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Task task = parseTask(line);
                    if (task != null) {
                        tasks.add(task);
                    }
                } catch (Exception e) {
                    System.out.println("Skipping corrupted line: " + line + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        return tasks;
    }

    public void saveTasks(ArrayList<Task> tasks) {
        File dir = new File("./data");
        if (!dir.exists()) {
            dir.mkdir(); // Create the directory if it doesn't exist
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Task task : tasks) {
                writer.write(task.getSaveData());
                // System.out.println(task.getSaveData());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private Task parseTask(String line) throws NovaException {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) {
            throw new NovaException("Invalid task format.");
        }
        String type = parts[0];
        String done = parts[1];
        String description = parts[2];
        boolean isDone = done.equals("1");
        Task task;

        switch (type) {
        case "T":
            task = new Todo(description);
            break;
        case "D":
            if (parts.length < 4) {
                throw new NovaException("Invalid Deadline format.");
            }
            task = new Deadline(description, parts[3]);
            break;

        case "E":
            if (parts.length < 4) {
                throw new NovaException("Invalid Event format.");
            }
            String[] fromTo = parts[3].split("-", 2);
            task = new Event(description, fromTo[0], fromTo[1]);
            break;

        default:
            throw new NovaException("Unknown task type.");
        }

        if(isDone) {
            task.markAsDone();
        }
        return task;
    }
}
