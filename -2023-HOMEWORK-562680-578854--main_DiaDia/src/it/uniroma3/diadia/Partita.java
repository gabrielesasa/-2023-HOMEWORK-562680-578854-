package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {



	private boolean finita;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Labirinto labirinto=new Labirinto("l1");

	private Giocatore giocatore=new Giocatore();
	private IO io;
	String nome;												//overloding per test
	public Partita(String nome,IO io) {
		this.nome=nome;
		this.io=io;													
	}															//.
	public Partita(IO io){
		this.io=io;
		labirinto.creaStanze(io);
		this.finita = false;
		// il gioco comincia nell'atrio
		stanzaCorrente = labirinto.getStanzaCorrente();  
		stanzaVincente = labirinto.getStanzaVincente();
	}

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */


	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.stanzaCorrente== this.stanzaVincente;
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		int cfu=giocatore.getCfu();
		return finita || vinta() || (cfu == 0);
	}
	
	public IO getIO() {
		return io;
	}
	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	public Giocatore getGiocatore() {
		return giocatore;
	}
	public Labirinto getLabirinto() {
		return labirinto;
	}
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente=stanzaCorrente;
	}
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
}}
