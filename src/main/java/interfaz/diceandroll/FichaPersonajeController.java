/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.conector.Conector;
import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.clases.Habilidad;
import interfaz.diceandroll.clases.Personajes;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class FichaPersonajeController implements Initializable {

    private Pane panelPrincipal;
    private static Personajes personaje;
    private static String clase;
    @FXML
    private AnchorPane contenedor;
    @FXML
    private Label nombrePersonaje;
    @FXML
    private Label claseRazaNivel;
    @FXML
    private Label labelValorFuerza;
    @FXML
    private Label labelValorDestreza;
    @FXML
    private Label labelValorConstitucion;
    @FXML
    private Label labelValorInteligencia;
    @FXML
    private Label labelValorSabiduria;
    @FXML
    private Label labelValorCarisma;
    @FXML
    private Label labelFuerza;
    @FXML
    private Label labelDestreza;
    @FXML
    private Label labelConstitucion;
    @FXML
    private Label labelInteligencia;
    @FXML
    private Label labelSabiduria;
    @FXML
    private Label labelCarisma;
    @FXML
    private Label labelTSFue;
    @FXML
    private Label labelTSDes;
    @FXML
    private Label labelTSCon;
    @FXML
    private Label labelTSInt;
    @FXML
    private Label labelTSSab;
    @FXML
    private Label labelTSCar;
    @FXML
    private Label labelCompetenciaArmas;
    @FXML
    private Label labelCompetenciaArmaduras;
    @FXML
    private Label labelIdiomas;
    @FXML
    private Label labelArcanos;
    @FXML
    private Label labelAtletismo;
    @FXML
    private Label labelEngañar;
    @FXML
    private Label labelHistoria;
    @FXML
    private Label labelInterpretacion;
    @FXML
    private Label labelIntimidar;
    @FXML
    private Label labelInvestigacion;
    @FXML
    private Label labelJuegoManos;
    @FXML
    private Label labelMedicina;
    @FXML
    private Label labelNaturaleza;
    @FXML
    private Label labelPercepcion;
    @FXML
    private Label labelPerspicacia;
    @FXML
    private Label labelPersuasion;
    @FXML
    private Label labelReligion;
    @FXML
    private Label labelSigilo;
    @FXML
    private Label labelSupervivencia;
    @FXML
    private Label labelTratoConAnimales;
    @FXML
    private TextField textFieldVidaActual;
    @FXML
    private Label labelVidaMaxima;
    @FXML
    private Label labelCompetencia;
    @FXML
    private Label labelVelocidad;
    @FXML
    private Label labelIniciativa;
    @FXML
    private TextField labelCA;
    @FXML
    private Label labelAcrobacias;
    @FXML
    private Pane paneDescripcionHabilidad;
    @FXML
    private RadioButton radioAcrobacias;
    @FXML
    private RadioButton radioArcanos;
    @FXML
    private RadioButton radioAtletismo;
    @FXML
    private RadioButton radioEngañar;
    @FXML
    private RadioButton radioHistoria;
    @FXML
    private RadioButton radioInterpretacion;
    @FXML
    private RadioButton radioIntimidar;
    @FXML
    private RadioButton radioInvestigacion;
    @FXML
    private RadioButton radioJuegoDeManos;
    @FXML
    private RadioButton radioMedicina;
    @FXML
    private RadioButton radioNaturaleza;
    @FXML
    private RadioButton radioPercepcion;
    @FXML
    private RadioButton radioPerspicacia;
    @FXML
    private RadioButton radioPersuasion;
    @FXML
    private RadioButton radioReligion;
    @FXML
    private RadioButton radioSigilo;
    @FXML
    private RadioButton radioSupervivencia;
    @FXML
    private RadioButton radioTratoConAnilanes;
    ArrayList<Label> listaLabelHabilidades;
    ArrayList<Label> listaLabelCaracteristicaAsociada;
    ArrayList<Label> listaLabelTS;
    ArrayList<RadioButton> listaRadioButtonCompetenciaHabilidades;    
    ArrayList<RadioButton> listaRadioButtonTS;
    ArrayList<Habilidad> listaHabilidades;
    ArrayList<Habilidad> listaTS;
    ArrayList<String> listaNombreHabilidades;
    ArrayList<String> listaCaracteristicas;
    @FXML
    private Label labelCaracteristicaAsociada1;
    @FXML
    private Label labelCaracteristicaAsociada2;
    @FXML
    private Label labelCaracteristicaAsociada3;
    @FXML
    private Label labelCaracteristicaAsociada4;
    @FXML
    private Label labelCaracteristicaAsociada5;
    @FXML
    private Label labelCaracteristicaAsociada6;
    @FXML
    private Label labelCaracteristicaAsociada7;
    @FXML
    private Label labelCaracteristicaAsociada8;
    @FXML
    private Label labelCaracteristicaAsociada9;
    @FXML
    private Label labelCaracteristicaAsociada10;
    @FXML
    private Label labelCaracteristicaAsociada11;
    @FXML
    private Label labelCaracteristicaAsociada12;
    @FXML
    private Label labelCaracteristicaAsociada13;
    @FXML
    private Label labelCaracteristicaAsociada14;
    @FXML
    private Label labelCaracteristicaAsociada15;
    @FXML
    private Label labelCaracteristicaAsociada16;
    @FXML
    private Label labelCaracteristicaAsociada17;
    @FXML
    private Label labelCaracteristicaAsociada18;
    @FXML
    private RadioButton radioButtonTSFue;
    @FXML
    private RadioButton radioButtonTSDes;
    @FXML
    private RadioButton radioButtonTSCon;
    @FXML
    private RadioButton radioButtonTSInt;
    @FXML
    private RadioButton radioButtonTSSab;
    @FXML
    private RadioButton radioButtonTSCar;
    @FXML
    private ImageView imagenPersonaje;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaHabilidades = new ArrayList();
        listaLabelHabilidades = new ArrayList();
        listaLabelCaracteristicaAsociada = new ArrayList();
        listaRadioButtonCompetenciaHabilidades = new ArrayList();
        listaRadioButtonTS = new ArrayList();
        listaCaracteristicas = new ArrayList();
        listaLabelTS = new ArrayList();
        listaNombreHabilidades = new ArrayList();
        listaTS = new ArrayList();
        inicializarArrays();
        String signo = "";
        nombrePersonaje.setText(personaje.getNombre());
        claseRazaNivel.setText(clase);
        labelFuerza.setText(String.valueOf(personaje.getFue()));
        labelDestreza.setText(String.valueOf(personaje.getDes()));
        labelConstitucion.setText(String.valueOf(personaje.getCon()));
        labelInteligencia.setText(String.valueOf(personaje.getInte()));
        labelSabiduria.setText(String.valueOf(personaje.getSab()));
        labelCarisma.setText(String.valueOf(personaje.getCar()));
        if(personaje.getFue()>=10)
            signo="+";
        labelValorFuerza.setText(String.valueOf(signo+(personaje.getFue()-10)/2));
        if(personaje.getDes()>=10)
            signo="+";
        labelValorDestreza.setText(String.valueOf(signo+(personaje.getDes()-10)/2));
        if(personaje.getCon()>=10)
            signo="+";
        labelValorConstitucion.setText(String.valueOf(signo+(personaje.getCon()-10)/2));
        if(personaje.getInte()>=10)
            signo="+";
        labelValorInteligencia.setText(String.valueOf(signo+(personaje.getInte()-10)/2));
        if(personaje.getSab()>=10)
            signo="+";
        labelValorSabiduria.setText(String.valueOf(signo+(personaje.getSab()-10)/2));
        if(personaje.getSab()>=10)
            signo="+";
        labelValorCarisma.setText(String.valueOf(signo+(personaje.getCar()-10)/2));
        if(personaje.getCar()>=10)
            signo="+";
        labelCompetencia.setText(String.valueOf("+"+personaje.getCompetencia()));
        textFieldVidaActual.setText(String.valueOf(personaje.getVidaActual()));
        labelVidaMaxima.setText(String.valueOf(personaje.getVidaMaxima()));
        labelVelocidad.setText(String.valueOf(personaje.getVelocidad()));
        if(personaje.getIniciativa()>0)
            signo="+";
        labelIniciativa.setText(String.valueOf(signo+personaje.getIniciativa()));
        labelCA.setText(String.valueOf(personaje.getClaseArmadura()));
        int contador = 0;
        int contadorHabilidades = 0;
        
        try {
            String consultaCompetenciaHabilidades = "SELECT * FROM habilidad_personaje where id_personaje="+personaje.getIdPersonaje();
            ResultSet rsCompHabilidades = Conector.getSelect(consultaCompetenciaHabilidades, conector);
            while(rsCompHabilidades.next()){
                String habilidad = rsCompHabilidades.getString("habilidad");
                int base = rsCompHabilidades.getInt("base");
                int bono = rsCompHabilidades.getInt("bono");
                boolean competencia = rsCompHabilidades.getBoolean("competencia");
                boolean pericia = rsCompHabilidades.getBoolean("pericia");
                Habilidad hab = new Habilidad(habilidad,base,bono,competencia,pericia);
                listaHabilidades.add(hab);
            }
            
            for(Label label: listaLabelHabilidades){
                String car = listaLabelCaracteristicaAsociada.get(contador).getText();
                String signoHab = "";
                if(contadorHabilidades<listaHabilidades.size()&&listaNombreHabilidades.get(contador).equals(listaHabilidades.get(contadorHabilidades).getNombre())){
                    int base = listaHabilidades.get(contadorHabilidades).getBase();
                    int bono = listaHabilidades.get(contadorHabilidades).getBono();
                    boolean comp = listaHabilidades.get(contadorHabilidades).isCompetencia();
                    boolean pericia = listaHabilidades.get(contadorHabilidades).isPericia();
                    if(listaNombreHabilidades.get(contador).equals(listaHabilidades.get(contadorHabilidades).getNombre())){
                        if(pericia){
                            if(base+bono+(personaje.getCompetencia()*2)>0)
                                signoHab="+";
                            listaLabelHabilidades.get(contador).setText(signoHab+String.valueOf(base+bono+(personaje.getCompetencia()*2))); 
                            listaRadioButtonCompetenciaHabilidades.get(contador).setSelected(true);
                        }
                        else if(comp){
                            if(base+bono+personaje.getCompetencia()>0)
                                signoHab="+";
                            listaLabelHabilidades.get(contador).setText(signoHab+String.valueOf(base+bono+personaje.getCompetencia()));    
                            listaRadioButtonCompetenciaHabilidades.get(contador).setSelected(true);
                        }
                        else{
                            if(base+bono>0)
                                signoHab="+";
                            listaLabelHabilidades.get(contador).setText(signoHab+String.valueOf(base+bono));
                        }
                    }
                    contadorHabilidades++;
                }
                else{
                    switch (car) {
                        case "Fue":
                            if(personaje.getFue()>10)
                                signoHab="+";
                            label.setText(String.valueOf(signoHab+(personaje.getFue()-10)/2));
                            break;
                        case "Des":
                            if(personaje.getDes()>10)
                                signoHab="+";
                            label.setText(String.valueOf(signoHab+(personaje.getDes()-10)/2));
                            break;
                        case "Con":
                            if(personaje.getCon()>10)
                                signoHab="+";
                            label.setText(String.valueOf(signoHab+(personaje.getCon()-10)/2));
                            break;
                        case "Int":
                            if(personaje.getInte()>10)
                                signoHab="+";
                            label.setText(String.valueOf(signoHab+(personaje.getInte()-10)/2));
                            break;
                        case "Sab":
                            if(personaje.getSab()>10)
                                signoHab="+";
                            label.setText(String.valueOf(signoHab+(personaje.getSab()-10)/2));
                            break;
                        case "Car":
                            if(personaje.getCar()>10)
                                signoHab="+";
                            label.setText(String.valueOf(signoHab+(personaje.getCar()-10)/2));
                            break;
                    }
                }
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar competencias");
            ex.printStackTrace();
        }
        
        
        
        
        String consultaTS = "SELECT * FROM ts_personaje WHERE id_personaje="+personaje.getIdPersonaje();
        ResultSet rsTS = Conector.getSelect(consultaTS, conector);
        contador = 0;
        int contadorTS = 0;
        try{
            while(rsTS.next()){
                String nombreHabilidad = rsTS.getString("caracteristica");
                int base = rsTS.getInt("base");
                int mod = rsTS.getInt("modificador");
                boolean comp = rsTS.getBoolean("competencia");
                Habilidad hab = new Habilidad(nombreHabilidad, base, mod, comp);
                listaTS.add(hab);
            }
            for(Habilidad ts:listaTS){
                String car = listaCaracteristicas.get(contador);
                if(contadorTS<listaTS.size()&&listaCaracteristicas.get(contador).equals(listaTS.get(contadorTS).getNombre())){
                    int base = listaTS.get(contadorTS).getBase();
                    int bono = listaTS.get(contadorTS).getBono();
                    boolean comp = listaTS.get(contadorTS).isCompetencia();
                    if(comp){
                        if(base+bono+(personaje.getCompetencia())>0){
                                signo="+";
                            listaLabelTS.get(contador).setText(signo+String.valueOf(base+bono+personaje.getCompetencia())); 
                            listaRadioButtonTS.get(contador).setSelected(true);
                        }
                    }
                    else{
                        if(base+bono>0){
                                signo="+";
                            listaLabelTS.get(contador).setText(signo+String.valueOf(base+bono)); 
                        }
                    }
                    
                    contadorTS++;
                }
                else{
                    signo = "";
                    switch (car) {
                        case "Fue":
                            if(personaje.getFue()>10)
                                signo="+";
                            labelTSFue.setText(String.valueOf(signo+(personaje.getFue()-10)/2));
                            break;
                        case "Des":
                            if(personaje.getDes()>10)
                                signo="+";
                            labelTSDes.setText(String.valueOf(signo+(personaje.getDes()-10)/2));
                            break;
                        case "Con":
                            if(personaje.getCon()>10)
                                signo="+";
                            labelTSCon.setText(String.valueOf(signo+(personaje.getCon()-10)/2));
                            break;
                        case "Int":
                            if(personaje.getInte()>10)
                                signo="+";
                            labelTSInt.setText(String.valueOf(signo+(personaje.getInte()-10)/2));
                            break;
                        case "Sab":
                            if(personaje.getSab()>10)
                                signo="+";
                            labelTSSab.setText(String.valueOf(signo+(personaje.getSab()-10)/2));
                            break;
                        case "Car":
                            if(personaje.getCar()>10)
                                signo="+";
                            labelTSCar.setText(String.valueOf(signo+(personaje.getCar()-10)/2));
                            break;
                    }
                }
                contador++;
            }
        }
        catch(SQLException ex){
            System.out.println("Error al cargar la lista de TS del personaje");
            ex.printStackTrace();
        }    
    }
    
    private void inicializarArrays(){
        listaHabilidades.clear();
        listaLabelHabilidades.clear();
        listaRadioButtonCompetenciaHabilidades.clear();
        listaRadioButtonCompetenciaHabilidades.clear();
        listaNombreHabilidades.clear();
        listaLabelTS.clear();
        listaNombreHabilidades.clear();
        listaRadioButtonCompetenciaHabilidades.clear();
        listaRadioButtonTS.clear();
        listaTS.clear();
        listaLabelHabilidades.add(labelAcrobacias);
        listaLabelHabilidades.add(labelArcanos);
        listaLabelHabilidades.add(labelAtletismo);
        listaLabelHabilidades.add(labelEngañar);
        listaLabelHabilidades.add(labelHistoria);
        listaLabelHabilidades.add(labelInterpretacion);
        listaLabelHabilidades.add(labelIntimidar);
        listaLabelHabilidades.add(labelInvestigacion);
        listaLabelHabilidades.add(labelJuegoManos);
        listaLabelHabilidades.add(labelMedicina);
        listaLabelHabilidades.add(labelNaturaleza);
        listaLabelHabilidades.add(labelPercepcion);
        listaLabelHabilidades.add(labelPerspicacia);
        listaLabelHabilidades.add(labelPersuasion);
        listaLabelHabilidades.add(labelReligion);
        listaLabelHabilidades.add(labelSigilo);
        listaLabelHabilidades.add(labelSupervivencia);
        listaLabelHabilidades.add(labelTratoConAnimales);
        listaRadioButtonCompetenciaHabilidades.add(radioAcrobacias);
        listaRadioButtonCompetenciaHabilidades.add(radioArcanos);
        listaRadioButtonCompetenciaHabilidades.add(radioAtletismo);
        listaRadioButtonCompetenciaHabilidades.add(radioEngañar);
        listaRadioButtonCompetenciaHabilidades.add(radioHistoria);
        listaRadioButtonCompetenciaHabilidades.add(radioInterpretacion);
        listaRadioButtonCompetenciaHabilidades.add(radioIntimidar);
        listaRadioButtonCompetenciaHabilidades.add(radioInvestigacion);
        listaRadioButtonCompetenciaHabilidades.add(radioJuegoDeManos);
        listaRadioButtonCompetenciaHabilidades.add(radioMedicina);
        listaRadioButtonCompetenciaHabilidades.add(radioNaturaleza);
        listaRadioButtonCompetenciaHabilidades.add(radioPercepcion);
        listaRadioButtonCompetenciaHabilidades.add(radioPerspicacia);
        listaRadioButtonCompetenciaHabilidades.add(radioPersuasion);
        listaRadioButtonCompetenciaHabilidades.add(radioReligion);
        listaRadioButtonCompetenciaHabilidades.add(radioSigilo);
        listaRadioButtonCompetenciaHabilidades.add(radioSupervivencia);
        listaRadioButtonCompetenciaHabilidades.add(radioTratoConAnilanes);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada1);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada2);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada3);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada4);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada5);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada6);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada7);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada8);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada9);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada10);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada11);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada12);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada13);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada14);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada15);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada16);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada17);
        listaLabelCaracteristicaAsociada.add(labelCaracteristicaAsociada18);
        listaLabelTS.add(labelTSFue);
        listaLabelTS.add(labelTSDes);
        listaLabelTS.add(labelTSCon);
        listaLabelTS.add(labelTSInt);
        listaLabelTS.add(labelTSSab);
        listaLabelTS.add(labelTSCar);
        listaNombreHabilidades.add("acrobacias");
        listaNombreHabilidades.add("arcanos");
        listaNombreHabilidades.add("atletismo");
        listaNombreHabilidades.add("engañar");
        listaNombreHabilidades.add("historia");
        listaNombreHabilidades.add("interpretacion");
        listaNombreHabilidades.add("intimidar");
        listaNombreHabilidades.add("investigacion");
        listaNombreHabilidades.add("juego de manos");
        listaNombreHabilidades.add("medicina");
        listaNombreHabilidades.add("naturaleza");
        listaNombreHabilidades.add("percepcion");
        listaNombreHabilidades.add("perspicacia");
        listaNombreHabilidades.add("persuasion");
        listaNombreHabilidades.add("religion");
        listaNombreHabilidades.add("sigilo");
        listaNombreHabilidades.add("supervivencia");
        listaNombreHabilidades.add("trato con animales");
        listaCaracteristicas.add("Fuerza");
        listaCaracteristicas.add("Destreza");
        listaCaracteristicas.add("Constitucion");
        listaCaracteristicas.add("Inteligencia");
        listaCaracteristicas.add("Sabiduria");
        listaCaracteristicas.add("Carisma");
        listaRadioButtonTS.add(radioButtonTSFue);
        listaRadioButtonTS.add(radioButtonTSDes);
        listaRadioButtonTS.add(radioButtonTSCon);
        listaRadioButtonTS.add(radioButtonTSInt);
        listaRadioButtonTS.add(radioButtonTSSab);
        listaRadioButtonTS.add(radioButtonTSCar);
        
        
    }
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }
    public FichaPersonajeController(){
        
    }
    public FichaPersonajeController(Personajes personaje,String clase){
        this.personaje=personaje;
        this.clase=clase;
    }

    @FXML
    private void abrirMenuEditarPersonaje(ActionEvent event) {
    }
}
