/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.conector.Conector;
import static interfaz.diceandroll.App.conector;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import interfaz.diceandroll.clases.Usuario;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class LoginController implements Initializable {
    //Mis variables
    private int id;
    
    //JavaFX variables
    private String user,passw;
    @FXML
    private Label msgLogin;
    @FXML
    private TextField TextFieldUser;
    @FXML
    private PasswordField TextFieldPass;
    private PasswordField TextFieldConfirm;
    static Usuario u;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    /**
     * El metodo login, comprueba que el usuario y contraseña se encuentran en la base de datos, en caso afirmativo, cambian a la ventana home,
     * en caso negativo muestran un mensaje de error. Si no se encuentra la ventana de home muestra un mensaje de error
     */
    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException{
        try {
            user=TextFieldUser.getText();
            passw=TextFieldPass.getText();
            String consulta = "SELECT * FROM usuario WHERE nombre='"+user+"' AND pass='"+passw+"'";
            ResultSet rs = Conector.getSelect(consulta, conector);
            if(rs.next()){
                id = rs.getInt("id_usuario");
                u = new Usuario(id, user, passw);
                //Abrir el menu principal con el tamaño indicado y cerramos la ventana login
                Stage stage = new Stage();
                Parent content = FXMLLoader.load(getClass().getResource("home.fxml"));
                Scene home = new Scene(content, 1280, 720);
                stage.setScene(home);
                stage.show();
                Node tal = (Node) event.getSource();
                Stage ventAct = (Stage) tal.getScene().getWindow();
                ventAct.close();
                
            }
            else{
                msgLogin.setText("Usuario o contraseña incorrectos");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public int getId(){
        return id;
    }


    @FXML
    private void showCrearCuenta(MouseEvent event) {
        try {
            App.setRoot("registrar");
        } catch (IOException ex) {
            System.out.println("No se ha encontrado la ventana registrar");
            ex.printStackTrace();
        }
    }

    public static Usuario getLogin(){
        return u;
    }
}
