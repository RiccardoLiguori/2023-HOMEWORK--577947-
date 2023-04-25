package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	private IO IO;
	private final static String NOME = "vai";
	public ComandoVai() {
		this.IO=new IOConsole();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	@Override
	public void esegui (Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente() ;
		Stanza prossimaStanza = null;
		if (this.direzione == null) {
			IO.mostraMessaggio("Dove vuoi andare?");
			IO.mostraMessaggio("Devi specificare una direzione"); 
			direzione=IO.leggiRiga();
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione) ;
		if (prossimaStanza == null) {
			this.IO.mostraMessaggio("Direzione inesistente");
			return;
		}	else {
			partita.setStanzaCorrente(prossimaStanza) ;
			IO.mostraMessaggio(partita.getStanzaCorrente().getNome());
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;

	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}
}