package comprarEntradas.domain;

import java.util.*;

public class Noche {
	
	private Collection<Entrada> entradas = new ArrayList<Entrada>();
	private Collection<Banda> bandas = new ArrayList<Banda>();
	private int nroNoche;
	private Long fechaInicio;
	
	
	public Noche(Collection<Entrada> entradas, Collection<Banda> bandas, Long fechaInicio) {
		this.entradas = entradas;
		this.bandas = bandas;
		this.fechaInicio = fechaInicio;
	}
	

	public Noche(int nroNoche, Collection<Banda> bandas, Long fechaInicio) {		
		this.nroNoche = nroNoche;
		this.bandas = bandas;
		this.fechaInicio = fechaInicio;
	}
	
	
	public Collection<Entrada> getEntradas() {
		return entradas;
	}
	

    public void setEntradas(Collection<Entrada> entradas) {
		this.entradas = entradas;
	}
    

    public Collection<Banda> getBandas() {
		return bandas;
	}
    

    public void setBandas(Collection<Banda> bandas) {
		this.bandas = bandas;
	}

    
    public Long getFechaInicio() {
		return fechaInicio;
	}

    
    public void setFechaInicio(Long fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
    
    
	public int getNroNoche() {
		return nroNoche;
	}


	public void setNroNoche(int nroNoche) {
		this.nroNoche = nroNoche;
	}
    

	public Entrada seleccionarEntrada(int idEntrada) 
	{
		for (Entrada entrada:entradas)
		{
			if (entrada.getIdEntrada() == idEntrada)
				 return entrada;
		}
		
		return null;
	}
	

	public int precioExtra() 
	{
		int precioExtra = this.obtenerMejorBandaCategoria().valorCategoria();
		
		return precioExtra;
	}

	
	public Banda obtenerMejorBandaCategoria() 
	{
		Banda bandaMax = new Banda("aux", new Categoria(0,0));
		
		for(Banda banda:bandas)
		{
			if(banda.nroCategoria() > bandaMax.nroCategoria())
			bandaMax = banda;
		}
		
		return bandaMax;
	}

	
	public Collection<Entrada> entradasDisponibles()
	{
		Collection<Entrada> entradasAux = new ArrayList<Entrada>();
		
		for (Entrada entrada:entradas)
		{
			if (!entrada.isVendida())
			{
				entradasAux.add(entrada);
			}
		}
		
		return entradasAux;
	}
	
	
	public Entrada buscarEntradaPorUbicacion(Ubicacion ubicacion)
	{
		for (Entrada entradaAux:entradas)
		{
			if (entradaAux.getUbicacion().equals(ubicacion))
			{
				return entradaAux;
			}
		}
		
		return null;
	}

	
    /*public void listarLocalidades()
    {
	    int i = 0;
	    System.out.println("Entradas disponibles: ");
	    Collection <Entrada> entradasDisponibles = entradasDisponibles();
	    
	    for(Entrada entrada : entradasDisponibles)
     	{
	    	System.out.println("Entrada nro: "+ i +" Nro. Sector: "+ entrada.getUbicacion().getSector()+" Nro. Fila: "+entrada.getUbicacion().getNroFila()+" Nro. Silla "+entrada.getUbicacion().getButaca());
			i++;
     	}
    }*/
	
}
