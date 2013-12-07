package persistance;

import static persistance.ModelManager.getManager;

import java.util.List;

import javax.persistence.Query;

import model.Impuesto;

public class HomeImpuesto {
	
	public void save(Impuesto impuesto) {
		getManager().persist(impuesto);
	}
}


