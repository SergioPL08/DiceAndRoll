/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.conector.Conector;
import static interfaz.diceandroll.App.conector;
import interfaz.diceandroll.clases.Clases;
import interfaz.diceandroll.clases.Libro;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class ListaClasesController implements Initializable {
    //Variables FXML
    @FXML
    private Pane clase1,clase2,clase3,clase4,clase5,clase6,clase7,clase8,clase9;
    @FXML
    private Label nombreClase1,nombreClase2,nombreClase3,nombreClase4,nombreClase5,nombreClase6,nombreClase7,nombreClase8,nombreClase9;
    @FXML
    private ImageView imagen1,imagen2,imagen3,imagen4,imagen5,imagen6,imagen7,imagen8,imagen9;
    @FXML
    private Label libroClase1, libroClase2,libroClase3,libroClase4,libroClase5,libroClase6,libroClase7,libroClase8,libroClase9;
    @FXML
    private TextField textFieldBuscador;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private GridPane gridPane;
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
    @FXML
    private AnchorPane contenedor;;
    
    //Variables propias
    ArrayList<interfaz.diceandroll.clases.Clases> listaClases;
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
    Clases clase;
    private Pane panelPrincipal;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializamos todas las listas
        listaClases = new ArrayList();
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
        //Llamamos al método que recoge todas las clases y rellena el grid
        getClases();
        //Desactivamos los botones de navegación en caso necesario (los botones de retroceder si estamos en la primera página o los de avanzar si estamos en la última, además de desactivar el botón de la página actual)
        desactivarBotones();
    }    
    
    public void setPanePrincipal(Pane panelPrincipal){
        this.panelPrincipal=panelPrincipal;
    }
    
    /**
     * Este metodo añade las clases, los nombres de las mismas y su libro asociado a su respectiva lista
     */
    public void generaArrayClases(){
        listaPane.clear();
        listaNombre.clear();
        listaClases.clear();
        listaImagenes.clear();
        listaLibros.clear();
        listaPane.add(clase1);
        listaPane.add(clase2);
        listaPane.add(clase3);
        listaPane.add(clase4);
        listaPane.add(clase5);
        listaPane.add(clase6);
        listaPane.add(clase7);
        listaPane.add(clase8);
        listaPane.add(clase9);
        listaNombre.add(nombreClase1);
        listaNombre.add(nombreClase2);
        listaNombre.add(nombreClase3);
        listaNombre.add(nombreClase4);
        listaNombre.add(nombreClase5);
        listaNombre.add(nombreClase6);
        listaNombre.add(nombreClase7);
        listaNombre.add(nombreClase8);
        listaNombre.add(nombreClase9);
        listaLabelLibros.add(libroClase1);
        listaLabelLibros.add(libroClase2);
        listaLabelLibros.add(libroClase3);
        listaLabelLibros.add(libroClase4);
        listaLabelLibros.add(libroClase5);
        listaLabelLibros.add(libroClase6);
        listaLabelLibros.add(libroClase7);
        listaLabelLibros.add(libroClase8);
        listaLabelLibros.add(libroClase9);
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
    public void getClases(){
        generaArrayClases();
        String buscador = textFieldBuscador.getText();
        String filtro = comboBox.getValue();
        try {
            //Hacemos una consulta con base de datos para seleccionar las clases
            String consulta = "SELECT * FROM clase, libros_reglas";
            //Si queremos filtrar por nombre, aquí lo podemos hacer 
            if(!buscador.equals(""))
                consulta += " WHERE clase.nombre LIKE '%"+buscador+"%' ";
            //Si queremos ordenar por nombre ascendente o descendente o por libro de reglas
            if(filtro!=null){
                if(filtro.equals("Nombre [a-z]"))
                    consulta += " order by clase.nombre asc ";
                else if(filtro.equals("Nombre [z-a]"))
                    consulta += " order by clase.nombre desc ";
                else if(filtro.equals("Libro"))
                    consulta += " order by clase.id_libro, clase.nombre asc";
            }
            else
                consulta += " order by libros_reglas.id_libro, clase.nombre";
            //Establecemos la conexion con la base de datos y recogemos los datos encontrados
            ResultSet clases = Conector.getSelect(consulta, conector);
            while(clases.next()){
                //Recogemos toda la información de la clase y creamos un objeto con ella, también para el libro de reglas asociado
                int idClase = clases.getInt("id_clase");
                String nombre = clases.getString("clase.nombre");
                int puntosGolpe = clases.getInt("puntos_golpe");
                String resquisito_multiclase = clases.getString("requisito_multiclase1");
                Boolean compArmasSimples = clases.getBoolean("competencia_armas_sencillas");
                Boolean compArmasMarciales = clases.getBoolean("competencia_armas_marciales");
                Boolean compArmadurasLigeras = clases.getBoolean("competencia_armaduras_ligeras");
                Boolean compArmadurasMedias = clases.getBoolean("competencia_armaduras_intermedias");
                Boolean compArmadurasPesadas = clases.getBoolean("competencia_armaduras_pesadas");
                Boolean compEscudo = clases.getBoolean("competencia_escudo");
                String otrasCompArmas = clases.getString("otras_competencias_armas");
                String otrasComp = clases.getString("otras_competencias");
                String textCompHab = clases.getString("texto_competencia_habilidades");
                String caster = (String) clases.getString("tipo_caster");
                String aptMag = (String) clases.getString("aptitud_magica");
                String compStat1 = clases.getString("competencia_estadistica1");
                System.out.println("xDDD"+compStat1);
                String compStat2 = clases.getString("competencia_estadistica2");
                System.out.println("UwU"+compStat2);
                String icon = clases.getString("icon");
                int idLibro = clases.getInt("id_libro");
                String nombreLibro = clases.getString("libros_reglas.nombre");
                //                                                    id_clase, nombre, "", puntosGolpe, requisitoMulticlase,competenciaS,    competenciaArmasMa,competenciaArmadurasLigeras,competenciaArmadurasMedias,competenciaArmadurasPesadas,competenciaEscudo,otrasCompetenciasArmas,otrasCompetencias,textoCompetenciasHabilidades,tipoCaster,aptitudMagica,competenciaEstat1,competenciaEstat2,icon,idLibro
                interfaz.diceandroll.clases.Clases clase = new Clases(idClase, nombre, "",puntosGolpe, resquisito_multiclase,compArmasSimples,compArmasMarciales,compArmadurasLigeras,compArmadurasMedias,compArmadurasPesadas,compEscudo,otrasCompArmas,otrasComp,textCompHab,caster,aptMag,compStat1,compStat2,icon,idLibro);
                interfaz.diceandroll.clases.Libro libro = new Libro(idLibro,nombreLibro);
                //Añadimos ambos a sus respectivas listas
                listaClases.add(clase);
                //System.out.println(icon);
                Image imagen = new Image(getClass().getResourceAsStream(icon));
                //System.out.println(imagen.toString());
                listaImagenes.add(imagen);
                listaLibros.add(libro);
            }
            //Llamamos al metodo para rellenar el grid con los datos de ambas listas para que el usuario pueda ver las clases
            rellenaClases();
            //El total de las páginas será igual a la división entera de el tamaño de la lista de clases entre el número de elementos por página
            totalPaginas = (int) Math.ceil((double) listaClases.size() / NUM_ELEMENTOS_POR_PAGINA);
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
        Iterator iter = listaClases.iterator();
        int contador = 0;
        inicio = (paginaActual - 1) * NUM_ELEMENTOS_POR_PAGINA;
        //Rellenamos la información de cada panel de información de clase con su contenido
        while (iter.hasNext() && contador < NUM_ELEMENTOS_POR_PAGINA && inicio + contador < listaClases.size()) {
            listaPane.get(contador).setVisible(true);
            listaNombre.get(contador).setText(listaClases.get(inicio + contador).getNombre());
            listaLabelLibros.get(contador).setText(listaLibros.get(inicio + contador).getNombre());
            System.out.println(listaImagenes.get(inicio+contador).getUrl());
            listaImageview.get(contador).setImage(listaImagenes.get(inicio+contador));
            iter.next();
            contador++;
        }
        //En caso de que queden huecos de información por rellenar y no se haya hecho todavía, se hace aquí
        if (contador == NUM_ELEMENTOS_POR_PAGINA && inicio + contador < listaClases.size()) {
            listaPane.get(contador-1).setVisible(true);
            //System.out.println(contador);
            listaNombre.get(contador-1).setText(listaClases.get(inicio + contador-1).getNombre());
            listaImageview.get(contador-1).setImage(listaImagenes.get(inicio+contador-1));
            listaLabelLibros.get(contador-1).setText(listaLibros.get(inicio + contador-1).getNombre());
            contador++;
        }
        //Eliminamos todos los huecos vacíos que hayan quedado
        for (int i = contador; i < NUM_ELEMENTOS_POR_PAGINA; i++) {
            listaPane.get(i).setVisible(false);
            listaNombre.get(i).setText("");
            File ruta = new File("..\\..\\img\\no_image.png");
            Image imagen = new Image(ruta.toURI().toString());
            listaImageview.get(contador).setImage(imagen);
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
        generaArrayClases();
        int contador=0;
        while(contador<NUM_ELEMENTOS_POR_PAGINA){
            listaPane.get(contador).setVisible(false); 
            File ruta = new File("..\\..\\img\\no_image.png");
            Image imagen = new Image(ruta.toURI().toString());
            listaImageview.get(contador).setImage(imagen);
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
     * Abrimos la ventana de información detallada de la clase seleccionada
     * @param event 
     */
    @FXML
    private void abrirClase(MouseEvent event) {
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
        clase = listaClases.get(indice);
        Libro libro = listaLibros.get(indice);
        Image imagen = listaImagenes.get(indice);
        
        abrirMenuExplorarClase(clase,libro,imagen);
    }
    
    /**
     * Se carga la ventana con la clase seleccionada
     * @param clase
     * @param libro 
     */
    private void abrirMenuExplorarClase(Clases clase,Libro libro,Image imagen) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("explorarClase.fxml"));
        ExplorarClaseController explorarClaseController = new ExplorarClaseController(clase,libro,imagen);
        Parent root = fxmlLoader.load();
        explorarClaseController.setPanePrincipal(contenedor);
        fxmlLoader.setController(explorarClaseController);
        contenedor.getChildren().setAll(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    public Clases getClase(){
        return this.clase;
    }

}
