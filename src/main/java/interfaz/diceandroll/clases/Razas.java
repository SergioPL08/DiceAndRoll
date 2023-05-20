/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Razas {
    private int idRaza;
    private String nombre;
    private String descripcion;
    private String velocidad;
    int mod1;
    int mod2;
    private int idLibro;
    private int idPersonaje;

    public Razas(int idRaza, String nombre, String descripcion, String velocidad, int nMod1, int nMod2,int idLibro) {
        this.idRaza = idRaza;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.velocidad = velocidad;
        this.mod1=nMod1;
        this.mod2=nMod2;
        
        this.idLibro = idLibro;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
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

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

   

    public int getMod1() {
        return mod1;
    }

    public void setMod1(int mod1) {
        this.mod1 = mod1;
    }


    public int getMod2() {
        return mod2;
    }

    public void setMod2(int mod2) {
        this.mod2 = mod2;
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
