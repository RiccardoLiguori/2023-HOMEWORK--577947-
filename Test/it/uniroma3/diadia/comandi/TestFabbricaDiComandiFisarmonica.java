package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class TestFabbricaDiComandiFisarmonica {
    private Comando expected;
    private Comando current;
    private FabbricaDiComandiFisarmonica fabbrica;
    private Attrezzo attrezzo;
    
	@BeforeEach
	public void setUp() {
	   this.fabbrica = new FabbricaDiComandiFisarmonica();
	   this.attrezzo=new Attrezzo("martello",1);
	}
	
	@Test
	void testComandoVai() {
	    expected = new ComandoVai();
		expected.setParametro("nord");
		current = fabbrica.costruisciComando("vai nord");
		assertEquals( expected.getNome(), current.getNome());
		assertEquals( expected.getParametro(), current.getParametro());
	}
	@Test
	void testComandoPrendi() {
		expected=new ComandoPrendi();
		expected.setParametro("martello");
		current=fabbrica.costruisciComando("prendi martello");
		assertEquals( expected.getNome(), current.getNome());
		assertEquals( expected.getParametro(), current.getParametro());
	}
	@Test
	void testComandoPosa() {
		expected=new ComandoPosa();
		expected.setParametro("martello");
		current=fabbrica.costruisciComando("posa martello");
		assertEquals( expected.getNome(), current.getNome());
		assertEquals( expected.getParametro(), current.getParametro());
	}
	
	
}
