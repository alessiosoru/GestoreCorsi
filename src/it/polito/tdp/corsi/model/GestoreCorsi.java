package it.polito.tdp.corsi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.model.Corso;

public class GestoreCorsi {

	public List<Corso> getCorsiByPeriodo(int periodo) {
		// pattern con classi dette DAO
		// non faccio le operazioni dul DB direttamente qui, avrò un altro livello di classi
		// che mi permette di accedere al db
		// anche in questo caso, per ogni tabella ho il DAO specifico
		
		CorsoDAO dao = new CorsoDAO();
		
		// dubbio tra importare tutto e poi selezionare, oppure importare direttamente meno roba con la query,
		// questo riduce gli errori, d'altra parte l'elaborazione in Java è più veloce
		// la scelta dipende dalle situazioni
		
		
		// CASO 1) PRENDENDO TUTTO E FILTRANDO POI IN JAVA
//		List<Corso> corsi = dao.listAll();
//		List<Corso> result = new ArrayList<Corso>();
//		for(Corso c: corsi) {
//			if(c.getPd() == periodo) {
//				result.add(c);
//			}
//		}
//		
//		return result;
		
		// CASO 2) FACCIO FARE TUTTO AL DB
		return dao.listCorsiByPd(periodo);
		

	}
	
	

}
