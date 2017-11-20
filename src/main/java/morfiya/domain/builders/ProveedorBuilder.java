package morfiya.domain.builders;

import morfiya.domain.Proveedor;
import morfiya.domain.Servicio;

public class ProveedorBuilder {
	private String nombre;
	private Servicio servicio;
	private String email;
	private double creditos = 0;
	
	
	public static ProveedorBuilder mkBuilder() {
		return new ProveedorBuilder();
	}
	
	public ProveedorBuilder withNombre(String nombre) {
		this.nombre= nombre;
		return this;
	}
	
	public ProveedorBuilder withServicio(Servicio servicio) {
		this.servicio= servicio;
		return this;
	}
	
	public ProveedorBuilder withServicio(String email) {
		this.email= email;
		return this;
	}
	
	public ProveedorBuilder withCreditosDisponibles(double creditos) {
		this.creditos= creditos;
		return this;
	}
	
	public Proveedor build() {
		Proveedor proveedor = new Proveedor(this.nombre, this.servicio, this.creditos, this.email);
		return proveedor;
	}
}
