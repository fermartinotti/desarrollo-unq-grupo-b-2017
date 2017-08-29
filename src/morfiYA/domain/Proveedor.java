package morfiYA.domain;

import morfiYA.exceptions.DatoInvalidoException;

public class Proveedor {
	private String nombre;
	private Servicio servicio; // Preguntar sin falta si un proveedor puede tener mas de un servicio
	private double creditos;
	
	public void agregarServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	// No me cierra este metodo
	public void retirarCreditos(double cantidad) throws DatoInvalidoException{
		if(cantidad < 0) {
			throw new DatoInvalidoException("No se puede retirar una cantidad negativa de creditos");
		}
		
		if(cantidad > creditos) {
			throw new DatoInvalidoException("No tiene saldo suficiente para retirar la cantidad ingresada");
		}
		creditos -= cantidad;
	}

	public double getCreditos() {
		return creditos;
	}

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
