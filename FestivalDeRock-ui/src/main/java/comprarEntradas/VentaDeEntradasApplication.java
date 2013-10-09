package comprarEntradas;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

public class VentaDeEntradasApplication extends Application {
	
	public static void main(String[] args)
	{
		new VentaDeEntradasApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() 
	{
			return new SeleccionDeEntradasWindow(this);
	}	
}
