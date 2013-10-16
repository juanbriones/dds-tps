package comprarEntradas.ui;

import java.io.Serializable;
import java.util.List;

import org.uqbar.commons.utils.Observable;
import org.uqbar.edu.paiu.examples.celulares.dao.RepositorioCelulares;
import org.uqbar.edu.paiu.examples.celulares.domain.Celular;

import comprarEntradas.Entrada;
import comprarEntradas.ui.*;

public class VentaDeEntradas implements Serializable {
	
	//private int noche
	private char sector;
    private int fila;
    private int butaca;
	private List<Entrada> resultados;
	private Entrada entradaSeleccionada;

	// ********************************************************
	// ** Acciones
	// ********************************************************

	public void search() 
	{
		this.resultados = RepositorioEntradas.getInstance().search(this.sector, this.fila);
	}

	public void clear() 
	{
		this.sector = null;
		this.fila = null;
	}

	public void eliminarCelularSeleccionado() {
		RepositorioCelulares.getInstance().delete(this.getCelularSeleccionado());
		this.search();
		this.celularSeleccionado = null;
	}

	// ********************************************************
	// ** Accessors
	// ********************************************************

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Celular getCelularSeleccionado() {
		return this.celularSeleccionado;
	}

	public void setCelularSeleccionado(Celular celularSeleccionado) {
		this.celularSeleccionado = celularSeleccionado;
	}

	public List<Celular> getResultados() {
		return this.resultados;
	}

	public void setResultados(List<Celular> resultados) {
		this.resultados = resultados;
	}

}
