package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("M")
public class Media extends Complejidad{
	
	public Media() {
		this.tasaDeAtraso = 0.1;
	}

	@Override
	public double getCostoComplejidad(double tiempo) {
		
		double valor = (tiempo * 25) + ((tiempo * 25) * 0.05);
		//tiempo * $25 + 5% de lo anterior
	    return valor;
	}
	
	public double getTasaDeAtraso(double tiempo) {
		return (tiempo*tasaDeAtraso);
	}
}
