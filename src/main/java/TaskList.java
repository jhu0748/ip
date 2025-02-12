public class TaskList {
    private final Task[] taskList = new Task[100];
    private int numTasks = 0;

    // add task to tasklist
    public void addTask(Task task) {
        taskList[numTasks] = task;
        numTasks++;
        Ui.printSeparatorLine();
        System.out.println("Got it. I've added this task:");
        System.out.println("\t  " + task);
        System.out.println("\t Now you have " + numTasks + " tasks in the list.");
        Ui.printSeparatorLine();
    }
    // mark task as done [X]
    public void markTaskDone(int taskNum) {
        taskList[taskNum].markAsDone();
        Ui.printSeparatorLine();
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println(("\t   " + taskList[taskNum]));
        Ui.printSeparatorLine();
    }
    // mark as not done [ ]
    public void unmarkTaskDone(int taskNum) {
        taskList[taskNum].unmarkAsDone();
        Ui.printSeparatorLine();
        System.out.println("\t Ok! I've marked this task as not done yet:");
        System.out.println(("\t   " + taskList[taskNum]));
        Ui.printSeparatorLine();
    }
    // print out tasklist if there is at least 1 task in the list
    public void listTasks() {
        Ui.printSeparatorLine();

        if(numTasks == 0) {
            System.out.println("\t Sorry! No tasks were recorded. Try adding to the task list.");
        } else {
            System.out.println("\t Here are the tasks in your list:");
            for (int i = 0; i < numTasks; i++) {
                System.out.println("\t " + (i + 1) + "." + taskList[i]);
            }
        }
//adf
        Ui.printSeparatorLine();
    }
}
