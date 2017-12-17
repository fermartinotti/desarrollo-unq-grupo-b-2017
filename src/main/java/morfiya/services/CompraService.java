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
import morfiya.exceptions.DatoInvalidoException;
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
	public List<Pedido> getAllByPage(final int pageSize, final int pageNumber){
		return pedidoDAO.getAllByPage(pageSize, pageNumber);
	}
	
	@Transactional
	public List<Pedido> getAll() {
		return pedidoDAO.findAll();
	}

	@Transactional
	public void comprar(Pedido pedido, Integer cantidad) {
		Cliente cliente = clienteDAO.findByEmail(pedido.getCliente().getEmail());
		Proveedor proveedor = proveedorDAO.findByEmail(pedido.getProveedor().getEmail());
		Menu menu = menuDAO.findMenuByName(pedido.getMenu().getNombre());
		
		// Esto es solo para probar
		////////////////////////////////////////////////
		cliente.cargarCredito(50000.00);
		proveedor.cargarCreditoNoDisponible(2000.00);
		////////////////////////////////////////////////
		
		if (! (puedeComprar(menu, cliente, cantidad) &&  estaVigenteMenuYEsDiaDeSemana(pedido.getFechaDeEntrega(), menu.getFechaVigenciaDesde(), menu.getFechaVigenciaHasta()))){
			throw new DatoInvalidoException("No se puede realizar la compra");
		}	
			try{
				Double precioFinalMenu = ((Double) menu.getPrecio() * cantidad) - (evaluarDiferenciaDinero(menu, cantidad) * cantidad);
				
				cliente.retirarCreditos(precioFinalMenu);
				clienteDAO.update(cliente);
				proveedor.cargarCreditoNoDisponible(precioFinalMenu);
				proveedorDAO.update(proveedor);
				
				pedidoDAO.save(pedido); 
				EmailSender.sendEmail(cliente, "Email pruebas");
				
			}catch (Exception e) {}
	}
	
	@Transactional
	public Double evaluarDiferenciaDinero(Menu menu, Integer cantVendidos) {

		if(cantVendidos >= menu.getCantidadMinima() && cantVendidos < menu.getCantidadMinima2()) {
			return menu.getPrecio() - menu.getPrecioCantidadMinima();
		}
		if(cantVendidos >= menu.getCantidadMinima2() ) {
			return menu.getPrecio() - menu.getPrecioCantidadMinima2();
		}
		return 0.0;
	}
	
	@Transactional
	public Boolean puedeComprar(Menu menu, Cliente cliente, Integer cantidad){
		return (cantDeVentasNoSuperada(menu, cantidad) && cliente.puedeComprar() && cliente.getCreditos() >= (menu.getPrecio() * cantidad));
	}
	
	@Transactional
	public Boolean cantDeVentasNoSuperada(Menu menu, Integer cantidad){
		return (cantidad < menu.getCantidadMaxVtasPorDia());
	}
	
	@Transactional
	public Boolean estaVigenteMenuYEsDiaDeSemana(LocalDate fechaEntrega, LocalDate fechaD, LocalDate fechaH){
		return (fechaEntrega.isAfter(fechaD) || fechaD.equals(fechaEntrega)) && 
				(fechaEntrega.isBefore(fechaH) || fechaH.equals(fechaEntrega)) && 
				(fechaEntrega.getDayOfWeek() != DayOfWeek.SUNDAY && fechaEntrega.getDayOfWeek() != DayOfWeek.SATURDAY);
	
		
	
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
