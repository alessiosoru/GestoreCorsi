package it.polito.tdp.corsi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.GestoreCorsi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GestoreCorsiController {
	
	private GestoreCorsi model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextField txtPeriodo;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnStatCorsi;

    @FXML
    void doCalcolaStatCorsi(ActionEvent event) {

    }

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	// Controllo dell'input
    	int periodo;
    	try {
    		periodo= Integer.parseInt(txtPeriodo.getText());
    	}catch(NumberFormatException e) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}    	
    	if(periodo!=1 && periodo!=2){
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	
    	// Operazioni del programma    	
    	List<Corso> corsi = this.model.getCorsiByPeriodo(periodo);
    	for(Corso c : corsi) {
    		txtResult.appendText(c.toString()+"\n");
    	}
    	
    	// PATTERN ORM, sta per Object Relational Mapping
    	// (devo avere un contenitore di dati che modelli quello che c'� nel db)
    	// per quasi tutte le tabelle nel db ci deve essere la corrispondente classe in java
    	// che si chiama nello stesso modo, ha i campi che si chiamano nello stesso modo, definiti come
    	// private e tutti i getter e i setter
    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnStatCorsi != null : "fx:id=\"btnStatCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";

    }
    
    public void setModel(GestoreCorsi model) {
    	this.model = model;
    }
}
