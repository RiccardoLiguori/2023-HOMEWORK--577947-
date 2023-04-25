package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class TestComandoPosa {

	private Partita partita;
	private Attrezzo attrezzo;
	private Comando comando;
	private Stanza stanza;
	private Giocatore giocatore;
	private Borsa borsa;

	@Before
	public void setUp() {
		this.partita = new Partita();
		this.attrezzo = new Attrezzo("martello", 2);
		this.comando = new ComandoPosa();
		this.stanza=new Stanza("N10");
		this.giocatore=new Giocatore();
		this.borsa=new Borsa();
		this.giocatore.setBorsa(borsa);
		this.partita.setGiocatore(giocatore);
		this.partita.setStanzaCorrente(stanza);
	}

	@Test
	public void testAttrezzoPosato() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		this.comando.setParametro("martello");
		this.comando.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}

	@Test
	public void testAttrezzoPosatoNull() {
		this.comando.setParametro("martello");
		this.comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}


	public void creatoreAttrezzi() {
		Attrezzo attrezzi[]=new Attrezzo[10];
		for(int i=0; i<10;i++) {
			attrezzi[i]= new Attrezzo("utensile", 1);
			this.partita.getStanzaCorrente().addAttrezzo(attrezzi[i]);
			
		}
	
	}
	@Test
	public void testTroppiAttrezzi() {
	
		
		this.creatoreAttrezzi();
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		this.comando.setParametro("martello");
		this.comando.esegui(partita);

		assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}

}
