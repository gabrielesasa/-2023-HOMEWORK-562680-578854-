package it.uniroma3.test.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricadiComandiFisarmonica;

class testFabbricaDiComandiFisarmonica {
	private FabbricaDiComandi fc;
	private IO io;
	private Comando comando;
	@BeforeEach
	public void setUpComandi() {
		this.fc=new FabbricadiComandiFisarmonica();
	}

	@Test
	public void testComandoFine() {
		comando=fc.costruisci("fine", io);
		assertEquals("fine", comando.getNome());
	}

}
