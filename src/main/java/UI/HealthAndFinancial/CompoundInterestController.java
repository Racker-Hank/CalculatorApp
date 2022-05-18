package UI.HealthAndFinancial;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class CompoundInterestController {

    @FXML
    private AnchorPane test;

    @FXML
    private TextArea result;

    @FXML
    private TextArea interestrate;

    @FXML
    private TextArea princial;

    @FXML
    private GridPane modeName;

    @FXML
    private Button calculateButton;

    @FXML
    private TextArea time;

    @FXML
    private TextArea compoundedInterestTime;

    @FXML
    void saveCalculation(ActionEvent event) {
        double p = Double.parseDouble(princial.getText());
        double r = Double.parseDouble(interestrate.getText());
        double n = Double.parseDouble(compoundedInterestTime.getText());
        double t = Double.parseDouble(time.getText());
        String x = p * Math.pow(1 + ((r / n)/100), n * t)-p + "";
        result.setText(x);
    }


}
