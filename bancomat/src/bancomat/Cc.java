package bancomat;

public class Cc {
	private int saldo,i;
	public void versamento(int op){
		saldo=saldo+op;
	   
	}//fine metodo v
	public void prelievo(int op){
		saldo=saldo-op;
	     
	}//fine metodo p
	public int saldo(){
		return saldo; 
		}

}
