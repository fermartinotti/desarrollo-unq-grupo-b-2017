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
	
	public double puntajePromedioProveedor(Proveedor proveedor) {
		return pedidos.stream().filter(puntuacion-> puntuacion.estaFinalizado() && puntuacion.getProveedor().equals(proveedor))
				.mapToDouble(puntuacion -> puntuacion.getPuntuacion()).average().getAsDouble();
	}
	
	public boolean hayPuntuacionesPendientesCliente(Cliente cliente) {
		return pedidos.stream().filter(puntuacion -> puntuacion.estaPendiente() && puntuacion.getCliente().equals(cliente)).count() > 0;
		
	}
	
}
