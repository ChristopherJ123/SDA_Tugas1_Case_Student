package enrollment;

public interface Command {
    boolean execute();
    boolean undo();
}
