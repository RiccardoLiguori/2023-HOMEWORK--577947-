package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaMagica {
	private StanzaMagica stanza;
	private Attrezzo attrezzo;
	private int soglia;
	private StringBuilder Nome;
	private int peso;
	private Attrezzo attrezzoPesante;
	private StringBuilder Nome2;
	private int peso2;


	@BeforeEach
	public void setUp() {
		this.attrezzo=new Attrezzo("bomba",2);
		this.attrezzoPesante=new Attrezzo("incudine",10);
		this.Nome=new StringBuilder(attrezzo.getNome());
		this.Nome2=new StringBuilder(attrezzoPesante.getNome());
		this.peso=attrezzo.getPeso()*2;
		this.peso2=attrezzoPesante.getPeso()*2;
	}
	
	public void addAttrezzi(int soglia) {    
		this.soglia=soglia;
		for(int i=0;i<this.soglia;i++) {
			this.stanza.addAttrezzo(new Attrezzo("utensili"+i,1+i));
		}
	}

	@Test
	public void StanzaMagicatestSOGLIAMAGICA() {
		this.stanza=new StanzaMagica ("SMagica");
		addAttrezzi(this.stanza.getSoglia_Magica_Default());
		this.stanza.addAttrezzo(attrezzo);
		this.Nome=Nome.reverse();
		Attrezzo attrezzoinvertito=new Attrezzo(Nome.toString(),this.peso);
		
		assertTrue(this.stanza.hasAttrezzo("abmob"));
		
		assertEquals(attrezzoinvertito.getNome(),this.stanza.getAttrezzo("abmob").getNome());
		assertEquals(attrezzoinvertito.getPeso(),this.stanza.getAttrezzo("abmob").getPeso());
		
		//System.out.println(Arrays.asList(this.stanza.getAttrezzi()));
		}
	@Test
	public void StanzaMagicatest() {
		this.soglia=5;
		this.stanza=new StanzaMagica ("SMagica",this.soglia);
		addAttrezzi(this.soglia);
		this.stanza.addAttrezzo(attrezzoPesante);
		this.stanza.addAttrezzo(attrezzo);
		this.Nome=Nome.reverse();
		this.Nome2=Nome2.reverse();
		Attrezzo attrezzoinvertito=new Attrezzo(Nome.toString(),this.peso);
		Attrezzo attrezzoPesanteinvertito=new Attrezzo(Nome2.toString(),this.peso2);

		assertTrue(this.stanza.hasAttrezzo("abmob"));
		assertTrue(this.stanza.hasAttrezzo("eniducni"));
		assertFalse(this.stanza.hasAttrezzo("incudine"));
		
		assertEquals(attrezzoinvertito.getNome(),this.stanza.getAttrezzo("abmob").getNome());
		assertEquals(attrezzoinvertito.getPeso(),this.stanza.getAttrezzo("abmob").getPeso());
		
		assertEquals(attrezzoPesanteinvertito.getNome(),this.stanza.getAttrezzo("eniducni").getNome());
		assertEquals(attrezzoPesanteinvertito.getPeso(),this.stanza.getAttrezzo("eniducni").getPeso());
		
		System.out.println(Arrays.asList(this.stanza.getAttrezzi()));
		}	
	}
        

