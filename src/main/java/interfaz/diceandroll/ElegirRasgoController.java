/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.clases.Trasfondo;
import interfaz.diceandroll.conector.Conector;
import static interfaz.diceandroll.App.conector;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class ElegirRasgoController implements Initializable {
    private static Trasfondo trasfondo;
    @FXML
    private Label labelNombre;
    @FXML
    private TextArea textAreaRasgos;
    @FXML
    private VBox vboxRasgos;
    @FXML
    private Label labelDado;
    @FXML
    private Label labelRasgos;
    @FXML
    private Button botonAplicar;
    @FXML
    private Button botonCancelar;
    private CrearPersonajePagina2Controller paginaAnterior;
    private String texto;
    private static ArrayList lista;
    @FXML
    private ScrollPane scrollPane;
    ArrayList<Label> listaLabel;
    ArrayList<Button> listaBotones;
    public static ArrayList<Boolean> listaBotonesPulsados;
    private StringBuilder textoAnyadido;
    private StringBuilder textoOriginal;
    @FXML
    private Label labelTextoTal;
    @FXML
    private HBox hboxTal;
    @FXML
    private AnchorPane anchorPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaLabel = new ArrayList();
        listaBotones = new ArrayList();
        textoAnyadido = new StringBuilder();
        textoOriginal = new StringBuilder();
    }    
    
    public ElegirRasgoController(){
        
    }
    
    public ElegirRasgoController(Trasfondo trasfondo){
        this.trasfondo=trasfondo;
    }

    @FXML
    private void alAzar(ActionEvent event) {
        int aleatorio = (int) (Math.random() * listaLabel.size());
        Button boton = listaBotones.get(aleatorio);
        String style = "-fx-background-color: #3583F2;-fx-text-fill: #FFF;font-family: Calibri;font-weight:bold;font-size:14";
        String texto = listaLabel.get(aleatorio).getText() + "\n";
        for(Button botones: listaBotones){
            botones.getStyleClass().remove("pulsado");
            botones.setStyle(style);
            botones.setText("+");
        }
        textAreaRasgos.clear();
        textAreaRasgos.setText(texto);
        if (boton.getStyleClass().contains("pulsado")) {
            boton.getStyleClass().remove("pulsado");
            boton.setStyle(style);
            boton.setText("+");
        } else {
            boton.getStyleClass().add("pulsado");
            boton.setStyle("-fx-background-color: #00BF63;-fx-text-fill: #FFF;font-family: Calibri;font-weight:bold;font-size:14");
            boton.setText("-");
        }
        boton.fire();
    }

    @FXML
    private void aplicar(ActionEvent event) {
        try {
            texto = textAreaRasgos.getText();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("elegirRasgo.fxml"));
            Parent root = loader.load();
            ElegirRasgoController elegirRasgoController = loader.getController();
            System.out.println(texto);
            Stage stage = (Stage) botonAplicar.getScene().getWindow();
            stage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stage = (Stage) botonCancelar.getScene().getWindow();
        stage.close();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public void setNombreRasgo(String nombreRasgo){
        labelNombre.setText(nombreRasgo);
    }
    
    public void setDado(int dado){
        labelDado.setText("D"+String.valueOf(dado));
    }
    public void setTrasfondo(Trasfondo trasfondo){
        this.trasfondo=trasfondo;
    }
    public void setLista(ArrayList lista){
        int contador=1;
        for(Object rasgo: lista){
            HBox hbox = new HBox();
            hbox.setPrefHeight(Control.USE_COMPUTED_SIZE);
            hbox.setPrefWidth(Control.USE_COMPUTED_SIZE);
            //hbox.setMaxWidth(Double.MAX_VALUE);
            Label numRasgo = new Label();
            numRasgo.setText(String.valueOf(contador));
            Label labelRasgo = new Label(rasgo.toString());
            listaLabel.add(labelRasgo);
            labelRasgo.setWrapText(true);
            Pane espacio = new Pane();
            Button botonAnyadir = new Button();
            botonAnyadir.setId(String.valueOf(""+contador));
            botonAnyadir.setText("+");
            botonAnyadir.setPrefWidth(25);
            botonAnyadir.setPrefHeight(25);
            listaBotones.add(botonAnyadir);
            numRasgo.setPrefWidth(Control.USE_COMPUTED_SIZE);
            espacio.setPrefWidth(Control.USE_COMPUTED_SIZE);
            labelRasgo.setPrefHeight(Control.USE_COMPUTED_SIZE);
            labelRasgo.setPrefWidth(485);
            vboxRasgos.setPrefHeight(Control.USE_COMPUTED_SIZE);
            String style = "-fx-background-color: #3583F2;-fx-text-fill: #FFF;font-family: Calibri;font-weight:bold;font-size:14";
            botonAnyadir.setStyle(style);
            numRasgo.setStyle("font-family:Calibri;font-weight:bold;font-size:14px");
            labelRasgo.setStyle("font-family:Calibri;font-weight:bold;font-size:14px");
            botonAnyadir.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    Button buton = (Button) event.getSource();
                    int id = Integer.parseInt(buton.getId())-1;
                    String texto = listaLabel.get(id).getText()+"\n";
                    
                    if (textoAnyadido.toString().contains(texto)) {
                        textoAnyadido.replace(textoAnyadido.indexOf(texto), textoAnyadido.indexOf(texto) + texto.length(), "");
                    } else {
                        textoAnyadido.append(texto);
                    }
                    textAreaRasgos.setText(textoOriginal.toString() + textoAnyadido.toString());
                    
                    if (buton.getStyleClass().contains("pulsado")) {
                        buton.getStyleClass().remove("pulsado");
                        buton.setStyle(style);
                        buton.setText("+");
                    } else {
                        buton.getStyleClass().add("pulsado");
                        buton.setStyle("-fx-background-color: #00BF63;-fx-text-fill: #FFF;font-family: Calibri;font-weight:bold;font-size:14");
                        buton.setText("-");
                    }
                    botonAnyadir.setPrefWidth(25);
                    botonAnyadir.setPrefHeight(25);
                }
            });
            hbox.setSpacing(10);
            hbox.getChildren().add(numRasgo);
            hbox.getChildren().add(labelRasgo);
            hbox.getChildren().add(espacio);
            hbox.getChildren().add(botonAnyadir);
            hbox.setAlignment(Pos.CENTER_LEFT);
            HBox.setHgrow(espacio, Priority.ALWAYS);
            ScrollPane sp = new ScrollPane();
            sp.setContent(hbox);
            vboxRasgos.getChildren().add(hbox);
            contador++;
        }
    }
    public void setTextoTextArea(String texto){
        textAreaRasgos.setText(texto);
    }
    
    public ArrayList getLista(){
        return lista;
    }
    public void setInvisible(){
        vboxRasgos.setVisible(false);
        hboxTal.setVisible(false);
        scrollPane.setVisible(false);
        labelTextoTal.setVisible(false);
        hboxTal.setMaxHeight(0);
        scrollPane.setMaxHeight(0);
        anchorPane.setMaxHeight(200);
        
    }
}
