package comprarEntradas.domain;

public class Ubicacion {
	
	private char sector;
    private int fila;
    private int butaca;
    private int precio;

    
	public Ubicacion(char sector, int fila, int butaca, int precio) {
		this.sector = sector;
		this.fila = fila;
		this.butaca = butaca;
		this.precio = precio;
	}
    
	
	public char getSector() {
		return sector;
	}

	
	public void setSector(char sector) {
		this.sector = sector;
	}

	
	public int getFila() {
		return fila;
	}

	
	public void setFila(int fila) {
		this.fila = fila;
	}

	
	public int getButaca() {
		return butaca;
	}

	
	public void setButaca(int butaca) {
		this.butaca = butaca;
	}

	
	public int getPrecio() {
		return precio;
	}

	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	/*public void generarIdEntrada(Entrada entrada)
	{
		entrada.setIdEntrada((int) this.sector * 10000 + this.fila * 100 + this.butaca); //Falta numero de noche
	}*/

}