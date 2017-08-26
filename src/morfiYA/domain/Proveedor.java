package morfiYA.domain;

import morfiYA.exceptions.DatoInvalidoException;

public class Proveedor {
	private String nombre;
	private Servicio servicio;
	private Float creditos;
	
	public void agregarServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	public void retirarCreditos(Float cantidad) throws DatoInvalidoException{
		if(cantidad < 0) {
			throw new DatoInvalidoException("No se puede retirar una cantidad negativa de creditos");
		}
		
		if(cantidad > creditos) {
			throw new DatoInvalidoException("No tiene saldo suficiente para retirar la cantidad ingresada");
		}
		creditos -= cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
