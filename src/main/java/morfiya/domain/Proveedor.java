package morfiya.domain;

import morfiya.exceptions.DatoInvalidoException;

public class Proveedor extends Entity{

	private static final long serialVersionUID = -6057666662166650299L;
	
	private String nombre;
	private Servicio servicio;
	private double creditos = 0;
	private double creditosNoDisponibles= 0;
	private Habilitacion puedeVender = Habilitacion.HABILITADO; 
	//preguntar si el cliente no tiene que tener un telefono de contacto, y una direccion???

	public Proveedor() {
		super();
	}

	public Proveedor(String nombre, Servicio servicio, double creditos) {
		super();
		this.nombre=nombre;
		this.servicio=servicio;
		this.creditos=creditos;
	}
	
	public Proveedor(String nombre) {
		super();
		this.nombre = nombre;
	}
	public void agregarServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public void cargarCredito(double cantidad)throws DatoInvalidoException {
		 
	    if (cantidad <0) {
	    	throw new DatoInvalidoException("No se puede cargar saldo negativo");
	    }
	    creditos += cantidad;
	 }

	public double getCreditos() {
		return creditos;
	}

	public Habilitacion getPuedeVender() {
		return puedeVender;
	}

	public void setPuedeVender(Habilitacion puedeVender) {
		this.puedeVender = puedeVender;
	}

	public double getCreditosNoDisponibles() {
		return creditosNoDisponibles;
	}
	
	public void retirarCreditosNoDisponibles(double cantidad) throws DatoInvalidoException{
		if(cantidad < 0) {
			throw new DatoInvalidoException("No se puede retirar una cantidad negativa de creditos");
		}
		
		if(cantidad > creditosNoDisponibles) {
			throw new DatoInvalidoException("No tiene saldo suficiente para retirar la cantidad ingresada");
		}
		creditosNoDisponibles -= cantidad;
	}
	
	public void cargarCreditoNoDisponible(double cantidad)throws DatoInvalidoException {
		 
	    if (cantidad <0) {
	    	throw new DatoInvalidoException("No se puede cargar saldo negativo");
	    }
	    creditosNoDisponibles += cantidad;
	 }	
}
