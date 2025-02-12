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
                    String[] parts = input.substring(8).split(" /by ");
                    taskList.addTask(new Deadline(parts[0], parts[1]));
                } else if (input.startsWith("event")) {
                    String[] parts = input.substring(5).split(" /from | /to ");
                    taskList.addTask(new Event(parts[0], parts[1], parts[2]));
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
            } catch(IllegalArgumentException e) {
                Ui.printSeparatorLine();
                System.out.println("\t " + e.getMessage());
                Ui.printSeparatorLine();
            }
        }
        scanner.close();
    }

}