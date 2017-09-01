package morfiYA.domain;

import java.util.Date;

// Los compradores podrán comprar 1 menú (o más) del mismo servicio/negocio. Para hacer un pedido se deberá seleccionar Menú, Cantidad, TipoDeEntrega, FechaDeEntrega,
// HoraDeEntrega. ​ ​Solo ​ ​se ​ ​podrán ​ ​hacer ​ ​pedidos ​ ​hasta ​ ​48 ​ ​horas ​ ​antes ​ ​de ​ ​la ​ ​fecha ​ ​de ​ ​la ​ ​entrega.


public class Sistema {
	
	public void comprarMenu(Cliente cliente, Integer cantidad, Proveedor proveedor, Menu menu, Date horaEntrega, Date fechaEntrega, String tipoEntrega){
		// Corroborar la fecha de vigencia
		// Verificar si tiene saldo disponible
		// Preguntar si puede comprar (la cantidad maxima por dia)
		// Crear pedido
		// Sacarse plata
		// el proveedor se tiene que sumar la plata de la venta
		// En el caso de q se llegue a alguna cantidad maxima, devolver plata (ahi creo que entraria en juego el observer)
		
	}
	
}
