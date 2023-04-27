/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Rasgo {
    private int idRasgo;
    private String nombre;
    private String descripcion;
    private String descripcionCorta;
    private int idLibro;
    private int idClase;
    private int idRaza;
    private int idSubraza;
    private int nivel;
    private boolean adquisicion;
    
    public Rasgo(int idRasgo, String nombre, String descripcion, String descripcionCorta, int idLibro, int idRaza) {
        this.idRasgo = idRasgo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descripcionCorta = descripcionCorta;
        this.idLibro = idLibro;
        this.idClase = idClase;
    }

    public Rasgo(int idRasgo, String nombre, String descripcion, String descripcionCorta, int idLibro, int idClase, int nivel, boolean adquisicion) {
        this.idRasgo = idRasgo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descripcionCorta = descripcionCorta;
        this.idLibro = idLibro;
        this.idClase = idClase;
        this.nivel = nivel;
        this.adquisicion = adquisicion;
    }

    public int getIdRasgo() {
        return idRasgo;
    }

    public void setIdRasgo(int idRasgo) {
        this.idRasgo = idRasgo;
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

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public int getIdSubraza() {
        return idSubraza;
    }

    public void setIdSubraza(int idSubraza) {
        this.idSubraza = idSubraza;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isAdquisicion() {
        return adquisicion;
    }

    public void setAdquisicion(boolean adquisicion) {
        this.adquisicion = adquisicion;
    }

    

    
    
    
    
}
