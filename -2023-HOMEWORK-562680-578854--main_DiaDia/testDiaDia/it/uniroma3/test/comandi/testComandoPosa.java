package it.uniroma3.test.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;

class testComandoPosa {

	private Partita partita;
	
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private IOConsole io;
	private ComandoPosa cp;
	private Borsa borsa;
	private Stanza stanzaCorrente;
	@BeforeEach
	void setUpPrendi() {
		this.partita=new Partita(io);	
		this.attrezzo1= new Attrezzo("attrezzo1", 1);
		this.attrezzo2= new Attrezzo("attrezzo2", 5);
		this.cp = new ComandoPosa();
		this.borsa = new Borsa();	
		borsa=partita.getGiocatore().getBorsa();
		stanzaCorrente=partita.getStanzaCorrente();
	}

	@Test
	public void testSetParametro() {
		cp.setParametro("attrezzo1");
		assertEquals("attrezzo1",cp.getParametro());
	}
	@Test
	public void testPrendiConParametroNull() {
		cp.esegui(partita);
		assertEquals(null,partita.getGiocatore().getBorsa().getAttrezzo("attrezzo1"));
	}
	@Test
	public void testPosaunSoloAttrezzo() {
		borsa.addAttrezzo(attrezzo1);
		cp.setParametro("attrezzo1");
		cp.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("attrezzo1"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo1"));
	}
	@Test
	public void testInserisci2AttrezziInBorsa() {
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo1"));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo1"));
	}
	@Test
	public void testPosaAttrezzoNonPresente() {
		String nonPresente="nonPresente";
		stanzaCorrente.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo1);
		cp.setParametro(nonPresente);
		cp.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(nonPresente));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo1"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("attrezzo1"));
	}
	@Test
	public void testPrendiUltimoAttrezzo() {
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		cp.setParametro("attrezzo2");
		cp.esegui(partita);
		assertEquals(attrezzo1,borsa.getAttrezzo("attrezzo1"));
	}
	@Test
	public void testPrendiPrimoAttrezzo() {
		borsa.addAttrezzo(attrezzo2);
		cp.setParametro("attrezzo1");
		cp.esegui(partita);
		assertEquals(attrezzo2,borsa.getAttrezzo("attrezzo2"));
	}
	@Test
	public void testPrendi2Attrezzi() {
		borsa.addAttrezzo(attrezzo2);
		cp.setParametro("attrezzo1");
		cp.esegui(partita);
		cp.setParametro("attrezzo2");
		cp.esegui(partita);
		assertEquals(null,borsa.getAttrezzo("attrezzo2"));
	}
	@Test
	public void testInserisciAttrezzoBorsa() {
		borsa.addAttrezzo(attrezzo1);
		cp.setParametro("attrezzo1");
		cp.esegui(partita);
		assertEquals(attrezzo1,stanzaCorrente.getAttrezzo("attrezzo1"));
	}
	//AGGIUNGERE TEST sTANZA PIENA
	@Test
	public void testInserisci2AttrezziBorsa() {	
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		cp.setParametro("attrezzo1");
		cp.esegui(partita);
		cp.setParametro("attrezzo2");
		cp.esegui(partita);
		assertEquals(attrezzo1,stanzaCorrente.getAttrezzo("attrezzo1"));
		assertEquals(attrezzo2,stanzaCorrente.getAttrezzo("attrezzo2"));
	}
}
