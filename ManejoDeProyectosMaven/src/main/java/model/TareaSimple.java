package model;

import java.util.Collection;

import javax.persistence.*;

@Entity
@DiscriminatorValue("S")
public class TareaSimple extends Tarea{

	
	public TareaSimple(Complejidad complejidad, Collection<Impuesto> impuestos, int tiempo) {
		super(complejidad, impuestos, tiempo);
	}

	
	@Override
	public double getOverHead() {
		return 0;
	}


	public Complejidad getComplejidad() {
		return this.complejidad;
	}


	public void setComplejidad(Complejidad complejidad) {
		this.complejidad = complejidad;
	}


	public Collection<Impuesto> getImpuestos() {
		return impuestos;
	}


	public void setImpuestos(Collection<Impuesto> impuestos) {
		this.impuestos = impuestos;
	}


	public double getTiempoPermitidoAtraso() {
		return this.complejidad.getTasaDeAtraso(tiempo);
		//return tiempoPermitidoAtraso;
	}


	public void setTiempoPermitidoAtraso(double tiempoPermitidoAtraso) {
		this.tiempoPermitidoAtraso = tiempoPermitidoAtraso;
	}

}
