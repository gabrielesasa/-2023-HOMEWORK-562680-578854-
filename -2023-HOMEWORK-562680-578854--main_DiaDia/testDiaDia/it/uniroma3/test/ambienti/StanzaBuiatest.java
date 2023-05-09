package it.uniroma3.test.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiatest {
	private StanzaBuia stanzaBuia;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Attrezzo attrezzo4;
	private String buio="qui c è un buio pesto";
	@BeforeEach
	void setUpStanzaBuia() {
		this.stanzaBuia=new StanzaBuia("atrio", "lanterna");
		attrezzo1 = new Attrezzo("spada", 3);
		attrezzo2 = new Attrezzo("lanterna", 5);
		attrezzo3 = new Attrezzo("chiave", 2);
		attrezzo4 = new Attrezzo("scudo", 7);
	}

	@Test
	void testStanzaSenzaAttrezzoPerLuce() {
		assertEquals(stanzaBuia.BUIO,stanzaBuia.getDescrizione());
	}
	@Test
	void testStanzaConAttrezzoPerLuce() {
		stanzaBuia.addAttrezzo(attrezzo2);
		
		assertEquals("atrio\nUscite:\nAttrezzi nella stanza: lanterna (5kg) ",stanzaBuia.getDescrizione());
	}
	

}
