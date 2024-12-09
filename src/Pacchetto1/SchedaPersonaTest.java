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
		persona3 = new SchedaPersona("Jovanotti Cherubini", "Via di test, 62", "4859305739");
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
		RubricaTelefonica contactsList = new RubricaTelefonica(3);
		assertTrue(contactsList.insert(persona1));
		assertTrue(contactsList.insert(persona2));
		
		contactsList.search("Matteo");
		
	}
	
	
	
	
	
	
	
	
	
	
	

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
