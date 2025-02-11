import java.util.Scanner;

public class Nova {
    public static void main(String[] args) {
        String logo = "Nova";
        printSeparatorLine();
        System.out.println("\t Hello! I'm " + logo);
        System.out.println("\t What can I do for you?");
        printSeparatorLine();
        Scanner scanner = new Scanner(System.in);
        String[] taskList = new String[100];
        int numTasks = 0;
        String input;

        input_logic:
        while(true) {
            input = scanner.nextLine();
            String[] inputSplit = input.split(" ",2);
            String action = inputSplit[0];
            switch (action) {
            case "bye":  // exit
                printSeparatorLine();
                System.out.println("\t Bye. Hope to see you again soon!");
                printSeparatorLine();
                break input_logic;
            case "list":  // display task list
                printSeparatorLine();
                for (int i = 0; i < numTasks; i++) {
                    System.out.println("     " + (i + 1) + ". " + taskList[i]);
                }
                printSeparatorLine();
                break;
            case "mark": { // mark task as done
                int taskNum = Integer.parseInt(inputSplit[1]) - 1; // idx val in task array to be marked done

                printSeparatorLine();
                if (taskNum >= 0 && taskNum < numTasks) {
                    System.out.println("\t Nice! I've marked this task as done:");
                    System.out.println("\t [X] " + taskList[taskNum]);
                } else {
                    System.out.println("\t Invalid task number.");
                }
                printSeparatorLine();
                break;
            }
            case "unmark": { // unmark task
                int taskNum = Integer.parseInt(inputSplit[1]) - 1;
                printSeparatorLine();
                if (taskNum >= 0 && taskNum < numTasks) {
                    System.out.println("\t Ok, I've marked this task as not done yet:");
                    System.out.println("\t [ ] " + taskList[taskNum]);
                } else {
                    System.out.println("\t Invalid task number.");
                }
                printSeparatorLine();
                break;
            }
            default:
                taskList[numTasks] = input;
                numTasks++;
                printSeparatorLine();
                System.out.println("\t added: " + input);
                printSeparatorLine();
                break;
            }
        }

        scanner.close();
    }

    // helper method to print lines separating user input and command output
    private static void printSeparatorLine() {
        System.out.println("\t  ____________________________________________________________");
    }

}