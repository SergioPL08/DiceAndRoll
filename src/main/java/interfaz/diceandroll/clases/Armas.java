/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Armas {
    private int idArma;
    private String nombre;
    private String descripcion;
    private enum categoria{simple,marcial};
    private String alcance;
    private String danio;
    private String tipoDanio;
    private String precio;
    private String peso;    
    private String tiradaAtaque;
    private int bonusAtaque;
    private String tiradaDanio;
    private int bonusDanio;
    private String municion;
    private int idLibro;
    private int idPersonaje;

    public Armas(int idArma, String nombre, String descripcion, String alcance, String danio, String tipoDanio, String precio, String peso, String tiradaAtaque, int bonusAtaque, String tiradaDanio, int bonusDanio, String municion, int idLibro, int idPersonaje) {
        this.idArma = idArma;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.alcance = alcance;
        this.danio = danio;
        this.tipoDanio = tipoDanio;
        this.precio = precio;
        this.peso = peso;
        this.tiradaAtaque = tiradaAtaque;
        this.bonusAtaque = bonusAtaque;
        this.tiradaDanio = tiradaDanio;
        this.bonusDanio = bonusDanio;
        this.municion = municion;
        this.idLibro = idLibro;
        this.idPersonaje = idPersonaje;
    }

    public Armas(int idArma, String nombre, String descripcion, String alcance, String danio, String tipoDanio, String precio, String peso, String tiradaAtaque, int bonusAtaque, String tiradaDanio, int bonusDanio, String municion, int idLibro) {
        this.idArma = idArma;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.alcance = alcance;
        this.danio = danio;
        this.tipoDanio = tipoDanio;
        this.precio = precio;
        this.peso = peso;
        this.tiradaAtaque = tiradaAtaque;
        this.bonusAtaque = bonusAtaque;
        this.tiradaDanio = tiradaDanio;
        this.bonusDanio = bonusDanio;
        this.municion = municion;
        this.idLibro = idLibro;
    }

    public int getIdArma() {
        return idArma;
    }

    public void setIdArma(int idArma) {
        this.idArma = idArma;
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

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public String getDanio() {
        return danio;
    }

    public void setDanio(String danio) {
        this.danio = danio;
    }

    public String getTipoDanio() {
        return tipoDanio;
    }

    public void setTipoDanio(String tipoDanio) {
        this.tipoDanio = tipoDanio;
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

    public String getTiradaAtaque() {
        return tiradaAtaque;
    }

    public void setTiradaAtaque(String tiradaAtaque) {
        this.tiradaAtaque = tiradaAtaque;
    }

    public int getBonusAtaque() {
        return bonusAtaque;
    }

    public void setBonusAtaque(int bonusAtaque) {
        this.bonusAtaque = bonusAtaque;
    }

    public String getTiradaDanio() {
        return tiradaDanio;
    }

    public void setTiradaDanio(String tiradaDanio) {
        this.tiradaDanio = tiradaDanio;
    }

    public int getBonusDanio() {
        return bonusDanio;
    }

    public void setBonusDanio(int bonusDanio) {
        this.bonusDanio = bonusDanio;
    }

    public String getMunicion() {
        return municion;
    }

    public void setMunicion(String municion) {
        this.municion = municion;
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
