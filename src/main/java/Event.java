/**
 * Event class represents a task with description and from and to dates.
 * Extends Task class and includes additional logic for validating and formatting event's from and to dates.
 */
public class Event extends Task {
    private final String from;
    private final String to;

    /**
     * Constructs an Event task with given description and from and to dates.
     * Description, from date, and to date must not be empty.
     *
     * @param description description of event task
     * @param from start date of event
     * @param to end date of event
     * @throws NovaException if description, from date, or by date are invalid (empty)
     */
    public Event(String description, String from, String to) throws NovaException {
        super(description);
        if (description.trim().isEmpty()) {
            throw new NovaException("OOPS!!! Sorry, but the description of an event cannot be empty.");
        }
        if (from == null || from.trim().isEmpty()) {
            throw new NovaException("OOPS!!! Sorry, but the event must have a valid /from date.");
        }
        if (to == null || to.trim().isEmpty()) {
            throw new NovaException("OOPS!!! Sorry, but the event must have a valid /to date.");
        }

        this.from = from;
        this.to = to;
    }

    /**
     * Returns string representation of event task.
     * Format includes task's type ("[E]"), its status, description, from date, and to date.
     *
     * @return string representation of event task
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + from + " to: " + to + ")";
    }

    /**
     * Returns formatting for event task stored in storage file
     * Saved data includes task's type, status, description, from date, and to date.
     *
     * @return string formatting for how event task is stored in file
     */
    @Override
    public String getSaveData() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + "-" + to;
    }
}
