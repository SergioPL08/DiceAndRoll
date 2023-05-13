/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.diceandroll;

import interfaz.diceandroll.conector.Conector;
import static interfaz.diceandroll.App.conector;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class RegistrarController implements Initializable {

    @FXML
    private TextField TextFieldUser;
    @FXML
    private PasswordField TextFieldPass;
    @FXML
    private PasswordField TextFieldConfirm;
    @FXML
    private Label msg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void registrar(ActionEvent event) {
        String user = TextFieldUser.getText();
        String pass = TextFieldPass.getText();
        String confirm = TextFieldConfirm.getText();
        if(pass.equals(""))
            msg.setText("La contraseña no debe estar vacía!");
        else if(!pass.equals(confirm))
            msg.setText("Las contraseñas no coinciden");
        else{
            String consulta = "Insert into usuario (nombre, pass) values ('"+user+"','"+pass+"')";
            System.out.println(consulta);
            int rs = Conector.insertTable(consulta, conector);
            if(rs!=0)
                msg.setText("Usuario creado correctamente");
            else
                msg.setText("El nombre de usuario ya existe");
        }
            
            
    }

    @FXML
    private void volver(ActionEvent event) {
        try {
            App.setRoot("login");
        } catch (IOException ex) {
            msg.setText("No se ha encontrado la ventana login");
            ex.printStackTrace();
        }
    }
    
}
