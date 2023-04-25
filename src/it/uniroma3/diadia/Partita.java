package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;


/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private labirinto labirinto;
	private Giocatore giocatore;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	public Partita(){
		this.labirinto = new labirinto();
		this.giocatore= new Giocatore();
		this.stanzaCorrente=labirinto.getStanzaIniziale();
		this.stanzaVincente=labirinto.getStanzaVincente();
	}
       
		public Stanza getStanzaCorrente() {
			return this.stanzaCorrente;
		}
		public void setStanzaCorrente(Stanza StanzaCorrente) {
		     this.stanzaCorrente=StanzaCorrente;
		} 
		public Stanza getStanzaVincente() {
			return this.stanzaVincente;
		}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return getStanzaCorrente()== this.stanzaVincente;
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}	
	
	
}
