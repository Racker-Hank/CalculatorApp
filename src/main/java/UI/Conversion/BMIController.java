package UI.Conversion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import mode.HealthAndFinancial;

public class BMIController {

    @FXML
    private AnchorPane test;

    @FXML
    private TextArea result;

    @FXML
    private TextArea weight;

    @FXML
    private TextArea height;

    @FXML
    private GridPane modeName;

    @FXML
    private Button calculateButton;

    @FXML
    void saveCalculation(ActionEvent event) {
        double b = Double.parseDouble(weight.getText());
        double a = Double.parseDouble(height.getText());
        double res = b / ((a/ 100) * (a/ 100));
        String x = (double) Math.round(res * 10) / 10  + "";
        result.setText(x);
    }

}
