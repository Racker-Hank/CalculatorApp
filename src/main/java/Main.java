import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import operation.Operation;

import java.util.Objects;

public class    Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load((getClass().getResource("ui_test.fxml")));
//        Parent root = FXMLLoader.load((getClass().getResource("F:\\2Study\\2Nam2\\Sem2\\code\\CNPM\\Calculator-Project\\CalculatorApp\\src\\main\\java\\operation\\ui_test.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    //    public static void main(String[] args) {
    //        System.out.println("Hello World!");
    //        System.out.println("Hello World!");
    //        System.out.println("Harupip");
    //        System.out.println("bebunbeokute");
    //        System.out.println("minhvertu");
    //    }
}
