/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.clases;

/**
 *
 * @author Sergio
 */
public class Personajes {
    private int idPersonaje;
    private String nombre, velocidad;
    private int vidaMaxima, vidaActual, iniciativa, claseArmadura, competencia;
    private int fue,des,con,inte,sab,car;
    private int ts_fue,ts_des,ts_con,ts_int,ts_sab,ts_car;
    private int acrobacias, arcanos, atletismo, engañar, historia, interpretacion, juego_manos, medicina, naturaleza, percepcion, perspicacia, persuasion, religion, sigilo, supervivencia, trato_animales;
    private boolean bono_ts_fue,bono_ts_des,bono_ts_con,bono_ts_int,bono_ts_sab,bono_ts_car;
    private boolean bono_acrobacias, bono_arcanos, bono_atletismo, bono_engañar, bono_historia, bono_interpretacion, bono_juego_manos, bono_medicina, bono_naturaleza, bono_percepcion, bono_perspicacia, bono_persuasion, bono_religion, bono_sigilo, bono_supervivencia, bono_trato_animales;
    private int idUsuario;

    public Personajes(int idPersonaje, String nombre, String velocidad, int vidaMaxima, int vidaActual, int iniciativa, int claseArmadura, int competencia, int fue, int des, int con, int inte, int sab, int car, int ts_fue, int ts_des, int ts_con, int ts_int, int ts_sab, int ts_car, int acrobacias, int arcanos, int atletismo, int engañar, int historia, int interpretacion, int juego_manos, int medicina, int naturaleza, int percepcion, int perspicacia, int persuasion, int religion, int sigilo, int supervivencia, int trato_animales, boolean bono_ts_fue, boolean bono_ts_des, boolean bono_ts_con, boolean bono_ts_int, boolean bono_ts_sab, boolean bono_ts_car, boolean bono_acrobacias, boolean bono_arcanos, boolean bono_atletismo, boolean bono_engañar, boolean bono_historia, boolean bono_interpretacion, boolean bono_juego_manos, boolean bono_medicina, boolean bono_naturaleza, boolean bono_percepcion, boolean bono_perspicacia, boolean bono_persuasion, boolean bono_religion, boolean bono_sigilo, boolean bono_supervivencia, boolean bono_trato_animales, int idUsuario) {
        this.idPersonaje = idPersonaje;
        this.nombre = nombre;
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
        this.ts_fue = ts_fue;
        this.ts_des = ts_des;
        this.ts_con = ts_con;
        this.ts_int = ts_int;
        this.ts_sab = ts_sab;
        this.ts_car = ts_car;
        this.acrobacias = acrobacias;
        this.arcanos = arcanos;
        this.atletismo = atletismo;
        this.engañar = engañar;
        this.historia = historia;
        this.interpretacion = interpretacion;
        this.juego_manos = juego_manos;
        this.medicina = medicina;
        this.naturaleza = naturaleza;
        this.percepcion = percepcion;
        this.perspicacia = perspicacia;
        this.persuasion = persuasion;
        this.religion = religion;
        this.sigilo = sigilo;
        this.supervivencia = supervivencia;
        this.trato_animales = trato_animales;
        this.bono_ts_fue = bono_ts_fue;
        this.bono_ts_des = bono_ts_des;
        this.bono_ts_con = bono_ts_con;
        this.bono_ts_int = bono_ts_int;
        this.bono_ts_sab = bono_ts_sab;
        this.bono_ts_car = bono_ts_car;
        this.bono_acrobacias = bono_acrobacias;
        this.bono_arcanos = bono_arcanos;
        this.bono_atletismo = bono_atletismo;
        this.bono_engañar = bono_engañar;
        this.bono_historia = bono_historia;
        this.bono_interpretacion = bono_interpretacion;
        this.bono_juego_manos = bono_juego_manos;
        this.bono_medicina = bono_medicina;
        this.bono_naturaleza = bono_naturaleza;
        this.bono_percepcion = bono_percepcion;
        this.bono_perspicacia = bono_perspicacia;
        this.bono_persuasion = bono_persuasion;
        this.bono_religion = bono_religion;
        this.bono_sigilo = bono_sigilo;
        this.bono_supervivencia = bono_supervivencia;
        this.bono_trato_animales = bono_trato_animales;
        this.idUsuario = idUsuario;
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

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
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

    public int getTs_fue() {
        return ts_fue;
    }

    public void setTs_fue(int ts_fue) {
        this.ts_fue = ts_fue;
    }

    public int getTs_des() {
        return ts_des;
    }

    public void setTs_des(int ts_des) {
        this.ts_des = ts_des;
    }

    public int getTs_con() {
        return ts_con;
    }

    public void setTs_con(int ts_con) {
        this.ts_con = ts_con;
    }

    public int getTs_int() {
        return ts_int;
    }

    public void setTs_int(int ts_int) {
        this.ts_int = ts_int;
    }

    public int getTs_sab() {
        return ts_sab;
    }

    public void setTs_sab(int ts_sab) {
        this.ts_sab = ts_sab;
    }

    public int getTs_car() {
        return ts_car;
    }

    public void setTs_car(int ts_car) {
        this.ts_car = ts_car;
    }

    public int getAcrobacias() {
        return acrobacias;
    }

    public void setAcrobacias(int acrobacias) {
        this.acrobacias = acrobacias;
    }

    public int getArcanos() {
        return arcanos;
    }

    public void setArcanos(int arcanos) {
        this.arcanos = arcanos;
    }

    public int getAtletismo() {
        return atletismo;
    }

    public void setAtletismo(int atletismo) {
        this.atletismo = atletismo;
    }

    public int getEngañar() {
        return engañar;
    }

    public void setEngañar(int engañar) {
        this.engañar = engañar;
    }

    public int getHistoria() {
        return historia;
    }

    public void setHistoria(int historia) {
        this.historia = historia;
    }

    public int getInterpretacion() {
        return interpretacion;
    }

    public void setInterpretacion(int interpretacion) {
        this.interpretacion = interpretacion;
    }

    public int getJuego_manos() {
        return juego_manos;
    }

    public void setJuego_manos(int juego_manos) {
        this.juego_manos = juego_manos;
    }

    public int getMedicina() {
        return medicina;
    }

    public void setMedicina(int medicina) {
        this.medicina = medicina;
    }

    public int getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(int naturaleza) {
        this.naturaleza = naturaleza;
    }

    public int getPercepcion() {
        return percepcion;
    }

    public void setPercepcion(int percepcion) {
        this.percepcion = percepcion;
    }

    public int getPerspicacia() {
        return perspicacia;
    }

    public void setPerspicacia(int perspicacia) {
        this.perspicacia = perspicacia;
    }

    public int getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(int persuasion) {
        this.persuasion = persuasion;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getSigilo() {
        return sigilo;
    }

    public void setSigilo(int sigilo) {
        this.sigilo = sigilo;
    }

    public int getSupervivencia() {
        return supervivencia;
    }

    public void setSupervivencia(int supervivencia) {
        this.supervivencia = supervivencia;
    }

    public int getTrato_animales() {
        return trato_animales;
    }

    public void setTrato_animales(int trato_animales) {
        this.trato_animales = trato_animales;
    }

    public boolean isBono_ts_fue() {
        return bono_ts_fue;
    }

    public void setBono_ts_fue(boolean bono_ts_fue) {
        this.bono_ts_fue = bono_ts_fue;
    }

    public boolean isBono_ts_des() {
        return bono_ts_des;
    }

    public void setBono_ts_des(boolean bono_ts_des) {
        this.bono_ts_des = bono_ts_des;
    }

    public boolean isBono_ts_con() {
        return bono_ts_con;
    }

    public void setBono_ts_con(boolean bono_ts_con) {
        this.bono_ts_con = bono_ts_con;
    }

    public boolean isBono_ts_int() {
        return bono_ts_int;
    }

    public void setBono_ts_int(boolean bono_ts_int) {
        this.bono_ts_int = bono_ts_int;
    }

    public boolean isBono_ts_sab() {
        return bono_ts_sab;
    }

    public void setBono_ts_sab(boolean bono_ts_sab) {
        this.bono_ts_sab = bono_ts_sab;
    }

    public boolean isBono_ts_car() {
        return bono_ts_car;
    }

    public void setBono_ts_car(boolean bono_ts_car) {
        this.bono_ts_car = bono_ts_car;
    }

    public boolean isBono_acrobacias() {
        return bono_acrobacias;
    }

    public void setBono_acrobacias(boolean bono_acrobacias) {
        this.bono_acrobacias = bono_acrobacias;
    }

    public boolean isBono_arcanos() {
        return bono_arcanos;
    }

    public void setBono_arcanos(boolean bono_arcanos) {
        this.bono_arcanos = bono_arcanos;
    }

    public boolean isBono_atletismo() {
        return bono_atletismo;
    }

    public void setBono_atletismo(boolean bono_atletismo) {
        this.bono_atletismo = bono_atletismo;
    }

    public boolean isBono_engañar() {
        return bono_engañar;
    }

    public void setBono_engañar(boolean bono_engañar) {
        this.bono_engañar = bono_engañar;
    }

    public boolean isBono_historia() {
        return bono_historia;
    }

    public void setBono_historia(boolean bono_historia) {
        this.bono_historia = bono_historia;
    }

    public boolean isBono_interpretacion() {
        return bono_interpretacion;
    }

    public void setBono_interpretacion(boolean bono_interpretacion) {
        this.bono_interpretacion = bono_interpretacion;
    }

    public boolean isBono_juego_manos() {
        return bono_juego_manos;
    }

    public void setBono_juego_manos(boolean bono_juego_manos) {
        this.bono_juego_manos = bono_juego_manos;
    }

    public boolean isBono_medicina() {
        return bono_medicina;
    }

    public void setBono_medicina(boolean bono_medicina) {
        this.bono_medicina = bono_medicina;
    }

    public boolean isBono_naturaleza() {
        return bono_naturaleza;
    }

    public void setBono_naturaleza(boolean bono_naturaleza) {
        this.bono_naturaleza = bono_naturaleza;
    }

    public boolean isBono_percepcion() {
        return bono_percepcion;
    }

    public void setBono_percepcion(boolean bono_percepcion) {
        this.bono_percepcion = bono_percepcion;
    }

    public boolean isBono_perspicacia() {
        return bono_perspicacia;
    }

    public void setBono_perspicacia(boolean bono_perspicacia) {
        this.bono_perspicacia = bono_perspicacia;
    }

    public boolean isBono_persuasion() {
        return bono_persuasion;
    }

    public void setBono_persuasion(boolean bono_persuasion) {
        this.bono_persuasion = bono_persuasion;
    }

    public boolean isBono_religion() {
        return bono_religion;
    }

    public void setBono_religion(boolean bono_religion) {
        this.bono_religion = bono_religion;
    }

    public boolean isBono_sigilo() {
        return bono_sigilo;
    }

    public void setBono_sigilo(boolean bono_sigilo) {
        this.bono_sigilo = bono_sigilo;
    }

    public boolean isBono_supervivencia() {
        return bono_supervivencia;
    }

    public void setBono_supervivencia(boolean bono_supervivencia) {
        this.bono_supervivencia = bono_supervivencia;
    }

    public boolean isBono_trato_animales() {
        return bono_trato_animales;
    }

    public void setBono_trato_animales(boolean bono_trato_animales) {
        this.bono_trato_animales = bono_trato_animales;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
}
