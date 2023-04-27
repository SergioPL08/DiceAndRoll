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
    private enum competencia1{acrobacias,arcanos,atletismo,engañar,historia,interpretacion,intimidar,investigacion,juego_de_manos,medicina,naturaleza,percepcion,perspicacia,presuasion,religion,sigilo,supervivencia,trato_con_animales};
    private enum competencia2{acrobacias,arcanos,atletismo,engañar,historia,interpretacion,intimidar,investigacion,juego_de_manos,medicina,naturaleza,percepcion,perspicacia,presuasion,religion,sigilo,supervivencia,trato_con_animales};
    private String otrasCompetencias;
    private String descRasgo;
    private int idLibro;
    private int idPersonaje;

    public Trasfondo(int id_transfondo, String nombre, String descripcion, String otrasCompetencias, String descRasgo, int idLibro, int idPersonaje) {
        this.id_transfondo = id_transfondo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.otrasCompetencias = otrasCompetencias;
        this.descRasgo = descRasgo;
        this.idLibro = idLibro;
        this.idPersonaje = idPersonaje;
    }

    public Trasfondo(int id_transfondo, String nombre, String descripcion, String otrasCompetencias, String descRasgo, int idLibro) {
        this.id_transfondo = id_transfondo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.otrasCompetencias = otrasCompetencias;
        this.descRasgo = descRasgo;
        this.idLibro = idLibro;
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
