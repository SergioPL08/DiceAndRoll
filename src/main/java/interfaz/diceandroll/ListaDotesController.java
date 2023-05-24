/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.ExplorarDoteController;
import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.clases.Dote;
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
public class ListaDotesController implements Initializable {
    //Variables FXML
    @FXML
    private Pane dote1,dote2,dote3,dote4,dote5,dote6,dote7,dote8,dote9,dote10,dote11,dote12,dote13,dote14,dote15;
    @FXML
    private Label nombreDote1,nombreDote2,nombreDote3,nombreDote4,nombreDote5,nombreDote6,nombreDote7,nombreDote8,nombreDote9,nombreDote10,nombreDote11,nombreDote12,nombreDote13,nombreDote14,nombreDote15;
    @FXML
    private Label libroDote1,libroDote2,libroDote3,libroDote4,libroDote5,libroDote6,libroDote7,libroDote8,libroDote9,libroDote10,libroDote11,libroDote12,libroDote13,libroDote14,libroDote15;
    @FXML
    private TextField textFieldBuscador;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private HBox hboxPaginacion;
    @FXML
    private Button botonVolverInicio;
    @FXML
    private Button botonRetrocederUno;
    @FXML
    private Button botonAvanzarUno;
    @FXML
    private Button botonAlFinal;
    @FXML
    private AnchorPane contenedor;
    
