package morfiYA.domain;

import java.util.Date;

public class Pedido {
	private Date fechaDeEntrega;
	// como almacenamos la hora
	// Tipo de entrega definir
	private Puntuacion puntuacion;
	private Menu menu;
	private Cliente cliente;
	
	public Pedido(Date fechaDeEntrega, Puntuacion puntuacion, Menu menu, Cliente cliente) {
		super();
		this.fechaDeEntrega = fechaDeEntrega;
		this.puntuacion = puntuacion;
		this.menu = menu;
		this.cliente = cliente;
	}
	
	
}
