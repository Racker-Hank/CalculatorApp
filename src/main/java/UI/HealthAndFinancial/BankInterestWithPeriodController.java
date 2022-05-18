package UI.HealthAndFinancial;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import mode.healthAndFinancial.HealthAndFinancial;

public class BankInterestWithPeriodController {

    @FXML
    private AnchorPane test;

    @FXML
    private TextArea result;

    @FXML
    private TextArea interestByPercentage;

    @FXML
    private TextArea moneyIn;

    @FXML
    private GridPane modeName;

    @FXML
    private Button calculateButton;

    @FXML
    private TextArea timeByYear;

    @FXML
    void saveCalculation(ActionEvent event) {
        double p = Double.parseDouble(moneyIn.getText());
        double r = Double.parseDouble(interestByPercentage.getText());
        double t = Double.parseDouble(timeByYear.getText());
        String x = HealthAndFinancial.BankInterestWithPeriod.BankInterestWithPeriod(p, r, t) + "";
        result.setText(x);
    }
}
