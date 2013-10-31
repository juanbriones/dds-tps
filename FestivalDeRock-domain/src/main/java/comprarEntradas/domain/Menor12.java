package comprarEntradas.domain;

public class Menor12 extends Cliente {

	private static int porcentaje = 50;
	private boolean acompaniado;
	
	public Menor12() {
	}
	
	public Menor12(String nombre, String apellido, int edad, boolean acompaniado) {
		super(nombre, apellido, edad);
		this.acompaniado = acompaniado;
	}
	
	@Override
	public int calcularDescuentoCliente(Entrada entrada)
	{
		if (this.acompaniado)
		{
			return entrada.getPrecio() * porcentaje / 100;
		}
		else
		{
			return entrada.getPrecio();
		}
	}
}
