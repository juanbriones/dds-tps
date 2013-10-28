package comprarEntradas.ui;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;


//Ventana que contiene el menu principal.

@Observable
public class MenuPrincipalWindow extends SimpleWindow<MenuPrincipal>{

	public MenuPrincipalWindow(WindowOwner parent) {
		super(parent, null);
	}

	@Override
	protected void createMainTemplate(Panel mainPanel) {
		this.setTitle("Festival de Rock - Menu Principal");
		this.setTaskDescription("Seleccione una opcion");

		super.createMainTemplate(mainPanel);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
			Panel menuFormPanel = new Panel(mainPanel);
			menuFormPanel.setLayout(new ColumnLayout(2));
		
	}
	
	//Acciones asociadas de la pantalla.
	
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel)
			.setCaption("Vender")
			.onClick(new MessageSend(this.getModelObject(), "abrirVentanaVender"));

		new Button(actionsPanel) //
			.setCaption("Anular")
			.onClick(new MessageSend(this.getModelObject(), "abrirVentanaAnular"));
	}

}