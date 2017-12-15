package morfiya.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import morfiya.domain.Cliente;
import morfiya.domain.EmailSender;
import morfiya.domain.Menu;
import morfiya.domain.Pedido;
import morfiya.domain.Proveedor;
import morfiya.repositories.ClienteDAO;
import morfiya.repositories.MenuDAO;
import morfiya.repositories.PedidoDAO;
import morfiya.repositories.ProveedorDAO;

public class CompraService extends GenericService<Pedido>{
	private static final long serialVersionUID = 1L;
	ClienteDAO clienteDAO;
	ProveedorDAO proveedorDAO;
	MenuDAO menuDAO;
	PedidoDAO pedidoDAO;
	
	
	@Transactional
	public MenuDAO getMenuDAO() {
		return menuDAO;
	}
	
	@Transactional
	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	@Transactional
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}
	
	@Transactional
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@Transactional
	public ProveedorDAO getProveedorDAO() {
		return proveedorDAO;
	}

	@Transactional
	public void setProveedorDAO(ProveedorDAO proveedorDAO) {
		this.proveedorDAO = proveedorDAO;
	}

	@Transactional
	public PedidoDAO getPedidoDAO() {
		return pedidoDAO;
	}

	@Transactional
	public void setPedidoDAO(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}

	@Transactional
	public void comprar(Pedido pedido) {
		Cliente cliente = clienteDAO.findById(pedido.getCliente().getId());
		Proveedor proveedor = proveedorDAO.findById(pedido.getProveedor().getId());
		Menu menu = menuDAO.findById(pedido.getMenu().getId());
		
		
		if (puedeComprar(menu, cliente))
		{ 
			try{
				
				cliente.retirarCreditos(menu.getPrecio() * pedido.getCantMenusPedidos());
				clienteDAO.update(cliente);
				proveedor.cargarCreditoNoDisponible(menu.getPrecio() * pedido.getCantMenusPedidos());
				proveedorDAO.update(proveedor);
				
				pedidoDAO.save(pedido); 
				EmailSender.sendEmail(cliente, "Email pruebas");
				
			}catch (Exception e) {
				
			}
		}
	}
	
	@Transactional
	public Boolean puedeComprar(Menu menu, Cliente cliente){
		return (cantDeVentasNoSuperada(menu) && cliente.puedeComprar());
	}
	
	@Transactional
	public Boolean cantDeVentasNoSuperada(Menu menu){
		
//		List<Pedido> pedidos = pedidoDAO.getCantDePedidosPorMenu(menu);
//		return (pedidos.size() < menu.getCantidadMaxVtasPorDia());
		return (menu.getCantidadVendidos() < menu.getCantidadMaxVtasPorDia());
	}
	
	@Transactional
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
