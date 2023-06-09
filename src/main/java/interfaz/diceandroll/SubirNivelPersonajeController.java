/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.clases.Clase;
import interfaz.diceandroll.clases.Dote;
import interfaz.diceandroll.clases.Habilidad;
import interfaz.diceandroll.clases.Personaje;
import interfaz.diceandroll.conector.Conector;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class SubirNivelPersonajeController implements Initializable {

    @FXML
    private AnchorPane contenedor;
    private static Personaje personaje;
    private static Clase clase;
    private static Pane panelPrincipal;
    Popup popup;
    ListView<Habilidad> listView;
    @FXML
    private Label nombrePersonaje;
    @FXML
    private Label clasePersonajeNivel;
    ArrayList<Habilidad> listaHabilidadesClase;
    ArrayList<Habilidad> listaHabilidadesEspeciales;
    ArrayList<Habilidad> listaTodasHabilidades;
    ArrayList<Habilidad> listaHabilidadesSeleccionadas;
    ArrayList<Integer> listaCaracteristicasValorOriginal;
    ArrayList<String> listaCaracteristicas;
    ArrayList<Button> listaBotonesRestar;
    ArrayList<Button> listaBotonesSumar;
    ArrayList<Label> listaValoresCaracteristicas;
    ArrayList<Label> listaModCaracteristicas;
    ArrayList<Dote> listaDotes;
    Habilidad hab;
    private VBox vboxHabiliadesClase;
    @FXML
    private VBox vboxHabiliadesAutomaticas;
    @FXML
    private VBox vboxHabiliadesSeleccionar;
    @FXML
    private TextField elegirHabilidadesClase;
    @FXML
    private TextField textFieldPuntosDeGolpe;
    @FXML
    private Label rasgosClase;
    @FXML
    private Label labelMensaje;
    private int dado;
    private int maximo=1;
    private int contador=0;
    private final int MAXIMO_INCREMENTOS=2;
    private int contadorIncrementos=2;
    @FXML
    private Label labelElegirRasgosClase;
    @FXML
    private ScrollPane scrollPaneHabilidadesElegir;
    @FXML
    private VBox vboxSubidaCaracteristicas;
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
    private ComboBox<Dote> comboBoxDotes;
    @FXML
    private Label labelIncrementosDisponibles;
    @FXML
    private Label labelMensajeDote;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaHabilidadesClase = new ArrayList();
        listaHabilidadesEspeciales = new ArrayList();
        listaTodasHabilidades = new ArrayList();
        listaCaracteristicas = new ArrayList();
        listaHabilidadesSeleccionadas = new ArrayList();
        listaCaracteristicasValorOriginal = new ArrayList();
        nombrePersonaje.setText(personaje.getNombre());
        dado = clase.getPuntosGolpe();
        textFieldPuntosDeGolpe.setPromptText("1d"+dado);
        vboxSubidaCaracteristicas.setVisible(false);
        rellenaHabilidades();
        rellenaDotes();
    }    
    
    
    private void rellenaHabilidades(){
        try {
            listaBotonesRestar = new ArrayList();
            listaBotonesSumar = new ArrayList();
            listaValoresCaracteristicas = new ArrayList();
            listaModCaracteristicas = new ArrayList();
            listaDotes = new ArrayList();
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
            listaCaracteristicasValorOriginal.add(personaje.getFue());
            listaCaracteristicasValorOriginal.add(personaje.getDes());
            listaCaracteristicasValorOriginal.add(personaje.getCon());
            listaCaracteristicasValorOriginal.add(personaje.getInte());
            listaCaracteristicasValorOriginal.add(personaje.getSab());
            listaCaracteristicasValorOriginal.add(personaje.getCar());
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
            listaCaracteristicas.add("fue");
            listaCaracteristicas.add("des");
            listaCaracteristicas.add("con");
            listaCaracteristicas.add("int");
            listaCaracteristicas.add("sab");
            listaCaracteristicas.add("car");
            nombrePersonaje.setText(personaje.getNombre());
            String claseNivel = clase.getNombre()+" "+(personaje.getNivel()+1);
            clasePersonajeNivel.setText(claseNivel);
            listaHabilidadesClase = new ArrayList();
            listaHabilidadesEspeciales = new ArrayList();
            listaTodasHabilidades = new ArrayList();
            String consulta = "SELECT * FROM habilidad_clase WHERE id_clase = "+clase.getIdClase()+" AND nivel="+(personaje.getNivel()+1)+" ORDER BY nivel,nombre";
            ResultSet rs = Conector.getSelect(consulta, conector);
            System.out.println(consulta);
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
                    vboxHabiliadesAutomaticas.getChildren().add(hbox);
                    vboxHabiliadesAutomaticas.setAlignment(Pos.TOP_LEFT);
                }
                else{
                    vboxHabiliadesSeleccionar.getChildren().add(hbox);
                    vboxHabiliadesSeleccionar.setAlignment(Pos.TOP_LEFT);
                }
                
                HBox.setHgrow(nombre, Priority.ALWAYS);
                hbox.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        Stage ventanaEmergente = new Stage();
                        VBox vboxDetalle = new VBox();
                        Label labellNombre = new Label(hab.getNombre());
                        labellNombre.setStyle("-fx-text-fill: #3583F2; -fx-font-size:20; -fx-alingment:center; -fx-font-weight:bold");
                        VBox vboxDescripcion = new VBox();
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
                        WebView webViewDescripcion = new WebView();
                        WebEngine webEngine = webViewDescripcion.getEngine();
                        webEngine.loadContent(html);
                        webViewDescripcion.setStyle("-fx-padding-right: 10px;");
                        vboxDescripcion.setMinHeight(Control.USE_PREF_SIZE);
                        vboxDescripcion.setMaxHeight(Control.USE_PREF_SIZE);
                        vboxDescripcion.setPrefHeight(Control.USE_COMPUTED_SIZE);
                        vboxDescripcion.setMaxWidth(Control.USE_PREF_SIZE);
                        vboxDescripcion.setMinWidth(Control.USE_PREF_SIZE);
                        webViewDescripcion.setPrefSize(400, 550);
                        vboxDescripcion.setPrefWidth(500);
                        ScrollPane sp = new ScrollPane();
                        vboxDescripcion.getChildren().add(webViewDescripcion);
                        vboxDetalle.getChildren().addAll(labellNombre);
                        vboxDetalle.getChildren().addAll(vboxDescripcion);
                        
                        vboxDetalle.setStyle("-fx-background-color:#FFF");
                        vboxDescripcion.setStyle("-fx-background-color:#FFF; -fx-padding:0 0 0 13");
                        sp.setContent(vboxDetalle);
                        Scene scene = new Scene(sp, 500, 600);
                        scene.getStylesheets().add("style.css");
                        ventanaEmergente.setScene(scene);
                        ventanaEmergente.show();
                    }
                });
            }
            if(listaHabilidadesEspeciales.isEmpty()){
                elegirHabilidadesClase.setManaged(false);
                labelElegirRasgosClase.setManaged(false);
                vboxHabiliadesSeleccionar.setManaged(false);
                scrollPaneHabilidadesElegir.setManaged(false);
            }
            boolean subidaCaracteristica = false;
            for(Habilidad hab:listaHabilidadesClase){
                if(hab.getNombre().equals("Mejora de caracteristica"))
                    subidaCaracteristica=true;
            }
            if(subidaCaracteristica==true){
                vboxSubidaCaracteristicas.setVisible(true);
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
            }
        } catch (SQLException ex) {
            System.out.println("Error al rellenar las habilidades");
            ex.printStackTrace();
        }
    }
    
    

    public SubirNivelPersonajeController() {
    }
    
    public SubirNivelPersonajeController(Personaje personaje, Clase clase) {
        this.clase=clase;
        this.personaje=personaje;
    }
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }

    public void addHabilidad(){
        Habilidad habilidadSeleccionada = listView.getSelectionModel().getSelectedItem();
        if (habilidadSeleccionada != null) {
            if (elegirHabilidadesClase.getText().contains(habilidadSeleccionada.getNombre())) {
                String updatedText = elegirHabilidadesClase.getText().replace(habilidadSeleccionada + " ", "");
                elegirHabilidadesClase.setText(updatedText);
                contador--; 
                listaHabilidadesSeleccionadas.remove(habilidadSeleccionada);
            } else if (contador < maximo) { 
                elegirHabilidadesClase.appendText(habilidadSeleccionada + " ");
                contador++;
                listaHabilidadesSeleccionadas.add(habilidadSeleccionada);
            }
        }
    }
    
    @FXML
    private void abrirListaSeleccionarCompetenciasClase(MouseEvent event) {
        if (popup == null) {
            popup = new Popup();
            listView = new ListView<>();
            listView.getItems().addAll(listaHabilidadesEspeciales);
            listView.setOnMouseClicked(evento -> addHabilidad());

            VBox vbox = new VBox(listView);
            vbox.setStyle("-fx-background-color: white; -fx-border-color: lightgray; -fx-padding: 5;");
            vbox.setPrefWidth(Control.USE_COMPUTED_SIZE);
            popup.getContent().add(vbox);
            popup.setAutoHide(true);
        }
        Scene scene = elegirHabilidadesClase.getScene();
           scene.setOnMouseClicked(evento -> {
               Node source = evento.getPickResult().getIntersectedNode();
               if (source != listView && !listView.getChildrenUnmodifiable().contains(source)) {
                   popup.hide();
               }
           });
        popup.show(elegirHabilidadesClase.getScene().getWindow());
        popup.setX(elegirHabilidadesClase.localToScreen(elegirHabilidadesClase.getBoundsInLocal()).getMinX());
        popup.setY(elegirHabilidadesClase.localToScreen(elegirHabilidadesClase.getBoundsInLocal()).getMaxY());
        popup.setWidth(Control.USE_COMPUTED_SIZE);
    }

    @FXML
    private void botonLanzarDado(ActionEvent event) {
        textFieldPuntosDeGolpe.setText(String.valueOf((int)(Math.random()*dado+1)));
    }

    private void rellenaDotes(){
        String consultaDotes = "SELECT * FROM dote";
        ResultSet rs = Conector.getSelect(consultaDotes, conector);
        try{
            while(rs.next()){
                int idDote = rs.getInt("id_dote");
                String nombre = rs.getString("nombre");
                String desc = rs.getString("descripcion");
                Dote dote = new Dote(idDote, nombre, desc);
                listaDotes.add(dote);
            }
            ObservableList<Dote> listaComboBoxDotes = FXCollections.observableArrayList(listaDotes);
            comboBoxDotes.setItems(listaComboBoxDotes);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void botonSubirNivel(ActionEvent event) {
        String puntosGolpeString = textFieldPuntosDeGolpe.getText();
        if(!puntosGolpeString.equals("")&&puntosGolpeString.matches("[0-9]+")){
            int puntosGolpe = Integer.parseInt(puntosGolpeString);
            int vida;
            if(puntosGolpe<1||puntosGolpe>dado){
                labelMensaje.setText("El numero debe estar entre 1 y "+clase.getPuntosGolpe());
            }
            else{
                if(vboxHabiliadesSeleccionar.isManaged()&&elegirHabilidadesClase.getText().equals("")){
                    labelMensaje.setText("Selecciona las habilidades del personaje");
                }
                else{
                    try{
                        conector.setAutoCommit(false);
                        String caracteristicaModificada1="";
                        String caracteristicaModificada2="";
                        int mod1=-20;
                        int mod2=-20;
                        if(vboxSubidaCaracteristicas.isVisible()){
                            int contador=0;
                            for(Label label: listaValoresCaracteristicas){
                                int caracteristica = Integer.valueOf(label.getText());
                                if(caracteristica!=listaCaracteristicasValorOriginal.get(contador)){
                                    if(mod2!=-20){
                                        mod2=caracteristica;
                                        caracteristicaModificada2=listaCaracteristicas.get(contador);
                                    }
                                    if(mod1==-20){
                                        mod1=caracteristica;
                                        caracteristicaModificada1=listaCaracteristicas.get(contador);
                                        mod2=-21;
                                    }
                                }
                                contador++;
                            }
                            //System.out.println("Mod1: "+caracteristicaModificada1+" "+mod1);
                            //System.out.println("Mod2: "+caracteristicaModificada2+" "+mod2);
                        }
                        vida = (Integer.valueOf(textFieldPuntosDeGolpe.getText())-10)/2;
                        puntosGolpe = personaje.getVidaMaxima()+Integer.valueOf(vida);
                        String insertNivelPersonaje = "UPDATE personaje "
                                + "SET nivel = "+(personaje.getNivel()+1)+", "
                                + "puntos_de_golpe_maximos = "+puntosGolpe+", "
                                + "puntos_de_golpe_actuales= "+puntosGolpe+" ";
                        if(!caracteristicaModificada1.equals("")){
                            insertNivelPersonaje += ", "+caracteristicaModificada1+" = "+mod1;
                            switch (caracteristicaModificada1) {
                                case "fue":
                                    personaje.setFue(mod1);
                                    break;
                                case "des":
                                    personaje.setDes(mod1);
                                    break;
                                case "con":
                                    personaje.setCon(mod1);
                                    break;
                                case "int":
                                    personaje.setInte(mod1);
                                    break;
                                case "sab":
                                    personaje.setSab(mod1);
                                    break;
                                case "car":
                                    personaje.setCar(mod1);
                                    break;
                                    
                            }
                        }
                        
                        if(!caracteristicaModificada2.equals("")){
                            insertNivelPersonaje += ", "+caracteristicaModificada2+" = "+mod2;
                            switch (caracteristicaModificada2) {
                                case "fue":
                                    personaje.setFue(mod2);
                                    break;
                                case "des":
                                    personaje.setDes(mod2);
                                    break;
                                case "con":
                                    personaje.setCon(mod2);
                                    break;
                                case "int":
                                    personaje.setInte(mod2);
                                    break;
                                case "sab":
                                    personaje.setSab(mod2);
                                    break;
                                case "car":
                                    personaje.setCar(mod2);
                                    break;
                                    
                            }
                        }
                        insertNivelPersonaje+= " WHERE id_personaje = "+personaje.getIdPersonaje();
                        System.out.println(insertNivelPersonaje);
                        //System.out.println(insertNivelPersonaje);
                        int res = Conector.insertTable(insertNivelPersonaje, conector);
                        if(res<0){
                            throw new SQLException();
                        }
                        String insertNivelClase = "UPDATE clase_personaje "
                                + "SET nivel_clase = "+(personaje.getNivel()+1)+" "
                                + "WHERE id_personaje = "+personaje.getIdPersonaje()+" AND id_clase = "+clase.getId_clase();
                        res = Conector.insertTable(insertNivelClase, conector);
                        if(res<0){
                            throw new SQLException();
                        }
                        if(scrollPaneHabilidadesElegir.isManaged()){
                            for(Habilidad hab:listaHabilidadesSeleccionadas){
                                String insertHabilidadesSeleccionadas = "INSERT INTO habilidades_clase_seleccionadas (id_personaje,id_habilidad) "
                                        + "VALUES("+personaje.getIdPersonaje()+","+hab.getIdHabilidad()+")";
                                System.out.println(insertHabilidadesSeleccionadas);
                                if(Conector.insertTable(insertHabilidadesSeleccionadas, conector)<0)
                                    throw new SQLException();
                            }
                        }
                        conector.commit();
                        personaje.setVidaMaxima(personaje.getVidaMaxima()+puntosGolpe);
                        personaje.setVidaActual(personaje.getVidaActual()+puntosGolpe);
                        personaje.setNivel(personaje.getNivel()+1);
                        abrirMenuFichaPersonaje(personaje, clase);
                    }
                    catch(SQLException ex){
                        ex.printStackTrace();
                        labelMensaje.setText("Error al insertar los datos");
                    }
                }
            }
        }
        else
            labelMensaje.setText("Introduce un número");
        
        
    }

    @FXML
    private void botonRestar(ActionEvent event) {
        String signo="";
        Button botonPulsado = (Button) event.getSource();
        int pos = listaBotonesRestar.indexOf(botonPulsado);
        System.out.println(pos);
        if(contadorIncrementos<MAXIMO_INCREMENTOS){
            int valorCaracteristica = Integer.parseInt(listaValoresCaracteristicas.get(pos).getText());
            int modCaracteristica = Integer.parseInt(listaModCaracteristicas.get(pos).getText());
            
                contadorIncrementos++;
                valorCaracteristica--;
                modCaracteristica=(valorCaracteristica-10)/2;
                listaBotonesSumar.get(pos).setDisable(false);
                if(modCaracteristica>0)
                    signo="+";
            
            listaValoresCaracteristicas.get(pos).setText(String.valueOf(valorCaracteristica));
            listaModCaracteristicas.get(pos).setText(signo+String.valueOf(modCaracteristica));
            int caracteristica = Integer.valueOf(listaValoresCaracteristicas.get(pos).getText());
            if(caracteristica!=listaCaracteristicasValorOriginal.get(pos))
                listaValoresCaracteristicas.get(pos).setStyle("-fx-background-color:#F4E96E");
            else
                listaValoresCaracteristicas.get(pos).setStyle("-fx-background-color:transparent"); 
        }
            
    }
    @FXML
    private void botonSumar(ActionEvent event) {
        String signo="";
        Button botonPulsado = (Button) event.getSource();
        int pos = listaBotonesSumar.indexOf(botonPulsado);
        System.out.println(pos);
        if(contadorIncrementos>0){
            int valorCaracteristica = Integer.parseInt(listaValoresCaracteristicas.get(pos).getText());
            int modCaracteristica = Integer.parseInt(listaModCaracteristicas.get(pos).getText());
                contadorIncrementos--;
                valorCaracteristica++;
                modCaracteristica=(valorCaracteristica-10)/2;
                listaBotonesRestar.get(pos).setDisable(false);
                if(modCaracteristica>0)
                    signo="+";
            listaValoresCaracteristicas.get(pos).setText(String.valueOf(valorCaracteristica));
            listaModCaracteristicas.get(pos).setText(signo+String.valueOf(modCaracteristica));
            int caracteristica = Integer.valueOf(listaValoresCaracteristicas.get(pos).getText());
            if(caracteristica!=listaCaracteristicasValorOriginal.get(pos))
                listaValoresCaracteristicas.get(pos).setStyle("-fx-background-color:#F4E96E");
            else
                listaValoresCaracteristicas.get(pos).setStyle("-fx-background-color:transparent"); 
        }
    }
    
    private void abrirMenuFichaPersonaje(Personaje personaje, Clase clase) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fichaPersonaje.fxml"));
            int nivelClase = personaje.getNivel();
            FichaPersonajeController fichaPersonaje = new FichaPersonajeController(personaje,clase.getNombre()+" "+nivelClase,clase);
            Parent root = fxmlLoader.load();
            fichaPersonaje.setPanePrincipal(contenedor);
            fxmlLoader.setController(fichaPersonaje);
            contenedor.getChildren().setAll(root);
        } catch (IOException ex) {
                ex.printStackTrace();
        }
    }

    @FXML
    private void seleccionaDote(ActionEvent event) {
    }
}
