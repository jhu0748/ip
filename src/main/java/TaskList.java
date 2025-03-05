import java.util.ArrayList;

/**
 * TaskList class is responsible for managing a list of tasks.
 * Allows for adding tasks, marking/unmarking tasks as done, deleting tasks,
 * and listing all tasks currently in the list
 */
public class TaskList {
    private final ArrayList<Task> tasks;
    //private static final String FILE_PATH = "./data/nova.txt";

    /**
     * Creates an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Creates a TaskList from a given list of tasks.
     * Used for when loading in tasks from the saved file.
     *
     * @param tasks list of tasks to initialize the TaskList, from saved file
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks != null ? tasks : new ArrayList<>();
    }

    /**
     * Returns list of tasks
     *
     * @return list of tasks in the task list
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds a task to the task list.
     *
     * @param task task to add
     * @throws NovaException if there is an error adding the task
     */
    public void addTask(Task task) throws NovaException {
        tasks.add(task);
        Ui.printSeparatorLine();
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t  " + task);
        System.out.println("\t Now you have " + tasks.size() + " tasks in the list.");
        Ui.printSeparatorLine();
    }

    /**
     * Marks a task as done (with an [X]
     *
     * @param taskNum index of task to mark as done where 0 is first task
     * @throws NovaException if index of taskNum is out of bounds (negative or more than number of tasks in list - 1)
     */
    public void markTaskDone(int taskNum) throws NovaException{
        if(taskNum <= 0 || taskNum > (tasks.size() - 1)) {
            throw new NovaException("Please provide a valid task number to mark as done. Try again!");
        }

        tasks.get(taskNum).markAsDone();
        Ui.printSeparatorLine();
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t   " + tasks.get(taskNum));
        Ui.printSeparatorLine();
    }

    /**
     * Mark task as not done (becomes [ ])
     *
     * @param taskNum index of task to mark as not done (zero-based)
     * @throws NovaException if index is out of bounds (negative or more than number of tasks in list - 1)
     */
    public void unmarkTaskDone(int taskNum) throws NovaException{
        if(taskNum <= 0 || taskNum > (tasks.size() - 1)) {
            throw new NovaException("Please provide a valid task number to unmark as done. Try again!");
        }

        tasks.get(taskNum).unmarkAsDone();
        Ui.printSeparatorLine();
        System.out.println("\t Ok! I've marked this task as not done yet:");
        System.out.println("\t   " + tasks.get(taskNum));
        Ui.printSeparatorLine();
    }

    /**
     * Deletes a task from task list.
     *
     * @param taskNum index of task to delete (zero-based)
     * @throws NovaException if index is out of bounds (negative or more than number of tasks in list - 1)
     */
    public void deleteTask(int taskNum) throws NovaException{
        if(taskNum <= 0 || taskNum > (tasks.size() - 1)) {
            throw new NovaException("Please provide a valid task number to delete. Try again!");
        }

        Ui.printSeparatorLine();
        System.out.println("\t Noted. I've removed this task:");
        System.out.println("\t   " + tasks.get(taskNum));
        System.out.println("\t Now you have " + (tasks.size() - 1) + " tasks in the list.");
        Ui.printSeparatorLine();
        tasks.remove(taskNum);
    }

    /**
     * Lists all tasks in task list.
     * If task list is empty, informs user there are no tasks in the list at the moment.
     */
    // print out tasklist if there is at least 1 task in the list
    public void listTasks() {
        Ui.printSeparatorLine();

        if (tasks.isEmpty()) {
            System.out.println("\t Sorry! No tasks were recorded. Try adding to the task list.");
        } else {
            System.out.println("\t Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("\t " + (i + 1) + "." + tasks.get(i));
            }
        }
        Ui.printSeparatorLine();
    }
}
