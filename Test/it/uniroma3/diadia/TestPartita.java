package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class TestPartita {
	private Partita partita;
	private Stanza stanza;
	private Stanza stanzaVincente;

	@BeforeEach
	void setUp() {
		this.partita = new Partita();
		this.stanza=new Stanza("N10");
		this.stanzaVincente=new Stanza("Biblioteca");
		
	}
	
	@Test
	final void testVinta() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	final void testGetStanzaCorrente() {
		this.partita.setStanzaCorrente(stanza);
		assertEquals("N10",this.partita.getStanzaCorrente().getNome());
	}
	
	
	@Test
	final void testGetStanzaVincente() {
		this.partita.getStanzaVincente();
		assertEquals(this.stanzaVincente.getNome(),this.partita.getStanzaVincente().getNome());
	}
	
	

}