package testDiaDia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class testBorsa {
	Borsa b = new Borsa(10);
	Attrezzo spada;
	Attrezzo scudo;
	
	@BeforeEach
	public void setUp() {
		spada = new Attrezzo("spada", 2);
		scudo = new Attrezzo("scudo", 16);
	}
	
	
	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(spada));

	}
	
	@Test
	public void testGetPesoMax() {
		b.addAttrezzo(spada);
		b.addAttrezzo(scudo);
		assertEquals(10, b.getPesoMax());

	}

	
	@Test
	public void testGetPeso() {
		b.addAttrezzo(spada);
		b.addAttrezzo(scudo);
		assertEquals(18, b.getPeso());

	}

	


}
