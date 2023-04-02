package testDiaDia;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;


public class testGiocatore {
	
	Giocatore giocatore=new Giocatore();
	
	@Test
	public void testagetCfu() {
		assertEquals(20,giocatore.getCfu());
	}
	@Test
	public void testaBorsa() {
		assertNotNull(giocatore.getBorsa());
	}
	@Test
	public void testetCfu() {
		giocatore.setCfu(10);
		assertEquals(10,giocatore.getCfu());
	}
}