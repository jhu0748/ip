public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unmarkAsDone() {
        this.isDone = false;
    }
    public String getStatus() {
        return (isDone ? "X" : " ");
    }

    public String getSaveData() {
        return "";
    }
    @Override
    public String toString() {
        return "[" + getStatus() + "] " + description;
    }
}
