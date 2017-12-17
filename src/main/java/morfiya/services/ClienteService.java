package morfiya.services;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import morfiya.domain.Cliente;
import morfiya.repositories.ClienteDAO;

public class ClienteService extends GenericService<Cliente> {

	private static final long serialVersionUID = 1L;
	
	// Sin paginacion
	@Transactional
	public List<Cliente> getAll() {
		return getRepository().findAll();
	}
	
	// CON paginacion
	@Transactional
	public List<Cliente> getAllByPage(final int pageSize, final int pageNumber){
		return getRepository().getAllByPage(pageSize, pageNumber);
	}
	
	@Transactional
	public Cliente getClienteByID(Integer id) {
		return getRepository().findById(id);
	}
	
	@Transactional
	public Cliente getClienteByEmail(String email){
		return ((ClienteDAO) getRepository()).findByEmail(email);
	}

	@Transactional
	public Cliente crearCliente(Cliente cliente) {
		return getRepository().save(cliente);
	}
	
	@Transactional
	public void editarCliente(Cliente cliente){
		getRepository().update(cliente);
	}
	
	@Transactional
	public void deleteCliente(Integer id){
		getRepository().deleteById(id);
	}

	@Transactional
	public Double getClienteCreditos() {
		Cliente cliente = authService.getCliente();
		return cliente.getCreditos();
	}
	
	@Transactional
	public void cargarCreditosCliente(Double credito) {
		Cliente cliente = authService.getCliente();
		Double current = cliente.getCreditos();
		cliente.setCreditos(current + credito);
		this.getRepository().update(cliente);
	}
}