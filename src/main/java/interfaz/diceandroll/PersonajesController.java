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
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class PersonajesController implements Initializable {

    @FXML
    private AnchorPane PanePersonajes;
    private Pane panelPrincipal;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }
    

    @FXML
    private void seleccionarPersonaje(MouseEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("fichaPersonaje.fxml"));
            Parent root = fxml.load();
            PanePersonajes.getChildren().setAll(root);
            FichaPersonajeController personajes = fxml.getController();
            personajes.setPanePrincipal(PanePersonajes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
