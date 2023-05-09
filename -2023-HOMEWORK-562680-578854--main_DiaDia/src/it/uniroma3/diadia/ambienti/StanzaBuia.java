package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	public static final String BUIO = "qui c'è un buio pesto";
	private String attrezzoAccessoADescrizione;
	public StanzaBuia(String nome,String attrezzoPerDescrizione) {
		super(nome);
		this.attrezzoAccessoADescrizione=attrezzoPerDescrizione;
	}
	@Override
	public String getDescrizione() {
		if(!super.hasAttrezzo(attrezzoAccessoADescrizione))
			return BUIO;
		else
		return super.getDescrizione();
	}
		

}
