import java.util.Scanner;

/**
 * The Parser class processes user inputs/commands and updates the task list and storage file accordingly.
 * It handles commands like "list", "todo", "deadline", "mark", etc.
 * It allows users to manipulate and track their tasks.
 */
public class Parser {
    private final TaskList tasks;
    private final Ui ui;
    private final Scanner scanner;
    private final Storage storage;

    /**
     * Constructs a Parser object given specified TaskList, Ui, and Storage objects.
     *
     * @param tasks TaskList object holding all tasks
     * @param ui Ui object for displaying messages to the user
     * @param storage Storage object for saving and loading tasks
     */
    public Parser(TaskList tasks, Ui ui, Storage storage) {
        this.tasks = tasks;
        this.ui = ui;
        this.scanner = new Scanner(System.in);
        this.storage = storage;
    }

    /**
     * Continuously processes user commands until user exits by inputting "bye".
     * Handles several commands like "list", "todo", "deadline", "event", "mark", "unmark", etc.
     * Commands can modify the task list and it will save the updates to the file where it is being stored.
     */
    public void processCommands() {
        ui.showWelcome();
        while(true) {
            try {
                String input = scanner.nextLine();
                if (input.equals("bye")) {
                    ui.showGoodbye();
                    break;
                } else if (input.equals("list")) {
                    tasks.listTasks();
                } else if (input.startsWith("todo ")) {
                    String description = input.substring(5);
                    tasks.addTask(new Todo(description));
                    storage.saveTasks(tasks.getTasks());
                } else if (input.startsWith("deadline ")) {
                    try {
                        String[] parts = input.substring(9).split(" /by ");
                        if (parts.length < 2) {
                            throw new NovaException("OOPS!!! A deadline must have a description and a /by time.");
                        }
                        tasks.addTask(new Deadline(parts[0], parts[1]));
                        storage.saveTasks(tasks.getTasks());
                    } catch (NovaException e) {
                        ui.showError(e.getMessage());
                    }
                } else if (input.startsWith("event ")) {
                    try {
                        String[] parts = input.substring(6).split(" /from | /to ");
                        if (parts.length < 3) {
                            throw new NovaException("OOPS!! An event must have a description, /from, and /to times.");
                        }
                        tasks.addTask(new Event(parts[0], parts[1], parts[2]));
                        storage.saveTasks(tasks.getTasks());
                    } catch (NovaException e){
                        ui.showError(e.getMessage());
                    }
                } else if (input.startsWith("mark ")) {
                    int index = Integer.parseInt(input.substring(5)) - 1;
                    tasks.markTaskDone(index);
                    storage.saveTasks(tasks.getTasks());
                } else if (input.startsWith("unmark ")) {
                    int index = Integer.parseInt(input.substring(7)) - 1;
                    tasks.unmarkTaskDone(index);
                    storage.saveTasks(tasks.getTasks());
                } else if (input.startsWith("delete ")) {
                    int index = Integer.parseInt(input.substring(7)) - 1;
                    tasks.deleteTask(index);
                    storage.saveTasks(tasks.getTasks());
                } else {
                    ui.showError("OOPS!! I apologize but that is an unrecognized command, please try again.");
                }
            } catch (NumberFormatException e) {
                ui.showError("OOPS!! Please provide a valid number for mark, unmark, or delete commands.");
            } catch (NovaException e) {
                ui.showError(e.getMessage());
            }
        }
        scanner.close();
    }
}