    //Variables propias
    private Pane panelPrincipal;
    ArrayList<interfaz.diceandroll.clases.Dote> listaDotes;
    ArrayList<interfaz.diceandroll.clases.Libro> listaLibros;
    ArrayList<Pane> listaPane;
    ArrayList<Label> listaNombre;
    ArrayList<Label> listaLabelLibros;
    ArrayList<Button> listaBotones;
    private int indice = 0;
    private int totalPaginas;
    private int paginaActual=1;
    int inicio;
    private final int NUM_ELEMENTOS_POR_PAGINA = 15;
    Dote dote;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializamos todas las listas
        listaDotes = new ArrayList();
        listaLibros = new ArrayList();
        listaPane = new ArrayList();
        listaNombre = new ArrayList();
        listaLabelLibros = new ArrayList();
        listaBotones = new ArrayList();
        String[] filtrosOrdenacion = {"Nombre [a-z]","Nombre [z-a]", "Libro"};
        ObservableList<String> listaValores = FXCollections.observableArrayList(filtrosOrdenacion);
        //Inicializamos las listas
        comboBox.setItems(listaValores);
        //Llamamos al método que recoge todas las dotes y rellena el grid
        getDotes();
        //Desactivamos los botones de navegación en caso necesario (los botones de retroceder si estamos en la primera página o los de avanzar si estamos en la última, además de desactivar el botón de la página actual)
        desactivarBotones();
    }    
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }
    /**
     * Este metodo añade las dotes, los nombres de las mismas y su libro asociado a su respectiva lista
     */
    public void generaArrayDotes(){
        listaPane.clear();
        listaLabelLibros.clear();
        listaLibros.clear();
        listaNombre.clear();
        listaDotes.clear();
        listaPane.add(dote1);
        listaPane.add(dote2);
        listaPane.add(dote3);
        listaPane.add(dote4);
        listaPane.add(dote5);
        listaPane.add(dote6);
        listaPane.add(dote7);
        listaPane.add(dote8);
        listaPane.add(dote9);
        listaPane.add(dote10);
        listaPane.add(dote11);
        listaPane.add(dote12);
        listaPane.add(dote13);
        listaPane.add(dote14);
        listaPane.add(dote15);
        listaNombre.add(nombreDote1);
        listaNombre.add(nombreDote2);
        listaNombre.add(nombreDote3);
        listaNombre.add(nombreDote4);
        listaNombre.add(nombreDote5);
        listaNombre.add(nombreDote6);
        listaNombre.add(nombreDote7);
        listaNombre.add(nombreDote8);
        listaNombre.add(nombreDote9);
        listaNombre.add(nombreDote10);
        listaNombre.add(nombreDote11);
        listaNombre.add(nombreDote12);
        listaNombre.add(nombreDote13);
        listaNombre.add(nombreDote14);
        listaNombre.add(nombreDote15);
        listaLabelLibros.add(libroDote1);
        listaLabelLibros.add(libroDote1);
        listaLabelLibros.add(libroDote2);
        listaLabelLibros.add(libroDote3);
        listaLabelLibros.add(libroDote4);
        listaLabelLibros.add(libroDote5);
        listaLabelLibros.add(libroDote6);
        listaLabelLibros.add(libroDote7);
        listaLabelLibros.add(libroDote8);
        listaLabelLibros.add(libroDote9);
        listaLabelLibros.add(libroDote10);
        listaLabelLibros.add(libroDote11);
        listaLabelLibros.add(libroDote12);
        listaLabelLibros.add(libroDote13);
        listaLabelLibros.add(libroDote14);
        listaLabelLibros.add(libroDote15);
        
        
    }
    /**
     * Este es el método que busca las dotes en base de datos 
     */
    public void getDotes(){
        generaArrayDotes();
        String buscador = textFieldBuscador.getText();
        String filtro = comboBox.getValue();
        try {
            //Hacemos una consulta con base de datos para seleccionar las dotes deseadas
            String consulta = "SELECT * FROM dote, libros_reglas";
            //Si queremos filtrar por nombre, aquí lo podemos hacer 
            if(!buscador.equals(""))
                consulta += " WHERE dote.nombre LIKE '%"+buscador+"%' ";
            //Si queremos ordenar por nombre ascendente o descendente o por libro de reglas
            if(filtro!=null){
                if(filtro.equals("Nombre [a-z]"))
                    consulta += " order by dote.nombre asc ";
                else if(filtro.equals("Nombre [z-a]"))
                    consulta += " order by dote.nombre desc ";
                else if(filtro.equals("Libro"))
                    consulta += " order by dote.id_libro, dote.nombre asc";
            }
            else
                consulta += " order by libros_reglas.id_libro, dote.nombre";
            //System.out.println(consulta);
            //Establecemos la conexion con la base de datos y recogemos los datos encontrados
            ResultSet dotes = Conector.getSelect(consulta, conector);
            while(dotes.next()){
                //Recogemos toda la información de la dote y creamos un objeto con ella, también para el libro de reglas asociado
                int idClase = dotes.getInt("id_dote");
                String nombre = dotes.getString("dote.nombre");
                String descripcion = dotes.getString("descripcion");
                String carMod1 = dotes.getString("caracteristica_mod");
                String carMod2 = dotes.getString("caracteristica_mod2");
                int mod = dotes.getInt("modificador");
                int idLibro = dotes.getInt("id_libro");
                String nombreLibro = dotes.getString("libros_reglas.nombre");
                interfaz.diceandroll.clases.Dote dote = new Dote(idClase, nombre, descripcion, carMod1, carMod2, mod, idLibro);
                interfaz.diceandroll.clases.Libro libro = new Libro(idLibro,nombreLibro);
                //Añadimos ambos a sus respectivas listas
                listaDotes.add(dote);
                listaLibros.add(libro);
            }
            //Llamamos al metodo para rellenar el grid con los datos de ambas listas para que el usuario pueda ver las dotes
            rellenaDotes();
            //El total de las páginas será igual a la división entera de el tamaño de la lista de dotes entre el número de elementos por página
            totalPaginas = (int) Math.ceil((double) listaDotes.size() / NUM_ELEMENTOS_POR_PAGINA);
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
            System.out.println("Error al encontrar las dotes");
            ex.printStackTrace();
        }
    }

    /**
     * Este método vacía todas las listas y llama el método que devuelve las dotes con los filtros aplicados
     * @param event 
     */
    @FXML
    private void botonAplicarFiltro(ActionEvent event) {
        generaArrayDotes();
        paginaActual=1;
        int contador=0;
        while(contador<NUM_ELEMENTOS_POR_PAGINA){
            listaPane.get(contador).setVisible(false); 
            listaNombre.get(contador).setText("");
            contador++;
        }
        getDotes();
        
    }

    /**
     * Este método se llama en caso de pulsar un boton de navegacion, llama a los metodos que desactivan los botones y rellenan las dotes
     * @param numero 
     */
    private void actualizarContenido(int numero){
        paginaActual=numero;
        desactivarBotones();
        rellenaDotes();        
    }
    /**
     * Este metodo rellena el grid con las dotes
     */
    private void rellenaDotes() {
        Iterator iter = listaDotes.iterator();
        int contador = 0;
        inicio = (paginaActual - 1) * NUM_ELEMENTOS_POR_PAGINA;
        //Rellenamos la información de cada panel de información de dote con su contenido
        while (iter.hasNext() && contador < NUM_ELEMENTOS_POR_PAGINA && inicio + contador < listaDotes.size()) {
            listaPane.get(contador).setVisible(true);
            listaNombre.get(contador).setText(listaDotes.get(inicio + contador).getNombre());
            listaLabelLibros.get(contador).setText(listaLibros.get(inicio + contador).getNombre());
            iter.next();
            contador++;
        }
        //En caso de que queden huecos de información por rellenar y no se haya hecho todavía, se hace aquí
        if (contador == NUM_ELEMENTOS_POR_PAGINA && inicio + contador < listaDotes.size()) {
            listaPane.get(contador-1).setVisible(true);
            //System.out.println(contador);
            listaNombre.get(contador-1).setText(listaDotes.get(inicio + contador-1).getNombre());
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
     * Regresa a la primera página
     * @param event 
     */
    @FXML
    private void botonVolverInicioArray(ActionEvent event) {
        paginaActual=1;
        desactivarBotones();
        rellenaDotes();
    }
    /**
     * Retrocede una página
     * @param event 
     */
    @FXML
    private void botonRetrocederUnoArray(ActionEvent event) {
        paginaActual--;
        desactivarBotones();
        rellenaDotes();
    }

    /**
     * Avanza una página
     * @param event 
     */
    @FXML
    private void botonAvanzarUnoArray(ActionEvent event) {
        paginaActual++;
        desactivarBotones();
        rellenaDotes();
    }
    /**
     * Avanza hasta la última página
     * @param event 
     */
    @FXML
    private void botonIrAlFinalArray(ActionEvent event) {
        paginaActual=totalPaginas;
        desactivarBotones();
        rellenaDotes();
    }
    /**
     * Abrimos la ventana de información detallada de la dote seleccionada
     * @param event 
     */
    @FXML
    private void abrirDote(MouseEvent event) {
        Pane panePulsado = (Pane)event.getSource();
        String idPane = panePulsado.getId();
        int id = Integer.parseInt(idPane.substring(4));
        int indice = inicio+(id-1);
        //System.out.println(indice);
        //System.out.println(id-1);
        dote = listaDotes.get(indice);
        Libro libro = listaLibros.get(indice);
        abrirMenuExplorarDote(dote,libro);
    }
    
    /**
     * Se carga la ventana con la dote seleccionada
     * @param dote
     * @param libro 
     */
    private void abrirMenuExplorarDote(Dote dote,Libro libro) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("explorarDote.fxml"));
        ExplorarDoteController explorarDoteController = new ExplorarDoteController(dote,libro);
        Parent root = fxmlLoader.load();
        explorarDoteController.setPanePrincipal(contenedor);
        fxmlLoader.setController(explorarDoteController);
        contenedor.getChildren().setAll(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    public Dote getDote(){
        return this.dote;
    }

     
   
}
