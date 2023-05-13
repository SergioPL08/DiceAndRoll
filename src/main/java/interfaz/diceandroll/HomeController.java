/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
    @FXML
    private Pane contenedor;
    @FXML
    private Button botonPersonajes;
    @FXML
    private AnchorPane panePrincipal;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoginController.getLogin();
        abrirHome();   
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
            Scene home = new Scene(content, 527, 577);
            stage.setScene(home);
            stage.show();
            Node tal = (Node) event.getSource();
            Stage ventAct = (Stage) tal.getScene().getWindow();
            ventAct.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
   

    @FXML
    private void abrirMenuListaPersonajes(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("personajes.fxml"));
            Parent root = fxml.load();
            contenedor.getChildren().setAll(root);
            PersonajesController personajes = fxml.getController();
            personajes.setPanePrincipal(contenedor);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void abrirMenuListaCampañas(ActionEvent event) {
        
    }

    @FXML
    private void abrirMenuListaRazas(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("razas.fxml"));
            Parent root = fxml.load();
            contenedor.getChildren().setAll(root);
            RazasController razas = fxml.getController();
            razas.setPanePrincipal(contenedor);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    @FXML
    private void abrirMenuListaClases(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("listaClases.fxml"));
            Parent root = fxml.load();
            contenedor.getChildren().setAll(root);
            ListaClasesController clases = fxml.getController();
            clases.setPanePrincipal(contenedor);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void abrirMenuListaTrasfondos(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("listaTrasfondos.fxml"));
            Parent root = fxml.load();
            contenedor.getChildren().setAll(root);
            ListaTrasfondosController trasfondos = fxml.getController();
            trasfondos.setPanePrincipal(contenedor);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void abrirMenuListaDotes(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("listaDotes.fxml"));
            Parent root = fxml.load();
            contenedor.getChildren().setAll(root);
            ListaDotesController dotes = fxml.getController();
            dotes.setPanePrincipal(contenedor);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void abrirMenuListaConjuros(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("listaConjuros.fxml"));
            Parent root = fxml.load();
            contenedor.getChildren().setAll(root);
            ListaConjurosController conjuros = fxml.getController();
            conjuros.setPanePrincipal(contenedor);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void abrirMenuListaEquipo(ActionEvent event) {
    }


    public void setMainPane(Pane mainPane){
        this.contenedor=mainPane;
    }

    @FXML
    private void mouseReleased(MouseEvent event) {
        botonPersonajes.setStyle("color: blue");
    }

    @FXML
    void mousePressed(MouseEvent event) {
        botonPersonajes.setStyle("color: red");
    }

    @FXML
    private void abrirMenuPrincipal(ActionEvent event) {
        abrirHome();

    }
    
    private void abrirHome(){
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("homeImage.fxml"));
            Parent root = fxml.load();
            contenedor.getChildren().setAll(root);
            HomeImageController home = fxml.getController();
            home.setPanePrincipal(contenedor);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error al abrir el menu principal");
        }
    }

    @FXML
    private void abrirMenuTablero(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("tablero.fxml"));
            Parent root = fxml.load();
            contenedor.getChildren().setAll(root);
            TableroController tablero = fxml.getController();
            tablero.setPanePrincipal(contenedor);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error al abrir el menu principal");
        
    }

    }
}
