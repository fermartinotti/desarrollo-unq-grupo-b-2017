package morfiYA.domain;

import java.time.Duration;
import java.time.LocalDate;
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
	
//	public boolean hayPuntuacionesPendientesCliente(Cliente cliente) {
//		return ! cliente.estaHabilitado();
//	}
//	
//	public void comprar(Menu menu, LocalDate fechaDeEntrega, Cliente cliente, String descripcion) {
//		if (puedeComprar(menu, cliente, fechaDeEntrega)){ 
//			try{
//				cliente.retirarCreditos(menu.getPrecio());
//				//sumar plata a proveedor (decidir quien conoce a proveedor)
//				//calcular tiempo de entrega (RELEASE 2)
//				Pedido pedido = new Pedido(fechaDeEntrega, descripcion,menu, cliente);
//				pedidos.add(pedido); // Futuro save de un servicio a la DB.
//				// Enviar emails ( RELEASE 2 )
//			}catch (Exception e) {
//				
//			}
//		}
//			
//	}
//	
//	public Boolean puedeComprar(Menu menu, Cliente cliente, LocalDate fecha){
//		return (cantDeVentasNoSuperada(menu) && ! hayPuntuacionesPendientesCliente(cliente) && esFechaValida(menu, fecha));
//	}
//	
//	public Boolean cantDeVentasNoSuperada(Menu menu){
//		// chekea si este menu no supera la cant de ventas maximas por dia.		
//		ArrayList<Pedido> pedidos = pedidosServicesImpl.getCantDePedidosPorMenu(menu);
//		return (pedidos.size < menu.getCantidadMaxVtasPorDia);
//	}
	
	public Boolean esFechaValida(Menu menu, LocalDate fecha){
		// FALTA AGREGARLE LA LOGICA DE LOS FERIADOS Y FINES DE SEMANA
		LocalDate today = LocalDate.now();
		Duration diferencia = Duration.between(today, fecha); // throws an exception
		return (diferencia.toHours() < 48);
	}
	
	public void confirmarCompras() {
		// Se cobra a todos el mismo precio, se devuelve a todos lo mismo
		// updatear saldos, pasar saldos de no disponible a disponible
		// actualizar estado de los pedidos. 
    
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
