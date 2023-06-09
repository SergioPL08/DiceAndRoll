/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.clases.Clase;
import interfaz.diceandroll.clases.Habilidad;
import interfaz.diceandroll.clases.Personaje;
import interfaz.diceandroll.conector.Conector;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class RasgosPersonajeController implements Initializable {

    @FXML
    private VBox vboxHabilidades;
    @FXML
    private VBox vboxRasgosClase;
    @FXML
    private Label labelRasgosEspeciales;
    @FXML
    private VBox vboxRasgosEleccion;
    @FXML
    private VBox vboxSubclases;
    private Pane panelPrincipal;
    private static Clase clase;
    private static Personaje personaje;
    private ArrayList<Habilidad> listaHabilidadesClase;
    private ArrayList<Habilidad> listaHabilidadesEspeciales;
    private ArrayList<Habilidad> listaTodasHabilidades;
    private Habilidad hab;
    private static FichaPersonajeController fichaPersonaje;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaHabilidadesClase = new ArrayList();
        listaHabilidadesEspeciales = new ArrayList();
        listaTodasHabilidades = new ArrayList();
        rellenaHabilidades();
    }    

    public RasgosPersonajeController() {
    }
    
    public RasgosPersonajeController(Clase clase, Personaje personaje) {
        this.clase=clase;
        this.personaje=personaje;        
    }
    
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }
    
    private void rellenaHabilidades(){
        try {
            listaHabilidadesClase = new ArrayList();
            listaHabilidadesEspeciales = new ArrayList();
            listaTodasHabilidades = new ArrayList();
            String consulta = "SELECT hc.*\n" +
                "FROM habilidad_clase hc\n" +
                "LEFT JOIN habilidades_clase_seleccionadas hcs ON hc.id_habilidad = hcs.id_habilidad\n" +
                "WHERE hc.id_clase = "+clase.getIdClase()+"\n" +
                "  AND hc.nivel <= "+personaje.getNivel()+"\n" +
                "  AND (hc.adquisicion = \"automatico\" OR (hc.adquisicion = \"seleccion\" AND hcs.id_personaje = "+personaje.getIdPersonaje()+"))\n" +
                "ORDER BY hc.nivel, hc.nombre;";
            ResultSet rs = Conector.getSelect(consulta, conector);
            while(rs.next()){
                //(int idHabilidad, String nombre, String descripcion, String adquisicion, String descCorta, String stat1, String stat2, int nivel, int bonoStat1, int bonoStat2
                int idHabilidad = rs.getInt("id_habilidad");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String adquisicion = rs.getString("adquisicion");
                String descCorta = rs.getString("descripcion_corta");
                String stat1 = rs.getString("caracteristica1");
                String stat2 = rs.getString("caracteristica2");
                int nivel = rs.getInt("nivel");
                int bonoStat1 = rs.getInt("bono_caracteristica1");
                int bonoStat2 = rs.getInt("bono_caracteristica2");
                hab = new Habilidad(idHabilidad, nombre, descripcion, adquisicion, descCorta, stat1, stat2, nivel, bonoStat1, bonoStat2);
                if(adquisicion.equals("automatico")){
                    listaHabilidadesClase.add(hab);
                    listaTodasHabilidades.add(hab);
                }
                else{
                    listaHabilidadesEspeciales.add(hab);
                    listaTodasHabilidades.add(hab);
                }
            }
            for(Habilidad hab: listaTodasHabilidades){
                Label nombre = new Label(hab.getNombre());
                HBox hbox = new HBox();
                hbox.getChildren().addAll(nombre);
                hbox.setHgrow(hbox, Priority.ALWAYS);
                hbox.setStyle("-fx-background-color: #");
                if(hab.getAdquisicion().equals("automatico")){
                    vboxRasgosClase.getChildren().add(hbox);
                    vboxRasgosClase.setAlignment(Pos.TOP_LEFT);
                }
                else{
                    vboxRasgosEleccion.getChildren().add(hbox);
                    vboxRasgosEleccion.setAlignment(Pos.TOP_LEFT);
                }
                HBox.setHgrow(nombre, Priority.ALWAYS);
                hbox.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        String nombre = hab.getNombre();
                        String html = 
                            "<html>"
                                + "<head>"
                                    + "<style>"
                                        + "body{font-family: Calibri; font-size: 14px;}"
                                    + "</style>"
                                + "</head>" 
                                + "</body>"
                                + hab.getDescripcion()
                                +"</body>";
                        fichaPersonaje.abrirVistaDetallada(nombre, html);
                    }
                });
            }
            if(listaHabilidadesEspeciales.isEmpty()){
                labelRasgosEspeciales.setManaged(false);
            }
        } catch (SQLException ex) {
            System.out.println("Error al rellenar las habilidades");
            ex.printStackTrace();
        }
    }
    
    public void setClase(Clase clase){
        this.clase=clase;
    }

    public void setFichaPersonajeController(FichaPersonajeController fichaPersonaje) {
        this.fichaPersonaje = fichaPersonaje;
    }
}
