package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("C")
public class Compleja extends Complejidad{
		
	public double tiempoExtraAtraso;

	public Compleja() {		
		this.tasaDeAtraso = 0.2;
		this.tiempoExtraAtraso= 8;
	}

	@Override
	public double getCostoComplejidad(double tiempo) {
		//si tiempo es menor o igual a 10 d�as --> tiempo * $25 + 7%
	    if (tiempo <= 10)
			return (tiempo * 25) + ((tiempo * 25) * 0.07);
		else
		//si tiempo es mayor a 10 d�as --> (tiempo * $25) + 7% + $10 por cada d�a despu�s del d�cimo
			return (tiempo * 25) + ((tiempo * 25) * 0.07 + ((tiempo - 10) * 10));
	    
	}
	
	public double getTasaDeAtraso(double tiempo) {
		return ((tiempo*tasaDeAtraso) + tiempoExtraAtraso);
	}
}
