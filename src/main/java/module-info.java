module erpdashboard.erp {
    requires javafx.controls;
    requires javafx.fxml;


    opens erpdashboard.erp to javafx.fxml;
    exports erpdashboard.erp;
    exports erpdashboard.erp.control;
    opens erpdashboard.erp.control to javafx.fxml;
}