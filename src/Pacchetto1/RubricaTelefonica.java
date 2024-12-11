package Pacchetto1;

public class RubricaTelefonica implements Rubrica {
	SchedaPersona schedaPersonaVuota = new SchedaPersona("vuoto", "vuoto", "vuoto");
	
	// Dichiaro la rubrica vuota.
	private SchedaPersona[] rubrica;

	public RubricaTelefonica(int maxCapacity) {
		rubrica = new SchedaPersona[maxCapacity];
		for (int i = 0; i < maxCapacity; i++) {
			rubrica[i] = schedaPersonaVuota;
		}
	}
	
	public SchedaPersona[] getRubrica() {
		return rubrica;
	}
	
	public void setRubrica(SchedaPersona[] rubrica) {
		this.rubrica = rubrica;
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
		for (SchedaPersona contact : rubrica) {
			if (contact.getNome() != "vuoto" && contact.contains(stringToResearch)) {
				foundedContactsQta++;
			}
		}
		
		// Ora che so quanti risultati avrò, posso dimensionare l'array
		foundedContacts = new SchedaPersona[foundedContactsQta];
		
		// Popolo l'array
		int savedContactsCounter = 0;
		for (SchedaPersona contact : rubrica) {
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
		
		return rubricaToString;
	}

	// Questo metodo ha il compito di eliminare un contatto.
	// Alla fine compatta la rubrica.
	@Override
	public boolean delete(SchedaPersona elementToDelete) {
		
		// Elimino il contatto
		for (int i = 0; i < rubrica.length; i++) {
			SchedaPersona schedaPersona = rubrica[i];
			if (schedaPersona.equals(elementToDelete)) {
				rubrica[i] = schedaPersonaVuota;
			}
			
		}
		
		// Compatto la rubrica
		this.compactRubrica();
		
		System.out.println("Rubrica aggiornata");
		System.out.println(this.toString());
		
		return true;
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
	
	/* Questo metodo ha il compito di compattare un array.
	 * Ad esempio, se eliminassimo il primo contatto e quindi lo rimpiazzassimo
	 * con uno vuoto, quello vuoto non deve andare al primo posto, ma all'ultimo,
	 * e gli altri contatti devono scalare in avanti. */
	public SchedaPersona[] compactArray(SchedaPersona[] inputArray) {
		
		int emptyContactPosition = -1; // 1
		for (int i = 0; i < inputArray.length; i++) { // 1
			SchedaPersona element = inputArray[i];
			if (element.equals(schedaPersonaVuota)) {
				emptyContactPosition = i;
				
				// Se è l'ultimo elemento è vuoto, non entra nel ciclo perchè dopo non c'è nessun contatto con cui sostituire
				for (int j = emptyContactPosition + 1; j < inputArray.length; j++) { // 3
					SchedaPersona element2 = inputArray[j];
					if (!element2.equals(schedaPersonaVuota)) {
						inputArray[emptyContactPosition] = element2;  // metto nella posizione vuota il prox contatto
						inputArray[j] = schedaPersonaVuota;  // Al posto del contatto che ho spostato metto un contatto vuoto
						break;
					}
				}
			}
			
		}
		
		return inputArray;
	}
	
	private void compactRubrica() {
		rubrica = this.compactArray(rubrica);
	}
}
