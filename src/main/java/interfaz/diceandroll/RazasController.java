/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class RazasController implements Initializable {

    private Pane panelPrincipal;
    @FXML
    private TextField textFieldBuscador;
    @FXML
    private ComboBox<?> comboBox;
    @FXML
    private Label nombre1;
    @FXML
    private ImageView img1;
    @FXML
    private Label libro1;
    @FXML
    private Label nombre2;
    @FXML
    private ImageView img2;
    @FXML
    private Label nombre3;
    @FXML
    private ImageView img3;
    @FXML
    private Label nombre4;
    @FXML
    private ImageView img4;
    @FXML
    private Label nombre5;
    @FXML
    private ImageView img5;
    @FXML
    private Label nombre6;
    @FXML
    private ImageView img6;
    @FXML
    private Label nombre8;
    @FXML
    private ImageView img7;
    @FXML
    private Label nombre7;
    @FXML
    private ImageView img8;
    @FXML
    private Label nombre9;
    @FXML
    private ImageView img9;

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
    private void botonAplicarFiltro(ActionEvent event) {
    }
}
