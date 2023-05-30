/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Personaje {
    private int idPersonaje;
    private String nombre;
    private int idRaza;
    private String nombreRaza;
    private String nombreSubRaza;    
    private int velocidad;
    private int vidaMaxima, vidaActual, iniciativa, claseArmadura, competencia;
    private int fue,des,con,inte,sab,car;
    private int idUsuario;
    private int total;

    public Personaje(int idPersonaje, String nombre, int idRaza, String nombreRaza, String nombreSubRaza, int velocidad, int vidaMaxima, int vidaActual, int iniciativa, int claseArmadura, int competencia, int fue, int des, int con, int inte, int sab, int car) {
        this.idPersonaje = idPersonaje;
        this.nombre = nombre;
        this.idRaza = idRaza;
        this.nombreRaza = nombreRaza;
        this.nombreSubRaza = nombreSubRaza;
        this.velocidad = velocidad;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaActual;
        this.iniciativa = iniciativa;
        this.claseArmadura = claseArmadura;
        this.competencia = competencia;
        this.fue = fue;
        this.des = des;
        this.con = con;
        this.inte = inte;
        this.sab = sab;
        this.car = car;
    }

    public Personaje(String nombre,int fue,int des,int con,int inte,int sab,int car,int total){
        this.nombre=nombre;
        this.fue=fue;
        this.des=des;
        this.con=con;
        this.inte=inte;
        this.sab=sab;
        this.car=car;
        this.total=total;
    }
    
    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public String getNombreSubRaza() {
        return nombreSubRaza;
    }

    public void setNombreSubRaza(String nombreSubRaza) {
        this.nombreSubRaza = nombreSubRaza;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

    public int getClaseArmadura() {
        return claseArmadura;
    }

    public void setClaseArmadura(int claseArmadura) {
        this.claseArmadura = claseArmadura;
    }

    public int getCompetencia() {
        return competencia;
    }

    public void setCompetencia(int competencia) {
        this.competencia = competencia;
    }

    public int getFue() {
        return fue;
    }

    public void setFue(int fue) {
        this.fue = fue;
    }

    public int getDes() {
        return des;
    }

    public void setDes(int des) {
        this.des = des;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getInte() {
        return inte;
    }

    public void setInte(int inte) {
        this.inte = inte;
    }

    public int getSab() {
        return sab;
    }

    public void setSab(int sab) {
        this.sab = sab;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
        
}
