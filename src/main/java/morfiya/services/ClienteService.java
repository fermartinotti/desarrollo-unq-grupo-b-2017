package morfiya.services;

import java.util.List;

import morfiya.domain.Cliente;
import morfiya.repositories.ClienteDAO;

public class ClienteService extends GenericService<Cliente>{

	private static final long serialVersionUID = 1L;
	
	ClienteDAO clienteDAO;
	
	public List<Cliente> getAll(){
		return clienteDAO.findAll();
		
	}
	
	public Cliente getClienteByID(Integer id) {
		return clienteDAO.findByID(id);
	}

}
