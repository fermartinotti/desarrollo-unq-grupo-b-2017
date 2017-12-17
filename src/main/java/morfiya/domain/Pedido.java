package morfiya.domain;

import java.time.LocalDate;

import morfiya.exceptions.DatoInvalidoException;
import morfiya.utils.DateFormatter;

public class Pedido extends Entity {

	private static final long serialVersionUID = 1L;
	
	private LocalDate fechaDeEntrega;
	private LocalDate fechaCompra = LocalDate.now();
	
	Integer puntuacion=0;
	Proveedor proveedor;
	Cliente cliente;
	Menu menu;
	String descripcion;
	Integer cantMenusPedidos = 0;
	EstadoPuntuacion estadoPuntuacion = EstadoPuntuacion.PENDIENTE;
	
	
	public Pedido() {
		super();
	}

	public Pedido(String fechaDeEntrega, String descripcion, Menu menu, 
			Cliente cliente, Proveedor proveedor) {
		super();
		this.setFechaDeEntrega(DateFormatter.formatLocalDate(fechaDeEntrega));
		this.menu = menu;
		this.cliente = cliente;
		this.proveedor = proveedor;
		this.descripcion = descripcion;
	}
	
	public LocalDate getFechaDeEntrega() {
		return fechaDeEntrega;
	}

	public void setFechaDeEntrega(LocalDate fechaDeEntrega) {
		this.fechaDeEntrega = fechaDeEntrega;
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
	
	public Integer getCantMenusPedidos() {
		return cantMenusPedidos;
	}

	public void setCantMenusPedidos(Integer cantMenusPedidos) {
		this.cantMenusPedidos = cantMenusPedidos;
	}
	
	public void puntuar(Integer valor) throws DatoInvalidoException {
		if(valor > 0 && valor < 6) {
			puntuacion = valor;
			setEstadoPuntuacion(EstadoPuntuacion.FINALIZADO);
		}
		else {throw new DatoInvalidoException("Se debe puntuar del 1 al 5"); }
	}

	
}
