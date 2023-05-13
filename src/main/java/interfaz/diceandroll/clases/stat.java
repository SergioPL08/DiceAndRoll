package interfaz.diceandroll.clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sergio
 */
public enum stat { 
    Fuerza("fue"),Destreza("des"),Constitucion("con"),Inteligencia("int"),Sabiduría("sab"),Carisma("car");  
    private final String caracteristica;
    
    stat(String caracteristica){
        this.caracteristica = caracteristica;
    }
    

}
