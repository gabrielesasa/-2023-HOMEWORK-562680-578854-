package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	private static final String NONVALIDO = "nonvalido";
	private IO io;

	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("Comando inserito non riconosciuto");
	}

	@Override
	public void setParametro(String parametro) {
		// niente
	}
	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public void setIO(IO io) {
		this.io=io;
		
	}

	@Override
	public String getNome() {
	return NONVALIDO;
	}
}
