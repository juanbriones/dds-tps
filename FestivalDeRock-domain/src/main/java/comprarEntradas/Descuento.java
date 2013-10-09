package comprarEntradas;

public class Descuento {
	
	private int porcentajeAnticipada = 10;
	private int porcentajePrecioCombo = 10;


	public void setPorcentajeAnticipada(int porcentajeAnticipada) {
		this.porcentajeAnticipada = porcentajeAnticipada;
	}
	

	public void setPorcentajePrecioCombo(int porcentajePrecioCombo) {
		this.porcentajePrecioCombo = porcentajePrecioCombo;
	}
	
	
	public int diferenciaEnDias(int fecha1, int fecha2)
	{
		int difFecha = fecha1 - fecha2;
		
		int aniosAux = difFecha / 10000;
		int mesesAux = (difFecha % 10000) / 100;
		int diasAux = difFecha % 100;
		
		return aniosAux * 360 + mesesAux * 30 + diasAux;
	}
	
	
	public int calcularDescuentoTotal(Cliente cliente, Entrada entrada, int fechaVenta) 
	{
		int descuentoAnticipada = 0;
		int descuentoCliente = cliente.calcularDescuentoCliente(entrada);
		
		
		if (this.diferenciaEnDias(entrada.getNoche().getFechaInicio(), fechaVenta) > 30)
		{
			descuentoAnticipada = entrada.obtenerPrecio() * porcentajeAnticipada / 100; 
		}
		
		return descuentoCliente + descuentoAnticipada;
	}
	
	
	public int calcularDescuentoCombo(int precioCombo) 
	{	
		if (precioCombo > 1000)
		{
			return precioCombo * porcentajePrecioCombo / 100;
		}
		else
		{
			return 0;
		}
	}
	
}
