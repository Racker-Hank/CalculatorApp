package UI;

import  javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class UI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Main3.fxml")));
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ui_test.fxml")));
        root.getStylesheets().add("/styles.css");
        Scene scene = new Scene(root);

        Image icon = new Image("images/Frame 42.png");
        stage.getIcons().add(icon);
        stage.setTitle("Calculator");
//        stage.setX(50);
//        stage.setY(50);\
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);
        UIConfig.primaryStage = stage;
//        stage.setFullScreen(true);
//        stage.setMaximized(true);
        stage.show();
    }
}
