package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
    private IO IO;
    private final static String NOME = "fine";
    
    public ComandoFine() {
    	this.IO =new IOConsole();
    }

	/**
	 * Comando "Fine".
	 */

	@Override
	public void esegui(Partita partita) {
		this.IO.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}


}
