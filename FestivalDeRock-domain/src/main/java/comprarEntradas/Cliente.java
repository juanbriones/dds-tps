package comprarEntradas;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Cliente {	
	
	public TarjetaCredito tarjeta;
	public Collection<Entrada> entradas = new ArrayList<Entrada>();
	
	
	public TarjetaCredito getTarjeta() {
		return tarjeta;
	}

	
	public void setTarjeta(TarjetaCredito tarjeta) {
		this.tarjeta = tarjeta;
	}


	public Collection<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(Collection<Entrada> entradas) {
		this.entradas = entradas;
	}
	
    
    public void agregarEntrada(Entrada entrada) {
		entradas.add(entrada);	
	}
    
	
	public int calcularDescuentoCliente(Entrada entrada) {
		return 0;
	}
	
	
	public boolean isDama() {
		return false;
	}

}
