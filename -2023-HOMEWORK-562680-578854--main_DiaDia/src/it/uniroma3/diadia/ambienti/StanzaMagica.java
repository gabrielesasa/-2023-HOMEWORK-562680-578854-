package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	private int contantatoriAttrezziPosati;
	private int sogliaMagica;
	
	private static final int SOGLIA_MAGICA_DEFAULT = 3;
	public StanzaMagica(String nome) {
		super(nome);
		this.sogliaMagica=SOGLIA_MAGICA_DEFAULT;
	}
	public StanzaMagica(String nome,int sogliaMagica) {
		super(nome);
		this.sogliaMagica=sogliaMagica;
		this.contantatoriAttrezziPosati=0;
	}
	public Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesox2=attrezzo.getPeso()*2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesox2);
		return attrezzo;
	}
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		contantatoriAttrezziPosati++;
		if(contantatoriAttrezziPosati>sogliaMagica) {
			attrezzo=this.modificaAttrezzo(attrezzo);
		}
		return super.addAttrezzo(attrezzo);

	}
}
