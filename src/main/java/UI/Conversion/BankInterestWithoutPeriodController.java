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

public class BankInterestWithoutPeriodController {

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
    private TextArea timeByDay;

    @FXML
    void saveCalculation(ActionEvent event) {
        double p = Double.parseDouble(moneyIn.getText());
        double r = Double.parseDouble(interestByPercentage.getText());
        double t = Double.parseDouble(timeByDay.getText());
        String x = HealthAndFinancial.BankInterestWithoutPeriod.BankInterestWithoutPeriod(p, r, t) + "";
        result.setText(x);
    }

}
