package morfiya.domain;

import morfiya.exceptions.DatoInvalidoException;

public class Cliente {
	
	private Integer cuit;
	private String nombre;
	private String apellido;
	private String email;
	private Telefono telefono;
	private Direccion direccion;
	private double creditos = 0;
	private Habilitacion puedeComprar = Habilitacion.HABILITADO; 
	
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
	public Telefono getTelefono() {
		return telefono;
	}
	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public double getCreditos() {
		return creditos;
	}
	
	public Habilitacion getEstado(){
		return puedeComprar;
	}
	public void habilitarCliente(){
		puedeComprar = Habilitacion.HABILITADO; 
	}
	public void deshabilitarCliente(){
		puedeComprar = Habilitacion.INHABILITADO; 
	}
	
	public Boolean puedeComprar() {
		return (puedeComprar == Habilitacion.HABILITADO);
	}
	
	 public void cargarCredito(double cantidad)throws DatoInvalidoException {
		 if (cantidad <0) {
		   	throw new DatoInvalidoException("No se puede cargar saldo negativo");
		 }
		 creditos += cantidad;
	}
	
	 public void retirarCreditos(double cantidad) throws DatoInvalidoException{
		if(cantidad < 0) {
			throw new DatoInvalidoException("No se puede retirar una cantidad negativa de creditos");
		}	
		if(cantidad > creditos) {
			throw new DatoInvalidoException("No tiene saldo suficiente para retirar la cantidad ingresada");
		}
		creditos -= cantidad;
	}
	 
}
