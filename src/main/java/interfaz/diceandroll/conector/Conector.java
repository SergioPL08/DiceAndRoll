/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.diceandroll.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Sergio
 */
public class Conector {
    // Para establecer la conexión con la base de datos tenemos que seguir la siguiente estructura: jdbc:mysql://[host][:puerto]/[DB]
    static final private String HOST = "servidor.choto.es";
    static final private String PORT = "3306";
    static final private String DBNAME = "alu_sergio_dungeon";
    static final private String USER = "unalumno";
    static final private String PASS = "soyunalumno2022";
    

// Para usarlo con MariaDB en una base de datos local llamada javanet  -> Connnection conex = new Conexion("localhost","3306","javanet","javanet","1234qwerty").makeconnect();
    
    public static Connection makeConnect(){
        try{
            String url="jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME;
            return DriverManager.getConnection(url, USER, PASS);
        }catch(SQLException ex){
            System.err.println("Error al establecer la conexion "+ex.getMessage());
            return null;
        }
        
    }
    public static void closeConnect(Connection con){
        try {
            // Cerramos posibles conexiones abiertas
            if (con!=null) con.close();    
          } catch (Exception e) {
            System.out.println("Error cerrando conexiones: " + e.toString());
          } 
    }
    public static ResultSet getSelect(String consulta, Connection conDB){
        try {
            Statement st = conDB.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(consulta);
            return rs;
        } catch (SQLException ex) {
            System.out.println("Error al leer datos");
        }
        return null;
    }
    
    public static int insertTable(String consulta, Connection conDB){
        try {
            Statement st = conDB.createStatement();
            int resultado = st.executeUpdate(consulta);
            return resultado;
        } catch (SQLException ex) {
            System.out.println("Error al insertar datos");
        }
        return 0;
    }

}