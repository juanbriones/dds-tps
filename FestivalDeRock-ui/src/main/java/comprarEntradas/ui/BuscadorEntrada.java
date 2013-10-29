package comprarEntradas.ui;

import java.io.Serializable;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import comprarEntradas.repositorio.RepositorioEntradas;
import comprarEntradas.domain.Entrada;


@SuppressWarnings("serial")
@Observable
public class BuscadorEntrada implements Serializable {
	
	private Integer nroNoche;
	private Character sector;
    private Integer fila;
    private Integer butaca;
	private List<Entrada> resultados;
	private Entrada entradaSeleccionada;

	
	// ********************************************************
	// ** ACCIONES
	// ********************************************************

	public void search() {
		this.resultados = RepositorioEntradas.getInstance().search(this.nroNoche,this.sector, this.fila, this.butaca);
	}

	public void clear() {
		this.nroNoche = null;
		this.sector = null;
		this.fila = null;
		this.butaca = null;
	}

	// ********************************************************
	// ** ACCESSORS
	// ********************************************************

	public Integer getNroNoche() {
		return this.nroNoche;
	}

	public void setNroNoche(Integer nroNoche) {
		this.nroNoche = nroNoche;
	}
	
	public Character getSector() {
		return this.sector;
	}

	public void setSector(Character sector) {
		this.sector = sector;
	}

	public Integer getFila() {
		return this.fila;
	}

	public void setFila(Integer fila) {
		this.fila = fila;
	}
	
	public Integer getButaca() {
		return this.butaca;
	}

	public void setButaca(Integer butaca) {
		this.butaca = butaca;
	}

	public Entrada getEntradaSeleccionada() {
		return this.entradaSeleccionada;
	}

	public void setEntradaSeleccionada(Entrada entradaSeleccionada) {
		this.entradaSeleccionada = entradaSeleccionada;
	}

	public List<Entrada> getResultados() {
		return this.resultados;
	}

	public void setResultados(List<Entrada> resultados) {
		this.resultados = resultados;
	}
}
