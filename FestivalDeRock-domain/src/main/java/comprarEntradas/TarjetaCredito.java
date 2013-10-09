package comprarEntradas;

public class TarjetaCredito {
	
	public int numero;
	public int credito;
	
	
	public TarjetaCredito() {

	}
	
	
	public TarjetaCredito(int numero, int credito) {
		this.numero = numero;
		this.credito = credito;
	}
	
	
	public int getNumero() {
		return numero;
	}
	

	public void setNumero(int numero) {
		this.numero = numero;
	}
	

	public int getCredito() {
		return credito;
	}
	

	public void setCredito(int credito) {
		this.credito = credito;
	}
	
}
