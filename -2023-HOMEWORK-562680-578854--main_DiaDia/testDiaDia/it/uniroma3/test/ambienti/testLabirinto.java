package it.uniroma3.test.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class testLabirinto {
	private Labirinto vuoto;
	private Labirinto labirinto1;
	private Labirinto labirinto2;
	
	private Stanza stanza1;
	private Stanza stanza2;
	private Stanza stanza3;
	private IOConsole io;
	
	@BeforeEach
	public void setUp(){
		vuoto = new Labirinto("Bunker", "Test");
		labirinto1 = new Labirinto("Labirinto1", "Test");
		labirinto2 = new Labirinto("Labirinto2", "Test");
		
		stanza1 = new Stanza("Stanza1");
		stanza2 = new Stanza("Stanza2"); 
		stanza3 = new Stanza("Stanza3"); 
		
		labirinto1.setStanzaCorrente(stanza1);
		labirinto1.setStanzaVincente(stanza2);
		
		labirinto2.setStanzaCorrente(stanza3);
		labirinto2.setStanzaVincente(stanza3);
	}

	@Test
	public void testSetStanzaVincenteVuota() {
		assertNull(vuoto.getStanzaVincente());
	}
	
	@Test
	public void testSetStanzaVincenteDiversa() {
		assertEquals(stanza2, labirinto1.getStanzaVincente());
	}
	
	@Test
	public void testSetStanzaVincenteUguale() {
		assertEquals(stanza3, labirinto2.getStanzaVincente());
	}

	@Test
	public void testSetStanzaInizialeVuota() {
		assertNull(vuoto.getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaInizialeDiversa() {
		assertEquals(stanza1, labirinto1.getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaInizialeUguale() {
		assertEquals(stanza3, labirinto2.getStanzaCorrente());
	}
	
	/*@Before
	public void setUpEffettivo(){
		mappa = new Labirinto("Mappa");
		mappaFix = mappa.getLabirintoFixture();
		mappaFix.creaStanzeUni();
	}
	
	@Test
	public void testGetStanzaVincenteEff() {
		assertNotNull(mappa.getStanzaVincente());
	}
	
	@Test
	public void testGetStanzaInizialeEff() {
		assertNotNull(mappa.getStanzaIniziale());
	}*/


}
