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
    private enum caracMod{fue,des,con,inte,sab,car};
    private int mod;
    private int idLibro;
    private int idPersonaje;

     public Dote(int id, String nombre, String descripcion, int mod, int idLibro, int idPersonaje) {
        this.idDote = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.mod = mod;
        this.idLibro = idLibro;
        this.idPersonaje = idPersonaje;
    }
    
    public Dote(int id, String nombre, String descripcion, int mod, int idLibro) {
        this.idDote = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.mod = mod;
        this.idLibro = idLibro;
    }
    
    
    public int getId() {
        return idDote;
    }

    public void setId(int id) {
        this.idDote = id;
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


    
    
}
