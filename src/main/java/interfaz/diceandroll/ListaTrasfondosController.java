/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.ExplorarTrasfondoController;
import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.clases.Trasfondo;
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
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class ListaTrasfondosController implements Initializable {

    private Pane panelPrincipal;
    @FXML
    private AnchorPane contenedor;
    @FXML
    private TextField textFieldBuscador;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Pane trasfondo1;
    @FXML
    private Label nombreTrasfondo1;
    @FXML
    private Label libroTrasfondo1;
    @FXML
    private Pane trasfondo2;
    @FXML
    private Label nombreTrasfondo2;
    @FXML
    private Pane trasfondo3;
    @FXML
    private Label nombreTrasfondo3;
    @FXML
    private Pane trasfondo4;
    @FXML
    private Label nombreTrasfondo4;
    @FXML
    private Pane trasfondo5;
    @FXML
    private Label nombreTrasfondo5;
    @FXML
    private Pane trasfondo6;
    @FXML
    private Label nombreTrasfondo6;
    @FXML
    private Pane trasfondo7;
    @FXML
    private Label nombreTrasfondo7;
    @FXML
    private Pane trasfondo8;
    @FXML
    private Label nombreTrasfondo8;
    @FXML
    private Pane trasfondo9;
    @FXML
    private Label nombreTrasfondo9;
    @FXML
    private Pane trasfondo10;
    @FXML
    private Label nombreTrasfondo10;
    @FXML
    private Pane trasfondo11;
    @FXML
    private Label nombreTrasfondo11;
    @FXML
    private Pane trasfondo12;
    @FXML
    private Label nombreTrasfondo12;
    @FXML
    private Pane trasfondo13;
    @FXML
    private Label nombreTrasfondo13;
    @FXML
    private Pane trasfondo14;
    @FXML
    private Label nombreTrasfondo14;
    @FXML
    private Pane trasfondo15;
    @FXML
    private Label nombreTrasfondo15;

   //Variables propias
    ArrayList<interfaz.diceandroll.clases.Trasfondo> listaTrasfondos;
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
    Trasfondo trasfondo;
    @FXML
    private Label libroTrasfondo10;
    @FXML
    private Label libroTrasfondo11;
    @FXML
    private Label libroTrasfondo12;
    @FXML
    private Label libroTrasfondo13;
    @FXML
    private Label libroTrasfondo14;
    @FXML
    private Label libroTrasfondo2;
    @FXML
    private Label libroTrasfondo3;
    @FXML
    private Label libroTrasfondo4;
    @FXML
    private Label libroTrasfondo5;
    @FXML
    private Label libroTrasfondo6;
    @FXML
    private Label libroTrasfondo8;
    @FXML
    private Label libroTrasfondo7;
    @FXML
    private Label libroTrasfondo9;
    @FXML
    private Label libroTrasfondo15;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializamos todas las listas
        listaTrasfondos = new ArrayList();
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
        getTrasfondo();
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
        listaTrasfondos.clear();
        listaPane.add(trasfondo1);
        listaPane.add(trasfondo2);
        listaPane.add(trasfondo3);
        listaPane.add(trasfondo4);
        listaPane.add(trasfondo5);
        listaPane.add(trasfondo6);
        listaPane.add(trasfondo7);
        listaPane.add(trasfondo8);
        listaPane.add(trasfondo9);
        listaPane.add(trasfondo10);
        listaPane.add(trasfondo11);
        listaPane.add(trasfondo12);
        listaPane.add(trasfondo13);
        listaPane.add(trasfondo14);
        listaPane.add(trasfondo15);
        listaNombre.add(nombreTrasfondo1);
        listaNombre.add(nombreTrasfondo2);
        listaNombre.add(nombreTrasfondo3);
        listaNombre.add(nombreTrasfondo4);
        listaNombre.add(nombreTrasfondo5);
        listaNombre.add(nombreTrasfondo6);
        listaNombre.add(nombreTrasfondo7);
        listaNombre.add(nombreTrasfondo8);
        listaNombre.add(nombreTrasfondo9);
        listaNombre.add(nombreTrasfondo10);
        listaNombre.add(nombreTrasfondo11);
        listaNombre.add(nombreTrasfondo12);
        listaNombre.add(nombreTrasfondo13);
        listaNombre.add(nombreTrasfondo14);
        listaNombre.add(nombreTrasfondo15);
        listaLabelLibros.add(libroTrasfondo1);
        listaLabelLibros.add(libroTrasfondo2);
        listaLabelLibros.add(libroTrasfondo3);
        listaLabelLibros.add(libroTrasfondo4);
        listaLabelLibros.add(libroTrasfondo5);
        listaLabelLibros.add(libroTrasfondo6);
        listaLabelLibros.add(libroTrasfondo7);
        listaLabelLibros.add(libroTrasfondo8);
        listaLabelLibros.add(libroTrasfondo9);
        listaLabelLibros.add(libroTrasfondo10);
        listaLabelLibros.add(libroTrasfondo11);
        listaLabelLibros.add(libroTrasfondo12);
        listaLabelLibros.add(libroTrasfondo13);
        listaLabelLibros.add(libroTrasfondo14);
        listaLabelLibros.add(libroTrasfondo15);
        
        
    }
    /**
     * Este es el método que busca los trasfondos en base de datos 
     */
    public void getTrasfondo(){
        generaArrayDotes();
        String buscador = textFieldBuscador.getText();
        String filtro = comboBox.getValue();
        try {
            //Hacemos una consulta con base de datos para seleccionar las dotes deseadas
            String consulta = "SELECT * FROM trasfondo, libros_reglas";
            //Si queremos filtrar por nombre, aquí lo podemos hacer 
            if(!buscador.equals(""))
                consulta += " WHERE trasfondo.nombre LIKE '%"+buscador+"%' ";
            //Si queremos ordenar por nombre ascendente o descendente o por libro de reglas
            if(filtro!=null){
                if(filtro.equals("Nombre [a-z]"))
                    consulta += " order by trasfondo.nombre asc ";
                else if(filtro.equals("Nombre [z-a]"))
                    consulta += " order by trasfondo.nombre desc ";
                else if(filtro.equals("Libro"))
                    consulta += " order by trasfondo.id_libro, trasfondo.nombre asc";
            }
            else
                consulta += " order by libros_reglas.id_libro, trasfondo.nombre";
            System.out.println(consulta);
            //Establecemos la conexion con la base de datos y recogemos los datos encontrados
            ResultSet trasfondos = Conector.getSelect(consulta, conector);
            while(trasfondos.next()){
                //Recogemos toda la información de los trasfondos lo trasfondo y creamos un objeto con ella, también para el libro de reglas asociado
                int idTrasfondo = trasfondos.getInt("id_trasfondo");
                String nombre = trasfondos.getString("nombre");
                String descripcion = trasfondos.getString("descripcion");
                String comp1 = trasfondos.getString("competencia1");
                String comp2 = trasfondos.getString("competencia2");
                String otrasComp = trasfondos.getString("otras_competencias");
                String nombreRasgo = trasfondos.getString("nombre_rasgo");
                String descRasgo = trasfondos.getString("desc_rasgo");
                String nombreEsp = trasfondos.getString("nombre_especialidad");
                String descripcionEspecialidad = trasfondos.getString("descripcion_especialidad");
                String desCaracSug = trasfondos.getString("desc_caracteristicas_sugeridas");
                int idLibro = trasfondos.getInt("id_libro");
                String nombreLibro = trasfondos.getString("libros_reglas.nombre");
                //                                  id_transfondo,nombre,descripcion,competencia1,competencia2,otrasCompetencias,nombreRasgo, String descRasgo,nombreEspecialidad,descCarSug,idLibro

                Trasfondo trasfondo = new Trasfondo(idTrasfondo,nombre,descripcion,comp1,comp2,otrasComp,nombreRasgo,descRasgo,nombreEsp,descripcionEspecialidad, desCaracSug,idLibro);
                Libro libro = new Libro(idLibro,nombreLibro);
                //Añadimos ambos a sus respectivas listas
                listaTrasfondos.add(trasfondo);
                listaLibros.add(libro);
            }
            //Llamamos al metodo para rellenar el grid con los datos de ambas listas para que el usuario pueda ver las dotes
            rellenaTrasfondos();
            //El total de las páginas será igual a la división entera de el tamaño de la lista de dotes entre el número de elementos por página
            totalPaginas = (int) Math.ceil((double) listaTrasfondos.size() / NUM_ELEMENTOS_POR_PAGINA);
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
            System.out.println("Error al encontrar los trasfondos");
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
        int contador=0;
        paginaActual=1;
        while(contador<NUM_ELEMENTOS_POR_PAGINA){
            listaPane.get(contador).setVisible(false); 
            listaNombre.get(contador).setText("");
            contador++;
        }
        getTrasfondo();
        
    }

    /**
     * Este método se llama en caso de pulsar un boton de navegacion, llama a los metodos que desactivan los botones y rellenan las dotes
     * @param numero 
     */
    private void actualizarContenido(int numero){
        paginaActual=numero;
        desactivarBotones();
        rellenaTrasfondos();        
    }
    /**
     * Este metodo rellena el grid con las dotes
     */
    private void rellenaTrasfondos() {
        Iterator iter = listaTrasfondos.iterator();
        int contador = 0;
        inicio = (paginaActual - 1) * NUM_ELEMENTOS_POR_PAGINA;
        //Rellenamos la información de cada panel de información de dote con su contenido
        while (iter.hasNext() && contador < NUM_ELEMENTOS_POR_PAGINA && inicio + contador < listaTrasfondos.size()) {
            listaPane.get(contador).setVisible(true);
            listaNombre.get(contador).setText(listaTrasfondos.get(inicio + contador).getNombre());
            listaLabelLibros.get(contador).setText(listaLibros.get(inicio + contador).getNombre());
            iter.next();
            contador++;
        }
        //En caso de que queden huecos de información por rellenar y no se haya hecho todavía, se hace aquí
        if (contador == NUM_ELEMENTOS_POR_PAGINA && inicio + contador < listaTrasfondos.size()) {
            listaPane.get(contador-1).setVisible(true);
            //System.out.println(contador);
            listaNombre.get(contador-1).setText(listaTrasfondos.get(inicio + contador-1).getNombre());
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
        rellenaTrasfondos();
    }
    /**
     * Retrocede una página
     * @param event 
     */
    @FXML
    private void botonRetrocederUnoArray(ActionEvent event) {
        paginaActual--;
        desactivarBotones();
        rellenaTrasfondos();
    }

    /**
     * Avanza una página
     * @param event 
     */
    @FXML
    private void botonAvanzarUnoArray(ActionEvent event) {
        paginaActual++;
        desactivarBotones();
        rellenaTrasfondos();
    }
    /**
     * Avanza hasta la última página
     * @param event 
     */
    @FXML
    private void botonIrAlFinalArray(ActionEvent event) {
        paginaActual=totalPaginas;
        desactivarBotones();
        rellenaTrasfondos();
    }
    /**
     * Abrimos la ventana de información detallada de la dote seleccionada
     * @param event 
     */
    private void abrirDote(MouseEvent event) {
        Pane panePulsado = (Pane)event.getSource();
        String idPane = panePulsado.getId();
        int id = Integer.parseInt(idPane.substring(4));
        int indice = inicio+(id-1);
        //System.out.println(indice);
        //System.out.println(id-1);
        trasfondo = listaTrasfondos.get(indice);
        Libro libro = listaLibros.get(indice);
        abrirMenuExplorarDote(trasfondo,libro);
    }
    
    /**
     * Se carga la ventana con la dote seleccionada
     * @param dote
     * @param libro 
     */
    private void abrirMenuExplorarDote(Trasfondo trasfondo,Libro libro) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("explorarTrasfondo.fxml"));
        ExplorarTrasfondoController explorarTrasfondoController = new ExplorarTrasfondoController(trasfondo,libro);
        Parent root = fxmlLoader.load();
        explorarTrasfondoController.setPanePrincipal(contenedor);
        fxmlLoader.setController(explorarTrasfondoController);
        contenedor.getChildren().setAll(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    public Trasfondo getDote(){
        return this.trasfondo;
    }

    @FXML
    private void abrirTrasfondo(MouseEvent event) {
        Pane panePulsado = (Pane)event.getSource();
        String idPane = panePulsado.getId();
        int id = Integer.parseInt(idPane.substring(9));
        int indice = inicio+(id-1);
        //System.out.println(indice);
        //System.out.println(id-1);
        trasfondo = listaTrasfondos.get(indice);
        Libro libro = listaLibros.get(indice);
        abrirMenuExplorarDote(trasfondo,libro);
    }

     
    
}
