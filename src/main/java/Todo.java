public class Todo extends Task {
    public Todo(String description) {
        super(description.trim());

        if(description.trim().isEmpty()) {
            throw new IllegalArgumentException("OOPS!! Sorry, but the todo description can't be empty. Please include a description and try again.");
        }
        if(description.charAt(0) != ' ') {
            throw new IllegalArgumentException(("OOPS!! Sorry, but that is an unrecognized command."));
        }
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
