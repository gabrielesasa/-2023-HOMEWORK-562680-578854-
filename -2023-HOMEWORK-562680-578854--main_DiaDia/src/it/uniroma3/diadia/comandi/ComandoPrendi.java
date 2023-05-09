package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPrendi implements Comando{
	private static final String PRENDI = "prendi";
	private String nomeAttrezzo;
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Giocatore giocatore=partita.getGiocatore();
		Borsa borsa=giocatore.getBorsa();
		Attrezzo attrezzoDaPrendere = stanzaCorrente.getAttrezzo(nomeAttrezzo);
		
		if(this.nomeAttrezzo == null) {
			System.out.print("quale attrezzo vuoi prendere?");
			return;
		}
		if(stanzaCorrente.removeAttrezzo(nomeAttrezzo)) {
			System.out.print("Provaprova");
			
			if(borsa.addAttrezzo(attrezzoDaPrendere)) {
				System.out.print("attrezzo aggiunta alla borsa");
			}
			else {
				System.out.print("borsa piena");
			}


	}
	}
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	@Override
	public void setIO(IO io) {
		this.io=io;
		
	}
	@Override
	public String getNome() {
		return PRENDI;
	}
}
