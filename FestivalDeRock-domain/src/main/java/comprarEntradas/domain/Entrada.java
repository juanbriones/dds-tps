package comprarEntradas.domain;

import org.uqbar.commons.utils.Observable;


@Observable
public class Entrada {
	
	private int idEntrada;
	private boolean vendida;
	private boolean vip;
	private int precioBase;
	private int fechaVenta;
	private Cliente cliente;
	private Noche noche;
	private Ubicacion ubicacion;
	
	
	public Entrada() {
		
	}
	
    public Entrada(int idEntrada, boolean vip, Ubicacion ubicacion, Noche noche) {
		this.idEntrada = idEntrada;
		this.vendida = false;
		this.vip = vip;
		this.precioBase = ubicacion.getPrecio();
		this.noche = noche;
		this.ubicacion = ubicacion;
	}
	
	public Entrada(int idEntrada, boolean vip, Ubicacion ubicacion) {
		this.idEntrada = idEntrada;
		this.vendida = false;
		this.vip = vip;
		this.precioBase = ubicacion.getPrecio();
		this.ubicacion = ubicacion;
	}
	
	public int getIdEntrada() {
		return idEntrada;
	}

    public void setIdEntrada(int idEntrada) {
    	this.idEntrada = idEntrada;
    }
    
    public void setVendida(boolean vendida) {
    	this.vendida = vendida;
    }
        
    public boolean isVendida() {
    	return vendida;	
    }
        
    public boolean isVip() {
    	return vip;
    }
    
    public void setVip(boolean vip) {
    	this.vip = vip;
    }
        
    public Cliente getCliente() {
    	return cliente;
    }
    
    public void setCliente(Cliente cliente) {
    	this.cliente = cliente;
    }
   
    public int getPrecioBase() {
    	return precioBase;
    }
      
    public void setPrecioBase(int precioBase) {
    	this.precioBase = precioBase;
    }
       
    public Ubicacion getUbicacion() {
    	return ubicacion;
    }
       
    public void setUbicacion(Ubicacion ubicacion) {
    	this.ubicacion = ubicacion;
    }
        
    public Noche getNoche() {
    	return noche;
    }
       
    public void setNoche(Noche noche) {
    	this.noche = noche;
    } 
   
	public int getFechaVenta() {
		return fechaVenta;
	}
	
	public void setFechaVenta(int fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	public void estasVendida(Cliente cliente, int fechaVenta) {
		this.vendida = true;
		this.cliente = cliente;
		this.fechaVenta = fechaVenta;
    }
	
	public int getPrecio() {		
		int precioExtra = noche.precioExtra();
	    int precioTotal = this.precioBase + precioExtra;
	    
	    return precioTotal;
	}
	
	public char getSector(){
		return this.getUbicacion().getSector();
	}
	
	public int getFila(){
		return this.getUbicacion().getFila();
	}
	
	public int getButaca(){
		return this.getUbicacion().getButaca();
	}
}
