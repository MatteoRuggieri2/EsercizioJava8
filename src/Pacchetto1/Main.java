package Pacchetto1;

public class Main {

	public static void main(String[] args) {
 		SchedaPersona matteo = new SchedaPersona("Matteo Ruggieri", "Via di test, 15", "3279998887");
 		SchedaPersona max = new SchedaPersona("Max Rossi", "Via di test, 15", "3279998887");
 		SchedaPersona giovanni = new SchedaPersona("Giovanni Bianchi", "Via di test, 15", "3279998887");

		
		RubricaTelefonica miaRubrica = new RubricaTelefonica(3);
		miaRubrica.insert(matteo);
		miaRubrica.insert(max);
		miaRubrica.insert(giovanni);
		
		// Provo ad aggiungerne uno in più
		miaRubrica.insert(giovanni);
		
		// Stampo elenco telefonico
		for (SchedaPersona persona : miaRubrica.rubrica) {
			System.out.println(persona.getNome());
		}
		
		System.out.println(miaRubrica.search("matteo"));
		
	}

}
