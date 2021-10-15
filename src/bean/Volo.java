package bean;

import java.sql.Date;

public class Volo {
	
	private int codiceVolo;
	private Date dataPartenza;
	private Date dataArrivo;
	private int numeroPasseggeri;
	private Aeroporto aeroportoPartenza;
	private Aeroporto aeroportoArrivo;
	private Aereo aereo;
	
	
	public Volo(int codiceVolo, Date dataPartenza, Date dataArrivo, int numeroPasseggeri,
			Aeroporto aeroportoPartenza, Aeroporto aeroportoArrivo, Aereo aereo) {
		
		this.codiceVolo = codiceVolo;
		this.dataPartenza = dataPartenza;
		this.dataArrivo = dataArrivo;
		this.numeroPasseggeri = numeroPasseggeri;
		this.aeroportoPartenza = aeroportoPartenza;
		this.aeroportoArrivo = aeroportoArrivo;
		this.aereo = aereo;
	}
	

	@Override
	public String toString() {
		return "Volo [codiceVolo=" + codiceVolo + ", dataPartenza=" + dataPartenza + ", dataArrivo=" + dataArrivo
				+ ", numeroPasseggeri=" + numeroPasseggeri + ", aeroportoPartenza=" + aeroportoPartenza.getAeroportoId()
				+ ", aeroportoArrivo=" + aeroportoArrivo.getAeroportoId() + ", aereo=" + aereo.getAereoId() + "]";
	}

	public int getCodiceVolo() {
		return codiceVolo;
	}
	public void setCodiceVolo(int codiceVolo) {
		this.codiceVolo = codiceVolo;
	}
	public Date getDataPartenza() {
		return dataPartenza;
	}
	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	public Date getDataArrivo() {
		return dataArrivo;
	}
	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}
	public int getNumeroPasseggeri() {
		return numeroPasseggeri;
	}
	public void setNumeroPasseggeri(int numeroPasseggeri) {
		this.numeroPasseggeri = numeroPasseggeri;
	}
	
	public Aeroporto getAeroportoPartenza() {
		return aeroportoPartenza;
	}
	public void setAeroportoPartenza(Aeroporto aeroportoPartenza) {
		this.aeroportoPartenza = aeroportoPartenza;
	}
	public Aeroporto getAeroportoArrivo() {
		return aeroportoArrivo;
	}
	public void setAeroportoArrivo(Aeroporto aeroportoArrivo) {
		this.aeroportoArrivo = aeroportoArrivo;
	}
	public Aereo getAereo() {
		return aereo;
	}
	public void setAereo(Aereo aereo) {
		this.aereo = aereo;
	}


}
