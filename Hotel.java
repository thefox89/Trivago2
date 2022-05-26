package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Hotel extends DispalyJobs  {

	private final SimpleStringProperty Id_Hotel;
	private final SimpleStringProperty Nombre;
	private final SimpleStringProperty N_Habitaciones;
	private final SimpleStringProperty Categoria;
	private final SimpleStringProperty Classe;
	private final SimpleStringProperty Tipo;
	private final SimpleStringProperty Direccion;
	private final SimpleStringProperty Id_Reserva;
	private final SimpleStringProperty Ciudad;
	
	Hotel(String id_Hotel, String nombre, String n_Habitaciones, String categoria, String classe, String tipo,
			String direccion, String id_Reserva, String ciudad) {
		Id_Hotel = new SimpleStringProperty(id_Hotel);
		Nombre = new SimpleStringProperty(nombre);
		N_Habitaciones = new SimpleStringProperty(n_Habitaciones);
		Categoria = new SimpleStringProperty(categoria);
		Classe = new SimpleStringProperty(classe);
		Tipo = new SimpleStringProperty(tipo);
		Direccion = new SimpleStringProperty(direccion);
		Id_Reserva = new SimpleStringProperty(id_Reserva);
		Ciudad = new SimpleStringProperty(ciudad);
	}

	public SimpleStringProperty getId_Hotel() {
		return Id_Hotel;
	}

	public SimpleStringProperty getNombre() {
		return Nombre;
	}

	public SimpleStringProperty getN_Habitaciones() {
		return N_Habitaciones;
	}

	public SimpleStringProperty getCategoria() {
		return Categoria;
	}

	public SimpleStringProperty getClasse() {
		return Classe;
	}

	public SimpleStringProperty getTipo() {
		return Tipo;
	}

	public SimpleStringProperty getDireccion() {
		return Direccion;
	}

	public SimpleStringProperty getId_Reserva() {
		return Id_Reserva;
	}

	public SimpleStringProperty getCiudad() {
		return Ciudad;
	}

	final ObservableList<Hotel> hotel =FXCollections.observableArrayList(
			new Hotel("152934682", "Varlona", "9000", "5", "Luxury", "Individual", "Av. de la Playa, 120", "33333333", "Barcelona"),
			new Hotel("157148939", "GreenLand", "7000", "4", "Standard", "Junio", "C/ de Castalla, 17", "22222222", "Barcelona" ),
			new Hotel("214748362", "Golden River", "5000", "3", "Luxury", "Doble", "C/ de la Marina, 4", "11111111", "Barcelona" )
	); 
	
	
	
}
