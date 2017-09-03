package morfiYA.domain;

import morfiYA.exceptions.DatoInvalidoException;

public class Puntuacion {
	Integer puntuacion;
	Proveedor proveedor;
	Cliente cliente;
	Menu menu;
	EstadoPuntuacion estadoPuntuacion = EstadoPuntuacion.PENDIENTE;
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Integer getPuntuacion() {
		return puntuacion;
	}
	
	public boolean estaPendiente() {
		return estadoPuntuacion.equals(EstadoPuntuacion.PENDIENTE);
	}
	
	public boolean estaFinalizado() {
		return estadoPuntuacion.equals(EstadoPuntuacion.FINALIZADO);
	}
	
	public void setEstadoPuntuacion(EstadoPuntuacion estadoPuntuacion) {
		this.estadoPuntuacion = estadoPuntuacion;
	}
	
	public void puntuar(Integer valor) throws DatoInvalidoException {
		if(valor > 0 && valor < 6) {
			puntuacion = valor;
			setEstadoPuntuacion(EstadoPuntuacion.FINALIZADO);
		}
		else {throw new DatoInvalidoException("Se debe puntuar del 1 al 5"); }
	}

}	

	