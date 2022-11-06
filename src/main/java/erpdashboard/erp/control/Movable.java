package erpdashboard.erp.control;

import erpdashboard.erp.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Movable {
    private static double x = 150;
    private static double y = 0;
    private static Stack backBath = new Stack();
    private static Map<boolean[],String> viewId = new HashMap< boolean[],String>();

    private static void initializeMap(){
        viewId.put(new boolean[]{false,false,false},"dashboard.fxml");
        viewId.put(new boolean[]{true,false,false}, "item.fxml");
        viewId.put(new boolean[]{false,true,false}, "client.fxml");
        viewId.put(new boolean[]{false,false,true}, "report.fxml");
        viewId.put(new boolean[]{true,true,false}, "admin.fxml");
        viewId.put(new boolean[]{true,false,true}, "invoice.fxml");
        viewId.put(new boolean[]{false,true,true}, "login.fxml");
    }


    private static String choiceViewFile(Button button){
            String viewFileName = "dashboard.fxml";
            //System.out.println(button.getText());
            if (button.getText().equals("Items")) {
                viewFileName = "item.fxml";
            }else if(button.getText().equals("Clients")) {
                viewFileName = "client.fxml";
            }else if(button.getText().equals("Reports")) {
                viewFileName = "report.fxml";
            }else if(button.getText().equals("Admins")) {
                viewFileName = "admin.fxml";
            }else if(button.getText().equals("Login") || button.getText().equals("Dashboard")) {
                viewFileName = "dashboard.fxml";
            }else if(button.getText().equals("Invoices")) {
                viewFileName = "invoice.fxml";
            }else if(button.getText().equals("")) {
                viewFileName = (String) backBath.pop();
                System.out.println(viewFileName);
            }else if (button.getText().equals("Log out")){
                viewFileName = "login.fxml";
                backBath.clear();
            }
        return viewFileName;
    }

    private static String getViewFileName (boolean[]_viewID){
            if(_viewID.equals(viewId.containsKey(_viewID)))
                return viewId.get(_viewID);
            else return"Not Found";
    }
    private static void determineStartingCoordinate(boolean[]_viewID){
        if(_viewID.equals(new boolean[]{false,true,true})) {
            x = 300;
            y = 300;
        }
        else{
            x = 150;
            y = 0;
        }
    }

    public static void Move(Button button, String _currentView){
        try {
            x = 150;
            y = 0;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(choiceViewFile(button)));
            Scene scene = new Scene(fxmlLoader.load());
            Stage window = (Stage) button.getScene().getWindow();
            window.setScene(scene);
            window.setResizable(false);
            window.setX(x);
            window.setY(y);
            if(!button.getText().equals(""))
                backBath.push(_currentView);
        }catch (Exception e){
            System.out.println(e.toString());
            System.out.println(11);
        }
    }

}
/*
    Name varchar(255) NOT NULL,
    FOREIGN KEY (Name) REFERENCES Factory (Name) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (Cust_Name) REFERENCES Customer (Name) ON DELETE RESTRICT ON UPDATE CASCADE,
 */