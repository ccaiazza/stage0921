package bean;

import java.util.ArrayList;

public class Aeroporto {
	
	    private int aeroportoId;
	    private String città;
	    private String nome;
	    private String nazione;
	    private int numeroPiste;
	    
	    
	    public Aeroporto(int aeroportoId, String città, String nome, String nazione, int numeroPiste) {
	        this.aeroportoId = aeroportoId;
	        this.città = città;
	        this.nome = nome;
	        this.nazione = nazione;
	        this.numeroPiste = numeroPiste;
	    }
	    
	    
	    @Override
		public String toString() {
			return "Aeroporto [aeroportoId=" + aeroportoId + ", città=" + città + ", nome=" + nome + ", nazione="
					+ nazione + ", numeroPiste=" + numeroPiste + "]";
		}


		public int getAeroportoId() {
	        return aeroportoId;
	    }

	    public String getCittà() {
	        return città;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public String getNazione() {
	        return nazione;
	    }

	    public int getNumeroPiste() {
	        return numeroPiste;
	    }

	    public void setAeroportoId(int aeroportoId) {
	        this.aeroportoId = aeroportoId;
	    }

	    public void setCittà(String città) {
	        this.città = città;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public void setNazione(String nazione) {
	        this.nazione = nazione;
	    }

	    public void setNumeroPiste(int numeroPiste) {
	        this.numeroPiste = numeroPiste;
	    }

}
