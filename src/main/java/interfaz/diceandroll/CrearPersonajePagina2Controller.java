/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.clases.Clase;
import interfaz.diceandroll.clases.Personaje;
import interfaz.diceandroll.clases.Raza;
import interfaz.diceandroll.conector.Conector;
import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.clases.Subraza;
import interfaz.diceandroll.clases.Trasfondo;
import interfaz.diceandroll.clases.Usuario;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class CrearPersonajePagina2Controller implements Initializable {

    @FXML
    private AnchorPane contenedor;
    @FXML
    private ImageView imagenPersonaje;
    @FXML
    private TextField textFieldNombrePersronaje;
    @FXML
    private ComboBox<Trasfondo> comboBoxTrasfondo;
    @FXML
    private TextField textFieldCompetenciasHabilidadesTrasfondo;
    @FXML
    private TextField textFieldCompetenciaEquipoTrasfondo;
    @FXML
    private TextArea textAreaRasgoPersonalidad;
    @FXML
    private TextArea textAreaIdeales;
    @FXML
    private TextArea TextareaVinculos;
    @FXML
    private TextArea TextAreaDefectos;
    ArrayList<Trasfondo> listaTrasfondos;
    @FXML
    private Button botonRetrocederUno;
    private Pane panelPrincipal;
    private static Personaje personaje;
    private static Clase clase;
    private static Raza raza;
    private static Subraza subraza;
    private ArrayList listaRasgosPersonalidad;
    private ArrayList listaVinculos;
    private ArrayList listaIdeales;
    private ArrayList listaEspecialidades;
    private ArrayList listaDefectos;
    private static Usuario usuario;
    
    private static Trasfondo trasfondo;
    @FXML
    private Button botonAvanzarUno;
    @FXML
    private Label labelNombreRasgo;
    @FXML
    private TextArea textFieldRasgo;
    private String texto;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaTrasfondos = new ArrayList();
        listaRasgosPersonalidad = new ArrayList();
        listaVinculos = new ArrayList();
        listaIdeales = new ArrayList();
        listaDefectos = new ArrayList();
        listaEspecialidades = new ArrayList();
        
        listaTrasfondos.add(null);
        try {
            if(personaje!=null){
                textFieldNombrePersronaje.setText(personaje.getNombre());
            }
            String consultaTrasfondo = "SELECT * FROM trasfondo";
            ResultSet rs = Conector.getSelect(consultaTrasfondo, conector);
            while(rs.next()){
                int idTrasfondo = rs.getInt("id_trasfondo");
                String nombreTrasfondo = rs.getString("nombre");
                String nombreRasgo = rs.getString("nombre_rasgo");
                String descRasgo = rs.getString("desc_rasgo");
                String comp1 = rs.getString("competencia1");
                String comp2 = rs.getString("competencia2");
                String compEquipo = rs.getString("otras_competencias");
                Trasfondo trasfondo = new Trasfondo(idTrasfondo,nombreTrasfondo, nombreRasgo, descRasgo, comp1, comp2, compEquipo);
                listaTrasfondos.add(trasfondo);
            }
            ObservableList<Trasfondo> listaComboBoxTrasfondos = FXCollections.observableArrayList(listaTrasfondos);
            comboBoxTrasfondo.setItems(listaComboBoxTrasfondos);
            if(trasfondo!=null){
                comboBoxTrasfondo.setValue(trasfondo);
                textFieldCompetenciasHabilidadesTrasfondo.setText(trasfondo.getCompetencia1());
                textFieldCompetenciaEquipoTrasfondo.setText(trasfondo.getOtrasCompetencias());
                textFieldRasgo.setText(trasfondo.getDescRasgo());
                textAreaRasgoPersonalidad.setText(trasfondo.getRasgoPersonalidad());
                textAreaIdeales.setText(trasfondo.getIdeales());
                TextareaVinculos.setText(trasfondo.getVinculos());
                TextAreaDefectos.setText(trasfondo.getDefectos());
            }
            //System.out.println(trasfondo);
        } catch (SQLException ex) {
            Logger.getLogger(CrearPersonajePagina2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public CrearPersonajePagina2Controller(){
        
    }
    
    public CrearPersonajePagina2Controller(Usuario usuario, Personaje personaje, Clase clase, Raza raza, Subraza subraza){
        this.usuario = usuario;
        this.personaje = personaje;
        this.clase = clase;
        this.raza = raza;
        this.subraza = subraza;
    }

    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }
    
    @FXML
    private void seleccionarTrasfondo(ActionEvent event) {
        Trasfondo trasfondo = comboBoxTrasfondo.getValue();
        if(trasfondo!=null){
            labelNombreRasgo.setText("Rasgo: "+trasfondo.getNombreRasgo());
            textFieldRasgo.setText(trasfondo.getDescRasgo());
            textFieldCompetenciasHabilidadesTrasfondo.setText(trasfondo.getCompetencia1()+", "+trasfondo.getCompetencia2());
            textFieldCompetenciaEquipoTrasfondo.setText(trasfondo.getOtrasCompetencias());
        }
        else{
            labelNombreRasgo.setText("");
            textFieldRasgo.setText("");
            textFieldCompetenciasHabilidadesTrasfondo.setText("");
            textFieldCompetenciaEquipoTrasfondo.setText("");
        }
        
    }
    
    
    
    @FXML
    private void botonVolver(ActionEvent event) {
        try{
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmación");
            confirmacion.setHeaderText("¿Estás seguro?");
            confirmacion.setContentText("Se perderán todos los datos no guardados");
            ButtonType respuesta = confirmacion.showAndWait().orElse(ButtonType.CANCEL);
            if(respuesta == ButtonType.OK){
                FXMLLoader fxml = new FXMLLoader(getClass().getResource("personajes.fxml"));
                Parent root = fxml.load();
                contenedor.getChildren().setAll(root);
                PersonajesController personajes = fxml.getController();
                personajes.init(usuario, contenedor);
                personaje=null;
                trasfondo=null;
                clase=null;
                raza=null;
                subraza=null;
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void abrirPagina1(Personaje personaje,Clase clase,Raza raza, Trasfondo trasfondo){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("crearPersonaje.fxml"));
            CrearPersonajeController personajes = new CrearPersonajeController(usuario,personaje,clase,raza,subraza,trasfondo);
            Parent root = fxmlLoader.load();
            personajes.setPanePrincipal(contenedor);
            fxmlLoader.setController(personajes); 
            contenedor.getChildren().setAll(root); 
//            System.out.println("Personaje: "+personaje);
//            System.out.println("Clase: "+clase);
//            System.out.println("Raza: "+raza);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void abrirPagina3(Personaje personaje,Clase clase,Raza raza,Subraza subraza, Trasfondo trasfondo){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("crearPersonajePagina3.fxml"));
            CrearPersonajePagina3Controller personajes = new CrearPersonajePagina3Controller(usuario,personaje,clase,raza,subraza,trasfondo);
            Parent root = fxmlLoader.load();
            personajes.setPanePrincipal(contenedor);
            fxmlLoader.setController(personajes); 
            contenedor.getChildren().setAll(root); 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void botonAvanzarPagina(ActionEvent event) {
        trasfondo = comboBoxTrasfondo.getValue();
        if(trasfondo!=null){
            trasfondo.setCompetencia1(textFieldCompetenciasHabilidadesTrasfondo.getText());
            trasfondo.setOtrasCompetencias(textFieldCompetenciaEquipoTrasfondo.getText());
            trasfondo.setDescRasgo(textFieldRasgo.getText());
            trasfondo.setRasgoPersonalidad(textAreaRasgoPersonalidad.getText());
            trasfondo.setVinculos(TextareaVinculos.getText());
            trasfondo.setIdeales(textAreaIdeales.getText());
            trasfondo.setDefectos(TextAreaDefectos.getText());
        }
        else{
            trasfondo = new Trasfondo();
        }
        abrirPagina3(personaje, clase, raza, subraza, trasfondo);
    }

    @FXML
    private void botonVolverPagina(ActionEvent event) {
        trasfondo = comboBoxTrasfondo.getValue();
        if(trasfondo!=null){
            trasfondo.setCompetencia1(textFieldCompetenciasHabilidadesTrasfondo.getText());
            trasfondo.setOtrasCompetencias(textFieldCompetenciaEquipoTrasfondo.getText());
            trasfondo.setDescRasgo(textFieldRasgo.getText());
            trasfondo.setRasgoPersonalidad(textAreaRasgoPersonalidad.getText());
            trasfondo.setVinculos(TextareaVinculos.getText());
            trasfondo.setIdeales(textAreaIdeales.getText());
            trasfondo.setDefectos(TextAreaDefectos.getText());
        }
        abrirPagina1(personaje, clase, raza, trasfondo);
    }

    private void rellenarRasgos(ActionEvent event) {
        Trasfondo trasfondo = comboBoxTrasfondo.getValue();
        ArrayList listaPersonalidad = new ArrayList();
        ArrayList listaVinculos = new ArrayList();
        ArrayList listaIdeales = new ArrayList();
        ArrayList listaDefectos = new ArrayList();
        ArrayList listaEspecialidad = new ArrayList();
    }

    @FXML
    private void abrirPaneElegirRasgos(MouseEvent event) {
        try {
            TextArea textAreaPulsado = (TextArea) event.getSource();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("elegirRasgo.fxml"));
            Pane pane = loader.load();
            ElegirRasgoController elegirRasgoController = loader.getController();
            Stage stage = new Stage();
            Scene scene = new Scene(pane);
            String nombreRasgo="";
            int dado=0;            
            if(comboBoxTrasfondo.getValue()!=null){
                if(textAreaPulsado.equals(textAreaRasgoPersonalidad)){
                    nombreRasgo="Rasgos de personalidad";
                    dado=8;
                    String consultaRasgoPersonalidad = "SELECT * FROM rasgo_personalidad where id_trasfondo= "+comboBoxTrasfondo.getValue().getId_transfondo();
                    System.out.println(consultaRasgoPersonalidad);
                    ResultSet rsRasgoPersonalidad = Conector.getSelect(consultaRasgoPersonalidad, conector);
                    while(rsRasgoPersonalidad.next()){
                        String rasgo = rsRasgoPersonalidad.getString("rasgo");
                        listaRasgosPersonalidad.add(rasgo);
                    }
                    elegirRasgoController.setLista(listaRasgosPersonalidad);
                    listaRasgosPersonalidad.clear();
                }
                if(textAreaPulsado.equals(TextareaVinculos)){
                    nombreRasgo="Vínculos";
                    dado=6;
                    String consultaVinculos = "SELECT * FROM vinculo where id_trasfondo= "+comboBoxTrasfondo.getValue().getId_transfondo();
                    ResultSet rsVinculo = Conector.getSelect(consultaVinculos, conector);
                    while(rsVinculo.next()){
                        String vinculo = rsVinculo.getString("vinculo");
                        listaVinculos.add(vinculo);
                    }
                    elegirRasgoController.setLista(listaVinculos);
                    listaVinculos.clear();
                }
                if(textAreaPulsado.equals(textAreaIdeales)){
                    nombreRasgo="Ideales";
                    dado=6;
                    String consultaIdeal = "SELECT * FROM ideal where id_trasfondo= "+comboBoxTrasfondo.getValue().getId_transfondo();
                    ResultSet rsIdeal = Conector.getSelect(consultaIdeal, conector);
                    while(rsIdeal.next()){
                        String ideal = rsIdeal.getString("ideal");
                        listaIdeales.add(ideal);
                    }
                    elegirRasgoController.setLista(listaIdeales);
                    listaIdeales.clear();
                }
                if(textAreaPulsado.equals(TextAreaDefectos)){
                    nombreRasgo="Defectos";
                    dado=6;
                    String consultaDefectos = "SELECT * FROM defectos where id_trasfondo= "+comboBoxTrasfondo.getValue().getId_transfondo();
                    ResultSet rsDefectos = Conector.getSelect(consultaDefectos, conector);
                    while(rsDefectos.next()){
                        String defecto = rsDefectos.getString("defecto");
                        listaDefectos.add(defecto);
                    }
                    elegirRasgoController.setLista(listaDefectos);
                    listaDefectos.clear();
                }
            }
            if(comboBoxTrasfondo.getValue()!=null){
                elegirRasgoController.setNombreRasgo(nombreRasgo);
                elegirRasgoController.setDado(dado);
                elegirRasgoController.setTrasfondo(comboBoxTrasfondo.getValue());
                elegirRasgoController.setTextoTextArea(textAreaPulsado.getText());
            }
            else{
                elegirRasgoController.setNombreRasgo("Personalizado");
                elegirRasgoController.setTrasfondo(null);
                elegirRasgoController.setTextoTextArea(textAreaPulsado.getText());
                elegirRasgoController.setInvisible();
                
            }
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            texto= elegirRasgoController.getTexto();
            textAreaPulsado.setText(texto);
        } catch (IOException ex) {
            System.out.println("Error al cargar el panel");
            ex.printStackTrace();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
       
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    
}
