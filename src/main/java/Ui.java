/**
 * Ui class is responsible for displaying messages to the user and guides the interaction.
 * It handles showing welcome messages, errors, and a goodbye message.
 * Also provides helper methods for formatting output.
 */
public class Ui {
    /**
     * Helper method to print a separator line, used to separate user input and command output.
     */
    public static void printSeparatorLine() {
        System.out.println("\t____________________________________________________________");
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
        System.out.println("\t OOPS!!! Error loading tasks from file.");
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
