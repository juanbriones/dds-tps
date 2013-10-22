package comprarEntradas.domain;

//menor de 18 y mayor de 12
public class Menor18 extends Cliente {
	
	private static int porcentaje = 20;
	
	
	@Override
	public int calcularDescuentoCliente(Entrada entrada)
	{
		if (entrada.getPrecio() > 100)
		{
			return entrada.getPrecio() * porcentaje / 100;
		}
		else
		{
			if (entrada.getPrecio() <= 100 && entrada.getPrecio() > 50)
			{
				return 10;
			}
			else
			{
				return 0;
			}
		}
	}
	
}
