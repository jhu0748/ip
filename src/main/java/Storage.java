import java.io.*;
import java.util.ArrayList;

/**
 * Handles loading and saving of tasks to and from a file.
 * Tasks are stored in a file specified by provided file path.
 * Class provides functionality to load tasks from a file on startup and save current task list to the file
 */
public class Storage {
    private final String FILE_PATH;
    private final ArrayList<Task> tasks;

    /**
     * Initializes new Storage object with specified file path.
     *
     * @param filePath Path to file where list of tasks will be stored.
     */
    public Storage(String filePath) {
        this.FILE_PATH = filePath;
        this.tasks = new ArrayList<>();
    }

    /**
     * Loads tasks from file specified by FILE_PATH.
     * If file does not exist, new task list is returned.
     *
     * @return an ArrayList of tasks loaded from the file.
     * @throws NovaException if there is an error during task parsing.
     */
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

    /**
     * Saves provided list of tasks to file specified by FILE_PATH.
     * Creates directory if it does not exist.
     *
     * @param tasks List of tasks to save to file.
     */
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

    /**
     * Parses line of text from saved file into a Task object.
     * Line must be formatted correctly for type of task it represents.
     *
     * @param line The line of text representing a task.
     * @return Task object corresponding to parsed data.
     * @throws NovaException If line format is invalid or an unknown task type is encountered.
     */
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
