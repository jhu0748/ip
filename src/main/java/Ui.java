import java.util.ArrayList;
/**
 * Ui class is responsible for displaying messages to the user and guides the interaction.
 * It handles showing welcome messages, errors, and a goodbye message.
 * Also provides helper methods for formatting output.
 */
public class Ui {
    /**
     * Helper method to print a separator line, used to separate user input and command output.
     */
    public void printSeparatorLine() {
        System.out.println("\t____________________________________________________________");
    }

    /**
     * Method to print output after adding a task to the list
     * Prints task description and other details depending on type of task
     * Also prints how many tasks are now in the list
     *
     * @param task task that was added and its details
     * @param numTasks number of tasks now in the list
     */
    public void printAddTaskOutput(Task task, int numTasks) {
        printSeparatorLine();
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t  " + task);
        System.out.println("\t Now you have " + numTasks + " tasks in the list.");
        printSeparatorLine();
    }

    /**
     * Method to print output after deleting a task from the list
     * Prints the deleted task's description and other details depending on the task type
     * Prints how many tasks are remaining in the list
     *
     * @param task task that was deleted and its details
     * @param numTasks number of tasks remaining in the list
     */
    public void printDeleteTaskOutput(Task task, int numTasks) {
        printSeparatorLine();
        System.out.println("\t Noted. I've removed this task:");
        System.out.println("\t   " + task);
        System.out.println("\t Now you have " + numTasks + " tasks in the list.");
        printSeparatorLine();
    }

    /**
     * Method to print output after marking or unmarking a task as done based on user's command
     *
     * @param tasks ArrayList containing all tasks that have been added by user
     * @param taskNum Index of task to be marked or unmarked as done
     * @param isDone If true, then command was to mark as done. If false, the command was to unmark as done.
     */
    public void printMarkingOutput(ArrayList<Task> tasks, int taskNum, boolean isDone) {
        printSeparatorLine();
        if(isDone) { // command was to mark a task done
            System.out.println("\t Nice! I've marked this task as done:");
        } else { // command was to unmark a task done
            System.out.println("\t Ok! I've marked this task as not done yet:");
        }
        System.out.println("\t   " + tasks.get(taskNum));
        printSeparatorLine();
    }

    /**
     * Displays the tasks whose descriptions contained the keyword given by the user.
     *
     * @param matchingTasks ArrayList containing tasks whose descriptions matched keyword
     * @param keyword String keyword input by user
     */
    public void showFindResults(ArrayList<Task> matchingTasks, String keyword) {
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

    /**
     * Displays a welcome message when the program starts.
     */
    public void showWelcome() {
        System.out.println("\t Hello! I'm Nova.\n\t What can I do for you?");
    }

    /**
     * Displays error message when issue arises loading in the tasks from file.
     */
    public void showLoadingError() {
        System.out.println("\t OOPS!!! Error loading tasks from file. Creating an empty task list.");
    }

    /**
     * Displays error message with custom message passed as a parameter.
     * Formats output with separator lines.
     * Used for NovaExceptions
     *
     * @param message error message to be displayed
     */
    public void showError(String message) {
        printSeparatorLine();
        System.out.println("\t " + message);
        printSeparatorLine();
    }

    /**
     * Displays goodbye message when user exits the program and chatbot.
     */
    public void showGoodbye() {
        printSeparatorLine();
        System.out.println("\t Bye. Hope to see you again soon!");
        printSeparatorLine();
    }

}