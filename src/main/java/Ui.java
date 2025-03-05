import java.util.ArrayList;

public class Ui {
    // helper method to print lines separating user input and command output
    public static void printSeparatorLine() {
        System.out.println("\t____________________________________________________________");
    }

    public void showWelcome() {
        System.out.println("\t Hello! I'm Nova.\n\t What can I do for you?");
    }

    public void showLoadingError() {
        System.out.println("\t OOPS!!! Error loading tasks from file.");
    }

    public void showError(String message) {
        printSeparatorLine();
        System.out.println("\t " + message);
        printSeparatorLine();
    }

    public void showGoodbye() {
        printSeparatorLine();
        System.out.println("\t Bye. Hope to see you again soon!");
        printSeparatorLine();
    }

    public static void showFindResults(ArrayList<Task> matchingTasks, String keyword) {
        printSeparatorLine();
        if(matchingTasks.isEmpty()) {
            System.out.println("\t Sorry. No task descriptions matched the keyword given.");
        } else {
            System.out.println("\t Here are the matching tasks based on the keyword \"" + keyword + "\" you gave:");
            for(int i = 0; i < matchingTasks.size(); i++) {
                System.out.println("\t " + (i + 1) + "." + matchingTasks.get(i));
            }
        }
        printSeparatorLine();
    }
}
