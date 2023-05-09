package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private String attrezzoSbloccoDirezione;
	public StanzaBloccata(String nome,String direzioneBloccata,String AttrezzoSblocco) {
		super(nome);
		this.attrezzoSbloccoDirezione=AttrezzoSblocco;
		this.direzioneBloccata=direzioneBloccata;
	}
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!super.hasAttrezzo(attrezzoSbloccoDirezione) && direzione!=direzioneBloccata)
			return this;
		else
			return super.getStanzaAdiacente(direzione);

	}
	@Override
	public String getDescrizione() {
		return this.toString();
	}

	@Override
	public String toString() {
		String stampa= "\n Direzione bloccata :" + direzioneBloccata + "\n per sbloccarla serve l attrezzo:" + attrezzoSbloccoDirezione;
		return super.toString()+stampa;

	}
}
