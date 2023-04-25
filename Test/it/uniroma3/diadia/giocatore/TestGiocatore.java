package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;


class TestGiocatore {

	private Giocatore giocatoreConBorsaVuota;
	private Giocatore giocatoreConBorsaNonVuota;

	private Borsa borsaVuota;
	private Borsa borsaNonVuota;
	private Attrezzo osso;


	@BeforeEach
	void setUp(){
		giocatoreConBorsaVuota = new Giocatore();
		giocatoreConBorsaNonVuota = new Giocatore();
		osso = new Attrezzo("osso", 1);
		borsaVuota = new Borsa();
		borsaNonVuota = new Borsa();
		borsaNonVuota.addAttrezzo(osso);
		this.giocatoreConBorsaNonVuota.setBorsa(borsaNonVuota);
		this.giocatoreConBorsaVuota.setBorsa(borsaVuota);

	}

	@Test
	final void testGetCfu() {
		assertTrue(giocatoreConBorsaVuota.getCfu() == 20);		
		assertTrue(giocatoreConBorsaNonVuota.getCfu() == 20);		
	}
    @Test
	final void testGetBorsaVuota() {
		assertNull(giocatoreConBorsaVuota.getBorsa().getAttrezzo("osso"));
	}
    @Test
	final void testGetBorsaNonVuota() {
		assertEquals(osso, giocatoreConBorsaNonVuota.getBorsa().getAttrezzo("osso"));
	}

}


