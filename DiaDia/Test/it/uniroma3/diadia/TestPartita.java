package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPartita {
	private Partita partita;

	@BeforeEach
	void setUp() {
		this.partita = new Partita();
	}
	
	@Test
	final void testVinta() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	final void testGetStanzaCorrente() {
		assertNotNull(this.partita.getStanzaCorrente());
	}
	
	
	@Test
	final void testGetGiocatore() {
		assertNotNull(this.partita.getGiocatore());
	}
	
	
	

}