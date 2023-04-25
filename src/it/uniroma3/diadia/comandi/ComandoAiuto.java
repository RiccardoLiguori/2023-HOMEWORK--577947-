package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
    
	static final private String[] elencoComandi = {"vai     (nord,sud,est,ovest)", "aiuto",
			"fine","posa    (nome_attrezzo)","prendi    (nome_attrezzo)", "Guarda  (Stato partita)"};
	private IO IO;
	private final static String NOME = "aiuto";
	
	public ComandoAiuto() {
		this.IO=new IOConsole();

	}
	/**
	 * Stampa informazioni di aiuto.
	 */
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.IO.mostraMessaggio(elencoComandi[i]);
		this.IO.mostraMessaggio("\n");

	}

	@Override
	public void setParametro(String parametro) {

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
