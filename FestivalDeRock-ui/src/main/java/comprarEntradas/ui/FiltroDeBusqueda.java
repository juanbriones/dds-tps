package comprarEntradas.ui;

import java.util.ArrayList;
import java.util.List;

import comprarEntradas.domain.*;


public class FiltroDeBusqueda {

	Noche noche;
	Ubicacion ubicacion;
	String nombreCliente;
	String apellidoCliente;
	Integer fechaDesde;
	Integer fechaHasta;
	Integer numeroPuestoDeVenta;
	String festivalID;
	
	
	public Noche getNoche() {
		return noche;
	}
	
	public void setNoche(Noche noche) {
		this.noche = noche;
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	
	public Integer getFechaDesde() {
		return fechaDesde;
	}
	
	public void setFechaDesde(Integer fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	
	public Integer getFechaHasta() {
		return fechaHasta;
	}
	
	public void setFechaHasta(Integer fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
	public Integer getNumeroPuestoDeVenta() {
		return numeroPuestoDeVenta;
	}
	
	public void setNumeroPuestoDeVenta(Integer numeroPuestoDeVenta) {
		this.numeroPuestoDeVenta = numeroPuestoDeVenta;
	}
	
	public String getFestivalID() {
		return festivalID;
	}
	
	public void setFestivalID(String festivalID) {
		this.festivalID = festivalID;
	}
	
}
