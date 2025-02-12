import java.util.Scanner;

public class Nova {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        System.out.println("\t Hello! I'm Nova.\n\t What can I do for you?");
        
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                String input = scanner.nextLine();
                if (input.equals("bye")) {
                    Ui.printSeparatorLine();
                    System.out.println("\t Bye. Hope to see you again soon!");
                    Ui.printSeparatorLine();
                    break;
                } else if (input.equals("list")) {
                    taskList.listTasks();
                } else if (input.startsWith("todo")) {
                    String description = input.substring(4);
                    taskList.addTask(new Todo(description));
                } else if (input.startsWith("deadline")) {
                    try {
                        String[] parts = input.substring(8).split(" /by ");
                        if (parts.length < 2) {
                            throw new NovaException("OOPS!!! A deadline must have a description and a /by time.");
                        }
                        taskList.addTask(new Deadline(parts[0], parts[1]));
                    } catch (NovaException e) {
                        Ui.printSeparatorLine();
                        System.out.println("\t " + e.getMessage());
                        Ui.printSeparatorLine();
                    }
                } else if (input.startsWith("event")) {
                    try {
                        String[] parts = input.substring(5).split(" /from | /to ");
                        if (parts.length < 3) {
                            throw new NovaException("OOPS!! An event must have a description, /from, and /to times.");
                        }
                        taskList.addTask(new Event(parts[0], parts[1], parts[2]));
                    } catch (NovaException e) {
                        Ui.printSeparatorLine();
                        System.out.println("\t " + e.getMessage());
                        Ui.printSeparatorLine();
                    }
                } else if (input.startsWith("mark")) {
                    int taskIndexMark = Integer.parseInt(input.substring(5)) - 1;
                    taskList.markTaskDone(taskIndexMark);
                } else if (input.startsWith("unmark")) {
                    int taskIndexUnmark = Integer.parseInt((input.substring(7))) - 1;
                    taskList.unmarkTaskDone(taskIndexUnmark);
                } else {
                    Ui.printSeparatorLine();
                    System.out.println("\t OOPS!! I apologize but that is an unrecognized command, please try again.");
                    Ui.printSeparatorLine();
                }
            } catch(NovaException e) {
                Ui.printSeparatorLine();
                System.out.println("\t " + e.getMessage());
                Ui.printSeparatorLine();
            } catch (NumberFormatException e) {
                Ui.printSeparatorLine();
                System.out.println("\t OOPS!!! Please provide a valid number for mark or unmark commands.");
                Ui.printSeparatorLine();
            }
        }
        scanner.close();
    }

}