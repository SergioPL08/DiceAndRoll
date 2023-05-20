/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Conjuros {
    private int idConjuro;
    private String nombre;
    private int nivel;
    private String escuela;
    private boolean v;
    private boolean s;
    private boolean m;
    private String textoCompetenciaMaterial;
    private String tiempoLanzamiento;
    private String alcance;
    private String duracion;
    private String descripcion;
    private int idLibro;    

    public Conjuros(int idConjuro, String nombre, int nivel, String escuela, boolean v, boolean s, boolean m, String textoComponenteMaterial, String tiempoLanzamiento, String alcance, String duracion, String descripcion, int idLibro) {
        this.idConjuro = idConjuro;
        this.nombre = nombre;
        this.nivel = nivel;
        this.escuela = escuela;
        this.v = v;
        this.s = s;
        this.m = m;
        this.textoCompetenciaMaterial = textoComponenteMaterial;
        this.tiempoLanzamiento = tiempoLanzamiento;
        this.alcance = alcance;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.idLibro = idLibro;
    }

    public Conjuros(int idConjuro, String nombre, int nivel, boolean v, boolean s, boolean m, String tiempoLanzamiento, String alcance, String duracion, String descripcion) {
        this.idConjuro = idConjuro;
        this.nombre = nombre;
        this.nivel = nivel;
        this.v = v;
        this.s = s;
        this.m = m;
        this.tiempoLanzamiento = tiempoLanzamiento;
        this.alcance = alcance;
        this.duracion = duracion;
        this.descripcion = descripcion;
    }

    public int getIdConjuro() {
        return idConjuro;
    }

    public void setIdConjuro(int idConjuro) {
        this.idConjuro = idConjuro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isV() {
        return v;
    }

    public void setV(boolean v) {
        this.v = v;
    }

    public boolean isS() {
        return s;
    }

    public void setS(boolean s) {
        this.s = s;
    }

    public boolean isM() {
        return m;
    }

    public void setM(boolean m) {
        this.m = m;
    }

    public String getTiempoLanzamiento() {
        return tiempoLanzamiento;
    }

    public void setTiempoLanzamiento(String tiempoLanzamiento) {
        this.tiempoLanzamiento = tiempoLanzamiento;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getTextoCompetenciaMaterial() {
        return textoCompetenciaMaterial;
    }

    public void setTextoCompetenciaMaterial(String textoCompetenciaMaterial) {
        this.textoCompetenciaMaterial = textoCompetenciaMaterial;
    }
    
    
    
}
