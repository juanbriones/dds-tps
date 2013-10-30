package comprarEntradas.ui;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;


//Ventana de búsqueda, selección y anulación de entradas.

@SuppressWarnings("serial")
@Observable
public class AnulacionDeEntradasWindow extends VentaDeEntradasWindow{

	public AnulacionDeEntradasWindow(WindowOwner owner) {
		super(owner);
		this.getModelObject().searchOcupadas();
	}
	
	@Override
	protected void createGridActions(Panel mainPanel) {
		Panel actionsPanel = new Panel(mainPanel);
		actionsPanel.setLayout(new HorizontalLayout());
		
		new Button(actionsPanel)
		.setCaption("Anular")
		.onClick(new MessageSend(this, "anularEntrada"));
	}
	
	public void anularEntrada() {
		this.getModelObject().getEntradaSeleccionada().setVendida(false);
		this.getModelObject().searchOcupadas();
	}
}
