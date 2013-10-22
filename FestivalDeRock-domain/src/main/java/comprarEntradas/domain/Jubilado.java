package comprarEntradas.domain;

public class Jubilado extends Cliente{
	
	private static int porcentaje = 15;
	
	
	@Override
	public int calcularDescuentoCliente(Entrada entrada)
	{
		return entrada.getPrecio() * porcentaje / 100;
	}	
}
