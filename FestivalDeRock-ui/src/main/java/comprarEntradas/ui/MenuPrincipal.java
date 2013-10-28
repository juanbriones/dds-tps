package comprarEntradas.ui;

import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.Observable;


@Observable
public class MenuPrincipal{
		
	// ********************************************************
	// ** ACCIONES
	// ********************************************************

	
	public Window<?> abrirVentanaVender(){
		return new VentaDeEntradasWindow(null);
	}
	
//	public void abrirVentanaAnular(){
//		
//	}
	
}
