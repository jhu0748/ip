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

        while(true) {
            input = scanner.nextLine();
            if(input.equals("bye")) { // exit
                System.out.println("    ____________________________________________________________");
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
                break;
            } else if(input.equals("list")) { // display task list
                System.out.println("    ____________________________________________________________");
                for (int i = 0; i < numTasks; i++) {
                    System.out.println("     " + (i + 1) + ". " + tasks[i]);
                }
                System.out.println("    ____________________________________________________________");
            } else {
                tasks[numTasks] = input;
                numTasks++;
                System.out.println("    ____________________________________________________________");
                System.out.println("     added: " + input);
                System.out.println("    ____________________________________________________________");
            }
        }

        scanner.close();
    }
}