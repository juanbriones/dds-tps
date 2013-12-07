package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@DiscriminatorValue("C")
public class TareaCompuesta extends Tarea{
	
	private double valorOver = 0.04;
	
	private double tiempoPermitidoAtraso;
		
	//@ManyToOne(cascade={CascadeType.ALL})    
    //private Tarea tarea_padre;
 
    @OneToMany//(mappedBy="tarea_padre")
    @JoinColumn(name="tarea_padre_id")
    private Collection<Tarea> subTareas = new ArrayList<Tarea>();
	
	
	public TareaCompuesta(Collection<Tarea> tareas, double tiempo) {
		this.subTareas = tareas;
		
		if (tiempo >= getTiempoSubtareas())
		  this.tiempo = tiempo;
		else
		  this.tiempo = getTiempoSubtareas();
		
	}
	
	public double getTiempoSubtareas(){
		double tiempoSub = 0;
		for (Tarea subTarea:subTareas)
		{				
			tiempoSub = tiempoSub + subTarea.getTiempo();
		}
		return tiempoSub;
	}
	
	public double getCostoTarea() {	
		double costoTotal = 0;
		for (Tarea subTarea:subTareas)
		{				
			costoTotal = costoTotal + subTarea.getCostoTarea();
		}
		return (costoTotal + costoTotal *valorOver);		
	}
	
	//@Override
	public double getOverHead() {
		
		if (subTareas.size() > 3)
		    return valorOver;
		else 
			return 0;
	}

	public double getValorOver() {
		return valorOver;
	}

	public void setValorOver(double valorOver) {
		this.valorOver = valorOver;
	}

	public Collection<Tarea> getSubTareas() {
		return subTareas;
	}

	public void setSubTareas(Collection<Tarea> subTareas) {
		this.subTareas = subTareas;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public double getTiempoPermitidoAtraso() {
		for (Tarea subTarea:subTareas)
		{
			tiempoPermitidoAtraso = tiempoPermitidoAtraso + subTarea.complejidad.getTasaDeAtraso(tiempo);
		}
		
		return tiempoPermitidoAtraso;
	}

	public void setTiempoPermitidoAtraso(double tiempoPermitidoAtraso) {
		this.tiempoPermitidoAtraso = tiempoPermitidoAtraso;
	}

}
