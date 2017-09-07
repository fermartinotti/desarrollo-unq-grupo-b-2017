package morfiYA.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import morfiYA.exceptions.DatoInvalidoException;

public class Sistema {
	
	List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public void agregarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public double puntajePromedioPedido(List<Pedido> pedidos) {
		double sumaPuntajes = 0;
		
		for(Pedido p: pedidos){
			sumaPuntajes+=p.getPuntuacion();
		}
		return sumaPuntajes/pedidos.size();
	}
	
	public void evaluarMenu(List<Pedido> pedidos){
		if(puntajePromedioPedido(pedidos) < 2 ){
			pedidos.get(0).menu.inhabilitarMenu();
		}
	}
	
	public void calificarMenu(Cliente cliente, Pedido pedido, Integer puntuacion){
		pedido.puntuacion = puntuacion;
		cliente.habilitarCliente();
	}
}
