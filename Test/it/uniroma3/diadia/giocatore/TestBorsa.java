package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestBorsa {
    private Borsa borsaPiena;
    private Attrezzo Martello;
    private Borsa borsaVuota;   
    private Attrezzo Spada;
    @BeforeEach
    public void setUp() {
	borsaPiena=new Borsa();
	borsaVuota=new Borsa();
	Martello=new Attrezzo("martello",5);
	Spada=new Attrezzo("spada",3);
	borsaPiena.addAttrezzo(Martello);
	borsaVuota.addAttrezzo(Spada);
}
    @Test	
	final void testHasAttrezzo() {
		assertFalse(borsaPiena.hasAttrezzo("Spada"));
	}
    @Test	
	final void testaddAttrezzo() {
		assertTrue(borsaPiena.addAttrezzo(Martello));
	}
    @Test	
	final void removeatttrezzo() {
    	borsaVuota.addAttrezzo(Spada);
    	borsaVuota.removeAttrezzo("spada");
		assertEquals(Spada,borsaVuota.removeAttrezzo("spada"));
	}
    @Test	
   	final void testIsEmpty() {
   		assertFalse(borsaVuota.isEmpty());
   	}

    
    
}
