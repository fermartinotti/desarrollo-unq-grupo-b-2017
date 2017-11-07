package morfiya.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import morfiya.exceptions.DatoInvalidoException;

public class Sistema {
	private EmailSender emailSender = new EmailSender();
	List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void agregarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public void comprar(Menu menu, Integer cantidad, LocalDate fechaDeEntrega, Cliente cliente, String descripcion, Proveedor proveedor) {
		if (puedeComprar(menu, cliente, fechaDeEntrega)){ 
			try{
				cliente.retirarCreditos(menu.getPrecio() * cantidad);
				proveedor.cargarCreditoNoDisponible(menu.getPrecio() * cantidad);
				//calcular tiempo de entrega (RELEASE 2)
				Pedido pedido = new Pedido(fechaDeEntrega, descripcion,menu, cliente);
				pedidos.add(pedido); // Futuro save de un servicio a la DB.
				emailSender.sendEmaill(cliente, descripcion);
			}catch (Exception e) {}
		}
	}

	public Boolean puedeComprar(Menu menu, Cliente cliente, LocalDate fechaDeEntrega){
		return (cantDeVentasNoSuperada(menu) && cliente.puedeComprar() && esFechaValida(fechaDeEntrega));
	}
	
	public Boolean cantDeVentasNoSuperada(Menu menu){
		// chekea si este menu no supera la cant de ventas maximas por dia.		
		//ArrayList<Pedido> pedidos = pedidosServicesImpl.getCantDePedidosPorMenu(menu);  ESTA ES LA IMPLEMENTACION REAL
		return (pedidos.size() < menu.getCantidadMaxVtasPorDia());
		// En este caso pedidos es TODOS los pedidos, no se realiza el filter ya que es una Query a DB. Se implementa para el prox release.
	}
	
	public Boolean esFechaValida(LocalDate fecha) {
		int diffDays= 0;
		LocalDate today = LocalDate.now();
		  //mientras la fecha inicial sea menor o igual que la fecha final se cuentan los dias
		  while (today.isBefore(fecha) || today.equals(fecha)) {
			  if (today.getDayOfWeek() != DayOfWeek.SUNDAY || today.getDayOfWeek() != DayOfWeek.SATURDAY) {
				  diffDays++;
			  }
			  today = today.plusDays(1);
		  }
		return diffDays > 2;
	}

	public double evaluarDiferenciaDinero(Menu menu, int cantVendidos) {

		if(cantVendidos >= menu.getCantidadMinima() && cantVendidos < menu.getCantidadMinima2()) {
			return menu.getPrecio() - menu.getPrecioCantidadMinima();
		}
		if(cantVendidos >= menu.getCantidadMinima2() ) {
			return menu.getPrecio() - menu.getPrecioCantidadMinima2();
		}
		return 0;
	}
	
	public void confirmarCompras() throws DatoInvalidoException {
	// Se deberia hacer un for para cada menu comprado en X dia -> Esto me da una lista de pedidos de X menu realizados X dia.
	// Al resolverse con consultas a la db se agrega en release 2.
		
		for(Pedido pedido: this.pedidos) {
			
			Double precioMenu = pedido.getMenu().getPrecio();
			Double diferenciaDePrecio = evaluarDiferenciaDinero(pedido.getMenu(), pedidos.size());
			
			if(pedido.getFechaCompra().plusDays(1).equals(LocalDate.now())) {
				pedido.getCliente().cargarCredito(diferenciaDePrecio);
				pedido.getProveedor().retirarCreditosNoDisponibles(precioMenu);
				pedido.getProveedor().cargarCredito(precioMenu-diferenciaDePrecio);
			}
		}

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
