public class Deadline extends Task{
    private String by;

    public Deadline(String description, String by) throws NovaException{
        super(description.substring(1));
        if (description.trim().isEmpty()) {
            throw new NovaException("OOPS!!! Sorry, but the description of a deadline cannot be empty.");
        }
        if(description.charAt(0) != ' ') {
            throw new NovaException(("OOPS!! Sorry, but that is an unrecognized command."));
        }
        if (by == null || by.trim().isEmpty()) {
            throw new NovaException("OOPS!!! Sorry, but the deadline must have a valid /by date.");
        }
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
