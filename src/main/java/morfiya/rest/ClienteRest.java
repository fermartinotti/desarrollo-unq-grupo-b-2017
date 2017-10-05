package morfiya.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import morfiya.domain.Cliente;
import morfiya.services.ClienteService;

public class ClienteRest {
	
	ClienteService clienteService;
	
	
	
	@GET
	@Path("/calificaciones")
	@Produces("application/json")
	public List<Cliente> getAllClientes(){
		return clienteService.getAll();
		
	}
	
/*	@GET
	@Path("/calificaciones/{id}")
	@Produces("application/json")
	public Cliente getClienteByID(@PathParam("id") final Integer idUser){
		return clienteService.getClienteByID(idUser);
	}
*/	

}
