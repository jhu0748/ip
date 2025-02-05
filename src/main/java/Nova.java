import java.util.Scanner;

public class Nova {
    public static void main(String[] args) {
        String logo = "Nova";
        System.out.println("Hello! I'm " + logo);
        System.out.println("What can I do for you?");
        Scanner scanner = new Scanner(System.in);
        String input;
        while(true) {
            input = scanner.nextLine();
            if(input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else {
                System.out.println("     " + input);
            }
        }
        scanner.close();
    }
}