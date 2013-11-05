package comprarEntradas.ui;

import java.io.Serializable;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import comprarEntradas.repositorio.Repositorio;
import comprarEntradas.domain.Banda;

@SuppressWarnings("serial")
@Observable
public class BuscadorBandas implements Serializable {
	
    private String nombreBanda;
	private List<Banda> resultados;
	
	// ********************************************************
	// ** ACCIONES
	// ********************************************************

	public void searchBandas(){
		this.resultados = Repositorio.getInstance().searchBandas(this.nombreBanda);
	}

	public void clear() {
		this.nombreBanda = null;
	}

	// ********************************************************
	// ** ACCESSORS
	// ********************************************************


	public String getNombreBanda() {
		return nombreBanda;
	}

	public void setNombreBanda(String nombreBanda) {
		this.nombreBanda = nombreBanda;
	}

	public List<Banda> getResultados() {
		return resultados;
	}

	public void setResultados(List<Banda> resultados) {
		this.resultados = resultados;
	}
}