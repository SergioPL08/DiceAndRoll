/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.clases.Libro;
import interfaz.diceandroll.clases.Raza;
import interfaz.diceandroll.conector.Conector;
import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class RazasController implements Initializable {

    @FXML
    private TextField textFieldBuscador;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Label nombreRaza1;
    @FXML
    private ImageView imagen1;
    @FXML
    private Label libroRaza1;
    @FXML
    private ImageView imagen2;
    @FXML
    private Label libroRaza2;
    @FXML
    private Label nombreRaza3;
    @FXML
    private ImageView imagen3;
    @FXML
    private Label libroRaza3;
    @FXML
    private Label nombreRaza4;
    @FXML
    private ImageView imagen4;
    @FXML
    private Label libroRaza4;
    @FXML
    private Label nombreRaza5;
    @FXML
    private ImageView imagen5;
    @FXML
    private Label libroRaza5;
    @FXML
    private Label nombreRaza6;
    @FXML
    private ImageView imagen6;
    @FXML
    private Label libroRaza6;
    @FXML
    private Label nombreRaza7;
    @FXML
    private ImageView imagen7;
    @FXML
    private Label libroRaza7;
    @FXML
    private Label nombreRaza8;
    @FXML
    private ImageView imagen8;
    @FXML
    private Label libroRaza8;
    @FXML
    private Label nombreRaza9;
    @FXML
    private ImageView imagen9;
    @FXML
    private Label libroRaza9;
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

    

    ArrayList<interfaz.diceandroll.clases.Raza> listaRazas;
    ArrayList<interfaz.diceandroll.clases.Libro> listaLibros;
    ArrayList<Image> listaImagenes;
    ArrayList<Pane> listaPane;
    ArrayList<Label> listaNombre;
    ArrayList<Label> listaLabelLibros;
    ArrayList<Button> listaBotones;
    ArrayList<ImageView> listaImageview;
    private int indice = 0;
    private int totalPaginas;
    private int paginaActual=1;
    int inicio;
    private final int NUM_ELEMENTOS_POR_PAGINA = 9;
    Raza raza;
    private Pane panelPrincipal;
    @FXML
    private Label nombreRaza2;
    @FXML
    private Pane raza1;
    @FXML
    private Pane raza2;
    @FXML
    private Pane raza3;
    @FXML
    private Pane raza4;
    @FXML
    private Pane raza5;
    @FXML
    private Pane raza6;
    @FXML
    private Pane raza7;
    @FXML
    private Pane raza8;
    @FXML
    private Pane raza9;
    @FXML
    private AnchorPane contenedor;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializamos todas las listas
        listaRazas = new ArrayList();
        listaLibros = new ArrayList();
        listaPane = new ArrayList();
        listaNombre = new ArrayList();
        listaLabelLibros = new ArrayList();
        listaBotones = new ArrayList();
        listaImageview = new ArrayList();
        listaImagenes = new ArrayList();
        String[] filtrosOrdenacion = {"Nombre [a-z]","Nombre [z-a]", "Libro"};
        ObservableList<String> listaValores = FXCollections.observableArrayList(filtrosOrdenacion);
        //Inicializamos las listas
        comboBox.setItems(listaValores);
        //Llamamos al método que recoge todas las razas y rellena el grid
        getRazas();
        //Desactivamos los botones de navegación en caso necesario (los botones de retroceder si estamos en la primera página o los de avanzar si estamos en la última, además de desactivar el botón de la página actual)
        desactivarBotones();
    }    
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }
    
    /**
     * Este metodo añade las razas, los nombres de las mismas y su libro asociado a su respectiva lista
     */
    public void generaArrayRazas(){
        listaPane.clear();
        listaNombre.clear();
        listaRazas.clear();
        listaImagenes.clear();
        listaLibros.clear();
        listaPane.add(raza1);
        listaPane.add(raza2);
        listaPane.add(raza3);
        listaPane.add(raza4);
        listaPane.add(raza5);
        listaPane.add(raza6);
        listaPane.add(raza7);
        listaPane.add(raza8);
        listaPane.add(raza9);
        listaNombre.add(nombreRaza1);
        listaNombre.add(nombreRaza2);
        listaNombre.add(nombreRaza3);
        listaNombre.add(nombreRaza4);
        listaNombre.add(nombreRaza5);
        listaNombre.add(nombreRaza6);
        listaNombre.add(nombreRaza7);
        listaNombre.add(nombreRaza8);
        listaNombre.add(nombreRaza9);
        listaLabelLibros.add(libroRaza1);
        listaLabelLibros.add(libroRaza2);
        listaLabelLibros.add(libroRaza3);
        listaLabelLibros.add(libroRaza4);
        listaLabelLibros.add(libroRaza5);
        listaLabelLibros.add(libroRaza6);
        listaLabelLibros.add(libroRaza7);
        listaLabelLibros.add(libroRaza8);
        listaLabelLibros.add(libroRaza9);
        listaImageview.add(imagen1);
        listaImageview.add(imagen2);
        listaImageview.add(imagen3);
        listaImageview.add(imagen4);
        listaImageview.add(imagen5);
        listaImageview.add(imagen6);
        listaImageview.add(imagen7);
        listaImageview.add(imagen8);
        listaImageview.add(imagen9);
    }
    
    /**
     * Este es el método que busca las razas en base de datos 
     */
    public void getRazas(){
        generaArrayRazas();
        String buscador = textFieldBuscador.getText();
        String filtro = comboBox.getValue();
        try {
            //Hacemos una consulta con base de datos para seleccionar las razas
            String consulta = "SELECT * FROM raza, libros_reglas";
            //Si queremos filtrar por nombre, aquí lo podemos hacer 
            if(!buscador.equals(""))
                consulta += " WHERE raza.nombre LIKE '%"+buscador+"%' ";
            //Si queremos ordenar por nombre ascendente o descendente o por libro de reglas
            if(filtro!=null){
                if(filtro.equals("Nombre [a-z]"))
                    consulta += " order by raza.nombre asc ";
                else if(filtro.equals("Nombre [z-a]"))
                    consulta += " order by raza.nombre desc ";
                else if(filtro.equals("Libro"))
                    consulta += " order by raza.id_libro, raza.nombre asc";
            }
            else
                consulta += " order by libros_reglas.id_libro, raza.nombre";
            //Establecemos la conexion con la base de datos y recogemos los datos encontrados
            ResultSet razas = Conector.getSelect(consulta, conector);
            while(razas.next()){
                //Recogemos toda la información de la raza y creamos un objeto con ella, también para el libro de reglas asociado
                int id_raza = razas.getInt("id_raza");
                String nombre = razas.getString("raza.nombre");
                String descr = razas.getString("descripcion");
                int vel = razas.getInt("velocidad");
                int nMod1 = razas.getInt("num_bono_1");
                int nMod2 = razas.getInt("num_bono_2");
                String nombreLibro = razas.getString("libros_reglas.nombre");
                int idLibro = razas.getInt("id_libro");
                interfaz.diceandroll.clases.Raza raza = new Raza(id_raza,nombre,descr,vel,nMod1,nMod2,idLibro);
                interfaz.diceandroll.clases.Libro libro = new Libro(idLibro,nombreLibro);
                //Añadimos ambos a sus respectivas listas
                listaRazas.add(raza);
                //System.out.println(icon);
                //Image imagen = new Image(getClass().getResourceAsStream(icon));
                //System.out.println(imagen.toString());
                //listaImagenes.add(imagen);
                listaLibros.add(libro);
            }
            //Llamamos al metodo para rellenar el grid con los datos de ambas listas para que el usuario pueda ver las razas
            rellenaRazas();
            //El total de las páginas será igual a la división entera de el tamaño de la lista de razas entre el número de elementos por página
            totalPaginas = (int) Math.ceil((double) listaRazas.size() / NUM_ELEMENTOS_POR_PAGINA);
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
            System.out.println("Error al encontrar las razas");
            ex.printStackTrace();
        }
    }

    
    
    /**
     * Este método se llama en caso de pulsar un boton de navegacion, llama a los metodos que desactivan los botones y rellenan las razas
     * @param numero 
     */
    private void actualizarContenido(int numero){
        paginaActual=numero;
        desactivarBotones();
        rellenaRazas();        
    }
    
    /**
     * Este metodo rellena el grid con las razas
     */
    private void rellenaRazas() {
        Iterator iter = listaRazas.iterator();
        int contador = 0;
        inicio = (paginaActual - 1) * NUM_ELEMENTOS_POR_PAGINA;
        //Rellenamos la información de cada panel de información de razas con su contenido
        while (iter.hasNext() && contador < NUM_ELEMENTOS_POR_PAGINA && inicio + contador < listaRazas.size()) {
            listaPane.get(contador).setVisible(true);
            listaNombre.get(contador).setText(listaRazas.get(inicio + contador).getNombre());
            listaLabelLibros.get(contador).setText(listaLibros.get(inicio + contador).getNombre());
            //System.out.println(listaImagenes.get(inicio+contador).getUrl());
            //listaImageview.get(contador).setImage(listaImagenes.get(inicio+contador));
            iter.next();
            contador++;
        }
        //En caso de que queden huecos de información por rellenar y no se haya hecho todavía, se hace aquí
        if (contador == NUM_ELEMENTOS_POR_PAGINA && inicio + contador < listaRazas.size()) {
            listaPane.get(contador-1).setVisible(true);
            //System.out.println(contador);
            listaNombre.get(contador-1).setText(listaRazas.get(inicio + contador-1).getNombre());
            //listaImageview.get(contador-1).setImage(listaImagenes.get(inicio+contador-1));
            //listaLabelLibros.get(contador-1).setText(listaLibros.get(inicio + contador-1).getNombre());
            contador++;
        }
        //Eliminamos todos los huecos vacíos que hayan quedado
        for (int i = contador; i < NUM_ELEMENTOS_POR_PAGINA; i++) {
            listaPane.get(i).setVisible(false);
            listaNombre.get(i).setText("");
            File ruta = new File("..\\..\\img\\no_image.png");
            Image imagen = new Image(ruta.toURI().toString());
            //listaImageview.get(contador).setImage(imagen);
            //listaLabelLibros.get(i).setText("");
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
     * Este método vacía todas las listas y llama el método que devuelve las razas con los filtros aplicados
     * @param event 
     */
    @FXML
    private void botonAplicarFiltro(ActionEvent event) {
        generaArrayRazas();
        int contador=0;
        while(contador<NUM_ELEMENTOS_POR_PAGINA){
            listaPane.get(contador).setVisible(false); 
            File ruta = new File("..\\..\\img\\no_image.png");
            Image imagen = new Image(ruta.toURI().toString());
            listaImageview.get(contador).setImage(imagen);
            listaNombre.get(contador).setText("");
            contador++;
        }
        getRazas();
        
    }
    
    
    
    /**
     * Regresa a la primera página
     * @param event 
     */
    @FXML
    private void botonVolverInicioArray(ActionEvent event) {
        paginaActual=1;
        desactivarBotones();
        rellenaRazas();
    }
    /**
     * Retrocede una página
     * @param event 
     */
    @FXML
    private void botonRetrocederUnoArray(ActionEvent event) {
        paginaActual--;
        desactivarBotones();
        rellenaRazas();
    }

    /**
     * Avanza una página
     * @param event 
     */
    @FXML
    private void botonAvanzarUnoArray(ActionEvent event) {
        paginaActual++;
        desactivarBotones();
        rellenaRazas();
    }
    /**
     * Avanza hasta la última página
     * @param event 
     */
    @FXML
    private void botonIrAlFinalArray(ActionEvent event) {
        paginaActual=totalPaginas;
        desactivarBotones();
        rellenaRazas();
    }
    
    
    /**
     * Se carga la ventana con la raza seleccionada
     * @param raza
     * @param libro 
     */
    private void abrirMenuExplorarRaza(Raza raza,Libro libro) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("explorarRaza.fxml"));
        ExplorarRazaController explorarRazaController = new ExplorarRazaController(raza,libro);
        Parent root = fxmlLoader.load();
        explorarRazaController.setPanePrincipal(contenedor);
        fxmlLoader.setController(explorarRazaController);
        contenedor.getChildren().setAll(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Abrimos la ventana de información detallada de la raza seleccionada
     * @param event 
     */
    @FXML
    private void abrirRaza(MouseEvent event) {
        Pane panePulsado = (Pane)event.getSource();
        String idPane = panePulsado.getId();
        System.out.println(idPane);
        int longitudTexto = idPane.length();
        System.out.println(longitudTexto);
        int id = Integer.parseInt(idPane.substring(longitudTexto-1));
        System.out.println(id);
        int indice = inicio+(id-1);
        //System.out.println(indice);
        //System.out.println(id-1);
        raza = listaRazas.get(indice);
        Libro libro = listaLibros.get(indice);
        //Image imagen = listaImagenes.get(indice);
        
        abrirMenuExplorarRaza(raza,libro);
    }

    
   

}

