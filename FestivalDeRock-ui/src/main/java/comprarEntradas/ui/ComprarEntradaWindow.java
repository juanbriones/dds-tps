package comprarEntradas.ui;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;

import comprarEntradas.domain.Entrada;

@SuppressWarnings("serial")
public class ComprarEntradaWindow extends TransactionalDialog<Entrada> {
	
	public ComprarEntradaWindow(WindowOwner owner, Entrada model) {
		super(owner, model);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Nombre");
		new TextBox(form).bindValueToProperty("nombre");
		
		new Label(form).setText("Apellido");
		new TextBox(form).bindValueToProperty("apellido");
		
		new Label(form).setText("Edad");
		new TextBox(form).bindValueToProperty("edad");
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick(new MessageSend(this, "accept"))
			.setAsDefault()
			.disableOnError();

		new Button(actions)
			.setCaption("Cancelar")
			.onClick(new MessageSend(this, "cancel"));
	}
}
