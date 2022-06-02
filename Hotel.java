package application;

import com.mysql.cj.conf.StringProperty;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author hang i carles
 * @version 1.0
 *
 */
/**
 * @author hang
 *
 */
public class Hotel extends Main {

	private final SimpleStringProperty Id_Hotel;
	private final SimpleStringProperty Nombre;
	private final SimpleStringProperty N_Habitaciones;
	private final SimpleStringProperty Categoria;
	private final SimpleStringProperty Classe;
	private final SimpleStringProperty Tipo;
	private final SimpleStringProperty Direccion;
	private final SimpleStringProperty Id_Reserva;
	private final SimpleStringProperty Ciudad;
	private final String nombre = "test";

	/**
	 * @param id_Hotel       id del hotel
	 * @param nombre         nombre del hotel
	 * @param n_Habitaciones numero de habitaciones
	 * @param categoria      Estrellas de los hoteles
	 * @param classe         Si es una habitacion premium o normal
	 * @param tipo           Si es individual, doble o familiar
	 * @param direccion      Direccion del hotel
	 * @param id_Reserva     Id de la Reserva
	 * @param ciudad         Ubicacion del hotel
	 */
	Hotel(String id_Hotel, String nombre, String n_Habitaciones, String categoria, String classe, String tipo,
			String direccion, String id_Reserva, String ciudad) {
		Id_Hotel = new SimpleStringProperty(id_Hotel);
		Nombre = new SimpleStringProperty(nombre);
		N_Habitaciones = new SimpleStringProperty(n_Habitaciones);
		Categoria = new SimpleStringProperty(categoria); // Estrellas que tiene
		Classe = new SimpleStringProperty(classe);// si es una habitacion estandar o luxury
		Tipo = new SimpleStringProperty(tipo); // Si es junior, individual, doble...
		Direccion = new SimpleStringProperty(direccion);
		Id_Reserva = new SimpleStringProperty(id_Reserva);
		Ciudad = new SimpleStringProperty(ciudad);
	}

	/**
	 * @param nombre          nombre del hotel
	 * @param n_Habitaciones, numero de habitaciones que tiene el hotel
	 * @param categoria       las estrellas que tiene el hotel
	 * @param direccion,      cual es su ubicacion
	 * @param ciudad,         en que localidad se encuentra
	 */
	public Hotel(String nombre, String n_Habitaciones, String categoria, String direccion, String ciudad) {
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
	 * Propietat del Hotel
	 * @return id del hotel
	 */
	public final SimpleStringProperty Id_HotelProperty() {
		return Id_Hotel;
	}
	
	/**
	 * Getter de id Hotel
	 * @return el id del hotel
	 */
	public final String getId_Hotel() {
		return Id_Hotel.get();
	}

	/**
	 * Seter del id hotel
	 * @param value ID del hotel
	 */
	public final void setId_Hotel(String value) {
		Id_Hotel.set(value);
	}

	/**
	 * Propiedad de Nombre
	 * @return Nombre del hotel
	 */
	public final SimpleStringProperty NombreProperty() {
		return Nombre;
	}

	/**
	 * Getter del hotel
	 * @return Nombre del hotel
	 */
	public final String getNombre() {
		return Nombre.get();
	}

	/**
	 * Setter del hotel
	 * @param value nombre del hotel
	 */
	public final void setNombre(String value) {
		Nombre.set(value);
	}

	/**
	 * Propiedad de numero de habitaciones
	 * @return Numero de habitaciones
	 */
	public final SimpleStringProperty N_HabitacionesProperty() {
		return N_Habitaciones;
	}

	/**
	 * Getter de numero de habitaciones
	 * @return Numero de habitaciones
	 */
	public final String getN_Habitaciones() {
		return N_Habitaciones.get();
	}

	/**
	 * Setter de Numero 
	 * @param value Numero de habitaciones
	 */
	public final void setN_Habitaciones(String value) {
		N_Habitaciones.set(value);
	}

	/**
	 * Propiedad de categoria
	 * @return la categoria del hotel
	 */
	public final SimpleStringProperty CategoriaProperty() {
		return Categoria;
	}

	/**
	 * Getter de la categoria
	 * @return la categoria del hotel
	 */
	public final String getCategoria() {
		return Categoria.get();
	}

	/**
	 * Setter del hotel
	 * @param value la categoria del hotel
	 */
	public final void setCategoria(String value) {
		Categoria.set(value);
	}

	/**
	 * Propiedad de tipo
	 * @return tipo de habitacion
	 */
	public final SimpleStringProperty TipoProperty() {
		return Tipo;
	}

	/**
	 * Getter del hotel
	 * @return tipo de habitacion
	 */
	public final String getTipo() {
		return Tipo.get();
	}

	
	/**
	 * Setter del hotel
	 * @param value tipo de habitacion
	 */
	public final void setTipo(String value) {
		Tipo.set(value);
	}

	/**
	 * Propiedad de la classe
	 * @return Classe
	 */
	public final SimpleStringProperty ClasseProperty() {
		return Classe;
	}

	/**
	 * Getter de la classe
	 * @return Classe
	 */
	public final String getClasse() {
		return Classe.get();
	}

	/**
	 * Setter de la classe
	 * @param value la classe del hotel
	 */
	public final void setClasse(String value) {
		Classe.set(value);
	}

	/**
	 * Propiedad de la direccion
	 * @return Direccion
	 */
	public final SimpleStringProperty DireccionProperty() {
		return Direccion;
	}
	
	/**
	 * Getter de la direccion
	 * @return Direccion
	 */ 
	public final String getDireccion() {
		return Direccion.get();
	}

	/**
	 * Setter de la direccion
	 * @param value la direccion del hotel
	 */
	public final void setDireccion(String value) {
		Direccion.set(value);
	}

	/**
	 * Propiedad de la Id de la reserva
	 * @return Id_Reserva
	 */
	public final SimpleStringProperty Id_ReservaProperty() {
		return Id_Reserva;
	}

	/**
	 * Getter de la Id de la reserva
	 * @return Id_Reserva
	 */
	public final String getId_Reserva() {
		return Id_Reserva.get();
	}

	/**
	 * Setter de la Id de la reserva
	 * @param value la Id de la reserva
	 */
	public final void setId_Reserva(String value) {
		Id_Reserva.set(value);
	}

	/**
	 * Propiedad de la ciudad
	 * @return ciudad
	 */
	public final SimpleStringProperty CiudadProperty() {
		return Ciudad;
	}

	/**
	 * Getter de la ciudad
	 * @return ciudad
	 */
	public final String getCiudad() {
		return Ciudad.get();
	}

	/**
	 * Setter de la ciudad
	 * @param value la ciudad del hotel
	 */
	public final void setCiudad(String value) {
		Ciudad.set(value);
	}

	// SQL sentencias que utilizaremos:
	// "SELECT * FROM Hoteles",
	// "SELECT * FROM Hoteles WHERE Ciudad= "+ CiudadCol
	// "SELECT * FROM Hoteles WHERE Classe = 'Luxury'
	// "SELECT Nombre FROM Hoteles WHERE Nombre = "+ NombreCol
	// SELECT * FROM Reservas WHERE MONTH(Fecha_Inicio) = 07;
	// SELECT * FROM Reservas WHERE N_Personas BETWEEN 4 AND 10;

}
