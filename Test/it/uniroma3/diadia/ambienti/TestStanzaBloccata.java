package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanzaBloccata {
	
	private StanzaBloccata bloccata;
	private String direzioneBloccata;
	private Attrezzo attrezzoSbloccante;

	@BeforeEach
    public void setUp() {
		this.bloccata=new StanzaBloccata("N10","sud","osso");
		this.attrezzoSbloccante=new Attrezzo("osso",3);
		this.direzioneBloccata=new String ("sud");
		
	}

	@Test
	void testStanzaBloccata() {
	  String bloccata; 
	  bloccata="Stanza bloccata nella direzione: "+ direzioneBloccata+"\nPrendi il " + attrezzoSbloccante.getNome() + " e posalo nella stanza"; 
	  assertEquals(bloccata,this.bloccata.getDescrizione());
	
	}
	

	@Test
	void testStanzaSbloccata() {
	  this.bloccata.addAttrezzo(attrezzoSbloccante);
	  assertEquals(this.bloccata.toString(),this.bloccata.getDescrizione());
	
	}

	
	
}
