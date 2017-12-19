package morfiya.domain;

import morfiya.exceptions.DatoInvalidoException;
import morfiya.updates.ProveedorUpdate;

public class Proveedor extends Entity{

	private static final long serialVersionUID = -6057666662166650299L;
	
	private String nombre;
	private Servicio servicio;
	private Double creditos = 0.0;
	private Double creditosNoDisponibles= 0.0;
	private String email;
	private Habilitacion puedeVender = Habilitacion.HABILITADO; 
	

	public Proveedor() {
		super();
	}

	public Proveedor(String nombre, Servicio servicio, Double creditos, String email) {
		super();
		this.nombre=nombre;
		this.setServicio(servicio);
		this.creditos=creditos;
		this.email=email;
	}
	
	public Proveedor(String nombre) {
		super();
		this.nombre = nombre;
	}
	public void agregarServicio(Servicio servicio) {
		this.setServicio(servicio);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void retirarCreditos(Double cantidad) throws DatoInvalidoException{
		if(cantidad < 0.0) {
			throw new DatoInvalidoException("No se puede retirar una cantidad negativa de creditos");
		}
		
		if(cantidad > creditos) {
			throw new DatoInvalidoException("No tiene saldo suficiente para retirar la cantidad ingresada");
		}
		creditos -= cantidad;
	}
	
	public void cargarCredito(Double cantidad)throws DatoInvalidoException {
		 
	    if (cantidad <0.0) {
	    	throw new DatoInvalidoException("No se puede cargar saldo negativo");
	    }
	    creditos += cantidad;
	 }

	public Double getCreditos() {
		return creditos;
	}

	public Boolean puedeVender(){
		return this.puedeVender == Habilitacion.HABILITADO; 
	}
	
	public Habilitacion getPuedeVender() {
		return puedeVender;
	}

	public void setPuedeVender(Habilitacion puedeVender) {
		this.puedeVender = puedeVender;
	}

	public Double getCreditosNoDisponibles() {
		return creditosNoDisponibles;
	}
	
	public void retirarCreditosNoDisponibles(Double cantidad) throws DatoInvalidoException{
		if(cantidad < 0) {
			throw new DatoInvalidoException("No se puede retirar una cantidad negativa de creditos");
		}
		
		if(cantidad > creditosNoDisponibles) {
			throw new DatoInvalidoException("No tiene saldo suficiente para retirar la cantidad ingresada");
		}
		creditosNoDisponibles -= cantidad;
	}
	
	public void cargarCreditoNoDisponible(Double cantidad)throws DatoInvalidoException {
		 
	    if (cantidad <0.0) {
	    	throw new DatoInvalidoException("No se puede cargar saldo negativo");
	    }
	    creditosNoDisponibles += cantidad;
	 }	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void actualizar(ProveedorUpdate update){
		
		
		if(update.getCreditos()!=null)
			this.cargarCredito(update.getCreditos());
		
		if(update.getEmail()!=null)
			this.setEmail(update.getEmail());
		
		if(update.getNombre()!=null)
			this.setNombre(update.getNombre());
}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public void agregarMenu(Menu menu) {
		this.servicio.agregarMenu(menu);
		
	}
}
