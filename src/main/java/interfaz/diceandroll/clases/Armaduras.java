/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Armaduras {
    private int idArmadura;
    private String nombre, descripcion;
    private enum categoria{ligera,intermedia,pesada,escudo};
    private int ca;
    private enum bono_des{completo,intermedio,ninguno};
    //true: desventaja, false: ninguna
    private boolean penalizacion;
    private int fuerza;
    private String precio,peso;
    private int idLibro;
    private int idPersonaje;

    public Armaduras(int idArmadura, String nombre, String descripcion, int ca, boolean penalizacion, int fuerza, String precio, String peso, int idLibro, int idPersonaje) {
        this.idArmadura = idArmadura;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ca = ca;
        this.penalizacion = penalizacion;
        this.fuerza = fuerza;
        this.precio = precio;
        this.peso = peso;
        this.idLibro = idLibro;
        this.idPersonaje = idPersonaje;
    }

    public Armaduras(int idArmadura, String nombre, String descripcion, int ca, boolean penalizacion, int fuerza, String precio, String peso, int idLibro) {
        this.idArmadura = idArmadura;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ca = ca;
        this.penalizacion = penalizacion;
        this.fuerza = fuerza;
        this.precio = precio;
        this.peso = peso;
        this.idLibro = idLibro;
    }

    public int getIdArmadura() {
        return idArmadura;
    }

    public void setIdArmadura(int idArmadura) {
        this.idArmadura = idArmadura;
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

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public boolean isPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(boolean penalizacion) {
        this.penalizacion = penalizacion;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
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