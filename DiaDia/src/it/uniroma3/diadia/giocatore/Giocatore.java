package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa= new Borsa(20);

	public Giocatore(){
		this.cfu = CFU_INIZIALI;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		int numeroAttrezzi = borsa.getNumeroAttrezzi();
		Attrezzo[] arrayattrezzi=borsa.getAttrezzi();
		if (this.borsa.getPeso() + attrezzo.getPeso() > this.borsa.getPesoMax())
			return false;
		if (numeroAttrezzi==10)
			return false;
		if(numeroAttrezzi<10) {
			arrayattrezzi[numeroAttrezzi] = attrezzo;
			this.borsa.setNumeroAttrezzi(numeroAttrezzi++);
		}
		return true;}


	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	public Borsa getBorsa() {
		return borsa;
	}
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
}
}

