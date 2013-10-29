package comprarEntradas.domain;

import java.util.*;

public class Home {
	
    private Collection<Noche> noches = new ArrayList<Noche>();
    private Collection<Cliente> clientes = new ArrayList<Cliente>();
    private PaymentGateway plataformaDePago = new PaymentGateway();
    private Descuento descuento = new Descuento();
    private int fecha;
    
    
    public Home (Descuento descuento, int fecha)
    {
    	this.descuento = descuento;
    	this.fecha = fecha;
    }
    
	public int getFecha() {
		return fecha;
	}


	public void setFecha(int fecha) {
		this.fecha = fecha;
	}


	public void addNoche(Noche noche) {
		this.noches.add(noche);
	}
	

	public void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	

	public PaymentGateway getPlataformaDePago() {
		return plataformaDePago;
	}
	

	public void setPlataformaDePago(PaymentGateway plataformaDePago) {
		this.plataformaDePago = plataformaDePago;
	}
	
	
	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}
	

	public int comprarEntrada(Cliente cliente, Entrada entrada, String tipoPago)
	{	
		int precioFinal = 0;	
		
		if (!entrada.isVendida())
		{					
			precioFinal = calcularPrecioFinal(cliente, entrada);
			
			//TODO Hacer objeto polimorfico tipo de pago
			if (tipoPago == "Tarjeta")
			{
				if (plataformaDePago.procesarPago(precioFinal, cliente))
				{
					cliente.agregarEntrada(entrada);
					entrada.estasVendida(cliente, fecha);
				}
				else
				{
					System.out.println ("No se pudo realizar la compra"); //TODO Quitar interacción con el usuario
				}
			}
			else
			{
				cliente.agregarEntrada(entrada);
				entrada.estasVendida(cliente, fecha);
			}
		}
		
		return precioFinal;
	}
	
	
	public int comprarCombo(Cliente cliente, ArrayList<Entrada> entradas, String tipoPago)
	{
		int precioCombo = 0;
		int precioFinal = 0;
		
		Entrada entradaAux;
		
		while (entradas.size() != 0)
		{			
			entradaAux = entradas.remove(0);
			
			if (entradaAux.isVip())
			{
				precioCombo += comprarEntradaVip(cliente, entradaAux, tipoPago);
			}
			else
			{
				precioCombo += comprarEntrada(cliente, entradaAux, tipoPago);
			}		
		}
		
		precioFinal = calcularPrecioFinalCombo(precioCombo);
		
		return precioFinal;
	}
	
	
	public int comprarEntradaVip(Cliente cliente, Entrada entrada, String tipoPago)
	{
		int precioFinal = 0;
		int recargo = 0;
		
		Entrada entradaAux;
		
		if (!entrada.isVendida())
		{
			for(Noche nocheAux:noches)
			{
				entradaAux = nocheAux.buscarEntradaPorUbicacion(entrada.getUbicacion());
				
				recargo = entradaAux.getPrecio() * 50 / 100;
				precioFinal += calcularPrecioFinal(cliente, entradaAux) + recargo;
				
				if (tipoPago == "Tarjeta")
				{
					if (plataformaDePago.procesarPago(precioFinal, cliente))
					{
						cliente.agregarEntrada(entrada);
						entrada.estasVendida(cliente, fecha);
					}
					else
					{
						System.out.println ("No se pudo realizar la compra");
					}	
				}
				else
				{
					cliente.agregarEntrada(entrada);
					entrada.estasVendida(cliente, fecha);
				}
			}
			
			return precioFinal;	
		}
		
		return -1;
	}
	
	
	private int calcularPrecioFinal(Cliente cliente, Entrada entrada)
	{
		int precioTotal = entrada.getPrecio();
		int descuentoTotal = descuento.calcularDescuentoTotal(cliente, entrada, fecha);
		int precioFinal = precioTotal - descuentoTotal;
		
		return precioFinal;
	}
	
	
	private int calcularPrecioFinalCombo(int precioCombo)
	{
		int descuentoCombo = descuento.calcularDescuentoCombo(precioCombo); 
		int precioFinal = precioCombo - descuentoCombo;
		
		return precioFinal;
	}	
	
}
