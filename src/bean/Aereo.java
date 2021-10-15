package bean;

import java.util.ArrayList;

public class Aereo {

	private int aereoId;
	private String tipoAereo;
	private int postiDisponibili;
	private String compagniaAppartenenza;
	private String nomeAereo;
	

	public Aereo(int aereoId, String tipoAereo, int postiDisponibili, String compagniaAppartenenza, String nomeAereo) {
		this.aereoId = aereoId;
		this.tipoAereo = tipoAereo;
		this.postiDisponibili = postiDisponibili;
		this.compagniaAppartenenza = compagniaAppartenenza;
		this.nomeAereo = nomeAereo;
	}
	
	
	@Override
	public String toString() {
		return "Aereo [aereoId=" + aereoId + ", tipoAereo=" + tipoAereo + ", postiDisponibili=" + postiDisponibili
				+ ", compagniaAppartenenza=" + compagniaAppartenenza + ", nomeAereo=" + nomeAereo + "]";
	}


	public int getAereoId() {
		return aereoId;
	}
	
	public void setAereoId(int aereoId) {
		this.aereoId = aereoId;
	}
	
	public String getTipoAereo() {
		return tipoAereo;
	}
	
	public void setTipoAereo(String tipoAereo) {
		this.tipoAereo = tipoAereo;
	}
	
	public int getPostiDisponibili() {
		return postiDisponibili;
	}
	
	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}
	
	public String getCompagniaAppartenenza() {
		return compagniaAppartenenza;
	}
	
	public void setCompagniaAppartenenza(String compagniaAppartenenza) {
		this.compagniaAppartenenza = compagniaAppartenenza;
	}
	
	public String getNomeAereo() {
		return nomeAereo;
	}
	
	public void setNomeAereo(String nomeAereo) {
		this.nomeAereo = nomeAereo;
	}
	

}
