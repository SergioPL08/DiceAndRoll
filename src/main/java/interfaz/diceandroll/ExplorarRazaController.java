/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.conector.Conector;
import interfaz.diceandroll.clases.Habilidad;
import interfaz.diceandroll.clases.Libro;
import interfaz.diceandroll.clases.Raza;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class ExplorarRazaController implements Initializable {
    public static Raza raza;
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
    private Label labelTextoTal;
    @FXML
    private AnchorPane competenciasHabilidades;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int contador=0;
        ArrayList<Habilidad> habilidades = new ArrayList();
        labelNombreRaza.setText(raza.getNombre());
        labelDescripcion.setText(raza.getDescripcion());
        labelVelocidad.setText(String.valueOf(raza.getVelocidad())+" pies");
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
            String html = 
                    "<html>"
                        + "<head>"
                            + "<style>"
                                + "body{font-family: Calibri; font-size: 14px;}"
                            + "</style>"
                        + "</head>" 
                        + "</body>";
            for(Habilidad habilidad: habilidades){
                html+="<strong>"+habilidades.get(contador).getNombre()+".</strong>\n"+habilidades.get(contador).getDescripcion()+"<br>";
                contador++;
            }
            html+="</body>";
                WebView webView = new WebView();
                WebEngine webEngine = webView.getEngine();
                webEngine.loadContent(html);
                webView.setStyle("-fx-padding-right: 10px;");
                competenciasHabilidades.getChildren().add(webView);
//                
                
            
                
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener rasgos de raza");
            ex.printStackTrace();
        }
    }
    
    public ExplorarRazaController(Raza raza, Libro libro, Image icon){
        this.raza=raza;
        this.libro=libro;
        this.icon=icon;
    }
    public ExplorarRazaController(Raza raza, Libro libro){
        this.raza=raza;
        this.libro=libro;
    }
    
    public ExplorarRazaController(){
        
    }
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }
}
