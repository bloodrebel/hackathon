package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KorisnikController implements Initializable{
	
	public void odjava (ActionEvent event) {
		
		try {
            Parent regParent = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
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
