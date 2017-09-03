package morfiYA.domain;

import java.util.Date;

public class Pedido {
	private Date fechaDeEntrega;
	// como almacenamos la hora
	// Tipo de entrega definir
	private Opinion opinion;
	private Menu menu;
	private Cliente cliente;
	
	public Pedido(Date fechaDeEntrega, Opinion opinion, Menu menu, Cliente cliente) {
		super();
		this.fechaDeEntrega = fechaDeEntrega;
		this.opinion = opinion;
		this.menu = menu;
		this.cliente = cliente;
	}
	
	
}
