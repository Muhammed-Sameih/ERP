package erpdashboard.erp.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
    @FXML
    private Button dashboardButton;
    @FXML
    private Button itemButton;
    @FXML
    private Button invoiceButton;
    @FXML
    private Button clientButton;
    @FXML
    private Button reportButton;
    @FXML
    private Button goBackButton;
    @FXML
    private Button logOutButton;
    @FXML
    void onClick(ActionEvent event) {
        try {
            //System.out.println(((Button)event.getSource()).getText());
            Movable.Move(((Button)event.getSource()),"admin.fxml");
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
