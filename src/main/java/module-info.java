module net.project.reportgenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.apache.httpcomponents.httpcore;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens net.project.reportgenerator to javafx.fxml;
    exports net.project.reportgenerator;
}