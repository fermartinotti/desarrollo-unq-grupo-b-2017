package morfiYA.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import morfiYA.exceptions.DatoInvalidoException;

public class Sistema {
	
	List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public void agregarPuntuacion(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public double puntajePromedioProveedor(Proveedor proveedor) {
		return pedidos.stream().filter(puntuacion-> puntuacion.estaFinalizado() && puntuacion.getProveedor().equals(proveedor))
				.mapToDouble(puntuacion -> puntuacion.getPuntuacion()).average().getAsDouble();
	}
	
	public boolean hayPuntuacionesPendientesCliente(Cliente cliente) {
		return pedidos.stream().filter(puntuacion -> puntuacion.estaPendiente() && puntuacion.getCliente().equals(cliente)).count() > 0;
		
	}
	
//	// Es un re bardo
//	public List<Proveedores> proveedoresConMasDe20PuntucionesYPromedioMenorA2(){
//		return 
//	}
	
	
	
	
	
	
//	public void comprarMenu(Cliente cliente, Integer cantidad, Proveedor proveedor, Menu menu, Date horaEntrega, Date fechaEntrega, String tipoEntrega) throws DatoInvalidoException{                   
//		if(menu.estaMenuVigente() && (menu.getPrecio() * cantidad) <= cliente.getCreditos() && menu.puedeVender()) {
//			Pedido nuevoPedido = new Pedido(fechaEntrega, null, menu, cliente); // Falta tipo de entrega
//			// No se al final a donde va el pedido
//			cliente.setCreditos(cliente.getCreditos() - menu.getPrecio() * cantidad);
//			proveedor.setCreditos(proveedor.getCreditos() + menu.getPrecio() * cantidad);
//			menu.setCantidadVendidos(menu.getCantidadVendidos() + cantidad);
//			if(menu.getCantidadMinima()>= menu.getCantidadVendidos() && (menu.getCantidadVendidos() < menu.getCantidadMinima2())) {
//				AlarmaCambioPrecio alarma = new AlarmaCambioPrecio();
//				alarma.attachCantidadMinima(cliente);
//				alarma.attachProveedores(proveedor);
//				alarma.notifyObserversCantidadMinima(menu.getPrecio()-menu.getPrecioCantidadMinima());
//				alarma.notifyObserversProveedores(menu.getPrecio()-menu.getPrecioCantidadMinima());
//			}
//			if(menu.getCantidadMinima2()>= menu.getCantidadVendidos() && menu.getCantidadVendidos() > menu.getCantidadMinima()) {
//				AlarmaCambioPrecio alarma = new AlarmaCambioPrecio();
//				alarma.attachCantidadMinima2(cliente);
//				alarma.attachProveedores(proveedor);
//				alarma.notifyObserversCantidadMinima2(menu.getPrecio()-menu.getPrecioCantidadMinima2());
//				alarma.notifyObserversProveedores(menu.getPrecio()-menu.getPrecioCantidadMinima2());
//			}
//		}
//		
//	
//		// Corroborar la fecha de vigencia
//		// Verificar si tiene saldo disponible
//		// Preguntar si puede comprar (la cantidad maxima por dia)
//		// Crear pedido
//		// Sacarse plata
//		// el proveedor se tiene que sumar la plata de la venta
//		// En el caso de q se llegue a alguna cantidad maxima, devolver plata (ahi creo que entraria en juego el observer)
//		
//	}
	
}
