package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;


import org.junit.Before;
import org.junit.Test;

import persistance.HomeComplejidad;
import persistance.HomeImpuesto;
import persistance.HomeTarea;
import model.Complejidad;
import model.Facil;
import model.Impuesto;
import model.Tarea;
import model.TareaSimple;

import static org.junit.Assert.*;

public class HomeProyectoTest extends PersistentTest{
	
	private HomeComplejidad homeComplejidad = new HomeComplejidad();
	private HomeTarea homeTarea = new HomeTarea();
	private HomeImpuesto homeImpuesto = new HomeImpuesto();
    
	@Before
	public void initialize() {
		
		Complejidad complejidadFacil = new Complejidad();
		
		Impuesto impuestoA = new Impuesto(10,'A');	
		Impuesto impuestoB = new Impuesto(5,'B');
	        
        Collection<Impuesto> impuestos1 = new ArrayList<Impuesto>();  
        Collection<Impuesto> impuestos2 = new ArrayList<Impuesto>();
        
        impuestos1.add(impuestoA);
        impuestos2.add(impuestoA);
        impuestos2.add(impuestoB);
        
        Tarea tarea1 = new TareaSimple(complejidadFacil, impuestos1, 3);
		
		//homeComplejidad.save(complejidadFacil);		
		//homeImpuesto.save(impuestoA);
		//homeImpuesto.save(impuestoB);
		homeTarea.save(tarea1);
		
	}

	@Test
	public void test() {
		int num = 1;
		assertTrue(num == 1);
	}
	
}


/*
 
 
import org.junit.Before;
import org.junit.Test;

import persistance.HomeComplejidad;
import persistance.HomeProyecto;
import persistance.HomeTarea;

import model.Compleja;
import model.Facil;
import model.Impuesto;
import model.Media;
import model.Tarea;
import model.Proyecto;
import model.TareaCompuesta;
import model.TareaSimple;

public class HomeProyectoTest extends PersistentTest{
	
	
	private Facil complejidadFacil;
    private Media complejidadMedia;
    private Compleja complejidadCompleja;
    
    private Impuesto impuestoA;
    private Impuesto impuestoB;
    
    private TareaSimple tarea1;
    private TareaSimple tarea2;
    private TareaSimple tarea3;
    private TareaSimple tarea4;
    private TareaSimple tareaExtra;
    private TareaCompuesta tareaC1;
    private TareaCompuesta tareaC2;
    
    private Proyecto proyecto1;
    private Proyecto proyecto2;
    
	@Before
	public void initialize() {
		
		complejidadFacil = new Facil();
        complejidadMedia = new Media();
        complejidadCompleja = new Compleja();
      
        
        impuestoA = new Impuesto(3,'A');
        impuestoB = new Impuesto(5,'B');
        
        Collection<Impuesto> impuestos1 = new ArrayList<Impuesto>();  
        Collection<Impuesto> impuestos2 = new ArrayList<Impuesto>();
        
        impuestos1.add(impuestoA);
        impuestos2.add(impuestoA);
        impuestos2.add(impuestoB);
        
        tarea1 = new TareaSimple(complejidadFacil, impuestos1, 3);
        tarea2 = new TareaSimple(complejidadMedia, impuestos1, 5);
        tarea3 = new TareaSimple(complejidadCompleja, impuestos1, 8);
        tarea4 = new TareaSimple(complejidadCompleja, impuestos1, 11);
        tareaExtra = new TareaSimple(complejidadMedia, impuestos2, 6);
        
        Collection<Tarea> listaTareas = new ArrayList<Tarea>();
        listaTareas.add(tarea1);
        listaTareas.add(tarea2);
        listaTareas.add(tarea3);
        listaTareas.add(tarea4);
        
        tareaC1 = new TareaCompuesta(listaTareas, 5);
        tareaC2 = new TareaCompuesta(listaTareas, 28);
        
        Collection<Tarea> listaTareasProyecto = new ArrayList<Tarea>();
        listaTareasProyecto.add(tareaExtra);
        listaTareasProyecto.add(tareaC1);
        
        Collection<Tarea> listaTareasBis = new ArrayList<Tarea>();
        listaTareasBis.add(tareaExtra);
        listaTareasBis.add(tareaC2);
        
        proyecto1 = new Proyecto(listaTareasProyecto);
        proyecto2 = new Proyecto(listaTareasBis);
		
        
	
}

 */