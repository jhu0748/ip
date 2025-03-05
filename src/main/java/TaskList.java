import java.util.ArrayList;

/**
 * TaskList class is responsible for managing a list of tasks.
 * Allows for adding tasks, marking/unmarking tasks as done, deleting tasks,
 * and listing all tasks currently in the list
 */
public class TaskList {
    private final ArrayList<Task> tasks;
    private final Ui ui;

    /**
     * Creates an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
        this.ui = new Ui();
    }

    /**
     * Creates a TaskList from a given list of tasks.
     * Used for when loading in tasks from the saved file.
     *
     * @param tasks list of tasks to initialize the TaskList, from saved file
     */
    public TaskList(ArrayList<Task> tasks, Ui ui) {
        this.tasks = tasks != null ? tasks : new ArrayList<>();
        this.ui = ui;
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
     * Adds a task to the task list and prints task details as well as how many tasks now in the list.
     *
     * @param task task to add
     * @throws NovaException if there is an error adding the task
     */
    public void addTask(Task task) throws NovaException {
        int numTasks = tasks.size();

        tasks.add(task);
        numTasks++;
        ui.printAddTaskOutput(task, numTasks);
    }

    /**
     * Marks a task as done (with an [X])
     * isDone = true indicates to command prompt print function that user was marking a task as done.
     *
     * @param taskNum index of task to mark as done where 0 is first task
     * @throws NovaException if index of taskNum is out of bounds (negative or more than number of tasks in list - 1)
     */
    public void markTaskDone(int taskNum) throws NovaException{
        boolean isDone = true; // indicates to print function that we marked a task as done
        if(taskNum < 0 || taskNum > (tasks.size() - 1)) {
            throw new NovaException("Please provide a valid task number to mark as done. Try again!");
        }

        tasks.get(taskNum).markAsDone();
        ui.printMarkingOutput(tasks, taskNum, isDone);
    }

    /**
     * Mark task as not done (becomes [ ])
     * isDone = false indicates to command prompt print function that user was unmarking a task as done.
     *
     * @param taskNum index of task to mark as not done (zero-based)
     * @throws NovaException if index is out of bounds (negative or more than number of tasks in list - 1)
     */
    public void unmarkTaskDone(int taskNum) throws NovaException{
        boolean isDone = false;
        if(taskNum < 0 || taskNum > (tasks.size() - 1)) {
            throw new NovaException("Please provide a valid task number to unmark as done. Try again!");
        }

        tasks.get(taskNum).unmarkAsDone();
        ui.printMarkingOutput(tasks, taskNum, isDone);
    }

    /**
     * Deletes a task from task list. First saves task to be deleted so its details can be printed after deleting.
     *
     * @param taskNum index of task to delete (zero-based)
     * @throws NovaException if index is out of bounds (negative or more than number of tasks in list - 1)
     */
    public void deleteTask(int taskNum) throws NovaException{
        Task task = tasks.get(taskNum);
        int numTasks = tasks.size();

        if(taskNum < 0 || taskNum > (tasks.size() - 1)) {
            throw new NovaException("Please provide a valid task number to delete. Try again!");
        }

        tasks.remove(taskNum);
        numTasks--;
        ui.printDeleteTaskOutput(task, numTasks);
    }

    /**
     * Lists all tasks in task list.
     * If task list is empty, informs user there are no tasks in the list at the moment.
     */
    // print out tasklist if there is at least 1 task in the list
    public void listTasks() {
        ui.printSeparatorLine();

        if (tasks.isEmpty()) {
            System.out.println("\t Sorry! No tasks were recorded. Try adding to the task list.");
        } else {
            System.out.println("\t Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("\t " + (i + 1) + "." + tasks.get(i));
            }
        }
        ui.printSeparatorLine();
    }

    /**
     * Finds the tasks whose descriptions contain the keyword input the user.
     * Validates keyword by making sure it is not empty.
     *
     * @param keyword String keyword that user inputs and wants to find matches for
     * @throws NovaException If keyword is empty.
     */
    public void findTasks(String keyword) throws NovaException{
        if(keyword.isEmpty()) {
            throw new NovaException("Please provide a keyword and try again.");
        }
        ArrayList<Task> matchingTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (task.description.toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.add(task);
            }
        }

        ui.showFindResults(matchingTasks, keyword);
    }
}