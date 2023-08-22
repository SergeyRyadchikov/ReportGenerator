module net.project.reportgenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.apache.httpcomponents.httpcore;
    requires com.google.gson;


    opens net.project.reportgenerator to javafx.fxml;
    exports net.project.reportgenerator;
}