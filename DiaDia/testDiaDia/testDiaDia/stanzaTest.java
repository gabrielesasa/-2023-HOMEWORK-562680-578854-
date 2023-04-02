package testDiaDia;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class stanzaTest {	

	Stanza s1 = new Stanza("s1");
	Stanza s2= new Stanza("s2");
	Attrezzo m = new Attrezzo("bastone", 20);
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente("nord"));
	}
	

	@Test
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente("nord", s2);
		assertEquals(s2, s1.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testAddAttrezzo() {
		
		assertTrue(s1.addAttrezzo(m));
	}
	

}

