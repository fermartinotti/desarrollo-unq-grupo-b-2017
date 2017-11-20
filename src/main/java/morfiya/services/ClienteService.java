package morfiya.services;

import java.util.List;
import morfiya.domain.Cliente;
import morfiya.repositories.ClienteDAO;

public class ClienteService extends GenericService<Cliente> {

	private static final long serialVersionUID = 1L;

	// Sin paginacion
	public List<Cliente> getAll() {
		return getRepository().findAll();
	}
	
	// CON paginacion
	public List<Cliente> getAllByPage(final int pageSize, final int pageNumber){
		return getRepository().getAllByPage(pageSize, pageNumber);
	}
	
	public Cliente getClienteByID(Integer id) {
		return getRepository().findById(id);
	}
	
	public Cliente getClienteByEmail(String email){
		return ((ClienteDAO) getRepository()).findByEmail(email);
	}

	public void crearCliente(Cliente cliente) {
		getRepository().save(cliente);
	}
	
	public void editarCliente(Cliente cliente){
		getRepository().update(cliente);
	}
	
	public void deleteCliente(Integer id){
		getRepository().deleteById(id);
	}
}