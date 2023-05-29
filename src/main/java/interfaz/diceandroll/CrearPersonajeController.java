/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.clases.Clase;
import interfaz.diceandroll.clases.Raza;
import interfaz.diceandroll.clases.Subraza;
import interfaz.diceandroll.conector.Conector;
import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.PersonajesController;
import interfaz.diceandroll.clases.Personaje;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class CrearPersonajeController implements Initializable {

    @FXML
    private AnchorPane contenedor;
    Pane panelPrincipal;
    @FXML
    private ImageView imagenPersonaje;
    @FXML
    private Button botonRetrocederUno;
    @FXML
    private Button botonAvanzarUno;
    @FXML
    private TextField textFieldNombrePersronaje;
    @FXML
    private ComboBox<Clase> comboBoxClase;
    @FXML
    private ComboBox<Raza> comboBoxRaza;
    @FXML
    private ComboBox<Subraza> comboBoxSubraza;
    ArrayList<Clase> listaClases;
    ArrayList<Raza> listaRazas;
    ArrayList<Subraza> listaSubrazas;
    ArrayList<Button> listaBotonesRestar;
    ArrayList<Button> listaBotonesSumar;
    ArrayList<Label> listaValoresCaracteristicas;
    ArrayList<Label> listaModCaracteristicas;
    private int ID_CLASE_VALOR_POR_DEFECTO = 7;
    private String NOMBRE_CLASE_VALOR_POR_DEFECTO = "Guerrero";
    private int ID_RAZA_VALOR_POR_DEFECTO = 6;
    private String NOMBRE_RAZA_VALOR_POR_DEFECTO = "Humano";
    @FXML
    private Label labelValorFue;
    @FXML
    private Label labelValorDes;
    @FXML
    private Label labelValorCon;
    @FXML
    private Label labelValorInt;
    @FXML
    private Label labelValorSab;
    @FXML
    private Label labelValorCar;
    @FXML
    private Label labelModFue;
    @FXML
    private Label labelModDes;
    @FXML
    private Label labelModCon;
    @FXML
    private Label labelModInt;
    @FXML
    private Label labelModSab;
    @FXML
    private Label labelModCar;
    @FXML
    private Label labelTotal;
    @FXML
    private Button botonRestar1;
    @FXML
    private Button botonRestar2;
    @FXML
    private Button botonRestar3;
    @FXML
    private Button botonRestar4;
    @FXML
    private Button botonRestar5;
    @FXML
    private Button botonRestar6;
    @FXML
    private Button botonSumar1;
    @FXML
    private Button botonSumar2;
    @FXML
    private Button botonSumar3;
    @FXML
    private Button botonSumar4;
    @FXML
    private Button botonSumar5;
    @FXML
    private Button botonSumar6;
    private int contador=12;
    @FXML
    private Label labelMensajeError;
    private static Personaje personaje;
    private static Clase claseTal;
    private static Raza razaTal;
    private static Subraza subraza;
    private static Trasfondo trasfondo;
    private static Usuario usuario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelTotal.setText(String.valueOf(contador));
        inicializaArrays();
        String consultaClases = "SELECT * FROM clase";
        ResultSet rsClases = Conector.getSelect(consultaClases, conector);
        try {
            while(rsClases.next()){
                int idClase = rsClases.getInt("id_clase");
                String nombreClase = rsClases.getString("nombre");
                Clase clase = new Clase(idClase, nombreClase);
                listaClases.add(clase);
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar las clases");
            ex.printStackTrace();
        }
        ObservableList<Clase> listaComboBoxClases = FXCollections.observableArrayList(listaClases);
        comboBoxClase.setItems(listaComboBoxClases);
        Clase clase = new Clase(ID_CLASE_VALOR_POR_DEFECTO, NOMBRE_CLASE_VALOR_POR_DEFECTO);
        comboBoxClase.setValue(clase);
        
        String consultaRazas = "SELECT * FROM raza";
        ResultSet rsRazas = Conector.getSelect(consultaRazas, conector);
        try {
            while(rsRazas.next()){
                int idRaza = rsRazas.getInt("id_raza");
                String nombreRaza = rsRazas.getString("nombre");
                Raza raza = new Raza(idRaza, nombreRaza);
                listaRazas.add(raza);
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar las razas");
            ex.printStackTrace();
        }
        ObservableList<Raza> listaComboBoxRazas = FXCollections.observableArrayList(listaRazas);
        comboBoxRaza.setItems(listaComboBoxRazas);
        Raza raza = new Raza(ID_RAZA_VALOR_POR_DEFECTO, NOMBRE_RAZA_VALOR_POR_DEFECTO);
        comboBoxRaza.setValue(raza);
        comboBoxRaza.setItems(listaComboBoxRazas);
        if(personaje!=null){
            textFieldNombrePersronaje.setText(personaje.getNombre());
            labelValorFue.setText(String.valueOf(personaje.getFue()));
            labelValorDes.setText(String.valueOf(personaje.getDes()));
            labelValorCon.setText(String.valueOf(personaje.getCon()));
            labelValorInt.setText(String.valueOf(personaje.getInte()));
            labelValorSab.setText(String.valueOf(personaje.getSab()));
            labelValorCar.setText(String.valueOf(personaje.getCar()));
            String signo = "";
            if(personaje.getFue()>10)
                signo="+";
            labelModFue.setText(signo+String.valueOf((personaje.getFue()-10)/2));
            signo="";
            if(personaje.getDes()>10)
                signo="+";
            labelModDes.setText(signo+String.valueOf((personaje.getDes()-10)/2));
            signo="";
            if(personaje.getCon()>10)
                signo="+";
            labelModCon.setText(signo+String.valueOf((personaje.getCon()-10)/2));
            signo="";
            if(personaje.getInte()>10)
                signo="+";
            labelModInt.setText(signo+String.valueOf((personaje.getInte()-10)/2));
            signo="";
            if(personaje.getSab()>10)
                signo="+";
            labelModSab.setText(signo+String.valueOf((personaje.getSab()-10)/2));
            signo="";
            if(personaje.getCar()>10)
                signo="+";
            labelModCar.setText(signo+String.valueOf((personaje.getCar()-10)/2));
            signo="";
            labelTotal.setText(String.valueOf(personaje.getTotal()));
        }
        if(razaTal!=null){
            cargaSubraza();
            comboBoxRaza.setValue(razaTal);
        }
        if(subraza!=null)
            comboBoxSubraza.setValue(subraza);
        if(claseTal!=null)
            comboBoxClase.setValue(claseTal);
        
        //System.out.println("Personaje: "+personaje);
        //System.out.println("Clase: "+claseTal);
        //System.out.println("Raza: "+razaTal);
        System.out.println(trasfondo);
    }    
    
    public CrearPersonajeController(){
        
    }
    
    public CrearPersonajeController(Usuario usuario){
        this.usuario = usuario;
    }
    
    public CrearPersonajeController(Usuario usuario, Personaje personaje, Clase clase, Raza raza, Subraza subraza, Trasfondo trasfondo){
        this.usuario = usuario;
        this.personaje=personaje;
        this.claseTal=clase;
        this.razaTal=raza;
        this.subraza=subraza;
        this.trasfondo=trasfondo;
    }
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }

    @FXML
    private void botonVolver(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("personajes.fxml"));
            PersonajesController personajes = new PersonajesController();
            Parent root = fxmlLoader.load();
            personajes.setPanePrincipal(contenedor);
            fxmlLoader.setController(personajes);
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmación");
            confirmacion.setHeaderText("¿Estás seguro?");
            confirmacion.setContentText("Se perderán todos los datos no guardados");
            ButtonType respuesta = confirmacion.showAndWait().orElse(ButtonType.CANCEL);
            personaje=null;
            claseTal=null;
            razaTal=null;
            subraza=null;
            if(respuesta == ButtonType.OK){
                contenedor.getChildren().setAll(root);
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void inicializaArrays(){
        listaClases = new ArrayList();
        listaRazas = new ArrayList();
        listaSubrazas = new ArrayList();
        listaBotonesRestar = new ArrayList();
        listaBotonesSumar = new ArrayList();
        listaValoresCaracteristicas = new ArrayList();
        listaModCaracteristicas = new ArrayList();
        listaBotonesRestar.add(botonRestar1);
        listaBotonesRestar.add(botonRestar2);
        listaBotonesRestar.add(botonRestar3);
        listaBotonesRestar.add(botonRestar4);
        listaBotonesRestar.add(botonRestar5);
        listaBotonesRestar.add(botonRestar6);
        listaBotonesSumar.add(botonSumar1);
        listaBotonesSumar.add(botonSumar2);
        listaBotonesSumar.add(botonSumar3);
        listaBotonesSumar.add(botonSumar4);
        listaBotonesSumar.add(botonSumar5);
        listaBotonesSumar.add(botonSumar6);
        listaValoresCaracteristicas.add(labelValorFue);
        listaValoresCaracteristicas.add(labelValorDes);
        listaValoresCaracteristicas.add(labelValorCon);
        listaValoresCaracteristicas.add(labelValorInt);
        listaValoresCaracteristicas.add(labelValorSab);
        listaValoresCaracteristicas.add(labelValorCar);
        listaModCaracteristicas.add(labelModFue);
        listaModCaracteristicas.add(labelModDes);
        listaModCaracteristicas.add(labelModCon);
        listaModCaracteristicas.add(labelModInt);
        listaModCaracteristicas.add(labelModSab);
        listaModCaracteristicas.add(labelModCar);
        
        
        
   }


    @FXML
    private void seleccionarSubraza(ActionEvent event) {
        /*
        String consultaSubRazas = "SELECT * FROM subraza WHERE id_raza = "+comboBoxRaza.getValue().getIdRaza();
        ResultSet rsSubRazas = Conector.getSelect(consultaSubRazas, conector);
        try {
            while(rsSubRazas.next()){
                int idSubRaza = rsSubRazas.getInt("id_subraza");
                String nombreSubRaza = rsSubRazas.getString("nombre");
                Subraza subraza = new Subraza(idSubRaza, nombreSubRaza);
                listaSubrazas.add(subraza);
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar las subrazas");
            ex.printStackTrace();
        }
        ObservableList<Subraza> listaComboBoxSubrazas = FXCollections.observableArrayList(listaSubrazas);
        comboBoxSubraza.setItems(listaComboBoxSubrazas);
        */
    }

    @FXML
    private void botonRestar(ActionEvent event) {
        String signo="";
        Button botonPulsado = (Button) event.getSource();
        int pos = listaBotonesRestar.indexOf(botonPulsado);
        System.out.println(pos);
        if(contador>3){
            int valorCaracteristica = Integer.parseInt(listaValoresCaracteristicas.get(pos).getText());
            int modCaracteristica = Integer.parseInt(listaModCaracteristicas.get(pos).getText());
            if(valorCaracteristica>3){
                if(valorCaracteristica==13||valorCaracteristica==14)
                    contador-=2;
                else
                    contador--;
                valorCaracteristica--;
                modCaracteristica=(valorCaracteristica-10)/2;
                listaBotonesSumar.get(pos).setDisable(false);
                if(modCaracteristica>0)
                    signo="+";
            }
            if(valorCaracteristica<=3)
                botonPulsado.setDisable(true);
            listaValoresCaracteristicas.get(pos).setText(String.valueOf(valorCaracteristica));
            listaModCaracteristicas.get(pos).setText(signo+String.valueOf(modCaracteristica));
            labelTotal.setText(String.valueOf(contador));
        }
    }

    @FXML
    private void botonSumar(ActionEvent event) {
        String signo="";
        Button botonPulsado = (Button) event.getSource();
        int pos = listaBotonesSumar.indexOf(botonPulsado);
        System.out.println(pos);
        if(contador<27){
            int valorCaracteristica = Integer.parseInt(listaValoresCaracteristicas.get(pos).getText());
            int modCaracteristica = Integer.parseInt(listaModCaracteristicas.get(pos).getText());
            if(valorCaracteristica<15){
                if(valorCaracteristica==13||valorCaracteristica==14)
                    contador+=2;
                else
                    contador++;
                valorCaracteristica++;
                modCaracteristica=(valorCaracteristica-10)/2;
                listaBotonesRestar.get(pos).setDisable(false);
                if(modCaracteristica>0)
                    signo="+";
            }
            if(valorCaracteristica>=15)
                botonPulsado.setDisable(true);
            listaValoresCaracteristicas.get(pos).setText(String.valueOf(valorCaracteristica));
            listaModCaracteristicas.get(pos).setText(signo+String.valueOf(modCaracteristica));
            labelTotal.setText(String.valueOf(contador));
            
        }
    }

    private void abrirPagina(Personaje personaje, Clase clase, Raza raza, Subraza subraza, Trasfondo trasfondo){
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
    private void botonAvanzarPagina(ActionEvent event) {
        String nombre = textFieldNombrePersronaje.getText();
        Clase clase = comboBoxClase.getValue();
        Raza raza = comboBoxRaza.getValue();
        Subraza subraza = comboBoxSubraza.getValue();
        if(comboBoxSubraza.getValue()!=null)
            subraza = comboBoxSubraza.getValue();
        int fue = Integer.parseInt(labelValorFue.getText());
        int des = Integer.parseInt(labelValorDes.getText());
        int con = Integer.parseInt(labelValorCon.getText());
        int inte = Integer.parseInt(labelValorInt.getText());
        int sab = Integer.parseInt(labelValorSab.getText());
        int car = Integer.parseInt(labelValorCar.getText());
        int total = Integer.parseInt(labelTotal.getText());
        Personaje personaje = new Personaje(nombre,fue,des,con,inte,sab,car,total);
        abrirPagina(personaje,clase,raza,subraza,this.trasfondo);
        
        
    }

    
    @FXML
    private void botonVolverPagina(ActionEvent event) {
    }

    @FXML
    private void seleccionarRaza(ActionEvent event) {
        cargaSubraza();
    }

    public void cargaSubraza(){
        listaSubrazas.clear();
        comboBoxSubraza.setItems(null);
        Raza raza = comboBoxRaza.getValue();
        String consulta = "SELECT * FROM subraza where id_raza="+raza.getIdRaza();
        ResultSet rs = Conector.getSelect(consulta, conector);
        listaSubrazas.add(null);
        try {
            while(rs.next()){
                int idSubraza = rs.getInt("id_subraza");
                String nombre = rs.getString("nombre");
                String caracMod = rs.getString("carac_mod");
                int mod = rs.getInt("modificador");
                String comp = rs.getString("competencia");
                Subraza subraza = new Subraza(idSubraza,nombre,caracMod,mod,comp);
                listaSubrazas.add(subraza);
            }
            if(!listaSubrazas.isEmpty()){
                ObservableList<Subraza> listaComboBoxSubrazas = FXCollections.observableArrayList(listaSubrazas);
                comboBoxSubraza.setItems(listaComboBoxSubrazas);
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar las subrazas");
            ex.printStackTrace();
        }
    }
}
