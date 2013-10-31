package comprarEntradas.domain;

public class Descuento {
	
	private int porcentajeAnticipada = 10;
	private int porcentajePrecioCombo = 10;


	public void setPorcentajeAnticipada(int porcentajeAnticipada) {
		this.porcentajeAnticipada = porcentajeAnticipada;
	}
	

	public void setPorcentajePrecioCombo(int porcentajePrecioCombo) {
		this.porcentajePrecioCombo = porcentajePrecioCombo;
	}
	
	
	public long diferenciaEnDias(long fecha1, long fecha2)
	{
		long difFecha = fecha1 - fecha2;
		
		long aniosAux = difFecha / 10000;
		long mesesAux = (difFecha % 10000) / 100;
		long diasAux = difFecha % 100;
		
		return aniosAux * 360 + mesesAux * 30 + diasAux;
	}
	
	
	public int calcularDescuentoTotal(Cliente cliente, Entrada entrada, long fechaVenta) 
	{
		int descuentoAnticipada = 0;
		int descuentoCliente = cliente.calcularDescuentoCliente(entrada);
		
		
		if (this.diferenciaEnDias(entrada.getNoche().getFechaInicio(), fechaVenta) > 30)
		{
			descuentoAnticipada = entrada.getPrecio() * porcentajeAnticipada / 100; 
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
