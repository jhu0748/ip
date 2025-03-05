import java.util.Scanner;

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
//    public static void main(String[] args) {
//        TaskList taskList = new TaskList();
//        System.out.println("\t Hello! I'm Nova.\n\t What can I do for you?");
//
//        Scanner scanner = new Scanner(System.in);
//
//        while(true) {
//            try {
//                String input = scanner.nextLine();
//                if (input.equals("bye")) {
//                    Ui.printSeparatorLine();
//                    System.out.println("\t Bye. Hope to see you again soon!");
//                    Ui.printSeparatorLine();
//                    break;
//                } else if (input.equals("list")) {
//                    taskList.listTasks();
//                } else if (input.startsWith("todo ")) {
//                    String description = input.substring(5);
//                    taskList.addTask(new Todo(description));
//                } else if (input.startsWith("deadline ")) {
//                    try {
//                        String[] parts = input.substring(9).split(" /by ");
//                        if (parts.length < 2) {
//                            throw new NovaException("OOPS!!! A deadline must have a description and a /by time.");
//                        }
//                        taskList.addTask(new Deadline(parts[0], parts[1]));
//                    } catch (NovaException e) {
//                        Ui.printSeparatorLine();
//                        System.out.println("\t " + e.getMessage());
//                        Ui.printSeparatorLine();
//                    }
//                } else if (input.startsWith("event")) {
//                    try {
//                        String[] parts = input.substring(6).split(" /from | /to ");
//                        if (parts.length < 3) {
//                            throw new NovaException("OOPS!! An event must have a description, /from, and /to times.");
//                        }
//                        taskList.addTask(new Event(parts[0], parts[1], parts[2]));
//                    } catch (NovaException e) {
//                        Ui.printSeparatorLine();
//                        System.out.println("\t " + e.getMessage());
//                        Ui.printSeparatorLine();
//                    }
//                } else if (input.startsWith("mark")) {
//                    int taskIndexMark = Integer.parseInt(input.substring(5)) - 1;
//                    taskList.markTaskDone(taskIndexMark);
//                } else if (input.startsWith("unmark")) {
//                    int taskIndexUnmark = Integer.parseInt(input.substring(7)) - 1;
//                    taskList.unmarkTaskDone(taskIndexUnmark);
//                } else if (input.startsWith("delete")) {
//                    int taskIndexDelete = Integer.parseInt(input.substring(7)) - 1;
//                    taskList.deleteTask(taskIndexDelete);
//                } else {
//                    Ui.printSeparatorLine();
//                    System.out.println("\t OOPS!! I apologize but that is an unrecognized command, please try again.");
//                    Ui.printSeparatorLine();
//                }
//            } catch(NovaException e) {
//                Ui.printSeparatorLine();
//                System.out.println("\t " + e.getMessage());
//                Ui.printSeparatorLine();
//            } catch (NumberFormatException e) {
//                Ui.printSeparatorLine();
//                System.out.println("\t OOPS!!! Please provide a valid number for mark, unmark, or delete commands.");
//                Ui.printSeparatorLine();
//            }
//        }
//        scanner.close();
//    }
//
//}