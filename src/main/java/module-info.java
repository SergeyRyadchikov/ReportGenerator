module net.project.reportgenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires json;


    opens net.project.reportgenerator to javafx.fxml;
    exports net.project.reportgenerator;
}