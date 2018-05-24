package Controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Model.Korisnik;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController implements Initializable {
	
	@FXML private TextField tfIme;
	@FXML private TextField tfPrezime;
	@FXML private TextField tfKorisnickoIme;
	@FXML private TextField tfBrTel;
	@FXML private TextField tfAdresa;
	
	@FXML private Label lblDatum;
	@FXML private Label lblIme;
	@FXML private Label lblPrezime;
	@FXML private Label lblKorisnickoIme;
	@FXML private Label lblSifra;
	@FXML private Label lblAdresa;

	@FXML private PasswordField pfSifra;
	
	@FXML DatePicker datumRodjenja;
	
	public void cancel (ActionEvent event) {
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
	
	public void register () {
		if(validation()) {
			LocalDate date = datumRodjenja.getValue();
			Korisnik korisnik = new Korisnik(0, tfKorisnickoIme.getText(),
					tfIme.getText(), tfPrezime.getText(), 
					pfSifra.getText(), datumRodjenja.getValue().toString(), 
					tfAdresa.getText(), tfBrTel.getText(), 0);
            korisnik.save();
		}
        
	}
	
	public boolean validation () {
		
		if(tfIme.getText().length() > 1 
				&& datumRodjenja.getValue() != null
				&& tfPrezime.getText().length() > 2 
				&& tfKorisnickoIme.getText().length() > 2
				&& Korisnik.dostupno(tfKorisnickoIme.getText())
				&& pfSifra.getText().length() > 5 
				&& tfAdresa.getText().length() > 5) {
			
			return true;
		}
			if (datumRodjenja.getValue() == null) {
				lblDatum.setText("Datum rođenja ne smije biti prazan !");
			}
			else {
				lblDatum.setText("");
			}
			
			if(tfIme.getText().length() < 2) {
				lblIme.setText("Minimalno 3 znaka !");
			}
			else if (!isNum(tfIme.getText())) {
				lblIme.setText("Dopuštena su samo slova");
			}
			else {
				lblIme.setText("");
			}
			
			if (tfPrezime.getText().length() < 3) {
				lblPrezime.setText("Minimalno 3 znaka !");				
			}
			else if (!isNum(tfPrezime.getText())) {
				lblPrezime.setText("Dopuštena su samo slova");
			}
			else {
				lblPrezime.setText("");
			}
			
			if (tfKorisnickoIme.getText().length() < 3) {
				lblKorisnickoIme.setText("Minimalno 3 znaka !");				
			}
			else if (! Korisnik.dostupno(tfKorisnickoIme.getText())){
				lblKorisnickoIme.setText("Korisničko ime nije dostupno");
			}
			else {
				lblKorisnickoIme.setText("");
			}
			
			if (pfSifra.getText().length() < 6) {
				lblSifra.setText("Minimalno 6 znakova !");				
			}
			else {
				lblSifra.setText("");
			}
			
			if (tfAdresa.getText().length() < 6) {
				lblAdresa.setText("Minimalno 6 znakova !");				
			}
			else {
				lblAdresa.setText("");
			}
				
			return false;
		
	}
	
	public boolean isNum (String polje) {
		
		for (int i = 0; i < polje.length(); i++) {
			if (polje.charAt(i) < 'a' || polje.charAt(i) > 'z'
			&& (polje.charAt(i) < 'A' || polje.charAt(i) > 'Z')) return false;
		}
		
		return true;
	}
	
	@Override
    public void initialize(URL url, ResourceBundle rb) {
		
    }
}
