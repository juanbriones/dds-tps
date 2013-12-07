package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;


@Entity
public class Proyecto {
	
	@Id
	@GeneratedValue
	@Column(name = "proyect_id")
	protected int id;
	
	@OneToMany
	public Collection<Tarea> tareas = new ArrayList<Tarea>();
	
	public Proyecto(Collection<Tarea> tareas)
	{
		this.tareas = tareas;
	}
	
	
	public Collection<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(Collection<Tarea> tareas) {
		this.tareas = tareas;
	}

	public double getCostoTotal() {
		double costoTotal = 0;
		for (Tarea tarea:tareas)
		{				
			costoTotal = costoTotal + tarea.getCostoTarea();
		}
		return costoTotal;
	}
	
	public double getTiempoTotal() {
		double tiempoTotal = 0;
		for (Tarea tarea:tareas)
		{
			tiempoTotal = tiempoTotal + tarea.getTiempo();
		}
		return tiempoTotal;
	}
	
	public double obtenerDiasMaximoDeAtraso(){
		double atraso = 0;
		for (Tarea tarea:tareas)
		{
			atraso = atraso + tarea.getTiempoPermitidoAtraso();
		}
		return atraso;
	}
}
