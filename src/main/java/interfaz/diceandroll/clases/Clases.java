/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Clases {
    private int id_clase;
    private String nombre;
    private String descripcion;
    private int puntosGolpe;
    private String requisitoMulticlase;
    private int competenciaArmasSencillas;
    private int competenciaArmasMarciales;
    private int competenciaArmadurasLigeras;
    private int competenciaArmadurasMedias;
    private int competenciaArmadurasPesadas;
    private String otrasCompetencias;
    private String textoCompetenciasHabilidades;
    private enum tipoCaster{puro,medio,ninguno};
    private enum aptitudMagica{inte,sab,car};
    private enum competenciaEstat1{fue,des,con,inte,sab,car};
    private enum competenciaEstat2{fue,des,con,inte,sab,car};
    private int idLibro;
    private int idPersonaje;

    public Clases(int id_clase, String nombre, String descripcion, int puntosGolpe, String requisitoMulticlase, int competenciaArmasSencillas, int competenciaArmasMarciales, int competenciaArmadurasLigeras, int competenciaArmadurasMedias, int competenciaArmadurasPesadas, String otrasCompetencias, String textoCompetenciasHabilidades, int idLibro, int idPersonaje) {
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
        this.otrasCompetencias = otrasCompetencias;
        this.textoCompetenciasHabilidades = textoCompetenciasHabilidades;
        this.idLibro = idLibro;
        this.idPersonaje = idPersonaje;
    }

    public Clases(int id_clase, String nombre, String descripcion, int puntosGolpe, String requisitoMulticlase, int competenciaArmasSencillas, int competenciaArmasMarciales, int competenciaArmadurasLigeras, int competenciaArmadurasMedias, int competenciaArmadurasPesadas, String otrasCompetencias, String textoCompetenciasHabilidades, int idLibro) {
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
        this.otrasCompetencias = otrasCompetencias;
        this.textoCompetenciasHabilidades = textoCompetenciasHabilidades;
        this.idLibro = idLibro;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
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

    public int getCompetenciaArmasSencillas() {
        return competenciaArmasSencillas;
    }

    public void setCompetenciaArmasSencillas(int competenciaArmasSencillas) {
        this.competenciaArmasSencillas = competenciaArmasSencillas;
    }

    public int getCompetenciaArmasMarciales() {
        return competenciaArmasMarciales;
    }

    public void setCompetenciaArmasMarciales(int competenciaArmasMarciales) {
        this.competenciaArmasMarciales = competenciaArmasMarciales;
    }

    public int getCompetenciaArmadurasLigeras() {
        return competenciaArmadurasLigeras;
    }

    public void setCompetenciaArmadurasLigeras(int competenciaArmadurasLigeras) {
        this.competenciaArmadurasLigeras = competenciaArmadurasLigeras;
    }

    public int getCompetenciaArmadurasMedias() {
        return competenciaArmadurasMedias;
    }

    public void setCompetenciaArmadurasMedias(int competenciaArmadurasMedias) {
        this.competenciaArmadurasMedias = competenciaArmadurasMedias;
    }

    public int getCompetenciaArmadurasPesadas() {
        return competenciaArmadurasPesadas;
    }

    public void setCompetenciaArmadurasPesadas(int competenciaArmadurasPesadas) {
        this.competenciaArmadurasPesadas = competenciaArmadurasPesadas;
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

  
}
