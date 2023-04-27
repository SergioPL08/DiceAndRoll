module interfaz.diceandroll {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens interfaz.diceandroll to javafx.fxml;
    exports interfaz.diceandroll;
}
