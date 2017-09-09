package morfiYA.domain;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import morfiYA.exceptions.DatoInvalidoException;

public class Sistema {
	
	List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public void agregarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	
	public void comprar(Menu menu, LocalDate fechaDeEntrega, Cliente cliente, String descripcion, Proveedor proveedor) {
		if (puedeComprar(menu, cliente, fechaDeEntrega)){ 
			try{
				cliente.retirarCreditos(menu.getPrecio());
				proveedor.cargarCreditoNoDisponible(menu.getPrecio());
				//calcular tiempo de entrega (RELEASE 2)
				Pedido pedido = new Pedido(fechaDeEntrega, descripcion,menu, cliente);
				pedidos.add(pedido); // Futuro save de un servicio a la DB.
				// Enviar emails ( RELEASE 2 )
			}catch (Exception e) {}
		}
	}
	
	public Boolean puedeComprar(Menu menu, Cliente cliente, LocalDate fecha){
		return (cantDeVentasNoSuperada(menu) && cliente.puedeComprar() && esFechaValida(menu, fecha));
	}
	
	public Boolean cantDeVentasNoSuperada(Menu menu){
		// chekea si este menu no supera la cant de ventas maximas por dia.		
		//ArrayList<Pedido> pedidos = pedidosServicesImpl.getCantDePedidosPorMenu(menu);  ESTA ES LA IMPLEMENTACION REAL
		return (pedidos.size() < menu.getCantidadMaxVtasPorDia());
		// En este caso pedidos es TODOS los pedidos, no se realiza el filter ya que es una Query a DB. Se implementa para el prox release.
	}
	
	public Boolean esFechaValida(Menu menu, LocalDate fecha){
		// FALTA AGREGARLE LA LOGICA DE LOS FERIADOS
		LocalDate today = LocalDate.now();
		if(today.getDayOfWeek().equals(DayOfWeek.SATURDAY) || today.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			return false;
		}
		
		Duration diferencia = Duration.between(today, fecha); // throws an exception
		
		return (diferencia.toHours() < 48);
	}
	
	// DIEGO
	public double evaluarDiferenciaDinero(Menu menu) {
		// Cuando son las 00hs, no habria que setear la cantidad de vendidos en 0????
		if(menu.getCantidadVendidos() >= menu.getCantidadMinima() && menu.getCantidadVendidos() < menu.getCantidadMinima2()) {
			return menu.getPrecio() - menu.getPrecioCantidadMinima();
		}
		if(menu.getCantidadMinima2() >= menu.getCantidadVendidos()) {
			return menu.getPrecio() - menu.getPrecioCantidadMinima2();
		}
		return 0;
	}
	
	// DIEGO
	public void confirmarCompras() throws DatoInvalidoException {
		/*
		 IMPORTANTE: 
		 Cuando se confirman los pedidos se confirma por FECHA, es decir en esa fecha hay MUCHOS menues
		 y para cada menu hay que hacer una consulta para ver la cantidad que se vendio DE CADA UNO.
		 Se resuelve con querys a la base que realizan los servicios:
		 
		 1- Se les pide una lista de los menues que se vendieron por lo menos 1 en ese dia
		 2- Se realiza un for para cada menu
		 	FOR:
		 		3- se pide todos los pedidos para cada menu.
		 		4- se calcula el minimo alcanzado y se updatean los saldos en caso de ser necesario.

		 */
		for(Pedido pedido: this.pedidos) {
			if(pedido.getFechaCompra().plusDays(1).equals(LocalDate.now())) {
				pedido.getCliente().cargarCredito(evaluarDiferenciaDinero(pedido.getMenu()));
				pedido.getProveedor().retirarCreditosNoDisponibles(pedido.getMenu().getPrecio());
				pedido.getProveedor().cargarCredito(pedido.menu.getPrecio()-evaluarDiferenciaDinero(pedido.getMenu()));
			}
		}
		
		// POR ULTIMO: 
		this.evaluarMenu(pedidos);
		// IMPORTANTE: Revisar y pensar si vale la pena tener en menu una variable con su calificacion, 
		// y se recalcula con cada calificacion nueva.
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
