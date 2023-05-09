package it.uniroma3.test.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

class testComandoVai {
	private Partita partita;
	private IOConsole io;
	private String direzione;
	private Comando c1;
	private Stanza s1;
	private Stanza s2;
	private Stanza stanzaCorrente;
	private Stanza prossimaStanza;
	@BeforeEach
	public void setUp() {
		this.io=new IOConsole();
		this.partita = new Partita(io);
		this.c1=new ComandoVai();
		this.s1 = new Stanza("s1");
		this.s2 = new Stanza("s2");
		partita.setStanzaCorrente(s1);
		this.stanzaCorrente=partita.getStanzaCorrente();
		s1.impostaStanzaAdiacente("sud", s2);
		s2.impostaStanzaAdiacente("nord", s1);
		this.prossimaStanza = stanzaCorrente.getStanzaAdiacente("sud");
		
	}
	@Test
	public void testSetParametro() {
		c1.setIO(io);
		c1.setParametro("sud");
		
		assertEquals("sud",c1.getParametro());
	}
	@Test
	public void testSenzaDirzione() {
		c1.setIO(io);
		c1.setParametro(null);
		c1.esegui(partita);
		assertEquals(stanzaCorrente,partita.getStanzaCorrente());
	}
	@Test
	public void testDirezioneAdiacenteNull() {
		c1.setIO(io);
		c1.setParametro("est");
		this.stanzaCorrente=partita.getStanzaCorrente();
		c1.esegui(partita);
		assertEquals(stanzaCorrente,partita.getStanzaCorrente());
	}
	@Test
	public void testvaiSud() {
		c1.setParametro("sud");
		c1.setIO(io);
		this.stanzaCorrente=partita.getStanzaCorrente();
		c1.esegui(partita);
		assertEquals(s2,partita.getStanzaCorrente());
	}


}
