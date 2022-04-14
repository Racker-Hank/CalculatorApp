package UI;

import de.jensd.fx.glyphs.testapps.App;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class Graph extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/Graph.fxml")));
        Scene scene = new Scene(root);

        stage.setTitle("Graph test");

        stage.setScene(scene);
        stage.show();
    }
}
