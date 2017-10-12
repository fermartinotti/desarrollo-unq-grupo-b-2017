package morfiya.services;

import java.util.List;
import morfiya.domain.Cliente;

public class ClienteService extends GenericService<Cliente> {

	private static final long serialVersionUID = 1L;

	public List<Cliente> getAll() {
		return getRepository().findAll();

	}

	public Cliente getClienteByID(Integer id) {
		return getRepository().findById(id);
	}

	public void crearCliente(Cliente cliente) {
		getRepository().save(cliente);
	}



}