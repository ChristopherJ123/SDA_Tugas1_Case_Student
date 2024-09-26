package commands;

public interface Command {
    boolean execute();
    boolean undo();
}
