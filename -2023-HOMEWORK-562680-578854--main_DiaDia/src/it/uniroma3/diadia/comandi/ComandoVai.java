package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai implements Comando {
	private static final String NOME = "vai";
	private String direzione;
	private Giocatore giocatore;
	private IO io;
	
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		giocatore = partita.getGiocatore();
		if(direzione==null) {
			this.io.mostraMessaggio("Dove vuoi andare ?");
			return;
		}
		Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			this.io.mostraMessaggio("Direzione inesistente");
			return;
		}
		else {
			partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.giocatore.getCfu();
			this.giocatore.setCfu(cfu--);
		}
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());

	}
	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
	}
	@Override
	public String getParametro() {
		return this.direzione;
	}
	@Override
	public void setIO(IO io) {
		this.io=io;
		
	}
	@Override
	public String getNome() {
		return NOME;
	}

}
