package Pacchetto1;

public class RubricaTelefonica implements Rubrica {
	SchedaPersona schedaPersonaVuota = new SchedaPersona("vuoto", "vuoto", "vuoto");
	
	// Inizializzo la rubrica vuota.
	SchedaPersona[] rubrica = {schedaPersonaVuota, schedaPersonaVuota, schedaPersonaVuota};

	// TODO Fai il costruttore a cui passi il numero massimo (maxCapacity) di contatti dentro la rubrica
	
	@Override
	public boolean insert(SchedaPersona s) {
		
		int i = 0;
		
		/* Faccio un ciclo per trovare un contatto vuoto */
		for (SchedaPersona element : rubrica) {
			i++;
			
			// Per il controllo PUOI USARE EQUALS invece che fare sta roba
			if (element.getNome() == "vuoto") {
				// Sovrascrivo contatto
				rubrica[i - 1] = s;
				System.out.println("Contatto '" + s.getNome() + "' aggiunto");
				return true;
			}
			
			/* Se l'ultimo elemento è diverso da vuoto e mi trovo alla fine
			 * della rubrica vuol dire che è piena */
			if (element.getNome() != "vuoto" && i == rubrica.length) {
				System.out.println("Rubrica piena :(, non posso aggiungere " + s.getNome());
				return false;
				// break  // Posso usare questo per uscire dal ciclo e usare il false sotto
			}
			
		}
		
		return false;
	}

	@Override
	public SchedaPersona[] search(String s) {
		s = s.toLowerCase();
		SchedaPersona[] foundedContacts = {schedaPersonaVuota, schedaPersonaVuota, schedaPersonaVuota};
		
		// Numero di persone trovate
		int foundedContactsNumber = 0;
		
		/* Per ogni persona dentro rubrica, se ha un dato che contiene
		 * la stringa passata, lo inserisco dentro l'array "foundedContacts" */
		int i = 0;
		for (SchedaPersona element : foundedContacts) {
			i++;
			if (element.getNome().toLowerCase().contains(s) || element.getIndirizzo().toLowerCase().contains(s) || element.getNumero().toLowerCase().contains(s)) {
				foundedContacts[i - 1] = element;
			}
		}
		
		/* Mi creo un array dinamico in base a quante persone ho trovato */
		SchedaPersona[] finalFoundedContacts = new SchedaPersona[foundedContactsNumber];
		int i2 = 0;
		for (SchedaPersona personaTrovata : foundedContacts) {
			i2++;
			finalFoundedContacts[i2 - 1] = personaTrovata;
		}
		
		// Ritorno i contatti trovati
		return finalFoundedContacts;
	}
	
	@Override
	public String toString() {
		return "string";
	}

	@Override
	public boolean delete(SchedaPersona s) {
		// TODO Auto-generated method stub
		/* Fai anche la compattazione dell'array, ovvero i valori null devi metterli
		 * sempre alla fine */
		return false;
	}
}
