package it.uniroma3.diadia;

import java.util.Scanner;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai     (nord,sud,est,ovest)", "aiuto",
			"fine","posa    (nome_attrezzo)","prendi    (nome_attrezzo)", "Dove sono?   (?)"};

	private Partita partita;
	private IOConsole IO;
	
	public DiaDia() {
		this.partita = new Partita();
		this.IO = new IOConsole();
	}

	public void gioca() {
		String istruzione=new String(); 
		
		

		this.IO.mostraMessaggio(MESSAGGIO_BENVENUTO);
		try (Scanner scannerDiLinee = new Scanner(System.in)) {
			do		
				istruzione = scannerDiLinee.nextLine();
			while (!processaIstruzione(istruzione));
		}
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome()==null)
			this.IO.mostraMessaggio("Inserire un comando valido");
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("?"))
			this.Dove();		
		else
			this.IO.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.IO.mostraMessaggio("Hai vinto!");
			return true;
		} else
			if(this.partita.getGiocatore().getCfu()==0) {
				this.IO.mostraMessaggio("Hai Perso!");
		return true;
			}else 
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.IO.mostraMessaggio(elencoComandi[i]);
		this.IO.mostraMessaggio("\n");
	}
	
	private void Dove() {
		System.out.println(partita.getStanzaCorrente().getDescrizione());
		System.out.println(partita.getGiocatore().getCfu());
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
        
		
		if(direzione==null) { 
			this.IO.mostraMessaggio("Dove vuoi andare ?");
	
		try (Scanner direzione2 = new Scanner(System.in)) {
			direzione = direzione2.nextLine();
		}
		}
		
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.IO.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			cfu--;
			this.partita.getGiocatore().setCfu(cfu);
		}
		this.IO.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
        System.out.println("Vite: "+ this.partita.getGiocatore().getCfu()+"\n");
	}
	/**
	 * Raccoglie un attrezzo dalla stanza corrente (rimuovendolo da essa) e lo mette
	 * nella borsa.
	 * 
	 * @param attrezzo da prendere dalla stanza.
	 * 
	 */
	public void prendi(String nomeAttrezzo) {
		Stanza stanzaCorrente=this.partita.getStanzaCorrente();
		Borsa borsa = this.partita.getGiocatore().getBorsa();
		if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoDaPrendere = stanzaCorrente.getAttrezzo(nomeAttrezzo);
			if(borsa.addAttrezzo(attrezzoDaPrendere)==true) {
				this.IO.mostraMessaggio("Ho preso dalla stanza l'attrezzo:" + nomeAttrezzo
						+" dalla stanza "+ stanzaCorrente.getNome()+" e l'ho messo nella borsa!!");
				stanzaCorrente.removeAttrezzo(attrezzoDaPrendere);
			}
			else 
				this.IO.mostraMessaggio("La borsa è piena, non posso prendere l'attrezzo:"+nomeAttrezzo);
		}
			else
				this.IO.mostraMessaggio("Non c'è questo attrezzo nella stanza!!");

	}
	
	  public void posa(String nomeAttrezzo) {
	        Stanza stanzaCorrente = this.partita.getStanzaCorrente();
	        Borsa borsa = this.partita.getGiocatore().getBorsa();
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

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.IO.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		new DiaDia().gioca();

	}
}