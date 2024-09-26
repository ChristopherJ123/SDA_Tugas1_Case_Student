package enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EnrollmentHistory {
    private Stack<Command> commandHistory = new Stack<>();

    public void push(Command command) {
        commandHistory.push(command);
    }

    public Command remove(Command command) {
        return commandHistory.pop();
    }

    public boolean isEmpty() {
        return commandHistory.isEmpty();
    }
}

