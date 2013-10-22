package comprarEntradas.ui;

import java.awt.Color;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.Transformer;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;
import org.uqbar.edu.paiu.examples.celulares.domain.Celular;

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
		this.setTitle("Selección de Entradas");
		this.setTaskDescription("Ingrese los parámetros de búsqueda");

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
		searchFormPanel.setLayout(new ColumnLayout(3));

		new Label(searchFormPanel).setText("Sector").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).bindValueToProperty("sector");

		new Label(searchFormPanel).setText("Fila").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).bindValueToProperty("fila");
		
		new Label(searchFormPanel).setText("Butaca").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).bindValueToProperty("butaca");
	}
	
	//Acciones asociadas de la pantalla principal.
	
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
		table.setHeigth(200);
		table.setWidth(450);

		table.bindItemsToProperty("resultados");
		table.bindValueToProperty("entradaSeleccionada");

		this.describeResultsGrid(table);
	}
	
	//Define las columnas de la grilla.
	
	protected void describeResultsGrid(Table<Entrada> table) {
		new Column<Entrada>(table) //
			.setTitle("Sector")
			.setFixedSize(100)
			.bindContentsToProperty("sector");
		
		new Column<Entrada>(table) //
		.setTitle("Fila")
		.setFixedSize(50)
		.bindContentsToProperty("fila");
		
		new Column<Entrada>(table) //
		.setTitle("Butaca")
		.setFixedSize(50)
		.bindContentsToProperty("butaca");
	
		Column<Entrada> modeloColumn = new Column<Entrada>(table);
		modeloColumn.setTitle("Precio");
		modeloColumn.setFixedSize(50);
		modeloColumn.bindContentsToProperty("precio");
	
	}
}
