package bean;

import java.util.ArrayList;

public class Aeroporto {
	
	    private int aeroportoId;
	    private String citt�;
	    private String nome;
	    private String nazione;
	    private int numeroPiste;
	    
	    
	    public Aeroporto(int aeroportoId, String citt�, String nome, String nazione, int numeroPiste) {
	        this.aeroportoId = aeroportoId;
	        this.citt� = citt�;
	        this.nome = nome;
	        this.nazione = nazione;
	        this.numeroPiste = numeroPiste;
	    }
	    
	    
	    @Override
		public String toString() {
			return "Aeroporto [aeroportoId=" + aeroportoId + ", citt�=" + citt� + ", nome=" + nome + ", nazione="
					+ nazione + ", numeroPiste=" + numeroPiste + "]";
		}


		public int getAeroportoId() {
	        return aeroportoId;
	    }

	    public String getCitt�() {
	        return citt�;
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

	    public void setCitt�(String citt�) {
	        this.citt� = citt�;
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
