package comprarEntradas;

public class Banda {
	
	private String nombre;
	private Categoria categoria;
	
	
	public Banda(String nombre, Categoria categoria) {
		this.nombre = nombre;
		this.categoria = categoria;
	}

	
	public String getNombre(){
		return nombre;
	}
	
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	public int valorCategoria()
	{
		return this.getCategoria().getValor();
	}
	

	public int nroCategoria()
	{
		return this.getCategoria().getNro();		
	}

}
