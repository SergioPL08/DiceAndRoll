/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.clases.Clase;
import interfaz.diceandroll.clases.Libro;
import interfaz.diceandroll.clases.Conjuro;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class ExplorarConjuroController implements Initializable {
    private static Clase clase;
    private static Conjuro conjuro;
    private static Libro libro;
    @FXML
    private AnchorPane contenedor;
    Pane panelPrincipal;
    @FXML
    private Label labelNombreConjuro;
    @FXML
    private Label labelDescripcion;
    @FXML
    private Label labelNombreLibro;
    @FXML
    private Label labelNivel;
    @FXML
    private Label labelEscuela;
    @FXML
    private Label labelAlcance;
    @FXML
    private Label labelTiempoLanzamiento;
    @FXML
    private Label labelDuracion;
    @FXML
    private Label labelTipoDanioEfecto;
    @FXML
    private Label labelNombreLibro1;
    @FXML
    private Label labelComponentesConjuro;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //Se muestra la información de la dote seleccionada
        if(conjuro!=null){
                labelNombreConjuro.setText(conjuro.getNombre());
                labelNombreLibro.setText(libro.getNombre());
                labelNivel.setText(String.valueOf(conjuro.getNivel()));
                labelEscuela.setText(conjuro.getEscuela());
                List<String> competencias = new ArrayList();
                String componentesMateriales="";
                if(conjuro.isV())
                    competencias.add("V");
                if(conjuro.isS())
                    competencias.add("S");
                if(conjuro.isM()){
                    competencias.add("M");
                    componentesMateriales+="("+conjuro.getTextoCompetenciaMaterial()+")";
                }
                labelComponentesConjuro.setText(String.join(", ", competencias)+componentesMateriales);
                labelAlcance.setText(conjuro.getAlcance());
                labelTiempoLanzamiento.setText(conjuro.getTiempoLanzamiento());
                labelDuracion.setText(conjuro.getDuracion());
                labelDescripcion.setText(conjuro.getDescripcion());
        }    
    }    
    
    public ExplorarConjuroController(){
        
    }
    
    public ExplorarConjuroController(Conjuro conjuro,Libro libro) {
        this.conjuro = conjuro;
        this.libro = libro;
    }
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }

    @FXML
    private void volverListadoDotes(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("listaConjuros.fxml"));
            Parent root = fxml.load();
            contenedor.getChildren().setAll(root);
            ListaConjurosController dotes = fxml.getController();
            dotes.setPanePrincipal(contenedor);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
