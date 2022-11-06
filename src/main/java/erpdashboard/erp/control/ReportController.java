package erpdashboard.erp.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportController implements Initializable {
    @FXML
    private Button itemButton;
    @FXML
    private Button clientButton;
    @FXML
    private Button invoiceButton;
    @FXML
    private Button adminButton;
    @FXML
    private Button dashboardButton;
    @FXML
    private Button goBackButton;
    @FXML
    private Button logOutButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML
    void onClick(ActionEvent event) {
        try {
            //System.out.println(((Button)event.getSource()).getText());
            Movable.Move(((Button)event.getSource()),"report.fxml");
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
