/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Clase {
    private int id_clase;
    private String nombre;
    private String descripcion;
    private int puntosGolpe;
    private String requisitoMulticlase;
    private boolean competenciaArmasSencillas;
    private boolean competenciaArmasMarciales;
    private boolean competenciaArmadurasLigeras;
    private boolean competenciaArmadurasMedias;
    private boolean competenciaArmadurasPesadas;
    private boolean competenciaEscudo;
    private String otrasCompetenciasArmas;
    private String otrasCompetencias;
    private String textoCompetenciasHabilidades;
    private String tipoCaster;
    private String aptitudMagica;
    private String competenciaEstat1;
    private String competenciaEstat2;
    private String icon;
    private int idLibro;
    private int idPersonaje;

    public Clase(int id_clase, String nombre) {
        this.id_clase = id_clase;
        this.nombre = nombre;
    }
    
    public Clase(int id_clase, String nombre, String descripcion, int puntosGolpe, String requisitoMulticlase, boolean competenciaArmasSencillas, boolean competenciaArmasMarciales, boolean competenciaArmadurasLigeras, boolean competenciaArmadurasMedias, boolean competenciaArmadurasPesadas, boolean competenciaEscudo, String textoCompetenciasHabilidades, String tipoCaster, String aptitudMagica,String competenciaEstat1,String competenciaEstat2, String icon, int idLibro) {
        this.id_clase = id_clase;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntosGolpe = puntosGolpe;
        this.requisitoMulticlase = requisitoMulticlase;
        this.competenciaArmasSencillas = competenciaArmasSencillas;
        this.competenciaArmasMarciales = competenciaArmasMarciales;
        this.competenciaArmadurasLigeras = competenciaArmadurasLigeras;
        this.competenciaArmadurasMedias = competenciaArmadurasMedias;
        this.competenciaArmadurasPesadas = competenciaArmadurasPesadas;
        this.competenciaEscudo = competenciaEscudo;
        this.otrasCompetencias = otrasCompetencias;
        this.otrasCompetenciasArmas = otrasCompetenciasArmas;
        this.textoCompetenciasHabilidades = textoCompetenciasHabilidades;
        this.icon = icon;
        this.idLibro = idLibro;
        this.idPersonaje = idPersonaje;
    }
    public int getIdClase() {
        return id_clase;
    }

    public void setIdClase(int id_clase) {
        this.id_clase = id_clase;
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

    public int getPuntosGolpe() {
        return puntosGolpe;
    }

    public void setPuntosGolpe(int puntosGolpe) {
        this.puntosGolpe = puntosGolpe;
    }

    public String getRequisitoMulticlase() {
        return requisitoMulticlase;
    }

    public void setRequisitoMulticlase(String requisitoMulticlase) {
        this.requisitoMulticlase = requisitoMulticlase;
    }

    public boolean isCompetenciaArmasSencillas() {
        return competenciaArmasSencillas;
    }

    public void setCompetenciaArmasSencillas(boolean competenciaArmasSencillas) {
        this.competenciaArmasSencillas = competenciaArmasSencillas;
    }

    public boolean isCompetenciaArmasMarciales() {
        return competenciaArmasMarciales;
    }

    public void setCompetenciaArmasMarciales(boolean competenciaArmasMarciales) {
        this.competenciaArmasMarciales = competenciaArmasMarciales;
    }

    public boolean isCompetenciaArmadurasLigeras() {
        return competenciaArmadurasLigeras;
    }

    public void setCompetenciaArmadurasLigeras(boolean competenciaArmadurasLigeras) {
        this.competenciaArmadurasLigeras = competenciaArmadurasLigeras;
    }

    public boolean isCompetenciaArmadurasMedias() {
        return competenciaArmadurasMedias;
    }

    public void setCompetenciaArmadurasMedias(boolean competenciaArmadurasMedias) {
        this.competenciaArmadurasMedias = competenciaArmadurasMedias;
    }

    public boolean isCompetenciaArmadurasPesadas() {
        return competenciaArmadurasPesadas;
    }

    public void setCompetenciaArmadurasPesadas(boolean competenciaArmadurasPesadas) {
        this.competenciaArmadurasPesadas = competenciaArmadurasPesadas;
    }
    public boolean isCompetenciaEscudo(){
        return competenciaEscudo;
    }
    public void setCompetenciaEscudo(boolean competenciaEscudo) {
        this.competenciaEscudo= competenciaEscudo;
    }
    public String getOtrasCompetencias() {
        return otrasCompetencias;
    }

    public void setOtrasCompetencias(String otrasCompetencias) {
        this.otrasCompetencias = otrasCompetencias;
    }

    public String getTextoCompetenciasHabilidades() {
        return textoCompetenciasHabilidades;
    }

    public void setTextoCompetenciasHabilidades(String textoCompetenciasHabilidades) {
        this.textoCompetenciasHabilidades = textoCompetenciasHabilidades;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTipoCaster() {
        return tipoCaster;
    }

    public void setTipoCaster(String tipoCaster) {
        this.tipoCaster = tipoCaster;
    }

    public String getAptitudMagica() {
        return aptitudMagica;
    }

    public void setAptitudMagica(String aptitudMagica) {
        this.aptitudMagica = aptitudMagica;
    }

    public String getCompetenciaEstat1() {
        return competenciaEstat1;
    }

    public void setCompetenciaEstat1(String competenciaEstat1) {
        this.competenciaEstat1 = competenciaEstat1;
    }

    public String getCompetenciaEstat2() {
        return competenciaEstat2;
    }

    public void setCompetenciaEstat2(String competenciaEstat2) {
        this.competenciaEstat2 = competenciaEstat2;
    }
    
    public String getOtrasCompetenciasArmas() {
        return otrasCompetenciasArmas;
    }

    public void setOtrasCompetenciasArmas(String otrasCompetenciasArmas) {
        this.otrasCompetenciasArmas = otrasCompetenciasArmas;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
