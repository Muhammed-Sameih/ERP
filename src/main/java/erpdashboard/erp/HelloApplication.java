package erpdashboard.erp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage)  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("UAE Accounting Software");
            stage.setScene(scene);
            stage.show();
            stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream( "image/logo.png" )));
           // stage.setResizable(false);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}