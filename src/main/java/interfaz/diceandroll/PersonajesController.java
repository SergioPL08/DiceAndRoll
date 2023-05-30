/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.conector.Conector;
import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.CrearPersonajeController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import interfaz.diceandroll.clases.Libro;
import interfaz.diceandroll.clases.Personaje;
import interfaz.diceandroll.clases.Usuario;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class PersonajesController implements Initializable {

    private AnchorPane PanePersonajes;
    @FXML
    private TextField textFieldBuscador;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Label nombrePersonaje1;
    @FXML
    private ImageView imagen1;
    @FXML
    private Label nombreClase1;
    @FXML
    private Label nombrePersonaje2;
    @FXML
    private ImageView imagen2;
    @FXML
    private Label nombreClase2;
    @FXML
    private Label nombrePersonaje3;
    @FXML
    private ImageView imagen3;
    @FXML
    private Label nombreClase3;
    @FXML
    private Label nombrePersonaje4;
    @FXML
    private ImageView imagen4;
    @FXML
    private Label nombreClase4;
    @FXML
    private Label nombrePersonaje5;
    @FXML
    private ImageView imagen5;
    @FXML
    private Label nombreClase5;
    @FXML
    private Label nombrePersonaje6;
    @FXML
    private ImageView imagen6;
    @FXML
    private Label nombreClase6;
    @FXML
    private Label nombrePersonaje7;
    @FXML
    private ImageView imagen7;
    @FXML
    private Label nombreClase7;
    @FXML
    private Label nombrePersonaje8;
    @FXML
    private ImageView imagen8;
    @FXML
    private Label nombreClase8;
    @FXML
    private Label nombrePersonaje9;
    @FXML
    private ImageView imagen9;
    @FXML
    private Label nombreClase9;
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
    private Pane panelPrincipal;
    ArrayList<interfaz.diceandroll.clases.Personaje> listaPersonajes;
    ArrayList<Image> listaImagenes;
    ArrayList<Pane> listaPane;
    ArrayList<Label> listaNombre;
    ArrayList<Label> listaClase;
    ArrayList<Button> listaBotones;
    ArrayList<ImageView> listaImageview;
    List<String> listaClases;
    private int indice = 0;
    private int totalPaginas;
    private int paginaActual=1;
    int inicio;
    private final int NUM_ELEMENTOS_POR_PAGINA = 9;
    Personaje personaje;
    @FXML
    private Pane personaje1;
    @FXML
    private Pane personaje2;
    @FXML
    private Pane personaje3;
    @FXML
    private Pane personaje4;
    @FXML
    private Pane personaje5;
    @FXML
    private Pane personaje6;
    @FXML
    private Pane personaje7;
    @FXML
    private Pane personaje8;
    @FXML
    private Pane personaje9;
    @FXML
    private AnchorPane contenedor;
    private static Usuario usuario;
    @FXML
    private HBox hboxNavegacion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializamos todas las listas
        listaPersonajes = new ArrayList();
        listaPane = new ArrayList();
        listaNombre = new ArrayList();
        listaBotones = new ArrayList();
        listaImageview = new ArrayList();
        listaImagenes = new ArrayList();
        String[] filtrosOrdenacion = {"Nombre [a-z]","Nombre [z-a]"};
        ObservableList<String> listaValores = FXCollections.observableArrayList(filtrosOrdenacion);
        //Inicializamos las listas
        comboBox.setItems(listaValores);

    }    
    
    public void init(Usuario usuario, Pane panePrincipal){
        this.usuario = usuario;
        this.panelPrincipal = panePrincipal;
        //Llamamos al método que recoge todas las clases y rellena el grid
        getPersonajes();
        if(listaPersonajes.size()<1){
            hboxNavegacion.setVisible(false);
        }
        //Desactivamos los botones de navegación en caso necesario (los botones de retroceder si estamos en la primera página o los de avanzar si estamos en la última, además de desactivar el botón de la página actual)
        desactivarBotones();
    }
    
    public void generaArrayPersonajes(){
        listaPane.clear();
        listaNombre.clear();
        listaClase.clear();
        listaPersonajes.clear();
        listaImagenes.clear();
        listaPane.add(personaje1);
        listaPane.add(personaje2);
        listaPane.add(personaje3);
        listaPane.add(personaje4);
        listaPane.add(personaje5);
        listaPane.add(personaje6);
        listaPane.add(personaje7);
        listaPane.add(personaje8);
        listaPane.add(personaje9);
        listaNombre.add(nombrePersonaje1);
        listaNombre.add(nombrePersonaje2);
        listaNombre.add(nombrePersonaje3);
        listaNombre.add(nombrePersonaje4);
        listaNombre.add(nombrePersonaje5);
        listaNombre.add(nombrePersonaje6);
        listaNombre.add(nombrePersonaje7);
        listaNombre.add(nombrePersonaje8);
        listaNombre.add(nombrePersonaje9);
        listaClase.add(nombreClase1);
        listaClase.add(nombreClase2);
        listaClase.add(nombreClase3);
        listaClase.add(nombreClase4);
        listaClase.add(nombreClase5);
        listaClase.add(nombreClase6);
        listaClase.add(nombreClase7);
        listaClase.add(nombreClase8);
        listaClase.add(nombreClase9);
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
     * Este es el método que busca las clases en base de datos 
     */
    public void getPersonajes(){
        listaPersonajes = new ArrayList();
        listaImagenes = new ArrayList();
        listaImageview = new ArrayList();
        listaNombre = new ArrayList();
        listaClase = new ArrayList();
        listaPane = new ArrayList();
        listaBotones = new ArrayList();
        listaClases = new ArrayList();
        generaArrayPersonajes();
        String buscador = textFieldBuscador.getText();
        String filtro = comboBox.getValue();
        try {
            //Hacemos una consulta con base de datos para seleccionar las clases
            String consulta = "SELECT * FROM personaje " +
            "INNER JOIN raza ON personaje.raza = raza.id_raza " +
            "LEFT JOIN subraza_personaje  ON personaje.id_personaje = subraza_personaje.id_personaje " +
            "LEFT JOIN subraza ON subraza_personaje.id_subraza = subraza.id_subraza " +
            "WHERE usuario ="+usuario.getIdUsuario()+" ";
            
            //Si queremos filtrar por nombre, aquí lo podemos hacer 
            if(!buscador.equals(""))
                consulta += " AND personaje.nombre LIKE '%"+buscador+"%' ";
            consulta += " GROUP BY personaje.id_personaje ";
            //Si queremos ordenar por nombre ascendente o descendente o por libro de reglas
            if(filtro!=null){
                if(filtro.equals("Nombre [a-z]"))
                    consulta += " ORDER BY personaje.nombre asc ";
                else if(filtro.equals("Nombre [z-a]"))
                    consulta += " ORDER BY personaje.nombre desc ";
            }
            else
                consulta += " order by personaje.nombre";
            //Establecemos la conexion con la base de datos y recogemos los datos encontrados
            //System.out.println(consulta);
            ResultSet personajes = Conector.getSelect(consulta, conector);
            while(personajes.next()){
                //Recogemos toda la información de la clase y creamos un objeto con ella, también para el libro de reglas asociado
                int idPersonaje = personajes.getInt("id_personaje");
                String nombre = personajes.getString("nombre");
                int idRaza = personajes.getInt("raza");
                String nombreRaza = personajes.getString("raza.nombre");
                String nombreSubraza = personajes.getString("subraza.nombre");
                int puntosGolpeMax = personajes.getInt("puntos_de_golpe_maximos");
                int puntosGolpeAct = personajes.getInt("puntos_de_golpe_actuales");
                int iniciativa = personajes.getInt("iniciativa");
                int ca = personajes.getInt("ca");
                int vel = personajes.getInt("velocidad");
                int bonoComp = personajes.getInt("competencia");
                int fue = personajes.getInt("fue");
                int des = personajes.getInt("des");
                int con = personajes.getInt("con");
                int inte = personajes.getInt("inte");
                int sab = personajes.getInt("sab");
                int car = personajes.getInt("car");
                interfaz.diceandroll.clases.Personaje personaje = new Personaje(idPersonaje,nombre,idRaza,nombreRaza,nombreSubraza,vel,puntosGolpeMax,puntosGolpeAct,iniciativa,ca,bonoComp,fue,des,con,inte,sab,car);
                //Añadimos ambos a sus respectivas listas
                listaPersonajes.add(personaje);
                //System.out.println(icon);
                //Image imagen = new Image(getClass().getResourceAsStream(icon));
                //System.out.println(imagen.toString());
                //listaImagenes.add(imagen);
            }
            //Como cada personaje puede tener varias clases, tenemos que hacer una consulta aparte para mostrar las clases del personaje y añadirlas a una lista
            String consultaClases = "SELECT * from clase_personaje "
                    + "INNER JOIN clase ON clase_personaje.id_clase = clase.id_clase "
                    + "INNER JOIN personaje on clase_personaje.id_personaje = personaje.id_personaje WHERE personaje.usuario= "+usuario.getIdUsuario();
            if(!buscador.equals(""))
                consultaClases += " AND personaje.nombre LIKE '%"+buscador+"%' ";
            //Si queremos ordenar por nombre ascendente o descendente o por libro de reglas
            if(filtro!=null){
                if(filtro.equals("Nombre [a-z]"))
                    consultaClases += " order by personaje.nombre asc, nivel_clase desc ";
                else if(filtro.equals("Nombre [z-a]"))
                    consultaClases += " order by personaje.nombre desc, nivel_clase desc ";
            }
            else
                consultaClases += " order by personaje.nombre, nivel_clase desc";
            System.out.println(consultaClases);
            ResultSet rsClases = Conector.getSelect(consultaClases, conector);
            int contador = 0;
            int personajeAnterior=-1;
            ArrayList clases = new ArrayList();
            while(rsClases.next()){
                int idPersonaje = rsClases.getInt("id_personaje");
                int idClase = rsClases.getInt("clase.id_clase");
                String nombreClase = rsClases.getString("clase.nombre");
                int nivelClase = rsClases.getInt("nivel_clase");
                if (personajeAnterior != -1 && personajeAnterior != idPersonaje) {
                    listaClases.add(String.join(" ", clases));
                    contador++;
                    clases.clear();
                }

                clases.add(nombreClase + " " + nivelClase);
                personajeAnterior = idPersonaje;
            }
            if (!clases.isEmpty()) {
                listaClases.add(String.join(" ", clases));
                contador++;
            }
            //Llamamos al metodo para rellenar el grid con los datos de ambas listas para que el usuario pueda ver las clases
            rellenaClases();
            //El total de las páginas será igual a la división entera de el tamaño de la lista de clases entre el número de elementos por página
            totalPaginas = (int) Math.ceil((double) listaPersonajes.size() / NUM_ELEMENTOS_POR_PAGINA);
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
            System.out.println("Error al encontrar las clases");
            ex.printStackTrace();
        }
    }

    
    
    /**
     * Este método se llama en caso de pulsar un boton de navegacion, llama a los metodos que desactivan los botones y rellenan las clases
     * @param numero 
     */
    private void actualizarContenido(int numero){
        paginaActual=numero;
        desactivarBotones();
        rellenaClases();        
    }
    
    /**
     * Este metodo rellena el grid con las clases
     */
    private void rellenaClases() {
        Iterator iter = listaPersonajes.iterator();
        int contador = 0;
        inicio = (paginaActual - 1) * NUM_ELEMENTOS_POR_PAGINA;
        //Rellenamos la información de cada panel de información de clase con su contenido
        while (iter.hasNext() && contador < NUM_ELEMENTOS_POR_PAGINA && inicio + contador < listaPersonajes.size()) {
            listaPane.get(contador).setVisible(true);
            listaNombre.get(contador).setText(listaPersonajes.get(inicio + contador).getNombre());
            Personaje personaje = listaPersonajes.get(inicio + contador);
            String raza = personaje.getNombreRaza();
            String subRaza = personaje.getNombreSubRaza();
            String textoRaza = "";
            if(subRaza!=null)
                textoRaza = subRaza;
            else
                textoRaza = raza;
            listaClase.get(contador).setText((textoRaza)+" "+(listaClases.get(inicio + contador)));
            //System.out.println(listaImagenes.get(inicio+contador).getUrl());
            //listaImageview.get(contador).setImage(listaImagenes.get(inicio+contador));
            iter.next();
            contador++;
        }
        //En caso de que queden huecos de información por rellenar y no se haya hecho todavía, se hace aquí
        if (contador == NUM_ELEMENTOS_POR_PAGINA && inicio + contador < listaPersonajes.size()) {
            listaPane.get(contador-1).setVisible(true);
            //System.out.println(contador);
            listaNombre.get(contador-1).setText(listaPersonajes.get(inicio + contador-1).getNombre());
            Personaje personaje = listaPersonajes.get(inicio + contador-1);
            String raza = personaje.getNombreRaza();
            String subRaza = personaje.getNombreSubRaza();
            String textoRaza = "";
            if(subRaza!=null)
                textoRaza = subRaza;
            else
                textoRaza = raza;
            listaClase.get(contador).setText((textoRaza)+" "+(listaClases.get(inicio + contador-1)));
            //listaImageview.get(contador-1).setImage(listaImagenes.get(inicio+contador-1));
            contador++;
        }
        //Eliminamos todos los huecos vacíos que hayan quedado
        for (int i = contador; i < NUM_ELEMENTOS_POR_PAGINA; i++) {
            listaPane.get(i).setVisible(false);
            listaNombre.get(i).setText("");
            File ruta = new File("..\\..\\img\\no_image.png");
            Image imagen = new Image(ruta.toURI().toString());
            //listaImageview.get(contador).setImage(imagen);
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
     * Este método vacía todas las listas y llama el método que devuelve los personajes con los filtros aplicados
     * @param event 
     */
    @FXML
    private void botonAplicarFiltro(ActionEvent event) {
        generaArrayPersonajes();
        int contador=0;
        paginaActual=1;
        while(contador<NUM_ELEMENTOS_POR_PAGINA){
            listaPane.get(contador).setVisible(false); 
            File ruta = new File("..\\..\\img\\no_image.png");
            Image imagen = new Image(ruta.toURI().toString());
            //listaImageview.get(contador).setImage(imagen);
            listaNombre.get(contador).setText("");
            contador++;
        }
        getPersonajes();
        
    }
    
    
    
    /**
     * Regresa a la primera página
     * @param event 
     */
    @FXML
    private void botonVolverInicioArray(ActionEvent event) {
        paginaActual=1;
        desactivarBotones();
        rellenaClases();
    }
    /**
     * Retrocede una página
     * @param event 
     */
    @FXML
    private void botonRetrocederUnoArray(ActionEvent event) {
        paginaActual--;
        desactivarBotones();
        rellenaClases();
    }

    /**
     * Avanza una página
     * @param event 
     */
    @FXML
    private void botonAvanzarUnoArray(ActionEvent event) {
        paginaActual++;
        desactivarBotones();
        rellenaClases();
    }
    /**
     * Avanza hasta la última página
     * @param event 
     */
    @FXML
    private void botonIrAlFinalArray(ActionEvent event) {
        paginaActual=totalPaginas;
        desactivarBotones();
        rellenaClases();
    }
    
    /**
     * Abrimos la ventana de información detallada del personaje seleccionado
     * @param event 
     */
    @FXML
    private void seleccionarPersonaje(MouseEvent event) {
        Pane panePulsado = (Pane)event.getSource();
        String idPane = panePulsado.getId();
        System.out.println(idPane);
        int longitudTexto = idPane.length();
        System.out.println(longitudTexto);
        int id = Integer.parseInt(idPane.substring(longitudTexto-1));
        //System.out.println(id);
        int indice = inicio+(id-1);
        //System.out.println(indice);
        //System.out.println(id-1);
        personaje = listaPersonajes.get(indice);
        String clase = listaClases.get(indice);
        //Image imagen = listaImagenes.get(indice);
        
        abrirMenuFichaPersonaje(personaje,clase);
    }
    
    
    /**
     * Se carga la ventana con el personaje seleccionado
     * @param clase
     * @param libro 
     */
    
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
    
/*
    @FXML
    private void seleccionarPersonaje(MouseEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("fichaPersonaje.fxml"));
            Parent root = fxml.load();
            PanePersonajes.getChildren().setAll(root);
            FichaPersonajeController personajes = fxml.getController();
            personajes.setPanePrincipal(PanePersonajes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
*/

    @FXML
    private void abrirMenuCrearPersonaje(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("crearPersonaje.fxml"));
            CrearPersonajeController crearPersonaje = new CrearPersonajeController(usuario);
            Parent root = fxmlLoader.load();
            crearPersonaje.setPanePrincipal(contenedor);
            fxmlLoader.setController(crearPersonaje);
            contenedor.getChildren().setAll(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}

