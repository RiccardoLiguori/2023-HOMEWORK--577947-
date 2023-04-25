package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	private Stanza vuota;
	private Attrezzo osso;
	private Stanza Nonvuota;
    private String[] direzione;

	@BeforeEach
	public void setUp(){
		this.Nonvuota=new Stanza("Nonvuota");
		this.osso=new Attrezzo("osso",1);
		Nonvuota.addAttrezzo(this.osso);
		this.vuota=new Stanza("vuota");
		this.Nonvuota.impostaStanzaAdiacente("sud",vuota);
		this.vuota.impostaStanzaAdiacente("nord",Nonvuota);
		this.direzione=this.vuota.getDirezioni();
	}

	@Test
	final void testHasAttrezzo() {
		assertTrue(this.Nonvuota.hasAttrezzo("osso"));
		assertFalse(this.vuota.hasAttrezzo("osso"));
	}
	@Test
	final void testRemoveAttrezzo() {
		assertTrue(this.Nonvuota.removeAttrezzo(this.osso));
		assertFalse(this.vuota.removeAttrezzo(this.osso));


	}
	@Test
	final void testGetStanzaAdiacente() {
		assertEquals("vuota",this.Nonvuota.getStanzaAdiacente("sud").getNome());
		assertEquals("Nonvuota",this.vuota.getStanzaAdiacente("nord").getNome());

	}	
	@Test
	final void testaddAttrezzo() {
		assertTrue(this.Nonvuota.addAttrezzo(osso));
	    assertTrue(this.vuota.addAttrezzo(osso));

	}



}