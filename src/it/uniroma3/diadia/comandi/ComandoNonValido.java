package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	private IO IO;
	private final static String NOME = "Comando non valido";

	public ComandoNonValido() {
		this.IO=new IOConsole();
     

	}
	@Override
	public void esegui(Partita partita) {
		this.IO.mostraMessaggio("Comando non valido!!");
		this.IO.mostraMessaggio("Inserire un comando: ");

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
