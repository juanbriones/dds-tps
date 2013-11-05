package comprarEntradas.repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import comprarEntradas.domain.*;
	

@SuppressWarnings("serial")
@Observable
public class Repositorio implements Serializable {
	private static Repositorio instance;
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Banda> bandas = new ArrayList<Banda>();
	private List<Noche> noches = new ArrayList<Noche>();
	private List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
	private List<Entrada> entradas = new ArrayList<Entrada>();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	
	public static synchronized Repositorio getInstance() {
		if (instance == null) {
			instance = new Repositorio();
		}
		return instance;
	}

	private Repositorio() {
		
		Categoria categoria1 = new Categoria(1,50);
		Categoria categoria2 = new Categoria(2,100);
		Categoria categoria3 = new Categoria(3,150);
		Categoria categoria4 = new Categoria(4,200);
		
		categorias.add(categoria1);
		categorias.add(categoria2);
		categorias.add(categoria3);
		categorias.add(categoria4);
		
		Banda banda1 = new Banda("Banda 1",categoria1);
		Banda banda2 = new Banda("Banda 2",categoria2);
		Banda banda3 = new Banda("Banda 3",categoria3);
		Banda banda4 = new Banda("Banda 4",categoria2);
		Banda banda5 = new Banda("Banda 5",categoria4);

		bandas.add(banda1);
		bandas.add(banda2);
		bandas.add(banda3);
		bandas.add(banda4);
		bandas.add(banda5);
		
		Collection<Banda> bandas1 = new ArrayList<Banda>();
		bandas1.add(banda1);
		bandas1.add(banda2);
		bandas1.add(banda3);

		Collection<Banda> bandas2 = new ArrayList<Banda>();
		bandas2.add(banda4);
		bandas2.add(banda5);

		Noche noche1 = new Noche(1,bandas1, (long) 20130810);
		Noche noche2 = new Noche(2,bandas2, (long) 20130815);
		
		noches.add(noche1);
		noches.add(noche2);

		Ubicacion ubicacion1 = new Ubicacion('A', 1, 1, 100);
		Ubicacion ubicacion2 = new Ubicacion('B', 2, 2, 200);
		Ubicacion ubicacion3 = new Ubicacion('C', 3, 3, 300);
		Ubicacion ubicacion4 = new Ubicacion('D', 4, 4, 400);
		
		ubicaciones.add(ubicacion1);
		ubicaciones.add(ubicacion2);
		ubicaciones.add(ubicacion3);
		ubicaciones.add(ubicacion4);
		
		Entrada entrada1 = new Entrada(1, false, ubicacion1, noche1);
		Entrada entrada2 = new Entrada(2, false, ubicacion2, noche1);
		Entrada entrada3 = new Entrada(3, true, ubicacion3, noche1);
		Entrada entrada4 = new Entrada(4, true, ubicacion4, noche1);
		Entrada entrada5 = new Entrada(5, false, ubicacion1, noche2);
		Entrada entrada6 = new Entrada(6, false, ubicacion2, noche2);
		Entrada entrada7 = new Entrada(7, true, ubicacion3, noche2);
		Entrada entrada8 = new Entrada(8, true, ubicacion4, noche2);
		
//		entrada1.setCliente(new Cliente());
//		entrada2.setCliente(new Cliente());
//		entrada3.setCliente(new Cliente());
//		entrada4.setCliente(new Cliente());
//		entrada5.setCliente(new Cliente());
//		entrada6.setCliente(new Cliente());
//		entrada7.setCliente(new Cliente());
//		entrada8.setCliente(new Cliente());
		
		entradas.add(entrada1);
		entradas.add(entrada2);
		entradas.add(entrada3);
		entradas.add(entrada4);
		entradas.add(entrada5);
		entradas.add(entrada6);
		entradas.add(entrada7);
		entradas.add(entrada8);
		
		Collection<Entrada> entradas1 = new ArrayList<Entrada>();
		entradas1.add(entrada1);
		entradas1.add(entrada2);
		entradas1.add(entrada3);
		entradas1.add(entrada4);
		
		Collection<Entrada> entradas2 = new ArrayList<Entrada>();
		entradas2.add(entrada5);
		entradas2.add(entrada6);
		entradas2.add(entrada7);
		entradas2.add(entrada8);
		
		noche1.setEntradas(entradas1);
		noche2.setEntradas(entradas2);
		
//		Cliente cliente1 = new Menor18("nombre1", "apellido1", 15);
//		Cliente cliente2 = new Mayor18("nombre2", "apellido2", 20);
//		Cliente cliente3 = new Jubilado("nombre3", "apellido3", 60);
//		
//		clientes.add(cliente1);
//		clientes.add(cliente2);
//		clientes.add(cliente3);	
	}
	
	// ********************************************************
	// ** ALTAS Y BAJAS
	// ********************************************************
	
	public void create(Banda banda) {
		this.bandas.add(banda);
	}

	public void delete(Banda banda) {
		this.bandas.remove(banda);
	}
	
	public void create(Noche noche) {
		this.noches.add(noche);
	}

	public void delete(Noche noche) {
		this.noches.remove(noche);
	}
	
	public void create(Ubicacion ubicacion) {
		this.ubicaciones.add(ubicacion);
	}

	public void delete(Ubicacion ubicacion) {
		this.ubicaciones.remove(ubicacion);
	}
	
	public void create(Entrada entrada) {
		this.entradas.add(entrada);
	}

	public void delete(Entrada entrada) {
		this.entradas.remove(entrada);
	}
	
	public void create(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public void delete(Cliente cliente) {
		this.clientes.remove(cliente);
	}

	// ********************************************************
	// ** BUSQUEDAS
	// ********************************************************
	
	public List<Entrada> searchDisponibles(Integer nroNoche, Character sector, Integer fila, Integer butaca) {
		List<Entrada> resultados = new ArrayList<Entrada>();

		for (Entrada entrada : this.entradas) 
		{
			if (match(nroNoche, entrada.getNroNoche()) 
					&& match(sector, entrada.getSector()) 
					&& match(fila, entrada.getFila()) 
					&& match(butaca, entrada.getButaca())) {
				resultados.add(entrada);
			}
		}

		return resultados;
	}
	
	public List<Entrada> searchOcupadas(Integer nroNoche, Character sector, Integer fila, Integer butaca, boolean estasVendida, String nombreCliente, String apellidoCliente, Long fechaInicio) {
		List<Entrada> resultados = new ArrayList<Entrada>();

		for (Entrada entrada : this.entradas) 
		{
			if (match(nroNoche, entrada.getNroNoche()) 
					&& match(sector, entrada.getSector()) 
					&& match(fila, entrada.getFila()) 
					&& match(butaca, entrada.getButaca()) 
					&& match(estasVendida, entrada.isVendida())
					&& match(nombreCliente, entrada.getNombreCliente())
					&& match(apellidoCliente, entrada.getApellidoCliente())
					&& (fechaInicio >= entrada.getFechaInicio())) {
				resultados.add(entrada);
			}
		}

		return resultados;
	}

	protected boolean match(Object expectedValue, Object realValue) {
		return expectedValue == null || realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase());
	}
}