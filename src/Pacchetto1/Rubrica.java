package Pacchetto1;

public interface Rubrica {
	
	/* Questo metodo ha lo scopo di inserire una scheda persona
	 * all'interno della rubrica.
	 * Return TRUE se il processo va a buon fine
	 * Return FALSE se non viene inserita la scheda persona */
	public boolean insert(SchedaPersona s);
	
	/* Questo metodo ha lo scopo di effettuare una ricerca
	 * all'interno della rubrica e restituire tutte le schede
	 * che contengono la stringa ricevuta come parametro. */
	public SchedaPersona[] search(String s);
	
	/* Questo metodo ha lo scopo di restituire una stringa
	 * per una rappresentazione stampabile della rubrica */
	public String toString();
	
	/* Questo metodo ha lo scopo di eliminare dalla rubrica
	 * la scheda persona passata.
	 * Return TRUE se la cancellazione avviene correttamente
	 * Return FALSE se l'elemento da cancellare non esiste nella rubrica */
	public boolean delete(SchedaPersona s);
}
