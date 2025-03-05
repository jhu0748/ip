/**
 * Task class represents a task with a description and a completion status.
 * A task can be marked or unmarked as done and can be printed out as a string.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a Task with a given description.
     * Task is initially marked as not done.
     *
     * @param description description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as done
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done
     */
    public void unmarkAsDone() {
        this.isDone = false;
    }

    /**
     * Returns status of the task.
     * If task is marked as done, returns "X", otherwise returns a space.
     * Used for printing tasks
     *
     * @return status of task as a string ("X" or " ")
     */
    public String getStatus() {
        return (isDone ? "X" : " ");
    }

    /**
     * Returns how task will be saved in storage file.
     * Method is overwritten in subclasses for customization based on type of task.
     *
     * @return save data for task as a string
     */
    public String getSaveData() {
        return "";
    }

    /**
     * Returns string representation of the task.
     * String includes task's status and description.
     *
     * @return string representation of task
     */
    @Override
    public String toString() {
        return "[" + getStatus() + "] " + description;
    }
}
