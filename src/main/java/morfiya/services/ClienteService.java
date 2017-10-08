package morfiya.services;

import java.util.List;

import morfiya.baseDeDatosFake.ClienteBD;
import morfiya.domain.Cliente;
import morfiya.repositories.ClienteDAO;

public class ClienteService extends GenericService<Cliente>{

	private static final long serialVersionUID = 1L;
	
	ClienteDAO repository;
	
	ClienteBD clienteBD = new ClienteBD();
	
	/*
	ClienteDAO clienteDAO;
	
	public List<Cliente> getAll(){
		return clienteDAO.findAll();
		
	}
	
	public Cliente getClienteByID(Integer id) {
		return clienteDAO.findByID(id);
	}
*/
	public List<Cliente> getAll(){
		return repository.getAll();
		
	}
	
}
