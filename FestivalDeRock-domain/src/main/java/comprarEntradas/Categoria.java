package comprarEntradas;

public class Categoria {
	
	private int nro;
	private int valor;
    
    
	public Categoria(int nro, int valor) {
		this.nro = nro;
		this.valor = valor;
	}
	

	public int getValor() {
		return valor;
	}
	

	public void setValor(int valor) {
		this.valor = valor;
	}
	

	public int getNro() {
		return nro;
	}
	

	public void setNro(int nro) {
		this.nro = nro;
	}
	
}
