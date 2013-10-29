package comprarEntradas.domain;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Cliente {	
	
	public TarjetaCredito tarjeta;
	public Collection<Entrada> entradas = new ArrayList<Entrada>();
	private char[] nombre;
	private char[] apellido;
	private int edad;
	
	
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


	public char[] getNombre() {
		return nombre;
	}


	public void setNombre(char[] nombre) {
		this.nombre = nombre;
	}


	public char[] getApellido() {
		return apellido;
	}


	public void setApellido(char[] apellido) {
		this.apellido = apellido;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}

}
