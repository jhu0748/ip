/**
 * The main class for the Nova chatbot app.
 * This class initializes the user interface to interact with the user, storage system, and task list.
 * It handles loading and storing tasks as well as running the chatbot.
 */
public class Nova {

    private final Storage storage;
    private TaskList tasks;
    private final Ui ui;

    public Nova(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);

        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (NovaException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }
    public void run() {
        Parser parser = new Parser(tasks, ui, storage);
        parser.processCommands();
    }

    public static void main(String[] args) {
        new Nova("./data/nova.txt").run();
    }

}