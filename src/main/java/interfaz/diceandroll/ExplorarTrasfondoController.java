/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.conector.Conector;
import interfaz.diceandroll.clases.Trasfondo;
import interfaz.diceandroll.clases.Libro;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Control;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class ExplorarTrasfondoController implements Initializable {


    @FXML
    private Label labelNombreTrasfondo;
    @FXML
    private VBox vboxHabilidades;
    @FXML
    private Label labelDescripcionRasgos;
    @FXML
    private VBox vboxRasgosPersonalidad;
    @FXML
    private VBox vboxIdeales;
    @FXML
    private VBox vboxVinculos;
    @FXML
    private VBox vboxDefectos;
    @FXML
    private Label labelDescripcionRasgo;
    @FXML
    private Label labelNombreEspecialidad;
    @FXML
    private Label labelDescripcionEspecialidad;
    @FXML
    private VBox vboxExpecialidades;
    @FXML
    private Label labelDescripcion,labelNombreLibro;
    private static Trasfondo trasfondo;
    private static Libro libro;
    private Pane panelPrincipal;
    @FXML
    private AnchorPane contenedor;
    @FXML
    private Label labelNombreRasgo;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private VBox vbox1;
    @FXML
    private ScrollPane scrollpaneRasgos;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AnchorPane.setTopAnchor(anchorPane, 0.0);
        AnchorPane.setBottomAnchor(anchorPane, 0.0);
        AnchorPane.setLeftAnchor(anchorPane, 0.0);
        AnchorPane.setRightAnchor(anchorPane, 0.0);
        vbox1.prefHeightProperty().bind(anchorPane.widthProperty());
        vboxHabilidades.prefHeightProperty().bind(anchorPane.widthProperty());
        //Se muestra la información de la dote seleccionada
        if(trasfondo!=null){
            try {
                ArrayList listaEspecialidades = new ArrayList();
                ArrayList listaRasgos = new ArrayList();
                ArrayList listaVinculos = new ArrayList();
                ArrayList listaIdeles = new ArrayList();
                ArrayList listaDefectos = new ArrayList();
                
                labelNombreTrasfondo.setText(trasfondo.getNombre());
                labelDescripcion.setText(trasfondo.getDescripcion());
                labelNombreEspecialidad.setText(trasfondo.getNombreEspecialidad());
                labelDescripcionEspecialidad.setText(trasfondo.getDescripcionEspecialidad());
                labelNombreRasgo.setText(trasfondo.getNombreRasgo());
                labelDescripcionRasgo.setText(trasfondo.getDescRasgo());
                labelDescripcionRasgos.setText(trasfondo.getDescCaracSug());
                labelNombreLibro.setText(libro.getNombre());
                
                String consultaEspecialidad = "Select * from especialidad where id_trasfondo="+trasfondo.getId_transfondo();
                String consultaRasgoPersonalidad = "Select * from rasgo_personalidad  where id_trasfondo="+trasfondo.getId_transfondo();
                String consultaVinculo = "Select * from vinculo  where id_trasfondo="+trasfondo.getId_transfondo();
                String consultaIdeal = "Select * from ideal where id_trasfondo="+trasfondo.getId_transfondo();
                String consultaDefectos = "Select * from defectos where id_trasfondo="+trasfondo.getId_transfondo();
                ResultSet rsEsp = Conector.getSelect(consultaEspecialidad, conector);
                ResultSet rsRasgo = Conector.getSelect(consultaRasgoPersonalidad, conector);
                ResultSet rsVinc = Conector.getSelect(consultaVinculo, conector);
                ResultSet rsIde = Conector.getSelect(consultaIdeal, conector);
                ResultSet rsDef = Conector.getSelect(consultaDefectos, conector);
                while(rsRasgo.next()){
                    listaRasgos.add(rsRasgo.getString("rasgo"));
                }
                while(rsVinc.next()){
                    listaVinculos.add(rsVinc.getString("vinculo"));
                }
                while(rsIde.next()){
                    listaIdeles.add(rsIde.getString("ideal"));
                }
                while(rsDef.next()){
                    listaDefectos.add(rsDef.getString("defecto"));
                }
                while(rsEsp.next()){
                    listaEspecialidades.add(rsEsp.getString("nombre_esp"));
                }
                int contador = 1;
                for(Object rasgo: listaRasgos){
                    Label nombre = new Label(contador+". "+rasgo.toString());
                    vboxRasgosPersonalidad.getChildren().add(nombre);
                    contador++;
                }
                contador = 1;
                for(Object vinculo: listaVinculos){
                    Label nombre = new Label(contador+". "+vinculo.toString());
                    vboxVinculos.getChildren().add(nombre);
                    contador++;
                }
                contador = 1;
                for(Object defecto: listaDefectos){
                    Label nombre = new Label(contador+". "+defecto.toString());
                    vboxDefectos.getChildren().add(nombre);
                    contador++;
                }
                contador = 1;
                for(Object ideal: listaIdeles){
                    Label nombre = new Label(contador+". "+ideal.toString());
                    vboxIdeales.getChildren().add(nombre);
                    contador++;
                }
                contador = 1;
                for(Object especialidad: listaEspecialidades){
                    Label nombre = new Label(contador+". "+especialidad.toString());
                    vboxExpecialidades.getChildren().add(nombre);
                    contador++;
                }
                
        
        } catch (SQLException ex) {
                System.out.println("Error consulta sql");
                ex.printStackTrace();
            }
        
        }
        
    }    

    public ExplorarTrasfondoController(){
        
    }
    
    public ExplorarTrasfondoController(Trasfondo trasfondo,Libro libro) {
        this.trasfondo = trasfondo;
        this.libro = libro;
    }
    /**
     * Regresa a la ventana de dotes
     * @param event 
     */
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
    
    public Trasfondo getTrasfondo(){
        return this.trasfondo;
    }
    
    public void setDote(Trasfondo trasfondo){
        System.out.println("setDote() "+trasfondo);
        System.out.println("this explorarDoteController: "+this);
        this.trasfondo = trasfondo;
        System.out.println("this.dote "+this.trasfondo);
    }  

    @FXML
    private void volverListadoTrasfondos(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("listaTrasfondos.fxml"));
            Parent root = fxml.load();
            contenedor.getChildren().setAll(root);
            ListaTrasfondosController dotes = fxml.getController();
            dotes.setPanePrincipal(contenedor);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void abrilCerralRasgoPersonalidad(MouseEvent event) {
        if(vboxRasgosPersonalidad.getLayoutY()==0){
            vboxRasgosPersonalidad.setLayoutY(Control.USE_PREF_SIZE);
        }
        else{
            vboxRasgosPersonalidad.setLayoutY(0);    
        }
        
    }

    @FXML
    private void abrilCerralIdeal(MouseEvent event) {
        if(vboxIdeales.getMinHeight()==0){
            vboxIdeales.setMinHeight(Control.USE_PREF_SIZE);
        }
        else{
            vboxIdeales.setMinHeight(0);    
        }
    }

    @FXML
    private void abrilCerralVinculo(MouseEvent event) {
    }

    @FXML
    private void abrilCerralDefecto(MouseEvent event) {
    }

    @FXML
    private void abrilCerralRasgo(MouseEvent event) {
    }

    @FXML
    private void abrilCerralEspecialidad(MouseEvent event) {
    }
    
}
