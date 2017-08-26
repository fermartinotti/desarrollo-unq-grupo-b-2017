package morfiYA.domain;

public class Proveedor {
	String nombre;
	Servicio servicio;
	
	public void agregarServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
}
