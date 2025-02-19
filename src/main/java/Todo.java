public class Todo extends Task {
    public Todo(String description) throws NovaException {
        super(description);

        if(description.trim().isEmpty()) {
            throw new NovaException("OOPS!! Sorry, but the todo description can't be empty. Please include a description and try again.");
        }
/*
        if(description.trim().charAt(0) == ' ') { //
            throw new NovaException(("OOPS!! Sorry, but that is an unrecognized command."));
        }
*/
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String getSaveData() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}
