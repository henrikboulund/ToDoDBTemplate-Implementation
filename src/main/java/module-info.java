module dk.easv.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    requires java.naming;


    opens dk.easv.gui to javafx.fxml;
    exports dk.easv.gui;
}