package Pacchetto1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SchedaPersonaTest {
	
	static SchedaPersona schedaPersonaVuota;
	static SchedaPersona persona1;
	static SchedaPersona persona2;
	static SchedaPersona persona3;
	static SchedaPersona persona4;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		schedaPersonaVuota = new SchedaPersona("vuoto", "vuoto", "vuoto");
		persona1 = new SchedaPersona("Matteo Ruggieri", "Via di test, 15", "3279998887");
		persona2 = new SchedaPersona("Gianni Morandi", "Via di test, 58", "4439808972");
		persona3 = new SchedaPersona("Jovanotti Cherubini", "Via di test, 62", "4439808972");
		persona4 = new SchedaPersona("Marco Bianchi", "Via di test, 32", "3245786568");
		
	}
	
	@Test
	void constructorTest() {
		RubricaTelefonica contactsList = new RubricaTelefonica(5);
		SchedaPersona[] resultArray = {schedaPersonaVuota, schedaPersonaVuota, schedaPersonaVuota, schedaPersonaVuota, schedaPersonaVuota};
		assertArrayEquals(resultArray, contactsList.rubrica);
	}
 	
	@Test
	void insertTest() {
		RubricaTelefonica contactsList = new RubricaTelefonica(3);
		
		// Prova inserimento corretto del contatto
		assertTrue(contactsList.insert(persona1));
		SchedaPersona[] resultArray = {persona1, schedaPersonaVuota, schedaPersonaVuota};
		assertArrayEquals(resultArray, contactsList.rubrica);
		
		// Prova inserimento contatto duplicato
		assertFalse(contactsList.insert(persona1));
		SchedaPersona[] resultArray2 = {persona1, schedaPersonaVuota, schedaPersonaVuota};
		assertArrayEquals(resultArray2, contactsList.rubrica);
		
		// Prova rubrica piena
		assertTrue(contactsList.insert(persona2));
		assertTrue(contactsList.insert(persona3));
		assertFalse(contactsList.insert(persona4));
		SchedaPersona[] resultArray3 = {persona1, persona2, persona3};
		assertArrayEquals(resultArray3, contactsList.rubrica);
	}
	
	@Test
	void searchTest() {
		
		// Inizializzazione della rubrica con un contatto vuoto (serve x test)
		RubricaTelefonica contactsList = new RubricaTelefonica(4);
		assertTrue(contactsList.insert(persona1));
		assertTrue(contactsList.insert(persona2));
		assertTrue(contactsList.insert(persona3));
		
		// Test ricerca prima persona
		SchedaPersona[] expectedArray = {persona1};
		assertArrayEquals(expectedArray, contactsList.search("Matteo"));
		
		// Test ricerca prima persona
		SchedaPersona[] expectedArray2 = {persona2};
		assertArrayEquals(expectedArray2, contactsList.search("morandi"));
		
		// Test ricerca multipla
		SchedaPersona[] expectedArray3 = {persona2, persona3};
		assertArrayEquals(expectedArray3, contactsList.search("4439808972"));
		
		// Test ricerca ignorata (da contatto vuoto)
		SchedaPersona[] expectedArray4 = {};
		assertArrayEquals(expectedArray4, contactsList.search("vuo"));
		
		// Test validazione stringa
		assertThrows(IllegalArgumentException.class, () -> contactsList.search(""));
		assertThrows(IllegalArgumentException.class, () -> contactsList.search(" "));
	}
	
	@Test
	void toStringTest() {
		// Test con la rubrica non completa
		RubricaTelefonica contactsList = new RubricaTelefonica(50);
		assertTrue(contactsList.insert(persona1));
		assertTrue(contactsList.insert(persona2));
		
		String expectedString = "ELENCO RUBRICA - N° contatti: 2, Matteo Ruggieri, Gianni Morandi";
		assertEquals(expectedString, contactsList.toString());
		
		// Test con rubrica vuota
		RubricaTelefonica contactsList2 = new RubricaTelefonica(50);
		
		String expectedString2 = "ELENCO RUBRICA - N° contatti: 0";
		assertEquals(expectedString2, contactsList2.toString());
	}
	
	@Test
	void compactArrayTest() {
		SchedaPersona[] inputArray1 = {persona1, schedaPersonaVuota, persona3, persona4};
		SchedaPersona[] inputArray2 = {persona1, schedaPersonaVuota, schedaPersonaVuota, persona4};
		SchedaPersona[] inputArray3 = {schedaPersonaVuota, schedaPersonaVuota, schedaPersonaVuota, persona4};
		SchedaPersona[] inputArray4 = {schedaPersonaVuota, persona1, persona3, persona4};
		
		RubricaTelefonica contactsList = new RubricaTelefonica(4);
		
		SchedaPersona[] expectedArray1 = {persona1, persona3, persona4, schedaPersonaVuota};
		assertArrayEquals(expectedArray1, contactsList.compactArray(inputArray1));
		
		SchedaPersona[] expectedArray2 = {persona1, persona4, schedaPersonaVuota, schedaPersonaVuota};
		assertArrayEquals(expectedArray2, contactsList.compactArray(inputArray2));
		
		SchedaPersona[] expectedArray3 = {persona4, schedaPersonaVuota, schedaPersonaVuota, schedaPersonaVuota};
		assertArrayEquals(expectedArray3, contactsList.compactArray(inputArray3));
		
		SchedaPersona[] expectedArray4 = {persona1, persona3, persona4, schedaPersonaVuota};
		assertArrayEquals(expectedArray4, contactsList.compactArray(inputArray4));
	}
	
	@Test
	void deleteTest() {
		RubricaTelefonica contactsList = new RubricaTelefonica(5);
		contactsList.delete(persona1);
	}
	
	
	
	
	
//TODO -> Test SchedaPersona Class
	
	
	
	
//	@Test
//	void testEqualsTrue() {
//		assertEquals(true, persona.equals(persona));
//	}
//	
//	@Test
//	void testEqualsFalse() {
//		assertEquals(false, persona.equals(persona2));
//	}
//	
//	@Test
//	void testContainsTrue() {
//		assertEquals(true, persona.contains("Matteo"));
//	}
//	
//	@Test
//	void testContainsFalse() {
//		assertEquals(false, persona.contains("Cestino"));
//	}
//
//	@Test
//	void testHashCode() {
//		assertEquals(2058933850, persona.hashCode());
//	}
//	
//	@Test
//	void testToString() {
//		assertEquals("SchedaPersona -> Nome: Matteo Ruggieri | Indirizzo: Via di test, 15 | Numero: 3279998887", persona.toString());
//	}
}
