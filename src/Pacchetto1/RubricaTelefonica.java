package Pacchetto1;

public class RubricaTelefonica implements Rubrica {
	SchedaPersona schedaPersonaVuota = new SchedaPersona("vuoto", "vuoto", "vuoto");
	
	// Inizializzo la rubrica vuota.
//	SchedaPersona[] rubrica = {schedaPersonaVuota, schedaPersonaVuota, schedaPersonaVuota};
	SchedaPersona[] rubrica;

	// TODO Fai il costruttore a cui passi il numero massimo (maxCapacity) di contatti dentro la rubrica
	public RubricaTelefonica(int maxCapacity) {
		rubrica = new SchedaPersona[maxCapacity];
		for (int i = 0; i < maxCapacity; i++) {
			rubrica[i] = schedaPersonaVuota;
		}
	}
	
	
	@Override
	public boolean insert(SchedaPersona contactToRegister) {
		
		for (int i = 0; i < rubrica.length; i++) {
			SchedaPersona currentContact = rubrica[i];
			
			if (currentContact.equals(schedaPersonaVuota)) {
				// Sovrascrivo contatto
				rubrica[i] = contactToRegister;
				System.out.println("Contatto '" + contactToRegister.getNome() + "' aggiunto");
				return true;
			}
			
			// Se la SchedaPersona è già presente ritorno FALSE
			if (currentContact.equals(contactToRegister)) {
				System.out.println("Contatto \"" + contactToRegister.getNome() + "\" già esistente!");
				break;
			}
			
			/* Se l'ultimo elemento è diverso da vuoto e mi trovo alla fine
			 * della rubrica vuol dire che è piena */
			if (!currentContact.equals(schedaPersonaVuota) && i == rubrica.length - 1) {
				System.out.println("Rubrica piena :(, non posso aggiungere " + contactToRegister.getNome());
				break;
			}
		}
		
		return false;
	}

	@Override
	public SchedaPersona[] search(String stringToResearch) {
		
		SchedaPersona[] foundedContacts = null;
		int foundedContactsQta = 0;
		/* Siccome in questo esercizio dobbiamo utilizzare solo gli array,
		 * sono obbligaato a fare 2 cicli, uno per capire quanti risultati
		 * genera la ricerca, e uno per salvarli nell'array finale. */
		for (SchedaPersona contact : this.rubrica) {
			if (contact.getNome() != "vuoto" && contact.contains(stringToResearch)) {
				foundedContactsQta++;
			}
		}
		
		// Ora che so quanti risultati avrò, posso dimensionare l'array
		foundedContacts = new SchedaPersona[foundedContactsQta];
		
		// Popolo l'array
		for (int i = 0; i < this.rubrica.length; i++) {
			SchedaPersona contact = this.rubrica[i];
			if (contact.getNome() != "vuoto" && contact.contains(stringToResearch)) {
				foundedContacts[i] = contact;
			}
			
		}
		
		System.out.println("Risultati trovati: " + foundedContactsQta);
		for (SchedaPersona schedaPersona : foundedContacts) {
			System.out.println(schedaPersona.toString());
		}
		return foundedContacts;
		
		
		
		
		
//		SchedaPersona[] foundedContacts = {schedaPersonaVuota, schedaPersonaVuota, schedaPersonaVuota};
//		
//		// Numero di persone trovate
//		int foundedContactsNumber = 0;
//		
//		/* Per ogni persona dentro rubrica, se ha un dato che contiene
//		 * la stringa passata, lo inserisco dentro l'array "foundedContacts" */
//		int i = 0;
//		for (SchedaPersona element : foundedContacts) {
//			i++;
//			if (element.getNome().toLowerCase().contains(stringToResearch) || element.getIndirizzo().toLowerCase().contains(stringToResearch) || element.getNumero().toLowerCase().contains(stringToResearch)) {
//				foundedContacts[i - 1] = element;
//			}
//		}
//		
//		/* Mi creo un array dinamico in base a quante persone ho trovato */
//		SchedaPersona[] finalFoundedContacts = new SchedaPersona[foundedContactsNumber];
//		int i2 = 0;
//		for (SchedaPersona personaTrovata : foundedContacts) {
//			i2++;
//			finalFoundedContacts[i2 - 1] = personaTrovata;
//		}
//		
//		// Ritorno i contatti trovati
//		return finalFoundedContacts;
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
