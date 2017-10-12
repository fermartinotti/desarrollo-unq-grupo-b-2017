package morfiya.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.springframework.web.bind.annotation.RequestBody;

import morfiya.domain.Cliente;
import morfiya.services.ClienteService;


@Path("/clientes")
public class ClienteRest {
	
	ClienteService service;
		

	public ClienteService getService() {
		return service;
	}


	public void setService(ClienteService service) {
		this.service = service;
	}


	@GET
	@Path("/todos")
	@Produces("application/json")
	public List<Cliente> getAllClientes(){
		return service.getAll();
		
	}
	
/*	@GET
	@Path("/calificaciones/{id}")
	@Produces("application/json")
	public Cliente getClienteByID(@PathParam("id") final Integer idUser){
		return clienteService.getClienteByID(idUser);
	}
*/	
	
	@POST
	@Path("/create")
	@Produces("application/json")
	public void createCliente(@Multipart(value = "jsonRequest", type = "application/json")
	Cliente cliente){
		service.crearCliente(cliente);
		
	}
	
	

}