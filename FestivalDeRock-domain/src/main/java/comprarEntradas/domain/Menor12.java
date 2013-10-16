package comprarEntradas.domain;

public class Menor12 extends Cliente {
		
	private static int porcentaje = 50;
	private boolean acompaniado;
	
	
	public Menor12 (boolean acompaniado)
	{
		this.acompaniado = acompaniado;
	}
	
	@Override
	public int calcularDescuentoCliente(Entrada entrada)
	{
		if (this.acompaniado)
		{
			return entrada.obtenerPrecio() * porcentaje / 100;
		}
		else
		{
			return entrada.obtenerPrecio();
		}
	}
}
