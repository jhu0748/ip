import java.util.ArrayList;
import java.io.*;

public class TaskList {
    private static ArrayList<Task> taskArrayList;
    private static final String FILE_PATH = "./data/nova.txt";

    public TaskList() {
        taskArrayList = new ArrayList<>();
        loadTasks();
    }


    // add task to tasklist
    public void addTask(Task task) throws NovaException {
        taskArrayList.add(task);
        Ui.printSeparatorLine();
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t  " + task);
        System.out.println("\t Now you have " + taskArrayList.size() + " tasks in the list.");
        Ui.printSeparatorLine();
        saveTasks();
    }
    // mark task as done [X]
    public void markTaskDone(int taskNum) {
        taskArrayList.get(taskNum).markAsDone();
        Ui.printSeparatorLine();
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t   " + taskArrayList.get(taskNum));
        Ui.printSeparatorLine();
        saveTasks();
    }
    // mark as not done [ ]
    public void unmarkTaskDone(int taskNum) {
        taskArrayList.get(taskNum).unmarkAsDone();
        Ui.printSeparatorLine();
        System.out.println("\t Ok! I've marked this task as not done yet:");
        System.out.println("\t   " + taskArrayList.get(taskNum));
        Ui.printSeparatorLine();
    }
    // delete task from arraylist
    public void deleteTask(int taskNum) {
        Ui.printSeparatorLine();
        System.out.println("\t Noted I've removed this task:");
        System.out.println("\t   " + taskArrayList.get(taskNum));
        System.out.println("\t Now you have " + taskArrayList.size() + " tasks in the list.");
        Ui.printSeparatorLine();
        taskArrayList.remove(taskNum);
    }
    // print out tasklist if there is at least 1 task in the list
    public void listTasks() {
        Ui.printSeparatorLine();

        if(taskArrayList.isEmpty()) {
            System.out.println("\t Sorry! No tasks were recorded. Try adding to the task list.");
        } else {
            System.out.println("\t Here are the tasks in your list:");
            for (int i = 0; i < taskArrayList.size(); i++) {
                System.out.println("\t " + (i + 1) + "." + taskArrayList.get(i));
            }
        }
        Ui.printSeparatorLine();
    }
    // save the tasks in the file
    private void saveTasks() {
        // Ensure the directory exists
        File dir = new File("./data");
        if (!dir.exists()) {
            dir.mkdir(); // Create the directory if it doesn't exist
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Task task : taskArrayList) {
                writer.write(task.getSaveData());
                // System.out.println(task.getSaveData());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // load tasks from file
    private void loadTasks() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("\t No saved tasks found. Starting fresh...");
            return;
        }
        System.out.println("\t Loading in saved tasks...");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Task task = parseTask(line);
                    if (task != null) {
                        taskArrayList.add(task);
                    }
                } catch (Exception e) {
                    System.out.println("Skipping corrupted line: " + line + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    // parse a task from the line
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
