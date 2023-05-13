/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Libro {
    private int idLibro;
    private String nombre;
    private String descripcion;

    public Libro(int idLibro, String nombre, String descripcion) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Libro(int idLibro, String nombre) {
        this.idLibro = idLibro;
        this.nombre = nombre;
    }

    
    
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
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
    
}
