/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.conector.Conector;
import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.clases.Habilidad;
import interfaz.diceandroll.clases.Libro;
import interfaz.diceandroll.clases.Razas;
import interfaz.diceandroll.conector.Conector;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class ExplorarRazaController implements Initializable {
    public static Razas raza;
    public static Libro libro;
    public static Image icon;
    @FXML
    private AnchorPane contenedor;
    private Pane panelPrincipal;
    @FXML
    private Label labelNombreRaza;
    @FXML
    private ImageView imagenClase;
    @FXML
    private Label labelDescripcion;
    @FXML
    private VBox vboxSubrazas;
    @FXML
    private Label labelNombreLibro;
    @FXML
    private Label labelVelocidad;
    @FXML
    private VBox vboxCompetenciasMods;
    @FXML
    private Label labelTextoTal;
    @FXML
    private HBox hbox;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int contador=0;
        ArrayList<Habilidad> habilidades = new ArrayList();
        labelNombreRaza.setText(raza.getNombre());
        labelDescripcion.setText(raza.getDescripcion());
        labelVelocidad.setText(raza.getVelocidad());
        labelTextoTal.setText("Los personajes "+raza.getNombre()+" tienen los siguientes rasgos:");
        labelNombreLibro.setText(libro.getNombre());
        String consultaRasgosRaza="SELECT * FROM rasgo_raza where id_raza="+raza.getIdRaza();
        ResultSet rs =  Conector.getSelect(consultaRasgosRaza, conector);
        try {
            while(rs.next()){
                String nombreHabilidadRaza = rs.getString("nombre");
                String descCorta = rs.getString("descripcion_corta");
                String descripcion = rs.getString("descripcion");
                Habilidad habilidad = new Habilidad(nombreHabilidadRaza,descripcion,descCorta);
                habilidades.add(habilidad);
            }
            for(Habilidad habilidad: habilidades){
                final int indice = contador;
                Label nombreTal = new Label(habilidades.get(contador).getNombre()+".");
                
               
                WebView descripcionCual = new WebView();
                descripcionCual.getEngine().loadContent(habilidades.get(contador).getDescripcion(),"text/html");
                System.out.println(habilidades.get(contador).getDescripcion());
                nombreTal.setMinHeight(Control.USE_PREF_SIZE);
                nombreTal.setMinWidth(Control.USE_PREF_SIZE);
                nombreTal.setMaxHeight(Control.USE_COMPUTED_SIZE);
                nombreTal.setMaxWidth(Control.USE_COMPUTED_SIZE);
                nombreTal.setWrapText(true);
                nombreTal.setTextAlignment(TextAlignment.LEFT);
                nombreTal.setStyle("-fx-font-weight: bold");
                //descripcionCual.setMinHeight(Control.USE_PREF_SIZE);
                //descripcionCual.setMinWidth(Control.USE_PREF_SIZE);
                //descripcionCual.setMaxHeight(Control.USE_COMPUTED_SIZE);
                //descripcionCual.setMaxWidth(Control.USE_COMPUTED_SIZE);
                //descripcionCual.setWrapText(true);
                //descripcionCual.setTextAlignment(TextAlignment.LEFT);
                vboxCompetenciasMods.getChildren().add(nombreTal);
                vboxCompetenciasMods.getChildren().add(descripcionCual);
                contador++;
                
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener rasgos de raza");
            ex.printStackTrace();
        }
    }    
    
    /*
    pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Stage ventanaEmergente = new Stage();
            VBox vboxDetalle = new VBox();
            Label labellNombre = new Label(habilidades.get(indice).getNombre());
            labellNombre.setStyle("-fx-text-fill: #3583F2");
            Label labelDescripcion = new Label(habilidades.get(indice).getDescripcion());
            labelDescripcion.setWrapText(true);
            labelDescripcion.setMaxWidth(Double.MAX_VALUE);
            labelDescripcion.setPrefWidth(500);
            ScrollPane sp = new ScrollPane();
            vboxDetalle.getChildren().addAll(labellNombre, labelDescripcion);
            sp.setContent(vboxDetalle);
            Scene scene = new Scene(sp, 500, 600);
            scene.getStylesheets().add("style.css");
            ventanaEmergente.setScene(scene);
            ventanaEmergente.show();
        }
    });
    */
    
    public ExplorarRazaController(Razas raza, Libro libro, Image icon){
        this.raza=raza;
        this.libro=libro;
        this.icon=icon;
    }
    public ExplorarRazaController(Razas raza, Libro libro){
        this.raza=raza;
        this.libro=libro;
    }
    
    public ExplorarRazaController(){
        
    }
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }
}
