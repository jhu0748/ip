public class Event extends Task {
    private String from;
    private String to;

    public Event(String description, String from, String to) {
        super(description);
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("OOPS!!! Sorry, but the description of an event cannot be empty.");
        }
        if (from == null || from.trim().isEmpty()) {
            throw new IllegalArgumentException("OOPS!!! Sorry, but the event must have a valid /from date.");
        }
        if (to == null || to.trim().isEmpty()) {
            throw new IllegalArgumentException("OOPS!!! Sorry, but the event must have a valid /to date.");
        }
        if(description.charAt(0) != ' ') {
            throw new IllegalArgumentException(("OOPS!! Sorry, but that is an unrecognized command."));
        }
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + from + " to: " + to + ")";
    }
}
