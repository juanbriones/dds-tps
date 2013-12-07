package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import model.Facil;
import model.Compleja;
import model.Media;
import model.Impuesto;
import model.Tarea;
import model.TareaSimple;
import model.TareaCompuesta;
import model.Proyecto;

//import org.junit.*;

import java.util.*;
import java.text.ParseException;

public class TestProyectos {

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
  	  public void setUp() throws Exception
  	  {
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
      
      
      
      /*-----Costos-----*/
      @Test
      public void testCostoTareaFacilConImpuesto1() throws ParseException
      {
    	  assertTrue(tarea1.getCostoTarea()== 77.25);
      }
      
      @Test
      public void testCostoTareaMediaConImpuesto1() throws ParseException 
      {
    	  assertTrue(tarea2.getCostoTarea()== 135.1875); 
      }
      
      @Test 
      public void testCostoTareaComplejaChica() throws ParseException
      {
    	  assertTrue(tarea3.getCostoTarea()== 220.42);
    	  
      }
      
      @Test
      public void testCostoTareaComplejaGrande() throws ParseException
      {
    	  assertTrue(tarea4.getCostoTarea() == 313.3775);
      }
      
      @Test
      public void testCostoTareaCompuesta() throws ParseException
      {
    	  assertTrue(tareaC1.getCostoTarea() == 776.0843999999998);
      }
      
      @Test
      public void testCostoProyectoTotal() throws ParseException
      {
    	  assertTrue(proyecto1.getCostoTotal()== 946.1843999999999);
      }
      
      
      /*------Tiempos--------*/
      @Test
      public void testTiempoTotalDelProyecto1() throws ParseException
      {
    	  assertTrue(proyecto1.getTiempoTotal() == 33);
      }
      
      @Test
      public void testTiempoTotalDelProyecto2() throws ParseException
      {
          assertTrue(proyecto2.getTiempoTotal()==34);
      }
      
      @Test
      public void testTiempoTotaldeTareaCompuesta2() throws ParseException
      {
    	  assertTrue(tareaC2.getTiempoSubtareas() == 27);
      }
      
      @Test
      public void testTiempoComunTareaCompuesta2() throws ParseException
      {
    	  assertTrue(tareaC2.getTiempo()==28);
      }
      
      
      
      
      /*------Tiempos de atraso-------*/
      @Test
      public void testTiempoMaximoPermitidoDeAtrasoEnProyecto1() throws ParseException
      {
    	  //System.out.println(proyecto1.obtenerDiasMaximoDeAtraso());
    	 // assertTrue(proyecto1.obtenerDiasMaximoDeAtraso()==27.9);
      }
      
      @Test
      public void testTasaComplejidad() throws ParseException
      {
    	  System.out.println(tarea1.getTiempoPermitidoAtraso());
    	  assertTrue(tarea1.getTiempoPermitidoAtraso()==8);
      }
      
      
} 
