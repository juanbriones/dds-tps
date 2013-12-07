/*package tests;

import static persistance.ModelManager.beginTransaction;
import static persistance.ModelManager.commit;

import model.Complejidad;
import model.Facil;

import org.junit.After;
import org.junit.Before;

import persistance.HomeComplejidad;

public class main {

	public static void main(String[] args) {
		
		HomeComplejidad homeComplejidad = new HomeComplejidad();
		beginTransaction();
		
		System.out.println("hola");
		//Complejidad complejidadFacil = new Complejidad(3);
		Complejidad complejidadFacil = new Complejidad();
		homeComplejidad.save(complejidadFacil);		
				
		commit();
		
	}

}
*/