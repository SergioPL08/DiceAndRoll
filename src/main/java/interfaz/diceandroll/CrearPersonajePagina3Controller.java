/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.clases.Clase;
import interfaz.diceandroll.clases.Personaje;
import interfaz.diceandroll.clases.Raza;
import interfaz.diceandroll.clases.Subraza;
import interfaz.diceandroll.clases.Trasfondo;
import interfaz.diceandroll.clases.Usuario;
import interfaz.diceandroll.conector.Conector;
import static interfaz.diceandroll.App.conector;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class CrearPersonajePagina3Controller implements Initializable {

    @FXML
    private AnchorPane contenedor;
    @FXML
    private ImageView imagenPersonaje;
    @FXML
    private TextField textFieldNombrePersronaje;
    @FXML
    private ComboBox<String> comboBoxAlineamiento;
    @FXML
    private TextField textFieldApariencia;
    @FXML
    private TextField textFieldEdad;
    @FXML
    private TextField textFieldIdiomas;
    @FXML
    private TextArea textAreaHistoria;
    private Pane panelPrincipal;
    @FXML
    private Button botonRetrocederUno;
    @FXML
    private Button botonAvanzarUno;
    private static Personaje personaje;
    private static Clase clase;
    private static Raza raza;
    private static Subraza subraza;
    private static Trasfondo trasfondo;
    private static Trasfondo trasfondo2;
    private static Usuario usuario;
    @FXML
    private Label labelMensajeError;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(personaje!=null){
            textFieldNombrePersronaje.setText(personaje.getNombre());
        }
        System.out.println(trasfondo);
        ArrayList<String> listaAlineamientos = new ArrayList();
        listaAlineamientos.add("Legal bueno");
        listaAlineamientos.add("Neutral bueno");
        listaAlineamientos.add("Caótico bueno");
        listaAlineamientos.add("Legal neutral");
        listaAlineamientos.add("Neutral");
        listaAlineamientos.add("Caótico neutral");
        listaAlineamientos.add("Legal maligno");
        listaAlineamientos.add("Neutral maligno");
        listaAlineamientos.add("Caótico maligno");        
        ObservableList<String> listaComboBoxAlineamientos = FXCollections.observableArrayList(listaAlineamientos);
        comboBoxAlineamiento.setItems(listaComboBoxAlineamientos);
        if (trasfondo2 != null) {
            comboBoxAlineamiento.setValue(trasfondo2.getAlineamiento());
            textFieldApariencia.setText(trasfondo2.getApariencia());
            textFieldEdad.setText(trasfondo2.getEdad());
            textFieldIdiomas.setText(trasfondo2.getIdiomas());
            textAreaHistoria.setText(trasfondo2.getHistoria());
        }
        
    }    

    public CrearPersonajePagina3Controller(){
        
    }
    public CrearPersonajePagina3Controller(Usuario usuario, Personaje personaje, Clase clase, Raza raza, Subraza subraza,Trasfondo trasfondo){
        this.usuario=usuario;
        this.personaje=personaje;
        this.clase=clase;
        this.raza=raza;
        this.subraza=subraza;
        this.trasfondo=trasfondo;
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
                clase=null;
                trasfondo=null;
                raza=null;
                subraza=null;
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    private void abrirPagina(Personaje personaje,Clase clase,Raza raza, Subraza subraza, Trasfondo trasfondo){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("crearPersonajePagina2.fxml"));            
            CrearPersonajePagina2Controller personajes = new CrearPersonajePagina2Controller(usuario,personaje,clase,raza,subraza);
            Parent root = fxmlLoader.load();
            personajes.setPanePrincipal(contenedor);
            fxmlLoader.setController(personajes); 
            contenedor.getChildren().setAll(root); 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    private void botonVolverPagina(ActionEvent event) {
        trasfondo2 = new Trasfondo();
        trasfondo2.setAlineamiento(comboBoxAlineamiento.getValue());
        trasfondo2.setApariencia(textFieldApariencia.getText());
        trasfondo2.setEdad(textFieldEdad.getText());
        trasfondo2.setIdiomas(textFieldIdiomas.getText());
        trasfondo2.setHistoria(textAreaHistoria.getText());
        
        abrirPagina(personaje, clase, raza, subraza, trasfondo);
    }
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }

    @FXML
    private void botonCrearPersonaje(ActionEvent event) {
        trasfondo2 = new Trasfondo();
        trasfondo2.setAlineamiento(comboBoxAlineamiento.getValue());
        trasfondo2.setApariencia(textFieldApariencia.getText());
        trasfondo2.setEdad(textFieldEdad.getText());
        trasfondo2.setIdiomas(textFieldIdiomas.getText());
        trasfondo2.setHistoria(textAreaHistoria.getText());
        if(personaje.getNombre().equals("")){
            labelMensajeError.setText("Introduce el nombre del personaje");
        }
        try {
            conector.setAutoCommit(false);
            String insertPersonaje = "INSERT INTO personaje "
                    + "(nombre,puntos_de_golpe_maximos,puntos_de_golpe_actuales,iniciativa,velocidad,ca,competencia,fue,des,con,inte,sab,car,raza,usuario) "
                    + "VALUES('"+personaje.getNombre()+"',"+(clase.getPuntosGolpe()+(personaje.getCon()-10)/2)+","+(clase.getPuntosGolpe()+(personaje.getCon()-10)/2)+","+personaje.getDes()+",'"+raza.getVelocidad()+"',10,2"
                    + ","+personaje.getFue()+","+personaje.getDes()+","+personaje.getCon()+","+personaje.getInte()+","+personaje.getSab()+","+personaje.getCar()
                    + ","+raza.getIdRaza()+","+usuario.getIdUsuario()+")";
            String consultaIdPersonaje = "SELECT AUTO_INCREMENT AS id_personaje FROM INFORMATION_SCHEMA.TABLES \n" +
                "WHERE TABLE_SCHEMA = 'alu_sergio_dungeon' \n" +
                "AND TABLE_NAME = 'personaje'";
            ResultSet rs = Conector.getSelect(consultaIdPersonaje, conector);
            int idPersonaje = -1;
            if(rs.next())
                idPersonaje = rs.getInt("id_personaje");
            else
                throw new SQLException();
            String insertClase = "INSERT INTO clase_personaje "
                + "(id_personaje,id_clase,nivel_clase) VALUES ("+idPersonaje+","+clase.getIdClase()+",1)";
            Conector.insertTable(insertPersonaje, conector);
            Conector.insertTable(insertClase, conector);
            conector.commit();
            labelMensajeError.setStyle("-fx-text-fill: #00BF63");
            labelMensajeError.setText("Personaje creado correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                conector.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace();
            }
        }
        
        
    }

}
