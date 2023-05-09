package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{
	private int contantatoriAttrezziPosati;
	private int sogliaMagica;
	
	private static final int SOGLIA_MAGICA_DEFAULT = 3;
	public StanzaMagicaProtected(String nome) {
		super(nome);
		this.sogliaMagica=SOGLIA_MAGICA_DEFAULT;
	}
public StanzaMagicaProtected(String nome,int sogliaMagica) {
		super(nome);
		this.sogliaMagica=sogliaMagica;
	}
	public Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInverso;
		int pesox2=attrezzo.getPeso()*2;
		nomeInverso=new StringBuilder(attrezzo.getNome());
		nomeInverso=nomeInverso.reverse();
		attrezzo=new Attrezzo(nomeInverso.toString(), pesox2);
		return attrezzo;
	}
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		contantatoriAttrezziPosati++;
		if(contantatoriAttrezziPosati> sogliaMagica)
			attrezzo=this.modificaAttrezzo(attrezzo);
	if (this.numeroAttrezzi < this.NUMERO_MASSIMO_ATTREZZI) {
		this.attrezzi[numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	} else {
		return false;
	}
}
}
