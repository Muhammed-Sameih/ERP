package erpdashboard.erp.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button login;

    @FXML
    public void onLoginHandle(){
        try {
            Movable.Move(login,"login.fxml");
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}