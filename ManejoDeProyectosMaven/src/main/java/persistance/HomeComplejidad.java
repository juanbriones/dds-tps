package persistance;

import static persistance.ModelManager.getManager;

import java.util.List;

import javax.persistence.Query;

import model.Complejidad;;

public class HomeComplejidad {
	
	public void save(Complejidad complejidad) {
		getManager().persist(complejidad);
	}
/*
	public List<Tarea> all() {
		Query query = getManager().createQuery("from " + Tarea.class.getSimpleName());
		return query.getResultList();
	}*/
	
}

