package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	private static final String AIUTO = "aiuto";
	private IO io;
	static final private String[] elencoComandi = { "vai", AIUTO, "fine",
			"prendi", "posa" };
	/**
	 * Stampa informazioni di aiuto.
	 */
	@Override
	public void esegui(Partita partita) {
		IO io = partita.getIO();
		for (int i = 0; i < elencoComandi.length; i++) {
			io.mostraMessaggio(elencoComandi[i] + " ");
			
				
		}
		io.mostraMessaggio("");
	}
	@Override
	public String getParametro() {
		return null;
	}
	@Override
	public void setParametro(String parametro) {
		//niente
	}
	@Override
	public void setIO(IO io) {
		this.io=io;
		
	}
	@Override
	public String getNome() {
		return AIUTO;
	}
}
