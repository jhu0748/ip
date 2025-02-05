import java.util.Scanner;

public class Nova {
    public static void main(String[] args) {
        String logo = "Nova";
        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm " + logo);
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] tasks = new String[100];
        int numTasks = 0;

        label:
        while(true) {
            input = scanner.nextLine();
            String[] inputSplit = input.split(" ",2);
            String action = inputSplit[0];
            switch (action) {
            case "bye":  // exit
                System.out.println("    ____________________________________________________________");
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
                break label;
            case "list":  // display task list
                System.out.println("    ____________________________________________________________");
                for (int i = 0; i < numTasks; i++) {
                    System.out.println("     " + (i + 1) + ". " + tasks[i]);
                }
                System.out.println("    ____________________________________________________________");
                break;
            case "mark": { // mark task as done
                int taskNum = Integer.parseInt(inputSplit[1]) - 1; // idx val in task array to be marked done

                if (taskNum >= 0 && taskNum < numTasks) {
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Nice! I've marked this task as done:");
                    System.out.println("       [X] " + tasks[taskNum]);
                    System.out.println("    ____________________________________________________________");
                } else {
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Invalid task number.");
                    System.out.println("    ____________________________________________________________");
                }
                break;
            }
            case "unmark": { // unmark task
                int taskNum = Integer.parseInt(inputSplit[1]) - 1;
                if (taskNum >= 0 && taskNum < numTasks) {
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Ok, I've marked this task as not done yet:");
                    System.out.println("       [ ] " + tasks[taskNum]);
                    System.out.println("    ____________________________________________________________");
                } else {
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Invalid task number.");
                    System.out.println("    ____________________________________________________________");
                }
                break;
            }
            default:
                tasks[numTasks] = input;
                numTasks++;
                System.out.println("    ____________________________________________________________");
                System.out.println("     added: " + input);
                System.out.println("    ____________________________________________________________");
                break;
            }
        }

        scanner.close();
    }

}