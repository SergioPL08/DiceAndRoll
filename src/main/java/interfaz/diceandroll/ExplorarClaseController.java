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
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
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
    private static Clases clase;
    private static Libro libro;
    private Pane panelPrincipal;
    private static Image imagen;
    @FXML
    private Label labelCompetenciaHerramientas;
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String consultaCompetenciaArmas = "SELECT * FROM competencia_armas_clase "
                + "INNER JOIN armas_base ON armas_base.id_arma = competencia_armas_clase.id_arma "
                + "WHERE id_clase = "+clase.getIdClase();
        ResultSet rs = Conector.getSelect(consultaCompetenciaArmas, conector);
        ArrayList armasCompetente = new ArrayList();
        String consultaCompetenciaEquipo = "SELECT * FROM competencias_equipo_clase "
                + "INNER JOIN herramientas_base ON herramientas_base.id_herramienta = id_equipo "
                + "WHERE id_clase = "+clase.getIdClase();
        ResultSet rs2 = Conector.getSelect(consultaCompetenciaEquipo, conector);
        ArrayList equipoCompetente = new ArrayList();
        if(clase.isCompetenciaArmasSencillas())
           armasCompetente.add("Armas simples");
        if(clase.isCompetenciaArmasMarciales())
           armasCompetente.add("Armas marciales");
        try {
            if(rs!=null){
                while(rs.next()){
                    armasCompetente.add(rs.getString("nombre"));
                }
            }
            if(rs2!=null){
                while(rs2.next()){
                    equipoCompetente.add(rs2.getString("nombre"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar las competencias con armas");
            ex.printStackTrace();
        }
        labelNombreClase.setText(clase.getNombre());
        labelDescripcion.setText(clase.getDescripcion());
        labelNombreLibro.setText(libro.getNombre());
        labelPuntosDeGolpe.setText("1d"+clase.getPuntosGolpe());
        labelRequisitosMulticlase.setText(clase.getRequisitoMulticlase());
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
        List<String> ListCompetenciaArmas = armasCompetente;
        labelCompetenciaArmas.setText(String.join(", ",ListCompetenciaArmas));
        List<String> ListCompetenciaEquipo = equipoCompetente;
        labelCompetenciaHerramientas.setText(String.join(", ",ListCompetenciaEquipo));
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

    @FXML
    private void volverListadoDotes(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("listaClases.fxml"));
            Parent root = fxml.load();
            contenedor.getChildren().setAll(root);
            ListaClasesController dotes = fxml.getController();
            dotes.setPanePrincipal(contenedor);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
