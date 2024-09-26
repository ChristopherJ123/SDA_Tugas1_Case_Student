package enrollment;

import commands.Command;

import java.util.Stack;

public class EnrollmentHistory {
    private Stack<Command> commandHistory = new Stack<>();

    public void push(Command command) {
        commandHistory.push(command);
    }

    public Command pop() {
        return commandHistory.pop();
    }

    public boolean isEmpty() {
        return commandHistory.isEmpty();
    }
}

