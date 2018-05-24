package Controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;import javafx.stage.Stage;

public class LoginController implements Initializable {
	
	@FXML private Label lblError;
	@FXML private TextField tfKorisnickoIme;
	@FXML private PasswordField pfSifra;
	
	String prijava;
	
	public void prijava (ActionEvent event) {
		if(true) {
			prijava = "/View/Korisnik.fxml";
		}
		else {
			prijava = "/View/Registracija.fxml";
		}
		
		try {
            Parent regParent = FXMLLoader.load(getClass().getResource(prijava));
            Scene regScene = new Scene(regParent);
            
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(regScene);
            window.show();
            
        } catch (IOException ex) {
        	System.out.println();
        }
	}
	
	public void register (ActionEvent event) {
		try {
            Parent regParent = FXMLLoader.load(getClass().getResource("/View/Registracija.fxml"));
            Scene regScene = new Scene(regParent);
            
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(regScene);
            window.show();
            
        } catch (IOException ex) {
        	System.out.println();
        }
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
}
