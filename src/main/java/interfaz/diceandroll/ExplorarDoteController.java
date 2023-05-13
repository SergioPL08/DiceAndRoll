/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.clases.Dote;
import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.clases.Libro;
import interfaz.diceandroll.conector.Conector;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class ExplorarDoteController implements Initializable {

    @FXML
    private Label labelNombreDote,labelDescripcion,labelNombreLibro;
    private static Dote dote;
    private static Libro libro;
    private Pane panelPrincipal;
    @FXML
    private AnchorPane contenedor;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Se muestra la información de la dote seleccionada
        if(dote!=null){
                labelNombreDote.setText(dote.getNombre());
                labelDescripcion.setText(dote.getDescripcion());
                labelNombreLibro.setText(libro.getNombre());
        }
    }    

    public ExplorarDoteController(){
        
    }
    
    public ExplorarDoteController(Dote dote,Libro libro) {
        this.dote = dote;
        this.libro = libro;
    }
    /**
     * Regresa a la ventana de dotes
     * @param event 
     */
    @FXML
    private void volverListadoDotes(ActionEvent event) {
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
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }
    
    public Dote getDote(){
        return this.dote;
    }
    
    public void setDote(Dote dote){
        System.out.println("setDote() "+dote);
        System.out.println("this explorarDoteController: "+this);
        this.dote = dote;
        System.out.println("this.dote "+this.dote);
    }
}
