package comprarEntradas.ui;

import java.awt.Color;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;

import comprarEntradas.domain.Entrada;


//Ventana de búsqueda, selección y anulación de entradas.

@SuppressWarnings("serial")
@Observable
public class AnulacionDeEntradasWindow extends VentaDeEntradasWindow{

	public AnulacionDeEntradasWindow(WindowOwner owner) {
		super(owner);
		this.getModelObject().searchOcupadas();
	}
	
	//El panel principal de búsqueda permite filtrar por sector, fila o butaca.
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel searchFormPanel = new Panel(mainPanel);
		searchFormPanel.setLayout(new ColumnLayout(8));
		
		new Label(searchFormPanel).setText("Noche").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).setWidth(50).bindValueToProperty("nroNoche");

		new Label(searchFormPanel).setText("Sector").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).setWidth(50).bindValueToProperty("sector");

		new Label(searchFormPanel).setText("Fila").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).setWidth(50).bindValueToProperty("fila");
		
		new Label(searchFormPanel).setText("Butaca").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).setWidth(50).bindValueToProperty("butaca");
		
		new Label(searchFormPanel).setText("Nombre").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).setWidth(50).bindValueToProperty("nombreCliente");
		
		new Label(searchFormPanel).setText("Apellido").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).setWidth(50).bindValueToProperty("apellidoCliente");
	}
	
	//Acciones asociadas a la pantalla.
	
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel)
			.setCaption("Buscar")
			.onClick(new MessageSend(this.getModelObject(), "searchOcupadas"))
			.setAsDefault()
			.disableOnError();

		new Button(actionsPanel) //
			.setCaption("Limpiar")
			.onClick(new MessageSend(this.getModelObject(), "clear"));
	}
	
	@Override
	protected void createResultsGrid(Panel mainPanel) {
		Table<Entrada> table = new Table<Entrada>(mainPanel, Entrada.class);
		table.setHeigth(250);
		table.setWidth(600);
		table.bindItemsToProperty("resultados");
		table.bindValueToProperty("entradaSeleccionada");

		this.describeResultsGrid(table);
	}
	
	@Override
	protected void describeResultsGrid(Table<Entrada> table) {
		new Column<Entrada>(table)
		.setTitle("Noche")
		.setFixedSize(80)
		.bindContentsToProperty("nroNoche");
		
		new Column<Entrada>(table)
		.setTitle("Sector")
		.setFixedSize(80)
		.bindContentsToProperty("sector");
		
		new Column<Entrada>(table)
		.setTitle("Fila")
		.setFixedSize(80)
		.bindContentsToProperty("fila");
		
		new Column<Entrada>(table)
		.setTitle("Butaca")
		.setFixedSize(80)
		.bindContentsToProperty("butaca");
	
		new Column<Entrada>(table)
		.setTitle("Precio")
		.setFixedSize(80)
		.bindContentsToProperty("precio");
		
		new Column<Entrada>(table)
		.setTitle("Nombre")
		.setFixedSize(80)
		.bindContentsToProperty("cliente.nombre");
		
		new Column<Entrada>(table)
		.setTitle("Apellido")
		.setFixedSize(80)
		.bindContentsToProperty("cliente.apellido");	
	}
	
	@Override
	protected void createGridActions(Panel mainPanel) {
		Panel actionsPanel = new Panel(mainPanel);
		actionsPanel.setLayout(new HorizontalLayout());
		
		Button anular = new Button(actionsPanel);
		anular.setCaption("Anular");
		anular.onClick(new MessageSend(this, "anularEntrada"));
	
		// Deshabilita los botones si no hay ningún elemento seleccionado en la grilla.
		
		NotNullObservable elementSelected = new NotNullObservable("entradaSeleccionada");
		anular.bindEnabled(elementSelected);
	}
	
	public void anularEntrada() {
		this.getModelObject().getEntradaSeleccionada().setVendida(false);
		this.getModelObject().searchOcupadas();
	}
}
