/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.ExplorarConjuroController;
import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.clases.Clase;
import interfaz.diceandroll.clases.Conjuro;
import interfaz.diceandroll.clases.Libro;
import interfaz.diceandroll.conector.Conector;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class ListaConjurosController implements Initializable {

    @FXML
    private TextField textFieldBuscador;
    @FXML
    private ComboBox<Integer> comboBoxNivel;
    @FXML
    private ComboBox<String> comboboxEscuela;
    @FXML
    private ComboBox<Clase> comboBoxClase;
    @FXML
    private ComboBox<String> comboBoxNombre;
    @FXML
    private ComboBox<String> comboBoxTipoDaño;
    @FXML
    private Button botonVolverInicio;
    @FXML
    private Button botonRetrocederUno;
    @FXML
    private HBox hboxPaginacion;
    @FXML
    private Button botonAvanzarUno;
    @FXML
    private Button botonAlFinal;

    
    ArrayList<interfaz.diceandroll.clases.Conjuro> listaConjuros;
    ArrayList<interfaz.diceandroll.clases.Clase> listaClases;
    ArrayList<interfaz.diceandroll.clases.Libro> listaLibros;
    ArrayList<Pane> listaPane;
    ArrayList<Label> listaNombre;
    ArrayList<Label> listaLabelLibros;
    ArrayList<Button> listaBotones;
    private int indice = 0;
    private int totalPaginas;
    private int paginaActual=1;
    int inicio;
    private final int NUM_ELEMENTOS_POR_PAGINA = 12;
    Conjuro conjuro;
    private Pane panelPrincipal;
    @FXML
    private AnchorPane contenedor;
    @FXML
    private Label nombreConjuro1;
    @FXML
    private Label nombreConjuro2;
    @FXML
    private Label nombreConjuro3;
    @FXML
    private Label nombreConjuro4;
    @FXML
    private Label nombreConjuro5;
    @FXML
    private Label nombreConjuro6;
    @FXML
    private Label nombreConjuro7;
    @FXML
    private Label nombreConjuro8;
    @FXML
    private Label nombreConjuro9;
    @FXML
    private Label nombreConjuro10;
    @FXML
    private Label nombreConjuro11;
    @FXML
    private Label nombreConjuro12;
    @FXML
    private Label libroConjuro12;
    @FXML
    private Pane conjuro1;
    @FXML
    private Label libroConjuro1;
    @FXML
    private Pane conjuro2;
    @FXML
    private Label libroConjuro2;
    @FXML
    private Pane conjuro3;
    @FXML
    private Label libroConjuro3;
    @FXML
    private Pane conjuro4;
    @FXML
    private Label libroConjuro4;
    @FXML
    private Pane conjuro5;
    @FXML
    private Label libroConjuro5;
    @FXML
    private Pane conjuro6;
    @FXML
    private Label libroConjuro6;
    @FXML
    private Pane conjuro7;
    @FXML
    private Label libroConjuro7;
    @FXML
    private Pane conjuro8;
    @FXML
    private Label libroConjuro8;
    @FXML
    private Pane conjuro9;
    @FXML
    private Label libroConjuro9;
    @FXML
    private Pane conjuro10;
    @FXML
    private Label libroConjuro10;
    @FXML
    private Pane conjuro11;
    @FXML
    private Label libroConjuro11;
    @FXML
    private Pane conjuro12;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializamos todas las listas
        listaConjuros = new ArrayList();
        listaLibros = new ArrayList();
        listaPane = new ArrayList();
        listaNombre = new ArrayList();
        listaLabelLibros = new ArrayList();
        listaBotones = new ArrayList();
        Integer[] filtrosOrdenacionNivel = {null,0,1,2,3,4,5,6,7,8,9};
        ObservableList<Integer> listaValoresNivel = FXCollections.observableArrayList(filtrosOrdenacionNivel);
        String[] filtrosOrdenacionEscuela = {null,"Abjuración","Adivinación","Conjuración","Encantamiento","Evocación","Ilusión","Nigromancia","Transmutación"};
        ObservableList<String> listaValoresEscuela = FXCollections.observableArrayList(filtrosOrdenacionEscuela);
        String[] filtrosOrdenacionNombre= {"Nombre [a-z]","Nombre [z-a]", "Libro", "Nivel"};
        ObservableList<String> listaValoresNombre = FXCollections.observableArrayList(filtrosOrdenacionNombre);
        //Inicializamos las listas
        comboBoxNivel.setItems(listaValoresNivel);
        comboboxEscuela.setItems(listaValoresEscuela);
        comboBoxNombre.setItems(listaValoresNombre);
        //Llamamos al método que recoge todas las clases y rellena el grid
        getClases();
        //Desactivamos los botones de navegación en caso necesario (los botones de retroceder si estamos en la primera página o los de avanzar si estamos en la última, además de desactivar el botón de la página actual)
        desactivarBotones();
    }    
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }

     public void generaArrays(){
        listaPane.clear();
        listaNombre.clear();
        listaConjuros.clear();
        //listaClases.clear();
        listaLibros.clear();
        listaPane.add(conjuro1);
        listaPane.add(conjuro2);
        listaPane.add(conjuro3);
        listaPane.add(conjuro4);
        listaPane.add(conjuro5);
        listaPane.add(conjuro6);
        listaPane.add(conjuro7);
        listaPane.add(conjuro8);
        listaPane.add(conjuro9);
        listaPane.add(conjuro10);
        listaPane.add(conjuro11);
        listaPane.add(conjuro12);
        listaNombre.add(nombreConjuro1);
        listaNombre.add(nombreConjuro2);
        listaNombre.add(nombreConjuro3);
        listaNombre.add(nombreConjuro4);
        listaNombre.add(nombreConjuro5);
        listaNombre.add(nombreConjuro6);
        listaNombre.add(nombreConjuro7);
        listaNombre.add(nombreConjuro8);
        listaNombre.add(nombreConjuro9);
        listaNombre.add(nombreConjuro10);
        listaNombre.add(nombreConjuro11);
        listaNombre.add(nombreConjuro12);
        listaLabelLibros.add(libroConjuro1);
        listaLabelLibros.add(libroConjuro2);
        listaLabelLibros.add(libroConjuro3);
        listaLabelLibros.add(libroConjuro4);
        listaLabelLibros.add(libroConjuro5);
        listaLabelLibros.add(libroConjuro6);
        listaLabelLibros.add(libroConjuro7);
        listaLabelLibros.add(libroConjuro8);
        listaLabelLibros.add(libroConjuro9);
        listaLabelLibros.add(libroConjuro10);
        listaLabelLibros.add(libroConjuro11);
        listaLabelLibros.add(libroConjuro12);
     }
     
    /**
     * Este es el método que busca los conjuros en base de datos 
     */
    public void getClases(){
        generaArrays();
        String buscador = textFieldBuscador.getText();
        String nombreBuscador = comboBoxNombre.getValue();
        Clase claseBuscador = comboBoxClase.getValue();
        Integer nivelBuscador = comboBoxNivel.getValue();
        //String tipoDaño = comboBoxTipoDaño.getValue();
        String escuelaBuscador = comboboxEscuela.getValue();
        
        
        try {
            //Hacemos una consulta con base de datos para seleccionar los conjuros, las clases y los libros de reglas
            String consulta = "SELECT * from conjuro "
                    + "INNER JOIN libros_reglas on conjuro.id_libro = libros_reglas.id_libro "
                    + "INNER JOIN lista_conjuros on conjuro.id_conjuro = lista_conjuros.id_conjuro ";
            //Si queremos filtrar por nombre, aquí lo podemos hacer 
            if(!buscador.equals("")||claseBuscador!=null||nivelBuscador!=null||escuelaBuscador!=null){
                consulta += " WHERE ";
                boolean esPrimero=true;
                if(!buscador.equals("")){
                    consulta += " conjuro.nombre LIKE '%"+buscador+"%' ";
                    esPrimero=false;
                }
                if(claseBuscador!=null){
                    if(!esPrimero)
                        consulta += " AND ";
                    consulta += " clase.nombre = '"+claseBuscador+"' ";
                    esPrimero=false;
                }
                if(nivelBuscador!=null){
                    if(!esPrimero)
                        consulta += " AND ";
                    consulta += " conjuro.nivel = "+nivelBuscador+" ";
                    esPrimero=false;
                }
                if(escuelaBuscador!=null){
                    if(!esPrimero)
                        consulta += " AND ";
                    consulta += " conjuro.escuela = '"+escuelaBuscador+"' ";
                    esPrimero=false;
                }   
            }
            consulta += " GROUP BY conjuro.id_conjuro, conjuro.nombre";
            //Si queremos ordenar por nombre ascendente o descendente o por libro de reglas
            if(nombreBuscador!=null){
                if(nombreBuscador.equals("Nombre [a-z]"))
                    consulta += " ORDER BY conjuro.nombre asc ";
                else if(nombreBuscador.equals("Nombre [z-a]"))
                    consulta += " ORDER BY conjuro.nombre desc ";
                else if(nombreBuscador.equals("Libro"))
                    consulta += " ORDER BY conjuro.id_libro, conjuro.nombre asc";
                else if(nombreBuscador.equals("Nivel"))
                    consulta += " ORDER BY conjuro.nivel, conjuro.id_libro, conjuro.nombre asc";
            }
            else
                consulta += " ORDER BY libros_reglas.id_libro, conjuro.nombre";
            //Establecemos la conexion con la base de datos y recogemos los datos encontrados
            System.out.println(consulta);
            ResultSet conjuros = Conector.getSelect(consulta, conector);
            while(conjuros.next()){
                //Recogemos toda la información de la clase y creamos un objeto con ella, también para el libro de reglas asociado
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
                String nombreLibro = conjuros.getString("libros_reglas.nombre");
                int idLibro = conjuros.getInt("conjuro.id_libro");
                interfaz.diceandroll.clases.Conjuro conjuro = new Conjuro(idConjuro,nombre,nivel,escuela,compVerbal,compSomatico,compMaterial,textCompMaterial,tiempoLanzamiento,alcance,duracion,descripcion,idLibro);
                interfaz.diceandroll.clases.Libro libro = new Libro(idLibro,nombreLibro);
                //Añadimos ambos a sus respectivas listas
                listaConjuros.add(conjuro);
                listaLibros.add(libro);
            }
            //Llamamos al metodo para rellenar el grid con los datos de ambas listas para que el usuario pueda ver las clases
            rellenaConjuros();
            //El total de las páginas será igual a la división entera de el tamaño de la lista de clases entre el número de elementos por página
            totalPaginas = (int) Math.ceil((double) listaConjuros.size() / NUM_ELEMENTOS_POR_PAGINA);
            /**
             * Eliminamos los botones de navegación ya existentes, esto se hace por si se aplica un filtro, que se volverá a llamar a este método,
             * lo que generaba botones de forma indefinida
            */
            for(Button boton:listaBotones){
                hboxPaginacion.getChildren().remove(boton);
            }
            //Creamos los botones de navegación, se crearán tantos botones como páginas haya y se les asigna el evento que permite navegar entre ellos
            for(int i=1;i<=totalPaginas;i++){
                int pagina = i;
                Button botonPagina = new Button(Integer.toString(i));
                listaBotones.add(botonPagina);
                botonPagina.setOnAction(event -> {
                    actualizarContenido(pagina);
                });
                hboxPaginacion.getChildren().add(botonPagina);
                //Se les asigna un id para aplicarle el estilo css
                botonPagina.setId("botonPaginacion");
            }
            //Se llama al método que desactiva los botones para desactivar el botón de la página actual y los botones de inicio y fin si nos encontramos en la primera y última página
            desactivarBotones();
        } catch (SQLException ex) {
            System.out.println("Error al encontrar los conjuros");
            ex.printStackTrace();
        }
    }
    
    /**
     * Este método se llama en caso de pulsar un boton de navegacion, llama a los metodos que desactivan los botones y rellenan los conjuros
     * @param numero 
     */
    private void actualizarContenido(int numero){
        paginaActual=numero;
        desactivarBotones();
        rellenaConjuros();        
    }
    
    /**
     * Este metodo rellena el grid con las clases
     */
    private void rellenaConjuros() {
        Iterator iter = listaConjuros.iterator();
        int contador = 0;
        inicio = (paginaActual - 1) * NUM_ELEMENTOS_POR_PAGINA;
        //Rellenamos la información de cada panel de información de clase con su contenido
        while (iter.hasNext() && contador < NUM_ELEMENTOS_POR_PAGINA && inicio + contador < listaConjuros.size()) {
            listaPane.get(contador).setVisible(true);
            listaNombre.get(contador).setText(listaConjuros.get(inicio + contador).getNombre());
            listaLabelLibros.get(contador).setText(listaLibros.get(inicio + contador).getNombre());
            iter.next();
            contador++;
        }
        //En caso de que queden huecos de información por rellenar y no se haya hecho todavía, se hace aquí
        if (contador == NUM_ELEMENTOS_POR_PAGINA && inicio + contador < listaConjuros.size()) {
            listaPane.get(contador-1).setVisible(true);
            //System.out.println(contador);
            listaNombre.get(contador-1).setText(listaConjuros.get(inicio + contador-1).getNombre());
            listaLabelLibros.get(contador-1).setText(listaLibros.get(inicio + contador-1).getNombre());
            contador++;
        }
        //Eliminamos todos los huecos vacíos que hayan quedado
        for (int i = contador; i < NUM_ELEMENTOS_POR_PAGINA; i++) {
            listaPane.get(i).setVisible(false);
            listaNombre.get(i).setText("");
            listaLabelLibros.get(i).setText("");
        }
        desactivarBotones();
    }
    
    /**
     * Este es el método que desactiva los botones en caso necesario.
     */
    private void desactivarBotones(){
        //Desactivamos el boton de la pagina actual
        for(Button boton:listaBotones){
            if(boton.getText().equals(String.valueOf(paginaActual)))
                boton.setDisable(true);
            else
                boton.setDisable(false);
        }
        //Desactivamos los botones fijos dependiendo de la pagia actual, si es la primera no se podrá ir más atrás y el mismo caso para la última página
        if(paginaActual==1){
            botonRetrocederUno.setDisable(true);
            botonVolverInicio.setDisable(true);
        }
        else{
            botonRetrocederUno.setDisable(false);
            botonVolverInicio.setDisable(false);
        }
        if(paginaActual==totalPaginas){                
            botonAvanzarUno.setDisable(true);
            botonAlFinal.setDisable(true);
        }
        else{
            botonAvanzarUno.setDisable(false);
            botonAlFinal.setDisable(false);
        }
    }
    
    /**
     * Este método vacía todas las listas y llama el método que devuelve las clases con los filtros aplicados
     * @param event 
     */
    @FXML
    private void botonAplicarFiltro(ActionEvent event) {
        generaArrays();
        int contador=0;
        paginaActual=1;
        while(contador<NUM_ELEMENTOS_POR_PAGINA){
            listaPane.get(contador).setVisible(false); 
            listaNombre.get(contador).setText("");
            contador++;
        }
        getClases();
        
    }
    
    /**
     * Regresa a la primera página
     * @param event 
     */
    @FXML
    private void botonVolverInicioArray(ActionEvent event) {
        paginaActual=1;
        desactivarBotones();
        rellenaConjuros();
    }
    /**
     * Retrocede una página
     * @param event 
     */
    @FXML
    private void botonRetrocederUnoArray(ActionEvent event) {
        paginaActual--;
        desactivarBotones();
        rellenaConjuros();
    }

    /**
     * Avanza una página
     * @param event 
     */
    @FXML
    private void botonAvanzarUnoArray(ActionEvent event) {
        paginaActual++;
        desactivarBotones();
        rellenaConjuros();
    }
    /**
     * Avanza hasta la última página
     * @param event 
     */
    @FXML
    private void botonIrAlFinalArray(ActionEvent event) {
        paginaActual=totalPaginas;
        desactivarBotones();
        rellenaConjuros();
    }
    
    
    /**
     * Abrimos la ventana de información detallada de el conjuro seleccionado
     * @param event 
     */
    @FXML
    private void abrirConjuro(MouseEvent event) {
        Pane panePulsado = (Pane)event.getSource();
        String idPane = panePulsado.getId();
        System.out.println(idPane);
        int longitudTexto = idPane.length();
        //System.out.println(longitudTexto);
        int id = Integer.parseInt(idPane.substring(longitudTexto-1));
        System.out.println(id);
        int indice = inicio+(id-1);
        if(idPane.equals("conjuro10"))
            indice=inicio+9;
        if(idPane.equals("conjuro11"))
            indice=inicio+10;
        if(idPane.equals("conjuro12"))
            indice=inicio+11;
        //System.out.println(indice);
        //System.out.println(id-1);
        conjuro = listaConjuros.get(indice);
        //clase = listaClases.get(indice);
        Libro libro = listaLibros.get(indice);
        abrirMenuExplorarConjuro(conjuro,libro);
        //abrirMenuExplorarConjuro(conjuro,clase,libro);
    }
    
    
    /**
     * Se carga la ventana con la clase seleccionada
     * @param clase
     * @param libro 
     */
    private void abrirMenuExplorarConjuro(Conjuro conjuro,Libro libro) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("explorarConjuro.fxml"));
        ExplorarConjuroController explorarConjuroController = new ExplorarConjuroController(conjuro,libro);
        Parent root = fxmlLoader.load();
        explorarConjuroController.setPanePrincipal(contenedor);
        fxmlLoader.setController(explorarConjuroController);
        contenedor.getChildren().setAll(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
