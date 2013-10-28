package comprarEntradas.ui;

import java.awt.Color;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;

import comprarEntradas.domain.Entrada;


//Ventana de búsqueda y selección de entradas.

@Observable
public class VentaDeEntradasWindow extends SimpleWindow<BuscadorEntrada> {

	public VentaDeEntradasWindow(WindowOwner parent) {
		super(parent, new BuscadorEntrada());
		this.getModelObject().search();
	}
	
	/*
	 * El default de la vista es un formulario que permite disparar la búsqueda (invocando con super). Además 
	 * le agregamos una grilla con los resultados de esa búsqueda y acciones que pueden hacerse con elementos 
	 * de esa búsqueda.
	*/
	
	@Override
	protected void createMainTemplate(Panel mainPanel) {
		this.setTitle("Festival de Rock - Venta de entradas");
		this.setTaskDescription("Ingrese los parametros de busqueda");

		super.createMainTemplate(mainPanel);

		this.createResultsGrid(mainPanel);
		this.createGridActions(mainPanel);
	}

	// *************************************************************************
	// * FORMULARIO DE BUSQUEDA
	// *************************************************************************

	//El panel principal de búsqueda permite filtrar por sector, fila o butaca.
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel searchFormPanel = new Panel(mainPanel);
		searchFormPanel.setLayout(new ColumnLayout(2));
		
		new Label(searchFormPanel).setText("Noche").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).setWidth(50).bindValueToProperty("nroNoche");

		new Label(searchFormPanel).setText("Sector").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).setWidth(50).bindValueToProperty("sector");

		new Label(searchFormPanel).setText("Fila").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).setWidth(50).bindValueToProperty("fila");
		
		new Label(searchFormPanel).setText("Butaca").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).setWidth(50).bindValueToProperty("butaca");
	}
	
	//Acciones asociadas de la pantalla.
	
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel)
			.setCaption("Buscar")
			.onClick(new MessageSend(this.getModelObject(), "search"))
			.setAsDefault()
			.disableOnError();

		new Button(actionsPanel) //
			.setCaption("Limpiar")
			.onClick(new MessageSend(this.getModelObject(), "clear"));
	}
	
	// *************************************************************************
	// ** RESULTADOS DE LA BUSQUEDA
	// *************************************************************************

	/*
	 * Se crea la grilla en el panel de abajo. El binding es: el contenido de la grilla en base a los
	 * resultados de la búsqueda. Cuando el usuario presiona Buscar, se actualiza el model, y éste a su vez
	 * dispara la notificación a la grilla que funciona como Observer.
	 */
	
	protected void createResultsGrid(Panel mainPanel) {
		Table<Entrada> table = new Table<Entrada>(mainPanel, Entrada.class);
		table.setHeigth(250);
		table.setWidth(400);
		table.bindItemsToProperty("resultados");
		table.bindValueToProperty("entradaSeleccionada");

		this.describeResultsGrid(table);
	}
	
	//Define las columnas de la grilla.
	
	protected void describeResultsGrid(Table<Entrada> table) {
		new Column<Entrada>(table) //
		.setTitle("Noche")
		.setFixedSize(80)
		.bindContentsToProperty("nroNoche");
		
		new Column<Entrada>(table) //
			.setTitle("Sector")
			.setFixedSize(80)
			.bindContentsToProperty("sector");
		
		new Column<Entrada>(table) //
		.setTitle("Fila")
		.setFixedSize(80)
		.bindContentsToProperty("fila");
		
		new Column<Entrada>(table) //
		.setTitle("Butaca")
		.setFixedSize(80)
		.bindContentsToProperty("butaca");
	
		Column<Entrada> modeloColumn = new Column<Entrada>(table);
		modeloColumn.setTitle("Precio");

		modeloColumn.setFixedSize(80);
		modeloColumn.bindContentsToProperty("precio");
	}
	
	protected void createGridActions(Panel mainPanel) {
		Panel actionsPanel = new Panel(mainPanel);
		actionsPanel.setLayout(new HorizontalLayout());
	
		
//		Button edit = new Button(actionsPanel);
//		edit.setCaption("Editar");
//		edit.onClick(new MessageSend(this, "modificarCelular"));
//	
//		Button remove = new Button(actionsPanel);
//		remove.setCaption("Borrar");
//		remove.onClick(new MessageSend(this.getModelObject(), "eliminarCelularSeleccionado"));
//		
//	
//		// Deshabilita los botones si no hay ningún elemento seleccionado en la grilla.
//		
//		NotNullObservable elementSelected = new NotNullObservable("entradaSeleccionada");
//		remove.bindEnabled(elementSelected);
//		edit.bindEnabled(elementSelected);
	}
		
	// ********************************************************
	// ** ACCIONES
	// ********************************************************

//	public void crearCelular() {
//		this.openDialog(new CrearCelularWindow(this));
//	}
//
//	public void modificarCelular() {
//		this.openDialog(new EditarCelularWindow(this, this.getModelObject().getCelularSeleccionado()));
//	}
//
//	protected void openDialog(Dialog<?> dialog) {
//		dialog.onAccept(new MessageSend(this.getModelObject(), "search"));
//		dialog.open();
//	}	
}