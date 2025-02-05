import java.util.Scanner;

public class Nova {
    public static void main(String[] args) {
        String logo = "Nova";
        printLine();
        System.out.println("     Hello! I'm " + logo);
        System.out.println("     What can I do for you?");
        printLine();
        Scanner scanner = new Scanner(System.in);
        String[] tasks = new String[100];
        int numTasks = 0;
        String input;

        input_logic:
        while(true) {
            input = scanner.nextLine();
            String[] inputSplit = input.split(" ",2);
            String action = inputSplit[0];
            switch (action) {
            case "bye":  // exit
                printLine();
                System.out.println("     Bye. Hope to see you again soon!");
                printLine();
                break input_logic;
            case "list":  // display task list
                printLine();
                for (int i = 0; i < numTasks; i++) {
                    System.out.println("     " + (i + 1) + ". " + tasks[i]);
                }
                printLine();
                break;
            case "mark": { // mark task as done
                int taskNum = Integer.parseInt(inputSplit[1]) - 1; // idx val in task array to be marked done

                if (taskNum >= 0 && taskNum < numTasks) {
                    printLine();
                    System.out.println("     Nice! I've marked this task as done:");
                    System.out.println("       [X] " + tasks[taskNum]);
                    printLine();
                } else {
                    printLine();
                    System.out.println("     Invalid task number.");
                    printLine();
                }
                break;
            }
            case "unmark": { // unmark task
                int taskNum = Integer.parseInt(inputSplit[1]) - 1;
                if (taskNum >= 0 && taskNum < numTasks) {
                    printLine();
                    System.out.println("     Ok, I've marked this task as not done yet:");
                    System.out.println("       [ ] " + tasks[taskNum]);
                    printLine();
                } else {
                    printLine();
                    System.out.println("     Invalid task number.");
                    printLine();
                }
                break;
            }
            default:
                tasks[numTasks] = input;
                numTasks++;
                printLine();
                System.out.println("     added: " + input);
                printLine();
                break;
            }
        }

        scanner.close();
    }

    // helper method to print lines separating user input and command output
    private static void printLine() {
        System.out.println("    ____________________________________________________________");
    }

}