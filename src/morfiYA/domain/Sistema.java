package morfiYA.domain;

import java.util.Date;

import morfiYA.exceptions.DatoInvalidoException;

public class Sistema {
	
	
	public void comprarMenu(Cliente cliente, Integer cantidad, Proveedor proveedor, Menu menu, Date horaEntrega, Date fechaEntrega, String tipoEntrega) throws DatoInvalidoException{                   
		if(menu.estaMenuVigente() && (menu.getPrecio() * cantidad) <= cliente.getCreditos() && menu.puedeVender()) {
			Pedido nuevoPedido = new Pedido(fechaEntrega, null, menu, cliente); // Falta tipo de entrega
			// No se al final a donde va el pedido
			cliente.setCreditos(menu.getPrecio() * cantidad);
			proveedor.setCreditos(menu.getPrecio() * cantidad);
			menu.setCantidadVendidos(menu.getCantidadVendidos() + cantidad);
			if(menu.getCantidadMinima()<= menu.getCantidadVendidos() && (menu.getCantidadVendidos() < menu.getCantidadMinima2())) {
				AlarmaCambioPrecio alarma = new AlarmaCambioPrecio();
				alarma.attachCantidadMinima(cliente);
				alarma.attachProveedores(proveedor);
				alarma.notifyObserversCantidadMinima(menu.getPrecio()-menu.getPrecioCantidadMinima());
				alarma.notifyObserversProveedores(menu.getPrecio()-menu.getPrecioCantidadMinima());
			}
			if(menu.getCantidadMinima2()<= menu.getCantidadVendidos() && menu.getCantidadVendidos() > menu.getCantidadMinima()) {
				AlarmaCambioPrecio alarma = new AlarmaCambioPrecio();
				alarma.attachCantidadMinima2(cliente);
				alarma.attachProveedores(proveedor);
				alarma.notifyObserversCantidadMinima2(menu.getPrecio()-menu.getPrecioCantidadMinima2());
				alarma.notifyObserversProveedores(menu.getPrecio()-menu.getPrecioCantidadMinima2());
			}
		}
		// Corroborar la fecha de vigencia
		// Verificar si tiene saldo disponible
		// Preguntar si puede comprar (la cantidad maxima por dia)
		// Crear pedido
		// Sacarse plata
		// el proveedor se tiene que sumar la plata de la venta
		// En el caso de q se llegue a alguna cantidad maxima, devolver plata (ahi creo que entraria en juego el observer)
		
	}
	
}
