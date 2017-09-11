package morfiYA.domain;

import morfiYA.exceptions.DatoInvalidoException;

public class Proveedor {
	private String nombre;
	private Servicio servicio;
	private double creditos = 0;
	private double creditosNoDisponibles= 0;
	private Habilitacion puedeVender = Habilitacion.HABILITADO; 
	

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
