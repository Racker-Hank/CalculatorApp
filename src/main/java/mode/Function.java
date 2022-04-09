package mode;

import java.lang.reflect.Method;

public class Function {
    public String name;
    public Method method;

    public void display() {
    }

    public Function() {
    }

    public Function(String name , Method method) {
        this.name = name;
        this.method = method;
    }
}
