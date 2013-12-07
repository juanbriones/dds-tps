package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TipoTarea")
public abstract class Tarea {
	
	@Id
	@GeneratedValue
	@Column(name = "tarea_id")
	protected int id;
	
	public double tiempo;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	public Complejidad complejidad;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "tarea_fk")
	public Collection<Impuesto> impuestos = new ArrayList<Impuesto>();
	
	public double tiempoPermitidoAtraso;
	
	public Tarea(Complejidad complejidad, Collection<Impuesto> impuestos, double tiempo) {		
		this.complejidad = complejidad;
		this.impuestos = impuestos;
		this.tiempo = tiempo;		
	}
	
	public Tarea(){
		
	}
	
	
	public abstract double getOverHead();
		
	public double getCostoTarea() {
		//calculo el costo de una tarea sumando el costo por complejidad con el costo impositivo
		double costoComplejidad = complejidad.getCostoComplejidad(tiempo); 
		double costoDeImpuesto = calculoCostoImpuesto(costoComplejidad);
		return (costoComplejidad + costoDeImpuesto);
	}
	    
	public double calculoCostoImpuesto(double valor){
		double calAux=0;
		for (Impuesto impuesto:impuestos)
		{				
			calAux = calAux + impuesto.getPorcentaje();
		}
		return (valor *(calAux/100));
	}
	
	public double getTiempoTarea(){
		return this.tiempo;
	}


	public double getTiempo() {
		return tiempo;
	}


	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}


	public Complejidad getComplejidad() {
		return complejidad;
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
		setTiempoPermitidoAtraso(complejidad.getTasaDeAtraso(tiempo));
		return tiempoPermitidoAtraso;
	}


	public void setTiempoPermitidoAtraso(double tiempoPermitidoAtraso) {
		this.tiempoPermitidoAtraso = tiempoPermitidoAtraso;
	}
	
}
