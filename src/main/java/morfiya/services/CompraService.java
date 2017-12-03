package morfiya.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import morfiya.domain.Cliente;
import morfiya.domain.EmailSender;
import morfiya.domain.Menu;
import morfiya.domain.Pedido;
import morfiya.domain.Proveedor;
import morfiya.repositories.ClienteDAO;
import morfiya.repositories.PedidoDAO;
import morfiya.repositories.ProveedorDAO;

public class CompraService extends GenericService<Pedido>{
	private static final long serialVersionUID = 1L;
	ClienteDAO clienteDAO;
	ProveedorDAO proveedorDAO;
	PedidoDAO pedidoDAO;
	
	@Transactional
	public void comprar(Menu menu, Integer cantidad, LocalDate fechaDeEntrega, Cliente cliente, String descripcion, Proveedor proveedor) {
		if (puedeComprar(menu, cliente, fechaDeEntrega))
		{ 
			try{
				
				cliente.retirarCreditos(menu.getPrecio() * cantidad);
				clienteDAO.save(cliente);
				proveedor.cargarCreditoNoDisponible(menu.getPrecio() * cantidad);
				proveedorDAO.save(proveedor);
				Pedido pedido = new Pedido(fechaDeEntrega, descripcion,menu, cliente);
				pedidoDAO.save(pedido); 
				EmailSender.sendEmail(cliente, descripcion);
				
			}catch (Exception e) {
				
			}
		}
	}
	
	public Boolean puedeComprar(Menu menu, Cliente cliente, LocalDate fechaDeEntrega){
		return (cantDeVentasNoSuperada(menu) && cliente.puedeComprar() && esFechaValida(fechaDeEntrega));
	}
	
	public Boolean cantDeVentasNoSuperada(Menu menu){
		
		List<Pedido> pedidos = pedidoDAO.getCantDePedidosPorMenu(menu);
		return (pedidos.size() < menu.getCantidadMaxVtasPorDia());
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
	
	

}
