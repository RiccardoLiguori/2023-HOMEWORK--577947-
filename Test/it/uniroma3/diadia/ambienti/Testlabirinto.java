package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Testlabirinto {
	private labirinto labirinto;
	private Stanza Biblioteca;
	private Stanza Atrio;

	@BeforeEach
	public void setUp() {
    this.labirinto=new labirinto();
    this.Biblioteca=this.labirinto.getStanzaVincente();
    this.Atrio=this.labirinto.getStanzaIniziale();

	}

	@Test
	void testGetStanzaVincente() {
		assertEquals(Biblioteca,this.labirinto.getStanzaVincente());
		
	}

	@Test
	void testGetStanzaIniziale() {
		assertEquals(Atrio, this.labirinto.getStanzaIniziale());
	}

}
