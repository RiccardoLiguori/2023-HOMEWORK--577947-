package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanzaBuia {
	private StanzaBuia buia;
	private Attrezzo attrezzo;
	private IO IO;
	
	@BeforeEach
	public void setUp() {
		this.buia=new StanzaBuia("N10","osso");
		this.attrezzo=new Attrezzo("osso",2);
		this.IO=new IOConsole();
	}
	@Test
	void testStanzaNONBuia() {
		this.buia.addAttrezzo(attrezzo);
		assertEquals(this.buia.toString(),this.buia.getDescrizione());
	    IO.mostraMessaggio(this.buia.getDescrizione());
	}
	@Test
	void testStanzaBuia() {
		String buia="Qui c'è un buio pesto!!";
		assertEquals(buia,this.buia.getDescrizione());
	}

}
