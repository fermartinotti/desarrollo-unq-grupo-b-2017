package morfiYA.domain;

import java.time.LocalDate;

import morfiYA.exceptions.DatoInvalidoException;

public class Pedido {
	private LocalDate fechaDeEntrega;
	private LocalDate fechaCompra = LocalDate.now();
	

	// como almacenamos la hora
	// Tipo de entrega definir
	Integer puntuacion=0;
	Proveedor proveedor;
	Cliente cliente;
	Menu menu;
	String	descripcion;
	EstadoPuntuacion estadoPuntuacion = EstadoPuntuacion.PENDIENTE;
	
	public Pedido(LocalDate fechaDeEntrega, String descripcion, Menu menu, Cliente cliente) {
		super();
		this.fechaDeEntrega = fechaDeEntrega;
		this.menu = menu;
		this.cliente = cliente;
		this.descripcion = descripcion; 
	}
	
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
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public LocalDate getFechaCompra() {
		return fechaCompra;
	}
	
	public void puntuar(Integer valor) throws DatoInvalidoException {
		if(valor > 0 && valor < 6) {
			puntuacion = valor;
			setEstadoPuntuacion(EstadoPuntuacion.FINALIZADO);
		}
		else {throw new DatoInvalidoException("Se debe puntuar del 1 al 5"); }
	}

	
}
