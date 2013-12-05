package comprarEntradas.domain;

import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;

@Observable
@Transactional
public class Ubicacion {
	
	private Character sector;
    private Integer fila;
    private Integer butaca;
    private Integer precio;

    
	public Ubicacion(Character sector, Integer fila, Integer butaca, Integer precio) {
		this.sector = sector;
		this.fila = fila;
		this.butaca = butaca;
		this.precio = precio;
	}
    
	
	public Character getSector() {
		return sector;
	}

	
	public void setSector(Character sector) {
		this.sector = sector;
	}

	
	public Integer getFila() {
		return fila;
	}

	
	public void setFila(Integer fila) {
		this.fila = fila;
	}

	
	public Integer getButaca() {
		return butaca;
	}

	
	public void setButaca(Integer butaca) {
		this.butaca = butaca;
	}

	
	public Integer getPrecio() {
		return precio;
	}

	
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	
	/*public void generarIdEntrada(Entrada entrada)
	{
		entrada.setIdEntrada((Integer) this.sector * 10000 + this.fila * 100 + this.butaca); //Falta numero de noche
	}*/

}