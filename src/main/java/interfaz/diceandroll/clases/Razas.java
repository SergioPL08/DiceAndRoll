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
    private int idLibro;
    private int idPersonaje;

    public Razas(int idRaza, String nombre, String descripcion, String velocidad, int idLibro, int idPersonaje) {
        this.idRaza = idRaza;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.velocidad = velocidad;
        this.idLibro = idLibro;
        this.idPersonaje = idPersonaje;
    }

    public Razas(int idRaza, String nombre, String descripcion, String velocidad, int idLibro) {
        this.idRaza = idRaza;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.velocidad = velocidad;
        this.idLibro = idLibro;
    }
    
    
}
