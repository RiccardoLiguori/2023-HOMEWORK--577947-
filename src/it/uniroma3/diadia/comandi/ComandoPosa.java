package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {
	
	private IO IO;
	private String nomeAttrezzo;
	private final static String NOME = "posa";

	public ComandoPosa() {
		this.IO=new IOConsole();
	}
	/**
	 * Posa l'attrezzo e lo mette nella StanzaCorrente.
	 * 
	 * @param attrezzo da posare nella stanza.
	 * 
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		if(borsa.hasAttrezzo(nomeAttrezzo) == true) {
			Attrezzo attrezzoDaPosare = borsa.getAttrezzo(nomeAttrezzo);
			if(stanzaCorrente.addAttrezzo(attrezzoDaPosare)) {
				this.IO.mostraMessaggio("l'attrezzo " + nomeAttrezzo + " e' stato posato nella stanza " + stanzaCorrente.getNome());
				borsa.removeAttrezzo(nomeAttrezzo);
			}
			else
				this.IO.mostraMessaggio("ci sono gia troppi attrezzi nella stanza!");
		}
		else
			this.IO.mostraMessaggio("l'attrezzo " + nomeAttrezzo + " non e' nella borsa");

	}
		

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;

	}
	@Override
	public String getNome() {
		return NOME;
	}
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
