/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Habilidad {
    private int idHabilidad;
    private String nombre,descripcion,adquisicion,descCorta,stat1,stat2;
    private int nivel,bonoStat1,bonoStat2, base, bono;
    private boolean competencia, pericia;
    //habilidad,base,bono,competencia,pericia

    public Habilidad(int idHabilidad, String nombre, String descripcion, String adquisicion, String descCorta, String stat1, String stat2, int nivel, int bonoStat1, int bonoStat2) {
        this.idHabilidad = idHabilidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.adquisicion = adquisicion;
        this.descCorta = descCorta;
        this.stat1 = stat1;
        this.stat2 = stat2;
        this.nivel = nivel;
        this.bonoStat1 = bonoStat1;
        this.bonoStat2 = bonoStat2;
    }
    
    public Habilidad(String nombre,int bono){
        this.nombre=nombre;
        this.bono=bono;
    }
    
    public Habilidad(String nombre,String descripcion,String adquisicion,String descCorta){
        this.nombre=nombre;
        this.descCorta=descCorta;
        this.adquisicion=adquisicion;
        this.descripcion=descripcion;
    }
    
    public Habilidad(String nombre, int base, int bono, boolean competencia, boolean pericia){
        this.nombre=nombre;
        this.base=base;
        this.bono=bono;
        this.competencia=competencia;
        this.pericia=pericia;
    }
    
    public Habilidad(String nombre, int base, int bono, boolean competencia){
        this.nombre=nombre;
        this.base=base;
        this.bono=bono;
        this.competencia=competencia;
    }
    
    public Habilidad(String nombre, String descripcion, String descripcionCorta){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.descCorta=descripcionCorta;
    }
    
    public int getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(int idHabilidad) {
        this.idHabilidad = idHabilidad;
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

    public String getAdquisicion() {
        return adquisicion;
    }

    public void setAdquisicion(String adquisicion) {
        this.adquisicion = adquisicion;
    }

    public String getDescCorta() {
        return descCorta;
    }

    public void setDescCorta(String descCorta) {
        this.descCorta = descCorta;
    }

    public String getStat1() {
        return stat1;
    }

    public void setStat1(String stat1) {
        this.stat1 = stat1;
    }

    public String getStat2() {
        return stat2;
    }

    public void setStat2(String stat2) {
        this.stat2 = stat2;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getBonoStat1() {
        return bonoStat1;
    }

    public void setBonoStat1(int bonoStat1) {
        this.bonoStat1 = bonoStat1;
    }

    public int getBonoStat2() {
        return bonoStat2;
    }

    public void setBonoStat2(int bonoStat2) {
        this.bonoStat2 = bonoStat2;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getBono() {
        return bono;
    }

    public void setBono(int bono) {
        this.bono = bono;
    }

    public boolean isCompetencia() {
        return competencia;
    }

    public void setCompetencia(boolean competencia) {
        this.competencia = competencia;
    }

    public boolean isPericia() {
        return pericia;
    }

    public void setPericia(boolean pericia) {
        this.pericia = pericia;
    }

    
    
    @Override
    public String toString() {
        return nombre;
    }
    
    
}
