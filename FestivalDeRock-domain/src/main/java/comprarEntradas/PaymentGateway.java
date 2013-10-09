package comprarEntradas;

import java.util.*;

public class PaymentGateway {

	private Collection<TarjetaCredito> tarjetas = new ArrayList<TarjetaCredito>();
	
	
	public PaymentGateway() {

	}
	
	
	public PaymentGateway(Collection<TarjetaCredito> tarjetas) {
		this.tarjetas = tarjetas;
	}
	
	
	public Collection<TarjetaCredito> getTarjetas() {
		return tarjetas;
	}

    public void setTarjetas(Collection<TarjetaCredito> tarjetas) {
		this.tarjetas = tarjetas;
	}
    
	
	public boolean procesarPago(int monto, Cliente cliente) 
	{
		TarjetaCredito tarjetaSeleccionada = new TarjetaCredito();
		
		for (TarjetaCredito tarjeta:tarjetas)
		{
			if (cliente.tarjeta.getNumero() == tarjeta.numero)
			{
			    tarjetaSeleccionada = tarjeta;
				
			    if (monto <= tarjetaSeleccionada.credito)
				{
			    	 tarjetaSeleccionada.credito -= monto;
				     return true;
				}
			    else
			    {
			    	return false;
			    }
			}
		}
		
		return false;
	}
	
}
