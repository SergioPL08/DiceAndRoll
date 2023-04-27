/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Equipo {
    private int idHerramienta;
    private String nombre;
    private String descripcion;
    private String precio;
    private String peso;
    private String idLibro;

    public Equipo(int idHerramienta, String nombre, String descripcion, String precio, String peso, String idLibro) {
        this.idHerramienta = idHerramienta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.peso = peso;
        this.idLibro = idLibro;
    }

    public Equipo(int idHerramienta, String nombre, String descripcion, String precio, String peso) {
        this.idHerramienta = idHerramienta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.peso = peso;
    }

    public int getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(int idHerramienta) {
        this.idHerramienta = idHerramienta;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }
    
}
