/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.clases.Conjuro;
import interfaz.diceandroll.conector.Conector;
import interfaz.diceandroll.clases.Personaje;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class ConjurosPersonajeController implements Initializable {
    private static FichaPersonajeController fichaPersonaje;
    private static Personaje personaje;
    private Pane panelPrincipal;
    ArrayList<Conjuro> listaConjuros;
    @FXML
    private TextField textFieldBuscador;
    @FXML
    private VBox vboxListaConjuros;
    @FXML
    private Label labelCaracMag;
    @FXML
    private Label labelCD;
    @FXML
    private Label LabelBonoAtq;
    @FXML
    private Label labelConjurosConocidos;
    @FXML
    private HBox hboxEspaciosConjuros;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaConjuros = new ArrayList();
        String consultaConjurosPersonaje = "SELECT * FROM lista_conjuros_personaje "
                + "INNER JOIN conjuro ON lista_conjuros_personaje.id_conjuro=conjuro.id_conjuro "
                + "WHERE id_personaje = "+personaje.getIdPersonaje()+" ORDER BY nivel, nombre, escuela";
        ResultSet conjuros = Conector.getSelect(consultaConjurosPersonaje, conector);
        try{
            while(conjuros.next()){
                int idConjuro = conjuros.getInt("id_conjuro");
                String nombre = conjuros.getString("conjuro.nombre");
                int nivel = conjuros.getInt("conjuro.nivel");
                String escuela = conjuros.getString("conjuro.escuela");
                boolean compVerbal = conjuros.getBoolean("conjuro.v");
                boolean compSomatico = conjuros.getBoolean("conjuro.s");
                boolean compMaterial = conjuros.getBoolean("conjuro.m");
                String textCompMaterial = conjuros.getString("conjuro.texto_componente_material");
                String tiempoLanzamiento = conjuros.getString("conjuro.tiempo_lanzamiento");
                String alcance = conjuros.getString("conjuro.alcance");
                String duracion = conjuros.getString("conjuro.duracion");
                String descripcion = conjuros.getString("conjuro.descripcion");
                int idLibro = conjuros.getInt("conjuro.id_libro");
                interfaz.diceandroll.clases.Conjuro conjuro = new Conjuro(idConjuro,nombre,nivel,escuela,compVerbal,compSomatico,compMaterial,textCompMaterial,tiempoLanzamiento,alcance,duracion,descripcion,idLibro);
                listaConjuros.add(conjuro);
            }
            for(Conjuro conjuro:listaConjuros){
                Label nombreConjuro = new Label(conjuro.getNombre());
                HBox hbox = new HBox();
                hbox.getChildren().add(nombreConjuro);
                vboxListaConjuros.getChildren().add(hbox);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }    

    public ConjurosPersonajeController() {
    }
    
    
    public ConjurosPersonajeController(Personaje personaje) {
        this.personaje=personaje;
    }
    
    
    
    public void setFichaPersonajeController(FichaPersonajeController fichaPersonaje) {
        this.fichaPersonaje = fichaPersonaje;
    }
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }

    @FXML
    private void botonAplicarFiltro(ActionEvent event) {
    }

    @FXML
    private void botonGestionarConjuros(ActionEvent event) {
    }
}
