package model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="complejidadTipo")
public class Complejidad {

	@Id
	@GeneratedValue
	@Column(name = "complejidad_id")
	protected int id;
	
	protected double tasaDeAtraso;
	protected double precio;
	
	public Complejidad() {	
	}
	
	public Complejidad(double tasaDeAtraso){

	    this.tasaDeAtraso = tasaDeAtraso;
	}
	
	public double getTasaDeAtraso(double tiempo) {
		return tasaDeAtraso;
	}

	public void setTasaDeAtraso(double tasaDeAtraso) {
		this.tasaDeAtraso = tasaDeAtraso;
	}

	
	public double getCostoComplejidad(double tiempo) {
		return 0;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
