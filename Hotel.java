package application;

import javafx.beans.property.SimpleStringProperty;

/**
 * 
 * @author hang i carles
 * @version 3.0
 *
 */
public class Hotel extends Main  {

	private final SimpleStringProperty Id_Hotel;
	private final SimpleStringProperty Nombre;
	private final SimpleStringProperty N_Habitaciones;
	private final SimpleStringProperty Categoria;
	private final SimpleStringProperty Classe;
	private final SimpleStringProperty Tipo;
	private final SimpleStringProperty Direccion;
	private final SimpleStringProperty Id_Reserva;
	private final SimpleStringProperty Ciudad;
	/**
	 * 
	 * @param id_Hotel id del hotel
	 * @param nombre nombre del hotel
	 * @param n_Habitaciones numero de habitaciones
	 * @param categoria estrellas del hotel
	 * @param classe si es habitacion normal o premium
	 * @param tipo tipo de habitaciones
	 * @param direccion direccion del hotel
	 * @param id_Reserva el id de la reserva del usuario
	 * @param ciudad la ubicacio del hotel
	 */
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

	
	/**
	 * 
	 * @param nombre nombre del hotel
	 * @param n_Habitaciones numero de habitaciones
	 * @param categoria estrellas del hotel
	 * @param direccion direccion del hotel
	 * @param ciudad la ubicacio del hotel
	 */
	public Hotel(String nombre, String n_Habitaciones, String categoria,
			String direccion, String ciudad) {
		Id_Hotel = new SimpleStringProperty();
		Nombre = new SimpleStringProperty(nombre);
		N_Habitaciones = new SimpleStringProperty(n_Habitaciones);
		Categoria = new SimpleStringProperty(categoria);
		Tipo = new SimpleStringProperty();
		Classe = new SimpleStringProperty();
		Direccion = new SimpleStringProperty(direccion);
		Id_Reserva = new SimpleStringProperty();
		Ciudad = new SimpleStringProperty(ciudad);
	}


	/**
	 * Id Hotel
	 * @return Id Hotel
	 */
	public SimpleStringProperty getId_Hotel() {
		return Id_Hotel;
	}
	/**
	 * Nombre
	 * @return Nomre
	 */
	public SimpleStringProperty getNombre() {
		return Nombre;
	}
	/**
	 * Numero de Habitaciones
	 * @return Numero de habitaciones
	 */
	public SimpleStringProperty getN_Habitaciones() {
		return N_Habitaciones;
	}
	/**
	 * Categoria
	 * @return Categoria
	 */
	public SimpleStringProperty getCategoria() {
		return Categoria;
	}
	/**
	 * Classe
	 * @return Classe
	 */
	public SimpleStringProperty getClasse() {
		return Classe;
	}
	/**
	 * Tipo
	 * @return Tipo
	 */
	public SimpleStringProperty getTipo() {
		return Tipo;
	}
	/**
	 * Direccion
	 * @return Direccion
	 */
	public SimpleStringProperty getDireccion() {
		return Direccion;
	}
	/**
	 * Reserva
	 * @return Reserva
	 */
	public SimpleStringProperty getId_Reserva() {
		return Id_Reserva;
	}
	/**
	 * Ciudad
	 * @return Ciudad
	 */
	public SimpleStringProperty getCiudad() {
		return Ciudad;
	}

	
			//"SELECT * FROM Hoteles",
			//"SELECT * FROM Hoteles WHERE Ciudad= "+ CiudadCol
			//"SELECT * FROM Hoteles WHERE Classe = 'Luxury'
			//"SELECT Nombre FROM Hoteles WHERE Nombre = "+ NombreCol
			// SELECT * FROM Reservas WHERE MONTH(Fecha_Inicio) = 07;
			// SELECT * FROM Reservas WHERE N_Personas BETWEEN 4 AND 10;

	


	
	
	
	
}
