package it.uniroma3.test.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;
class StanzaMagicatest {
	private StanzaMagica stanzaMagica;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Attrezzo attrezzo4;

	@BeforeEach
	void setUpStanzaMagica()  {
		stanzaMagica = new StanzaMagica("atrio" );
		attrezzo1 = new Attrezzo("spada", 3);
		attrezzo2 = new Attrezzo("lanterna", 5);
		attrezzo3 = new Attrezzo("chiave", 2);
		attrezzo4 = new Attrezzo("scudo", 7);
	}

	@Test
	void testAggiungiUnAttrezzo() {
		assertTrue(stanzaMagica.addAttrezzo(attrezzo1));
		assertEquals(attrezzo1, stanzaMagica.getAttrezzo("spada"));
	}
	@Test
	void testAggiungiTreAttrezzo() {
		stanzaMagica.addAttrezzo(attrezzo1);
		stanzaMagica.addAttrezzo(attrezzo2);
		stanzaMagica.addAttrezzo(attrezzo3);
		assertEquals(attrezzo1, stanzaMagica.getAttrezzo("spada"));
		assertEquals(attrezzo2, stanzaMagica.getAttrezzo("lanterna"));
		assertEquals(attrezzo3, stanzaMagica.getAttrezzo("chiave"));
	}
	@Test
	void testAggiungiAttrezzoMagica() {
		stanzaMagica.addAttrezzo(attrezzo1);
		stanzaMagica.addAttrezzo(attrezzo2);
		stanzaMagica.addAttrezzo(attrezzo3);
		assertTrue(stanzaMagica.addAttrezzo(attrezzo4));
	}
	@Test
	void testAttivazioneStanzaMagica() {
		stanzaMagica.addAttrezzo(attrezzo1);
		stanzaMagica.addAttrezzo(attrezzo2);
		stanzaMagica.addAttrezzo(attrezzo3);
		stanzaMagica.addAttrezzo(attrezzo4);
		stanzaMagica.modificaAttrezzo(attrezzo4);
		assertEquals(stanzaMagica.modificaAttrezzo(attrezzo4), stanzaMagica.getAttrezzo("oducs"));
	}
}
