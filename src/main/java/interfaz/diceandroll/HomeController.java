/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class HomeController implements Initializable {

    @FXML
    private VBox desplegable;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoginController.getLogin();
    }  

    @FXML
    private void mostrarDesplegable(ActionEvent event) {
        if(!desplegable.isVisible())
            desplegable.setVisible(true);
        else
            desplegable.setVisible(false);
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent content = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene home = new Scene(content, 800, 600);
            stage.setScene(home);
            stage.show();
            Node tal = (Node) event.getSource();
            Stage ventAct = (Stage) tal.getScene().getWindow();
            ventAct.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    
    

    
}
