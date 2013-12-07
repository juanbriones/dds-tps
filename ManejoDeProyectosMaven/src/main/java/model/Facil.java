package model;

import javax.persistence.*;


@Entity
@DiscriminatorValue("F")
public class Facil extends Complejidad{
	
    private int costo;
	
	public Facil() {
		super();
		this.tasaDeAtraso = 5;
		this.costo = 3;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	@Override
	public double getCostoComplejidad(double tiempo) {
		//tiempo * $25 
		return  (tiempo * 25);
	}
	
	public double getTasaDeAtraso(double tiempo) {
		return (tiempo + tasaDeAtraso);
	}
}
