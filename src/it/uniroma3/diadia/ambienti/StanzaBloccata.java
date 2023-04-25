package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private String direzioneBloccata;
	private String attrezzoSbloccante;

	public StanzaBloccata (String nome,String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata=direzioneBloccata;
		this.attrezzoSbloccante=attrezzoSbloccante;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(this.direzioneBloccata) && !this.hasAttrezzo(attrezzoSbloccante))
			return this;
		else 
			return this.getStanzaAdiacente(direzione);

	}
	@Override
	public String getDescrizione() {
		String bloccata = "Stanza bloccata nella direzione: "+ direzioneBloccata+"\nPrendi il " + attrezzoSbloccante + " e posalo nella stanza";

		if(!this.hasAttrezzo(attrezzoSbloccante))
			return bloccata;
		return super.getDescrizione();
	}
}