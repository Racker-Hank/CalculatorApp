package mode;

import java.lang.reflect.Method;

public class Command {
    public String description;
    public Method onClickMethod;
    public Function2 function;

    public Command() {
    }

    public Command(Function2 function) {
        this.function = function;
        this.description = function.description;
    }

    public Command(String description , Method onClickMethod) {
        this.description = description;
        this.onClickMethod = onClickMethod;
    }
}
