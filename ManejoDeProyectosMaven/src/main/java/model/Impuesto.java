package model;

import javax.persistence.*;

@Entity
public class Impuesto {
	
	@Id
	@GeneratedValue
	@Column(name = "impuesto_id")
	protected int id;
	
	private double porcentaje;
	private char tipo; //A o B
	
	public Impuesto (){
		
	}
	
	public Impuesto (double porcentaje, char tipo) {
		this.porcentaje = porcentaje;
		this.tipo =  tipo;
	}
	
	
	public double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	

}
