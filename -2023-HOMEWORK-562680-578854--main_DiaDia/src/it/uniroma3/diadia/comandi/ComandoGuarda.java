package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoGuarda implements Comando{
	private static final String GUARDA = "guarda";
	private Stanza stanzaCorrente;
	private IO io;

	@Override
	public void esegui(Partita partita) {
		stanzaCorrente=partita.getStanzaCorrente();
		io.mostraMessaggio("stanza corrente = "+partita.getStanzaCorrente().toString());
		io.mostraMessaggio("");
		io.mostraMessaggio("numero cfu" + partita.getGiocatore().toString());

	}
	@Override
	public String getParametro() {
		return null;
	}
	@Override
	public void setParametro(String direzine) {
		//niente
	}
	@Override
	public void setIO(IO io) {
		this.io=io;
		
	}
	@Override
	public String getNome() {
		return GUARDA;
	}
}
