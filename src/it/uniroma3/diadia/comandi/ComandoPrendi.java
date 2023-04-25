package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class ComandoPrendi implements Comando {
	
	private IO IO;
	private String nomeAttrezzo;
	private final static String NOME = "prendi";

	public ComandoPrendi() {
		this.IO=new IOConsole();
	}
	/**
	 * Raccoglie un attrezzo dalla stanza corrente (rimuovendolo da essa) e lo mette
	 * nella borsa.
	 * 
	 * @param attrezzo da prendere dalla stanza.
	 * 
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente=partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoDaPrendere = stanzaCorrente.getAttrezzo(nomeAttrezzo);
			if(borsa.addAttrezzo(attrezzoDaPrendere)==true) {
				this.IO.mostraMessaggio("Ho preso dalla stanza "+ stanzaCorrente.getNome()+"l'attrezzo "+ nomeAttrezzo
						+" e l'ho messo nella borsa!!");
				stanzaCorrente.removeAttrezzo(attrezzoDaPrendere);
			}
			else 
				this.IO.mostraMessaggio("La borsa è piena, non posso prendere l'attrezzo:"+nomeAttrezzo);
		}
		else
			this.IO.mostraMessaggio("Non c'è questo attrezzo nella stanza!!");

		

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
