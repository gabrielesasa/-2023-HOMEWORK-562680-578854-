package it.uniroma3.test.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.giocatore.Borsa;

class testComandoPrendi {
	private Partita partita;
	private Stanza stanza1;
	private Stanza stanza2;
	private Stanza stanzaCorrente;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private IOConsole io;
	private ComandoPrendi cv;
	private Borsa borsa;
	private String p="partita";
	@BeforeEach
	void setUpPrendi() {
		this.partita=new Partita(p,io);
		this.stanza1=new Stanza("s1");
		this.stanza2=new Stanza("s2");
		this.attrezzo1= new Attrezzo("attrezzo1", 10);
		this.attrezzo2= new Attrezzo("attrezzo2", 5);
		this.cv = new ComandoPrendi();
		this.borsa = new Borsa();	
		stanza1.addAttrezzo(attrezzo1);
		stanza2.addAttrezzo(attrezzo2);
		partita.setStanzaCorrente(stanza1);
		this.stanzaCorrente=partita.getStanzaCorrente();
	}

	@Test
	public void testSetParametro() {
		cv.setParametro("attrezzo1");
		assertEquals("attrezzo1",cv.getParametro());
	}
	@Test
	public void testPrendiConParametroNull() {
		cv.esegui(partita);
		assertEquals(attrezzo1,stanza1.getAttrezzo("attrezzo1"));
	}
	@Test
	public void testPrendiunSoloAttrezzo() {
		cv.setParametro("attrezzo1");
		cv.esegui(partita);
		assertEquals(null,stanza1.getAttrezzo("attrezzo1"));
	}
	@Test
	public void testPrendiUltimoAttrezzo() {
		stanza1.addAttrezzo(attrezzo2);
		cv.setParametro("attrezzo2");
		cv.esegui(partita);
		assertEquals(attrezzo1,stanza1.getAttrezzo("attrezzo1"));
	}
	@Test
	public void testPrendiPrimoAttrezzo() {
		stanza1.addAttrezzo(attrezzo2);
		cv.setParametro("attrezzo1");
		cv.esegui(partita);
		assertEquals(attrezzo2,stanza1.getAttrezzo("attrezzo2"));
	}
	@Test
	public void testPrendi2Attrezzi() {
		stanza1.addAttrezzo(attrezzo2);
		cv.setParametro("attrezzo1");
		cv.esegui(partita);
		cv.setParametro("attrezzo2");
		cv.esegui(partita);
		assertEquals(null,stanza1.getAttrezzo("attrezzo2"));
	}
	@Test
	public void testInserisciAttrezzoBorsa() {
		cv.setParametro("attrezzo1");
		cv.esegui(partita);
		assertEquals(attrezzo1,partita.getGiocatore().getBorsa().getAttrezzo("attrezzo1"));
	}
	@Test
	public void testInserisci2AttrezziBorsa() {	
		stanzaCorrente.addAttrezzo(attrezzo1);
		stanzaCorrente.addAttrezzo(attrezzo2);
		cv.setParametro("attrezzo1");
		cv.esegui(partita);
		cv.setParametro("attrezzo2");
		cv.esegui(partita);
		assertEquals(attrezzo1,partita.getGiocatore().getBorsa().getAttrezzo("attrezzo1"));
		assertEquals(attrezzo2,partita.getGiocatore().getBorsa().getAttrezzo("attrezzo2"));
	}
	
}
