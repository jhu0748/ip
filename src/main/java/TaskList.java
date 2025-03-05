import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class TaskList {
    private final ArrayList<Task> tasks;
    //private static final String FILE_PATH = "./data/nova.txt";

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks != null ? tasks : new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    // add task to tasklist
    public void addTask(Task task) throws NovaException {
        tasks.add(task);
        Ui.printSeparatorLine();
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t  " + task);
        System.out.println("\t Now you have " + tasks.size() + " tasks in the list.");
        Ui.printSeparatorLine();
    }
    // mark task as done [X]
    public void markTaskDone(int taskNum) {
        tasks.get(taskNum).markAsDone();
        Ui.printSeparatorLine();
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t   " + tasks.get(taskNum));
        Ui.printSeparatorLine();
    }
    // mark as not done [ ]
    public void unmarkTaskDone(int taskNum) {
        tasks.get(taskNum).unmarkAsDone();
        Ui.printSeparatorLine();
        System.out.println("\t Ok! I've marked this task as not done yet:");
        System.out.println("\t   " + tasks.get(taskNum));
        Ui.printSeparatorLine();
    }
    // delete task from arraylist
    public void deleteTask(int taskNum) {
        Ui.printSeparatorLine();
        System.out.println("\t Noted. I've removed this task:");
        System.out.println("\t   " + tasks.get(taskNum));
        System.out.println("\t Now you have " + (tasks.size() - 1) + " tasks in the list.");
        Ui.printSeparatorLine();
        tasks.remove(taskNum);
    }
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

        Ui.showFindResults(matchingTasks, keyword);
    }
}
