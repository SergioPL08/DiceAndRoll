/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Dote {
    private int idDote;
    private String nombre;
    private String descripcion;
    private String caracMod;
    private String caracMod2;
    private int mod;
    private int idLibro;
    private int idPersonaje;

    public Dote(){
        
    }
    
    public Dote(int idDote, String nombre, String descripcion, String caracMod, String caracMod2, int mod, int idLibro, int idPersonaje) {
        this.idDote = idDote;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracMod = caracMod;
        this.caracMod2 = caracMod2;
        this.mod = mod;
        this.idLibro = idLibro;
        this.idPersonaje = idPersonaje;
    }

    public Dote(int idDote, String nombre, String descripcion, int idLibro, int idPersonaje) {
        this.idDote = idDote;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idLibro = idLibro;
        this.idPersonaje = idPersonaje;
    }
    public Dote(int idDote, String nombre, String descripcion) {
        this.idDote = idDote;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Dote(int idDote, String nombre, String descripcion, String caracMod, String caracMod2, int mod, int idLibro) {
        this.idDote = idDote;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracMod = caracMod;
        this.caracMod2 = caracMod2;
        this.mod = mod;
        this.idLibro = idLibro;
    }

    public Dote(int idDote, String nombre, String descripcion, int idLibro) {
        this.idDote = idDote;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idLibro = idLibro;
    }

    public int getIdDote() {
        return idDote;
    }

    public void setIdDote(int idDote) {
        this.idDote = idDote;
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

    public String getCaracMod() {
        return caracMod;
    }

    public void setCaracMod(String caracMod) {
        this.caracMod = caracMod;
    }

    public String getCaracMod2() {
        return caracMod2;
    }

    public void setCaracMod2(String caracMod2) {
        this.caracMod2 = caracMod2;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
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

    @Override
    public String toString() {
        return nombre;
    }

    
 
    
}
