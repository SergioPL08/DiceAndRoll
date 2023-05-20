/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Trasfondo {
    private int id_transfondo;
    private String nombre;
    private String descripcion;
    private String competencia1;
    private String competencia2;
    private String otrasCompetencias;
    private String nombreRasgo;
    private String nombreEspecialidad;
    private String descRasgo;
    private String descripcionEspecialidad;
    private String descCaracSug;
    private int idLibro;
    private int idPersonaje;

    public Trasfondo(int id_transfondo, String nombre, String descripcion, String competencia1, String competencia2, String otrasCompetencias, String nombreRasgo, String descRasgo,String nombreEspecialidad, String descripcionEspecialidad, String descCarSug,int idLibro) {
        this.id_transfondo = id_transfondo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.competencia1=competencia1;
        this.competencia2=competencia2;
        this.otrasCompetencias = otrasCompetencias;
        this.nombreRasgo=nombreRasgo;
        this.descRasgo = descRasgo;
        this.nombreEspecialidad=nombreEspecialidad;
        this.descripcionEspecialidad=descripcionEspecialidad;
        this.descCaracSug=descCarSug;
        this.idLibro = idLibro;
    }

    public String getCompetencia1() {
        return competencia1;
    }

    public void setCompetencia1(String competencia1) {
        this.competencia1 = competencia1;
    }

    public String getCompetencia2() {
        return competencia2;
    }

    public void setCompetencia2(String competencia2) {
        this.competencia2 = competencia2;
    }

    public String getNombreRasgo() {
        return nombreRasgo;
    }

    public void setNombreRasgo(String nombreRasgo) {
        this.nombreRasgo = nombreRasgo;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public String getDescCaracSug() {
        return descCaracSug;
    }

    public void setDescCaracSug(String descCaracSug) {
        this.descCaracSug = descCaracSug;
    }

    public String getDescripcionEspecialidad() {
        return descripcionEspecialidad;
    }

    public void setDescripcionEspecialidad(String descripcionEspecialidad) {
        this.descripcionEspecialidad = descripcionEspecialidad;
    }
    

    public int getId_transfondo() {
        return id_transfondo;
    }

    public void setId_transfondo(int id_transfondo) {
        this.id_transfondo = id_transfondo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOtrasCompetencias() {
        return otrasCompetencias;
    }

    public void setOtrasCompetencias(String otrasCompetencias) {
        this.otrasCompetencias = otrasCompetencias;
    }

    public String getDescRasgo() {
        return descRasgo;
    }

    public void setDescRasgo(String descRasgo) {
        this.descRasgo = descRasgo;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }
    
}
