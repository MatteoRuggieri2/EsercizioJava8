package Pacchetto1;
import java.util.Objects;

public class SchedaPersona {
	
	private String nome = "";
	private String indirizzo = "";
	private String numero = "";
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	// Costruttore
	public SchedaPersona(String nuovoNome, String nuovoIndirizzo, String nuovoNumero) {
		setNome(nuovoNome);
		setIndirizzo(nuovoIndirizzo);
		setNumero(nuovoNumero);
	}

	
	
	/*
	 Questa funzione ritorna un valore booleano nei seguenti casi:
	 - "true" se l'oggetto passato è di tipo "SchedaPersona" e gli attributi della classe passata sono uguali alla classe corrente
	 - "false" se queste condizioni non si verificano
	 */
	@Override
	public boolean equals(Object obj) {
		
		// Se l'object passato è null ritorno FALSE
		if (obj == null) {
			return false;
		}
		
		// Se l'object passato NON è un istanza di SchedaPersona ritorno FALSE
		if (!(obj instanceof SchedaPersona)) {
			return false;
		}
		
		// Converto l'obj passato nel tipo "SchedaPersona"
		SchedaPersona sp = (SchedaPersona) obj;
		
		/* Se indirizzo, nome e numero dell'oggetto passato sono */
		if (this.indirizzo.equals(sp.indirizzo) && this.nome.equals(sp.nome) && this.numero.equals(numero)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/*
	Questa funzione ritorna un valore booleano nei seguenti casi:
	- "true" se la stringa passata come argomento è contenuta dentro un'attributo della classe corrente
	- "false" se la stringa non è inclusa dentro gli attributi
	  
	*/
	public boolean contains(String strInp) {
		strInp = strInp.toLowerCase();
		// Prendo la stringa passata come argomento è controllo se si trova dentro un'attributo
		if (this.nome.toLowerCase().contains(strInp) || this.indirizzo.toLowerCase().contains(strInp) || this.numero.toLowerCase().contains(strInp)) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}
	
	/* Questa funzione ha il compito di generare un numero intero
	 * univoco per identificare la classe istanziata (ovvero l'oggetto) */
	@Override
	public int hashCode() {
		return Objects.hash(indirizzo, nome, numero);
	}
	
	/* Questa funzione ha il compito di generare una rappresentazione
	 * stampabile della SchedaPersona, ovvero l'elenco di tutti i dati */
	@Override
	public String toString() {
		return "SchedaPersona -> " + "Nome: " + this.nome + " | Indirizzo: " + this.indirizzo + " | Numero: " + this.numero;
	}
}
