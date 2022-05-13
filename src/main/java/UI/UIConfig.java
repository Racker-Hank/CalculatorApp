package UI;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class UIConfig {
    public static Stage primaryStage;

    public static int fontSize = 14;

    public static String fontFamily = "Noto Sans Math";

    public static int borderRadius = 16;

    public static String colorWhite = "#ffffff";
    public static String colorPrimaryGreen = "#28F984";
    public static String colorPink = "#D97A85";
    public static String colorYellow = "#F6BD00";
    public static String colorInactiveGrey = "#777777";

    public static ArrayList <Node> getAllNodes(Parent root) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        addAllDescendents(root, nodes);
        return nodes;
    }

    private static void addAllDescendents(Parent parent, ArrayList<Node> nodes) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            nodes.add(node);
            if (node instanceof Parent)
                addAllDescendents((Parent)node, nodes);
        }
    }
}
