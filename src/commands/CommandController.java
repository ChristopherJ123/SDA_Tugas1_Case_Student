package commands;

public class CommandController {
    private CommandHistory history;

    public CommandController(CommandHistory history) {
        this.history = history;
    }

    public void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
            System.out.println("Command executed successfully");
        }
        else {
            System.out.println("Command failed to execute");
        }
    }

    public void undoCommand() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
            System.out.println("Undo command successfully");
        } else {
            System.out.println("There is no command to undo");
        }
    }
}
