package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public interface FabbricaDiComandi {
	public Comando costruisci(String nomecomando, IO io);
}
