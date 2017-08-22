package morfiYA.domain;

public class Cliente {
	
	Integer cuit;
	String nombre;
	String apellido;
	String email;
	Integer telefono;
	String localidad;
	String direccion;
	Float credito;
	
	public Integer getCuit() {
		return cuit;
	}
	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Float getCredito() {
		return credito;
	}
	public void setCredito(Float credito) {
		this.credito = credito;
	}

}
