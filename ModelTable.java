package application;

public class ModelTable {
	String nombre,n_habitaciones,categoria,direccion,ciudad;

	public ModelTable(String nombre, String n_habitaciones, String categoria, String direccion, String ciudad) {
		this.nombre = nombre;
		this.n_habitaciones = n_habitaciones;
		this.categoria = categoria;
		this.direccion = direccion;
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getN_habitaciones() {
		return n_habitaciones;
	}

	public void setN_habitaciones(String n_habitaciones) {
		this.n_habitaciones = n_habitaciones;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
