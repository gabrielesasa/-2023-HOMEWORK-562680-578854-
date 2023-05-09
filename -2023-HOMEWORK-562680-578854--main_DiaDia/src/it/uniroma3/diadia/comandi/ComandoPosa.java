package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPosa implements Comando{
	private static final String POSA = "posa";
	private String nomeAttrezzo;
	private IO io;
	@Override
	public void esegui(Partita partita) {
	
	Stanza stanzaCorrente=partita.getStanzaCorrente();
	Giocatore giocatore=partita.getGiocatore();
	Borsa borsa=giocatore.getBorsa();

	Attrezzo attrezzoDaPrendere = borsa.getAttrezzo(getParametro());
	if(attrezzoDaPrendere == null) {
		System.out.print("attrezzo non presente nella borsa");
		return;
	}
	
	//IMPLEMENTARE IF SE LA BORSA è PIENA	
	
	if(borsa.removeAttrezzo(getParametro())) {
		stanzaCorrente.addAttrezzo(attrezzoDaPrendere);
		System.out.print("attrezzo aggiunta alla stanza");
	}
	}
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}
	@Override
	public void setIO(IO io) {
		this.io=io;
		
	}
	@Override
	public String getNome() {
		return POSA;
	}
}
