package comprarEntradas.repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import comprarEntradas.domain.*;
	

@Observable
public class RepositorioEntradas implements Serializable {
	private static RepositorioEntradas instance;
	private List<Entrada> data = new ArrayList<Entrada>();

	public static synchronized RepositorioEntradas getInstance() {
		if (instance == null) {
			instance = new RepositorioEntradas();
		}
		return instance;
	}

	private RepositorioEntradas() {
		Banda banda1 = new Banda("Banda 1",new Categoria(1, 50));
		Banda banda2 = new Banda("Banda 2",new Categoria(2, 100));
		Banda banda3 = new Banda("Banda 3",new Categoria(3, 150));
		Banda banda4 = new Banda("Banda 4",new Categoria(2, 100));
		Banda banda5 = new Banda("Banda 5",new Categoria(4, 200));

		Collection<Banda> bandas1 = new ArrayList<Banda>();
		bandas1.add(banda1);
		bandas1.add(banda2);
		bandas1.add(banda3);

		Collection<Banda> bandas2 = new ArrayList<Banda>();
		bandas2.add(banda4);
		bandas2.add(banda5);

		Noche noche1 = new Noche(bandas1, 20130810);
		Noche noche2 = new Noche(bandas2, 20130815);

		Ubicacion ubicacion1 = new Ubicacion('A', 1, 1, 100);
		Ubicacion ubicacion2 = new Ubicacion('B', 2, 2, 200);
		Ubicacion ubicacion3 = new Ubicacion('C', 3, 3, 300);
		Ubicacion ubicacion4 = new Ubicacion('D', 4, 4, 400);
		
		this.create(new Entrada(1, false, ubicacion1, noche1));
		this.create(new Entrada(2, false, ubicacion2, noche1));
		this.create(new Entrada(3, true, ubicacion3, noche1));
		this.create(new Entrada(4, true, ubicacion4, noche1));
		this.create(new Entrada(5, false, ubicacion1, noche2));
		this.create(new Entrada(6, false, ubicacion2, noche2));
		this.create(new Entrada(7, true, ubicacion3, noche2));
		this.create(new Entrada(8, true, ubicacion4, noche2));
	}
	
	// ********************************************************
	// ** ALTAS Y BAJAS
	// ********************************************************
	
	public void create(Entrada entrada) {
		this.data.add(entrada);
	}

	public void delete(Entrada entrada) {
		this.data.remove(entrada);
	}

	// ********************************************************
	// ** BUSQUEDAS
	// ********************************************************

	public List<Entrada> searchSector(Character sector) {
		return this.search(sector, null, null);
	}

	public List<Entrada> searchFila(Integer fila) {
		return this.search(null, fila, null);
	}
	
	public List<Entrada> searchButaca(Integer butaca) {
		return this.search(null, null, butaca);
	}
	
	public List<Entrada> searchSectorFila(Character sector,Integer fila) {
		return this.search(sector, fila, null);
	}
	
	public List<Entrada> searchSectorButaca(Character sector, Integer butaca) {
		return this.search(sector, null, butaca);
	}
	
	public List<Entrada> searchFilaButaca(Integer fila, Integer butaca) {
		return this.search(null, fila, butaca);
	}
	
	public List<Entrada> search(Character sector, Integer fila, Integer butaca) {
		List<Entrada> resultados = new ArrayList<Entrada>();

		for (Entrada entrada : this.data) 
		{
			if (match(sector, entrada.getSector()) && match(fila, entrada.getFila()) && match(butaca, entrada.getButaca())) {
				resultados.add(entrada);
			}
		}

		return resultados;
	}

	protected boolean match(Object expectedValue, Object realValue) {
		return expectedValue == null || realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase());
	}
}