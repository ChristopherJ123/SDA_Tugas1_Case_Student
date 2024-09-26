package commands;

public interface Command {
    boolean execute();
    void undo();
}
