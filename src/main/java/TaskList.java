import java.util.ArrayList;

public class TaskList {
    private static final ArrayList<Task> taskArrayList = new ArrayList<>();

    // add task to tasklist
    public void addTask(Task task) throws NovaException {
        taskArrayList.add(task);
        Ui.printSeparatorLine();
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t  " + task);
        System.out.println("\t Now you have " + taskArrayList.size() + " tasks in the list.");
        Ui.printSeparatorLine();
    }
    // mark task as done [X]
    public void markTaskDone(int taskNum) {
        taskArrayList.get(taskNum).markAsDone();
        Ui.printSeparatorLine();
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t   " + taskArrayList.get(taskNum));
        Ui.printSeparatorLine();
    }
    // mark as not done [ ]
    public void unmarkTaskDone(int taskNum) {
        taskArrayList.get(taskNum).unmarkAsDone();
        Ui.printSeparatorLine();
        System.out.println("\t Ok! I've marked this task as not done yet:");
        System.out.println("\t   " + taskArrayList.get(taskNum));
        Ui.printSeparatorLine();
    }
    // print out tasklist if there is at least 1 task in the list
    public void listTasks() {
        Ui.printSeparatorLine();

        if(taskArrayList.isEmpty()) {
            System.out.println("\t Sorry! No tasks were recorded. Try adding to the task list.");
        } else {
            System.out.println("\t Here are the tasks in your list:");
            for (int i = 0; i < taskArrayList.size(); i++) {
                System.out.println("\t " + (i + 1) + "." + taskArrayList.get(i));
            }
        }
        Ui.printSeparatorLine();
    }
}
