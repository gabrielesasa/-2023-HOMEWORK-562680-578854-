package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;

	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}


	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}

	public int getPesoMax() {
		return pesoMax;
	}
	public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}

	public void setNumeroAttrezzi(int numeroAttrezzi) {
		this.numeroAttrezzi = numeroAttrezzi;
	}
	public Attrezzo[] getAttrezzi() {
		return attrezzi;
	}

	public void setAttrezzi(Attrezzo[] attrezzi) {
		this.attrezzi = attrezzi;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a =null;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			if(this.attrezzi[i]!=null)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];

		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			if(this.attrezzi[i]!=null)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public boolean removeAttrezzo(String nomeAttrezzo) {
		boolean a = false;
		if(getPeso()<1)
			return a;
		for(int i=0;i<numeroAttrezzi;i++) {
			if(attrezzi[i]!=null)
			if(attrezzi[i].getNome().equals(nomeAttrezzo)) {
				attrezzi[i]=null;
				a=true;
			}
			
		}
		return a;
		
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(numeroAttrezzi>9)
			return false;
		if(getPeso()>pesoMax || pesoMax<=1)
			return false;
		this.attrezzi[numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;


	}
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for (int i = 0; i < this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString() + " ");
		} else
			s.append("Borsa vuota");
		return s.toString();
	}

}
