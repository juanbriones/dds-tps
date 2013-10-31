package comprarEntradas.domain;

public class Jubilado extends Cliente{

	private static int porcentaje = 15;
	
	public Jubilado() {
	}
	
	public Jubilado(String nombre, String apellido, int edad) {
		super(nombre, apellido, edad);
	}
		
	@Override
	public int calcularDescuentoCliente(Entrada entrada)
	{
		return entrada.getPrecio() * porcentaje / 100;
	}	
}
