package Pacchetto1;

public class RubricaTelefonica implements Rubrica {
	SchedaPersona schedaPersonaVuota = new SchedaPersona("vuoto", "vuoto", "vuoto");
	
	// Inizializzo la rubrica vuota.
	SchedaPersona[] rubrica;

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
		int savedContactsCounter = 0;
		for (SchedaPersona contact : this.rubrica) {
			if (contact.getNome() != "vuoto" && contact.contains(stringToResearch)) {
				foundedContacts[savedContactsCounter] = contact;
				savedContactsCounter++;
			}
		}
		
		System.out.println("----------------------------");
		System.out.println("Ricerca: \"" + stringToResearch + "\"");
		System.out.println("Risultati trovati: " + foundedContactsQta);
		for (SchedaPersona schedaPersona : foundedContacts) {
			System.out.println(schedaPersona.toString());
		}
		System.out.println("----------------------------");
		
		return foundedContacts;
		
	}
	
	@Override
	public String toString() {
		String rubricaToString = "ELENCO RUBRICA - N° contatti: " + this.contactsListCount();
		for (SchedaPersona schedaPersona : rubrica) {
			if (schedaPersona.getNome() != "vuoto") {
				rubricaToString = rubricaToString + ", " + schedaPersona.getNome();
			}
		}
		
		System.out.println(rubricaToString);
		return rubricaToString;
	}

	@Override
	public boolean delete(SchedaPersona s) {
		// TODO Auto-generated method stub
		/* Fai anche la compattazione dell'array, ovvero i valori null devi metterli
		 * sempre alla fine */
		return false;
	}
	
	private int contactsListCount() {
		int count = 0;
		for (SchedaPersona schedaPersona : rubrica) {
			if (schedaPersona.getNome() != "vuoto") {
				count++;
			}
		}
		return count;
	}
}
