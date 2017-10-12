package morfiya.services;

import java.util.List;
import morfiya.domain.Cliente;
import morfiya.repositories.ClienteDAO;

public class ClienteService extends GenericService<Cliente>{

	private static final long serialVersionUID = 1L;
	
	ClienteDAO repository;
	
	public List<Cliente> getAll(){
		return repository.findAll();
		
	}
	
	public Cliente getClienteByID(Integer id) {
		return repository.findByID(id);
	}
	
	public Cliente crearCliente(Integer cuit, String nombre, String apellido, String email){
		return repository.createCliente(cuit, nombre, apellido, email);
	}

//	public List<Cliente> getAll(){
//		return repository.getAll();
//		
//	}
	
}