package it.uniroma3.diadia;

import java.util.Scanner;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.comandi.*;

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


	private Partita partita;
	private IO IO;



	public DiaDia() {
		this.partita = new Partita();
		this.IO = new IOConsole();
	}

	public void gioca() {
		String istruzione=new String(); 



		this.IO.mostraMessaggio(MESSAGGIO_BENVENUTO);
			do		
				istruzione = IO.leggiRiga();
			while (!processaIstruzione(istruzione));
		}
	


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		Comando comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta()) {
			this.IO.mostraMessaggio("Hai vinto!");
			return true;
        }
		else { if(this.partita.getGiocatore().getCfu()==0) {
			this.IO.mostraMessaggio("Hai Perso! ");
			System.out.println("Hai esaurito i CFU...");
			return true;
		}
	return false;
	}
	}	 

		
		public static void main(String[] argc) {
			new DiaDia().gioca();

		}

	}