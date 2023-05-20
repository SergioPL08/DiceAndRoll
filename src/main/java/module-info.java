module interfaz.diceandroll {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires javafx.web;
    opens interfaz.diceandroll to javafx.fxml;
    exports interfaz.diceandroll;
}
