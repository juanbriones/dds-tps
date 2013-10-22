package comprarEntradas.domain;

import java.util.*;

public class Dama extends Cliente {
	
	private static int porcentaje = 20;
	private static double porcentajeEntradas = 0.20;
	
	
	@Override
	public boolean isDama() {
		return true;
	}
		
	@Override
	public int calcularDescuentoCliente(Entrada entrada)
	{
		Collection <Entrada> entradasDamas = new ArrayList<Entrada>();
		Collection <Entrada> entradasDeLaNoche = entrada.getNoche().getEntradas();
		
		for (Entrada entradaAux:entradasDeLaNoche){
		if(entradaAux.isVendida() && entradaAux.getCliente().isDama())
			entradasDamas.add(entradaAux);
		}
		
		int cantEntradasDamas = entradasDamas.size();
		
		if ((cantEntradasDamas / entrada.getNoche().getEntradas().size()) < porcentajeEntradas)
		{
			return entrada.getPrecio() * porcentaje / 100;
		}
		else
		{
			return 0;
		}
	}
	
}
