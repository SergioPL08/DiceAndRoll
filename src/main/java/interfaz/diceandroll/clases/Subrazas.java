/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Subrazas {
    private int idSubraza;
    private String nombre;
    private String descripcion;
    private enum statMod{fue,des,con,inte,sab,car};
    private int mod;
    private String competencia;
    private int idRaza;
    private int idLibro;
    private int idPersonaje;

    public Subrazas(int idSubraza, String nombre, String descripcion, int mod, String competencia, int idRaza, int idLibro, int idPersonaje) {
        this.idSubraza = idSubraza;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.mod = mod;
        this.competencia = competencia;
        this.idRaza = idRaza;
        this.idLibro = idLibro;
        this.idPersonaje = idPersonaje;
    }

    public Subrazas(int idSubraza, String nombre, String descripcion, int mod, String competencia, int idRaza, int idLibro) {
        this.idSubraza = idSubraza;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.mod = mod;
        this.competencia = competencia;
        this.idRaza = idRaza;
        this.idLibro = idLibro;
    }

    public Subrazas(int idSubraza, String nombre) {
        this.idSubraza = idSubraza;
        this.nombre = nombre;
    }
    
    public int getIdSubraza() {
        return idSubraza;
    }

    public void setIdSubraza(int idSubraza) {
        this.idSubraza = idSubraza;
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

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
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
    public String toString(){
        return nombre;
    }
}
