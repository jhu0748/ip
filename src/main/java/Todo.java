/**
 * Todo class represents task with description that needs to be completed.
 * Extends Task class and ensures description is not empty.
 */
public class Todo extends Task {
    /**
     * Constructs todo task with given description.
     * Description must not be empty.
     *
     * @param description description of Todo task
     * @throws NovaException if description is empty or invalid
     */
    public Todo(String description) throws NovaException {
        super(description);

        if(description.trim().isEmpty()) {
            throw new NovaException("OOPS!! Sorry, but the todo description can't be empty. Please include a description and try again.");
        }
    }

    /**
     * Returns string representation of todo task.
     * Format includes task's type ("[T]"), its status, and description.
     *
     * @return string representation of todo task
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns formatting for how todo task stored in storage file
     * Saved data includes task's type, status, and description.
     *
     * @return string formatting for how todo task is stored in file
     */
    @Override
    public String getSaveData() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}