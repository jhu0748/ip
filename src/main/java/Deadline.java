/**
 * Deadline class represents a task with a description and deadline date given by user.
 * Extends Task class and includes additional logic for validating and formatting the deadline.
 */
public class Deadline extends Task{
    private final String by;

    /**
     * Constructs Deadline task with given description and "by" deadline date.
     * Description and deadline must not be empty.
     *
     * @param description description of deadline task
     * @param by deadline date for task in string format
     * @throws NovaException if the description or deadline are invalid (empty)
     */
    public Deadline(String description, String by) throws NovaException{
        super(description.trim());
        if (description.trim().isEmpty()) {
            throw new NovaException("OOPS!!! Sorry, but the description of a deadline cannot be empty.");
        }

        if (by == null || by.trim().isEmpty()) {
            throw new NovaException("OOPS!!! Sorry, but the deadline must have a valid /by date.");
        }
        this.by = by;
    }

    /**
     * Returns string representation of deadline task.
     * Format includes task's type ("[D]"), its status, description, and deadline date
     *
     * @return string representation of deadline task
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    /**
     * Returns formatting for deadline task stored in storage file
     * Saved data includes task's type, status, description, deadline date.
     *
     * @return string formatting for how deadline task is stored in file
     */
    @Override
    public String getSaveData() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}
