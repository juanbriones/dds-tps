package persistance;

import static persistance.ModelManager.getManager;

import java.util.List;

import javax.persistence.Query;

import model.Tarea;

public class HomeTarea {
	
	public void save(Tarea tarea) {
		getManager().persist(tarea);
	}

	/*
	public List<Tarea> all() {
		Query query = getManager().createQuery("from " + Tarea.class.getSimpleName());
		return query.getResultList();
	}*/
	
}



