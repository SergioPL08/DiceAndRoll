/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.clases.Clase;
import interfaz.diceandroll.clases.Habilidad;
import interfaz.diceandroll.clases.Personaje;
import interfaz.diceandroll.clases.Raza;
import interfaz.diceandroll.clases.Subraza;
import interfaz.diceandroll.clases.Trasfondo;
import interfaz.diceandroll.clases.Usuario;
import interfaz.diceandroll.conector.Conector;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class CrearPersonajePagina4Controller implements Initializable {

    @FXML
    private AnchorPane contenedor;
    @FXML
    private ImageView imagenPersonaje;
    @FXML
    private Label labelCompetenciasClase;
    @FXML
    private TextField competenciasClase;
    @FXML
    private Label labelTextoCompetenciaClase;
    @FXML
    private Label labelBonoRaza1;
    @FXML
    private TextField competenciasRaza1;
    @FXML
    private Label labelTextoBonoRaza1;
    @FXML
    private Label labelBonoRaza2;
    @FXML
    private TextField competenciasRaza2;
    @FXML
    private Label labelTextoBonoRaza2;
    @FXML
    private VBox vboxRasgosClaseAutomaticos;
    @FXML
    private VBox vboxRasgosClaseElegir;
    @FXML
    private Button botonAvanzarUno;
    @FXML
    private Button botonRetrocederUno;
    @FXML
    private Label labelMensajeError;
    ListView<String> listView;
    ListView<String> listViewRaza;
    ListView<String> listViewPericia;
    Popup popup;
    Popup popupRaza;
    Popup popupPericia;
    ArrayList<Habilidad> listaHabilidadesAutomaticas;
    ArrayList<Habilidad> listaHabilidadesSeleccion;
    private Pane panelPrincipal;
    private static Personaje personaje;
    private static Clase clase;
    private static Raza raza;
    private static Subraza subraza;
    private static Trasfondo trasfondo;
    private static Trasfondo trasfondo2;
    private static Usuario usuario;
    private int maximoRaza;
    private int maximoClase;
    private int maximoPericia;
    @FXML
    private Label labelRasgosAutomaticos;
    @FXML
    private Label labelRasgosElegir;
    @FXML
    private VBox vboxRasgosClase;
    @FXML
    private ComboBox<Habilidad> comboBoxHabilidadesSeleccion;
    ArrayList listaDes;
    ArrayList listaInt;
    ArrayList listaSab;
    ArrayList listaCar;
    ArrayList listaTodas;
    ArrayList listaCaracteristicas;
    int contadorClase=0;
    int contadorRaza=0;
    int contadorPericia=0;
    @FXML
    private Label labelEligeRasgos;
    @FXML
    private Label labelSubclase;
    @FXML
    private Label labelEligeSubclase;
    @FXML
    private ComboBox<Clase> comboBoxSubclase;
    ArrayList<Clase> listaSubclases;
    ArrayList<String> listaHabilidadesPersonajeString;
    ArrayList<Habilidad> listaHabilidadesPersonaje;
    ArrayList<Habilidad> listaBonosRaza;
    @FXML
    private Label labelPericia;
    @FXML
    private TextField pericia;
    @FXML
    private Label labelTextoPericia;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        maximoClase=clase.getNumHabNv1();
        maximoPericia=2;
        maximoRaza=raza.getNumBono1();
        listaDes = new ArrayList();
        listaInt = new ArrayList();
        listaSab = new ArrayList();
        listaCar = new ArrayList();
        listaTodas = new ArrayList();
        listaCaracteristicas = new ArrayList();
        listaSubclases = new ArrayList();
        listaHabilidadesPersonajeString = new ArrayList();
        listaHabilidadesPersonaje = new ArrayList();
        listaBonosRaza = new ArrayList();
        listaDes.add("acrobacias");
        listaDes.add("juego de manos");
        listaDes.add("sigilo");
        listaInt.add("arcanos");
        listaInt.add("historia");
        listaInt.add("investigacion");
        listaInt.add("naturaleza");
        listaSab.add("medicina");
        listaSab.add("percepcion");
        listaSab.add("perspicacia");
        listaSab.add("supervivencia");
        listaSab.add("trato con animales");
        listaCar.add("engañar");
        listaCar.add("interpretacion");
        listaCar.add("intimidar");
        listaCar.add("persuasion");
        listaTodas.add("atletismo");
        listaTodas.addAll(listaDes);
        listaTodas.addAll(listaInt);
        listaTodas.addAll(listaSab);
        listaTodas.addAll(listaCar);
        Collections.sort(listaTodas);
        listaHabilidadesAutomaticas = new ArrayList();
        listaHabilidadesSeleccion = new ArrayList();
        rellenaHabilidadesClase();
        labelTextoCompetenciaClase.setText(String.valueOf(clase.getTextoCompetenciasHabilidades()));
        listaCaracteristicas.add("Fue");
        listaCaracteristicas.add("Des");
        listaCaracteristicas.add("Con");
        listaCaracteristicas.add("Int");
        listaCaracteristicas.add("Sab");
        listaCaracteristicas.add("Car");
        labelSubclase.setVisible(false);
        labelEligeSubclase.setVisible(false);
        comboBoxSubclase.setVisible(false);
        labelBonoRaza1.setVisible(false);
        labelBonoRaza2.setManaged(false);
        competenciasRaza1.setVisible(false);
        competenciasRaza2.setManaged(false);
        labelTextoBonoRaza1.setVisible(false);
        labelTextoBonoRaza2.setManaged(false);
        labelPericia.setVisible(false);
        pericia.setVisible(false);
        labelTextoPericia.setVisible(false);
        muestraElegirSubclase();
        muestraElegirBonusRaza();
        muestraElegirPericia();
        rellenaBonosRaza();
    }
    
    private void rellenaBonosRaza(){
        String consulta = "SELECT * FROM bono_stat_raza WHERE caracteristica != \"Escoger\" AND id_raza = "+raza.getIdRaza();
            System.out.println(consulta);
            ResultSet rs = Conector.getSelect(consulta, conector);
            try{
                while(rs.next()){
                    String caracteristica = rs.getString("caracteristica");
                    int bono = rs.getInt("bono");
                    Habilidad hab = new Habilidad(caracteristica, bono);
                    listaBonosRaza.add(hab);
                }
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
    }
    
    private void muestraElegirPericia(){
        for(Habilidad habilidad: listaHabilidadesAutomaticas){
            if(habilidad.getNombre().equals("Pericia")){
                labelPericia.setVisible(true);
                pericia.setVisible(true);
                labelTextoPericia.setVisible(true);
            }
        }
    }
    
    private void muestraElegirSubclase(){
        if(clase.getNivelSubclase()==1){
            labelRasgosElegir.setManaged(false);
            labelEligeRasgos.setManaged(false);
            comboBoxHabilidadesSeleccion.setManaged(false);
            labelSubclase.setVisible(true);
            labelEligeSubclase.setVisible(true);
            comboBoxSubclase.setVisible(true);
            labelSubclase.setText("Subclases de "+clase.getNombre());
            String consultaSubclase = "SELECT * FROM subclase WHERE id_clase = "+clase.getIdClase();
            ResultSet rs = Conector.getSelect(consultaSubclase, conector);
            try{
                while(rs.next()){
                    int idSubclase = rs.getInt("id_subclase");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    Clase subclase = new Clase(idSubclase,nombre,descripcion);
                    listaSubclases.add(subclase);
                    ObservableList<Clase> listaComboBoxSubclases = FXCollections.observableArrayList(listaSubclases);
                    comboBoxSubclase.setItems(listaComboBoxSubclases);
                }
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    private void muestraElegirBonusRaza(){
        String consulta = "SELECT * FROM bono_stat_raza WHERE caracteristica = \"Escoger\" AND id_raza = "+raza.getIdRaza();
            System.out.println(consulta);
            ResultSet rs = Conector.getSelect(consulta, conector);
            boolean escoger = false;
            try{
                while(rs.next()){
                    escoger=true;
                }
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            if(escoger){
                labelBonoRaza1.setVisible(true);
                //labelBonoRaza2.setVisible(true);
                competenciasRaza1.setVisible(true);
                //competenciasRaza2.setVisible(true);
                labelTextoBonoRaza1.setVisible(true);
                //labelTextoBonoRaza2.setVisible(true);
                labelTextoBonoRaza1.setText("+1 a "+raza.getNumBono1()+" caracteristicas a elegir");
            }
    }
    
    public CrearPersonajePagina4Controller(){
        
    }
    
    public CrearPersonajePagina4Controller(Usuario usuario, Personaje personaje, Clase clase, Raza raza, Subraza subraza,Trasfondo trasfondo){
        
        this.usuario=usuario;
        this.personaje=personaje;
        this.clase=clase;
        this.raza=raza;
        this.subraza=subraza;
        this.trasfondo=trasfondo;
        
    }
    
    private void rellenaHabilidadesClase(){
        try {
            String consultaHabilidadesClase = "SELECT * FROM habilidad_clase WHERE id_clase = "+clase.getIdClase()+" AND nivel = 1 ORDER BY adquisicion,nombre";
            System.out.println(consultaHabilidadesClase);
            ResultSet rs = Conector.getSelect(consultaHabilidadesClase, conector);
            Habilidad habilidad;
            
            
            while(rs.next()){
                //(int idHabilidad, String nombre, String descripcion, String adquisicion, String descCorta, String stat1, String stat2, int nivel, int bonoStat1, int bonoStat2
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String adquisicion = rs.getString("adquisicion");
                String descCorta = rs.getString("descripcion_corta");
                String stat1 = rs.getString("caracteristica1");
                String stat2 = rs.getString("caracteristica2");
                int bonoStat1 = rs.getInt("bono_caracteristica1");
                int bonoStat2 = rs.getInt("bono_caracteristica2");
                habilidad = new Habilidad(nombre, descripcion, adquisicion, descCorta);
                if(adquisicion.equals("automatico"))
                    listaHabilidadesAutomaticas.add(habilidad);
                else
                    listaHabilidadesSeleccion.add(habilidad);
            }
            if(!listaHabilidadesAutomaticas.isEmpty())
                rellenaVBox(true);
            else{
                labelRasgosAutomaticos.setVisible(false);
                vboxRasgosClaseAutomaticos.setVisible(false);
            }
            if(!listaHabilidadesSeleccion.isEmpty()){
                rellenaVBox(false);
                ObservableList<Habilidad> listaComboBoxHabilidades = FXCollections.observableArrayList(listaHabilidadesSeleccion);
                comboBoxHabilidadesSeleccion.setItems(listaComboBoxHabilidades);
            }
            else{
                labelRasgosElegir.setVisible(false);
                vboxRasgosClaseElegir.setVisible(false);
                comboBoxHabilidadesSeleccion.setVisible(false);
                labelEligeRasgos.setVisible(false);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void rellenaVBox(Boolean automatico){
        ArrayList<Habilidad> lista;
        if(automatico)
            lista = new ArrayList(listaHabilidadesAutomaticas);
        else
            lista = new ArrayList(listaHabilidadesSeleccion);
        for(Habilidad hab: lista){
                Label nombre = new Label(hab.getNombre());
                Label label = new Label("<");
                HBox hbox = new HBox();
                Pane separacion = new Pane();
                nombre.setMinWidth(Control.USE_PREF_SIZE);
                nombre.setPadding(new Insets(5,5,5,5));
                label.setMinWidth(Control.USE_PREF_SIZE);
                label.setTextAlignment(TextAlignment.RIGHT);
                label.setPadding(new Insets(5,5,5,5));
                label.setRotate(-90);
                separacion.setMinWidth(Control.USE_PREF_SIZE);
                hbox.getChildren().addAll(nombre,separacion,label);
                hbox.setHgrow(hbox, Priority.ALWAYS);
                hbox.setStyle("-fx-background-color: #");
                if(automatico){
                    vboxRasgosClaseAutomaticos.getChildren().add(hbox);
                    vboxRasgosClaseAutomaticos.setAlignment(Pos.TOP_LEFT);
                }
                else{
                    vboxRasgosClaseElegir.getChildren().add(hbox);
                    vboxRasgosClaseElegir.setAlignment(Pos.TOP_LEFT);
                }
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
    }
    @FXML
    private void botonVolver(ActionEvent event) {
        
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
    
    public void addBonus(Habilidad hab){
        int nuevoValor;
        switch (hab.getNombre()) {
            case "Fue":
                nuevoValor = personaje.getFue()+hab.getBono();
                personaje.setFue(nuevoValor);
                break;
            case "Des":
                nuevoValor = personaje.getDes()+hab.getBono();
                personaje.setDes(nuevoValor);
                break;
            case "Con":
                nuevoValor = personaje.getCon()+hab.getBono();
                personaje.setCon(nuevoValor);
                break;
            case "Int":
                nuevoValor = personaje.getInte()+hab.getBono();
                personaje.setInte(nuevoValor);
                break;
            case "Sab":
                nuevoValor = personaje.getSab()+hab.getBono();
                personaje.setSab(nuevoValor);
                break;
            case "Car":
                nuevoValor = personaje.getCar()+hab.getBono();
                personaje.setCar(nuevoValor);
                break;
        }
    }
    
    public void addBonus(String caracteristica){
        int nuevoValor;
        switch (caracteristica) {
            case "Fue":
                nuevoValor = personaje.getFue()+1;
                personaje.setFue(nuevoValor);
                break;
            case "Des":
                nuevoValor = personaje.getDes()+1;
                personaje.setDes(nuevoValor);
                break;
            case "Con":
                nuevoValor = personaje.getCon()+1;
                personaje.setCon(nuevoValor);
                break;
            case "Int":
                nuevoValor = personaje.getInte()+1;
                personaje.setInte(nuevoValor);
                break;
            case "Sab":
                nuevoValor = personaje.getSab()+1;
                personaje.setSab(nuevoValor);
                break;
            case "Car":
                nuevoValor = personaje.getCar()+1;
                personaje.setCar(nuevoValor);
                break;
        }
    }
    
    public String compruebaEstadistica(String habilidad){
            if(habilidad.equals("atletismo"))
                return "fue";
            else if(listaDes.contains(habilidad))
                return "des";
            else if(listaInt.contains(habilidad))
                return "int";
            else if(listaCar.contains(habilidad))
                return "car";
            else if(listaSab.contains(habilidad))
                return "sab";
            else return null;
        }
        
        public int getBase(String estadistica){
            switch (estadistica) {
                case "Fuerza":
                    return personaje.getFue();
                case "Destreza":
                    return personaje.getDes();
                case "Constitucion":
                    return personaje.getCon();
                case "Inteligencia":
                    return personaje.getInte();
                case "Sabiduria":
                    return personaje.getSab();
                case "Carisma":
                    return personaje.getCar();
                default:
                    return -50;
            }
        }
        
        public int getBaseReducido(String estadistica){
            switch (estadistica) {
                case "fue":
                    return personaje.getFue();
                case "des":
                    return personaje.getDes();
                case "con":
                    return personaje.getCon();
                case "int":
                    return personaje.getInte();
                case "sab":
                    return personaje.getSab();
                case "car":
                    return personaje.getCar();
                default:
                    return -50;
            }
        }
        
        
        
    private void abrirMenuFichaPersonaje(Personaje personaje, String clase) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fichaPersonaje.fxml"));
            FichaPersonajeController fichaPersonaje = new FichaPersonajeController(personaje,clase);
            Parent root = fxmlLoader.load();
            fichaPersonaje.setPanePrincipal(contenedor);
            fxmlLoader.setController(fichaPersonaje);
            contenedor.getChildren().setAll(root);
        } catch (IOException ex) {
                ex.printStackTrace();
        }
    }
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }

    @FXML
    private void botonVolverPagina(ActionEvent event) {
        abrirPagina3(personaje, clase, raza, subraza, trasfondo);
    }
    
    private void addCompetencia() {
        String selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            if (competenciasClase.getText().contains(selectedItem)) {
                String updatedText = competenciasClase.getText().replace(selectedItem + " ", "");
                competenciasClase.setText(updatedText);
                contadorClase--; 
            } else if (contadorClase < maximoClase) { 
                competenciasClase.appendText(selectedItem + " ");
                contadorClase++;
            }
        }
    }
    
    private void addBonoPericia() {
        String selectedItem = listViewPericia.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            if (pericia.getText().contains(selectedItem)) {
                String updatedText = pericia.getText().replace(selectedItem + " ", "");
                pericia.setText(updatedText);
                contadorPericia--; 
            } else if (contadorPericia < maximoPericia) { 
                pericia.appendText(selectedItem + " ");
                contadorPericia++;
            }
        }
    }
    

    private void addBonoRaza() {
        System.out.println(maximoRaza);
        String selectedItem = listViewRaza.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            if (competenciasRaza1.getText().contains(selectedItem)) {
                String updatedText = competenciasRaza1.getText().replace(selectedItem + " ", "");
                competenciasRaza1.setText(updatedText);
                contadorRaza--; 
            } else if (contadorRaza < maximoRaza) { 
                competenciasRaza1.appendText(selectedItem + " ");
                contadorRaza++;
            }
        }
    }
    
    @FXML
    private void abrirListaSeleccionarCompetenciasClase(MouseEvent event) {
        if (popup == null) {
            popup = new Popup();
            listView = new ListView<>();
            String consultaHabilidades = "SELECT * FROM competencia_habilidades_clase WHERE id_clase="+clase.getIdClase();
            ResultSet rs = Conector.getSelect(consultaHabilidades, conector);
            try{
                while(rs.next()){
                    String habilidad = rs.getString("competencia");
                    if(habilidad.equals("todas"))
                        listView.getItems().addAll(listaTodas);
                    else
                        listView.getItems().add(habilidad);
                }
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            listView.setOnMouseClicked(evento -> addCompetencia());

            VBox vbox = new VBox(listView);
            vbox.setStyle("-fx-background-color: white; -fx-border-color: lightgray; -fx-padding: 5;");
            vbox.setPrefWidth(Control.USE_COMPUTED_SIZE);
            popup.getContent().add(vbox);
            popup.setAutoHide(true);
        }
        Scene scene = competenciasClase.getScene();
           scene.setOnMouseClicked(evento -> {
               Node source = evento.getPickResult().getIntersectedNode();
               if (source != listView && !listView.getChildrenUnmodifiable().contains(source)) {
                   popup.hide();
               }
           });
        popup.show(competenciasClase.getScene().getWindow());
        popup.setX(competenciasClase.localToScreen(competenciasClase.getBoundsInLocal()).getMinX());
        popup.setY(competenciasClase.localToScreen(competenciasClase.getBoundsInLocal()).getMaxY());
        popup.setWidth(Control.USE_COMPUTED_SIZE);
    }

    @FXML
    private void abrirListaSeleccionarBonosRaza1(MouseEvent event) {
        abrirListaBonosRaza();
    }

    @FXML
    private void abrirListaSeleccionarBonosRaza2(MouseEvent event) {
        
    }
    
    private void abrirListaBonosRaza(){
        if (popupRaza == null) {
            popupRaza = new Popup();
            listViewRaza = new ListView<>();
            listViewRaza.getItems().addAll(listaCaracteristicas);
            listViewRaza.setOnMouseClicked(evento2 -> addBonoRaza());

            VBox vbox = new VBox(listViewRaza);
            vbox.setStyle("-fx-background-color: white; -fx-border-color: lightgray; -fx-padding: 5;");
            vbox.setPrefWidth(Control.USE_COMPUTED_SIZE);
            popupRaza.getContent().add(vbox);
            popupRaza.setAutoHide(true);
        }
        Scene scene = competenciasRaza1.getScene();
           scene.setOnMouseClicked(evento -> {
               Node source = evento.getPickResult().getIntersectedNode();
               if (source != listViewRaza && !listViewRaza.getChildrenUnmodifiable().contains(source)) {
                   popupRaza.hide();
               }
           });
        popupRaza.show(competenciasRaza1.getScene().getWindow());
        popupRaza.setX(competenciasRaza1.localToScreen(competenciasRaza1.getBoundsInLocal()).getMinX());
        popupRaza.setY(competenciasRaza1.localToScreen(competenciasRaza1.getBoundsInLocal()).getMaxY());
        popupRaza.setWidth(Control.USE_COMPUTED_SIZE);
    }
    
    private void abrirListaPericia(){
        if (popupPericia == null) {
            popupPericia = new Popup();
            listViewPericia = new ListView<>();
            listViewPericia.getItems().addAll(listaTodas);
            listViewPericia.setOnMouseClicked(evento2 -> addBonoPericia());

            VBox vbox = new VBox(listViewPericia);
            vbox.setStyle("-fx-background-color: white; -fx-border-color: lightgray; -fx-padding: 5;");
            vbox.setPrefWidth(Control.USE_COMPUTED_SIZE);
            popupPericia.getContent().add(vbox);
            popupPericia.setAutoHide(true);
        }
        Scene scene = pericia.getScene();
           scene.setOnMouseClicked(evento -> {
               Node source = evento.getPickResult().getIntersectedNode();
               if (source != listViewPericia && !listViewPericia.getChildrenUnmodifiable().contains(source)) {
                   popupPericia.hide();
               }
           });
        popupPericia.show(pericia.getScene().getWindow());
        popupPericia.setX(pericia.localToScreen(pericia.getBoundsInLocal()).getMinX());
        popupPericia.setY(pericia.localToScreen(pericia.getBoundsInLocal()).getMaxY());
        popupPericia.setWidth(Control.USE_COMPUTED_SIZE);
    }

    @FXML
    private void abrirListaSeleccionarPericia(MouseEvent event) {
        abrirListaPericia();
    }
    
    @FXML
    private void botonCrearPersonaje(ActionEvent event) {
        if(personaje.getNombre().equals("")){
            labelMensajeError.setText("Introduce el nombre del personaje");
        }
        else if(comboBoxHabilidadesSeleccion.isVisible()&&comboBoxHabilidadesSeleccion.getValue()==null)
            labelMensajeError.setText("Selecciona una habilidad para el personaje");
        else if(comboBoxSubclase.isVisible()&&comboBoxSubclase.getValue()==null)
            labelMensajeError.setText("Elige la subclase para tu personaje");
        else if(contadorClase<maximoClase)
            labelMensajeError.setText("Elige las competencias de clase");
        else if(competenciasRaza1.isVisible()&&contadorRaza<maximoRaza)
            labelMensajeError.setText("Elige los bonos de raza");
        else if(pericia.isVisible()&&contadorPericia<maximoPericia)
            labelMensajeError.setText("Elige las habilidades con pericia");
        else{
            try {
                conector.setAutoCommit(false);
                String insertPersonaje = "INSERT INTO personaje "
                        + "(nombre,puntos_de_golpe_maximos,puntos_de_golpe_actuales,iniciativa,velocidad,ca,competencia,fue,des,con,inte,sab,car,raza,usuario) "
                        + "VALUES('"+personaje.getNombre()+"',"+(clase.getPuntosGolpe()+(personaje.getCon()-10)/2)+","+(clase.getPuntosGolpe()+(personaje.getCon()-10)/2)+","
                        + (personaje.getDes()-10)/2+",'"+raza.getVelocidad()+"',10,2"
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
                String stat1 = clase.getCompetenciaEstat1();
                int base1 = (getBase(stat1)-10)/2;
                String stat2 = clase.getCompetenciaEstat2();
                int base2 = (getBase(stat2)-10)/2;
                String insertTS1 = "INSERT INTO ts_personaje "
                        + "(id_personaje,caracteristica,base,modificador,competencia) VALUES ("+idPersonaje+",\""+stat1+"\","+base1+",0,1)";
                String insertTS2 = "INSERT INTO ts_personaje "
                        + "(id_personaje,caracteristica,base,modificador,competencia) VALUES ("+idPersonaje+",\""+stat2+"\","+base2+",0,1)";
                listaHabilidadesPersonajeString.add(trasfondo.getCompetencia1());
                listaHabilidadesPersonajeString.add(trasfondo.getCompetencia2());  
                String[] habilidades = competenciasClase.getText().split(" ");
                for(String habilidad : habilidades){
                    listaHabilidadesPersonajeString.add(habilidad);
                    int base = (getBaseReducido(compruebaEstadistica(habilidad))-10)/2;
                    Habilidad hab = new Habilidad(habilidad, base, 0, true);
                    listaHabilidadesPersonaje.add(hab);
                }
                ArrayList listaHabilidadesPericia = new ArrayList();
                String[] habilidadesPericia = pericia.getText().split(" ");
                for(String habPericia: habilidadesPericia){
                    listaHabilidadesPericia.add(habPericia);
                    for(Habilidad hab: listaHabilidadesPersonaje){
                        if(hab.getNombre().equals(habPericia)){
                            hab.setPericia(true);
                        }
                    }
                }
                String[] bonosRaza = competenciasRaza1.getText().split(" ");
                for(String Caracteristica: bonosRaza){
                    addBonus(Caracteristica);
                }
                for(Habilidad hab: listaBonosRaza){
                    addBonus(hab);
                }
                Conector.insertTable(insertPersonaje, conector);
                Conector.insertTable(insertClase, conector);
                Conector.insertTable(insertTS1, conector);
                Conector.insertTable(insertTS2, conector);
                for(Habilidad hab:listaHabilidadesPersonaje){
                    String insertHabilidadPersonaje = "INSERT INTO habilidad_personaje (id_personaje,habilidad,base,competencia,pericia) VALUES "
                            + "("+personaje.getIdPersonaje()+",\""+hab.getNombre()+"\","+hab.getBase()+","+hab.isCompetencia()+","+hab.isPericia()+")";
                    System.out.println(insertHabilidadPersonaje);
                    int habilidadesPersonajeInsertadas = Conector.insertTable(insertHabilidadPersonaje, conector);
                    if(habilidadesPersonajeInsertadas==0){
                        throw new SQLException();
                    }
                    System.out.println(habilidadesPersonajeInsertadas);
                }
                conector.commit();
                labelMensajeError.setStyle("-fx-text-fill: #00BF63");
                labelMensajeError.setText("Personaje creado correctamente");
                abrirMenuFichaPersonaje(personaje, clase.getNombre());
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
    
}
