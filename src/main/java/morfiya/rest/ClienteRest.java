package morfiya.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import morfiya.domain.Cliente;
import morfiya.repositories.ClienteDAO;
import morfiya.services.ClienteService;

@Path("/clientes")
public class ClienteRest {
	
	ClienteDAO repository;
		

	public ClienteDAO getRepository() {
		return repository;
	}


	public void setRepository(ClienteDAO repository) {
		this.repository = repository;
	}


	@GET
	@Path("/todos")
	@Produces("application/json")
	public List<Cliente> getAllClientes(){
		return repository.getAll();
		
	}
	
/*	@GET
	@Path("/calificaciones/{id}")
	@Produces("application/json")
	public Cliente getClienteByID(@PathParam("id") final Integer idUser){
		return clienteService.getClienteByID(idUser);
	}
*/	

}
