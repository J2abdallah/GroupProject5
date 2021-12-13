module com.example.groupproject5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;
    requires gson;

    opens com.example.groupproject5 to javafx.fxml;
    exports com.example.groupproject5;
}