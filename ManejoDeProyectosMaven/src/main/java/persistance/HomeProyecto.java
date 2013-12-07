package persistance;

import static persistance.ModelManager.getManager;

import java.util.List;

import model.Proyecto;
import model.Tarea;


public class HomeProyecto {
		
	public void save(Proyecto proyecto) {
		getManager().persist(proyecto);
	}

	/*
	public List<Proyecto> proyectos() {
		return getManager().createQuery("from Proyecto").getResultList();
	}

	public List<Tarea> all() {
		return getManager().createQuery("from Tarea").getResultList();
	}
*/

}
