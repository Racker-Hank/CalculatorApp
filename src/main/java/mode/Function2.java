package mode;

import UI.components.PrimaryButton;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import operation.Fraction;

import java.lang.reflect.Method;

public class Function2 {
    public String name;
    public String description;
    public PrimaryButton button;
    public Command command;

    public double calculate(Object... args) {
        return 0;
    }

    public void addToTextArea(TextArea inputTextArea) {
    }

//    when selected from command palette
    public void openFunction() {
    }

    public void test(double n , double m) {
        System.out.println(n + m);
    }

    public static void main(String[] args) {

    }
}
