/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.clases.Clases;
import interfaz.diceandroll.clases.Libro;
import interfaz.diceandroll.clases.Habilidad;
import interfaz.diceandroll.conector.Conector;
import static interfaz.diceandroll.App.conector;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class ExplorarClaseController implements Initializable {
    private static Clases clase;
    private static Libro libro;
    private Pane panelPrincipal;
    private static Image imagen;
    @FXML
    private AnchorPane contenedor;
    @FXML
    private Label labelDescripcion;
    @FXML
    private ImageView imagenClase;
    @FXML
    private Label labelNombreLibro;
    @FXML
    private Label labelRequisitosMulticlase;
    @FXML
    private Label labelPuntosDeGolpe;
    @FXML
    private Label labelCompetenciaArmaduras;
    @FXML
    private Label labelCompetenciaArmas;
    @FXML
    private Label labelCompetenciaHabilidades;
    @FXML
    private Label labelCompetenciaTiradasSalvacion;
    @FXML
    private Label labelCompetenciaEquipo;
    @FXML
    private Label labelNombreClase;
    Habilidad hab;
    ArrayList<Habilidad> listaHabilidades;
    @FXML
    private VBox vboxHabilidades;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelNombreClase.setText(clase.getNombre());
        labelDescripcion.setText(clase.getDescripcion());
        labelNombreLibro.setText(libro.getNombre());
        labelPuntosDeGolpe.setText("1d"+clase.getPuntosGolpe());
        labelRequisitosMulticlase.setText(clase.getRequisitoMulticlase());
        String competenciaArmas = "";
        List<String> competencias = new ArrayList();
        if(clase.isCompetenciaArmadurasLigeras())
            competencias.add("Armaduras ligeras");
        if(clase.isCompetenciaArmadurasMedias())
            competencias.add("Armaduras intermedias");
        if(clase.isCompetenciaArmadurasPesadas())
            competencias.add("Armaduras pesadas");
        if(clase.isCompetenciaEscudo())
            competencias.add("Escudo");
        labelCompetenciaArmaduras.setText(String.join(", ", competencias));
        if(clase.isCompetenciaArmasSencillas())
            competenciaArmas += "Armas simples";
        if(clase.isCompetenciaArmasMarciales())
            competenciaArmas += ", Armas marciales";
        if(clase.getOtrasCompetenciasArmas()!=null)
            competenciaArmas += clase.getOtrasCompetenciasArmas();
        labelCompetenciaArmas.setText(competenciaArmas);
        labelCompetenciaHabilidades.setText(clase.getTextoCompetenciasHabilidades());
        String compTS="";
        System.out.println(clase.getCompetenciaEstat1());
        System.out.println(clase.getCompetenciaEstat2());
        if(clase.getCompetenciaEstat1()!=null)
            compTS+=clase.getCompetenciaEstat1();
        if(clase.getCompetenciaEstat2()!=null)
            compTS+=clase.getCompetenciaEstat2();
        labelCompetenciaTiradasSalvacion.setText(compTS);
        if(clase.getOtrasCompetencias()!=null)
            labelCompetenciaEquipo.setText(clase.getOtrasCompetencias());
        imagenClase.setImage(imagen);
        rellenaHabilidades();

    }
    
    public ExplorarClaseController(){
        
    }
    
    public ExplorarClaseController(Clases clase,Libro libro,Image imagen) {
        this.clase = clase;
        this.libro = libro;
        this.imagen = imagen;
    }
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }
    
    
    private void rellenaHabilidades(){
        try {
            listaHabilidades = new ArrayList();
            String consulta = "SELECT * FROM habilidad_clase WHERE id_clase = "+clase.getIdClase()+" ORDER BY adquisicion,nivel,nombre";
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
                listaHabilidades.add(hab);
            }
            for(Habilidad hab: listaHabilidades){
                Label nombre = new Label(hab.getNombre());
                Label nivel = new Label("Nivel "+hab.getNivel());
                HBox hbox = new HBox();
                Pane separacion = new Pane();
                nombre.setMinWidth(Control.USE_PREF_SIZE);
                nombre.setPadding(new Insets(5,5,5,5));
                nivel.setMinWidth(Control.USE_PREF_SIZE);
                nivel.setTextAlignment(TextAlignment.RIGHT);
                nivel.setPadding(new Insets(5,5,5,5));
                separacion.setMinWidth(Control.USE_PREF_SIZE);
                hbox.getChildren().addAll(nombre,separacion,nivel);
                hbox.setHgrow(hbox, Priority.ALWAYS);
                hbox.setStyle("-fx-background-color: #");
                vboxHabilidades.getChildren().add(hbox);
                vboxHabilidades.setAlignment(Pos.TOP_LEFT);
                HBox.setHgrow(nombre, Priority.ALWAYS);
                HBox.setHgrow(separacion, Priority.ALWAYS);   
                hbox.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        Stage ventanaEmergente = new Stage();
                        VBox vboxDetalle = new VBox();
                        Label labellNombre = new Label(hab.getNombre());
                        labellNombre.setStyle("-fx-text-fill: #3583F2");
                        Label labelDescripcion = new Label(hab.getDescripcion());
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
            }
        } catch (SQLException ex) {
            System.out.println("Error al rellenar las habilidades");
            ex.printStackTrace();
        }
    }
}
