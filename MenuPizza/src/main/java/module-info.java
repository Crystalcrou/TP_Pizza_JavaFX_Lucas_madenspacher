module fr.madenspacher.menupizza {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens fr.madenspacher.menupizza to javafx.fxml;
    exports fr.madenspacher.menupizza;
}