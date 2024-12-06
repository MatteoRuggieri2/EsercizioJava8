package Pacchetto1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SchedaPersonaTest {
	
	static SchedaPersona persona;
	static SchedaPersona persona2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		persona = new SchedaPersona("Matteo Ruggieri", "Via di test, 15", "3279998887");
		persona2 = new SchedaPersona("Marco Bianchi", "Via di test, 32", "3245786568");
	}

	@Test
	void testEqualsTrue() {
		assertEquals(true, persona.equals(persona));
	}
	
	@Test
	void testEqualsFalse() {
		assertEquals(false, persona.equals(persona2));
	}
	
	@Test
	void testContainsTrue() {
		assertEquals(true, persona.contains("Matteo"));
	}
	
	@Test
	void testContainsFalse() {
		assertEquals(false, persona.contains("Cestino"));
	}

	@Test
	void testHashCode() {
		assertEquals(2058933850, persona.hashCode());
	}
	
	@Test
	void testToString() {
		assertEquals("SchedaPersona -> Nome: Matteo Ruggieri | Indirizzo: Via di test, 15 | Numero: 3279998887", persona.toString());
	}
}
