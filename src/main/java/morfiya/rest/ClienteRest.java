package morfiya.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;

import morfiya.domain.Cliente;
import morfiya.exceptions.DatoInvalidoException;
import morfiya.services.ClienteService;


@Path("/clientes")
@Transactional
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
	
	@GET
	@Path("/cliente/{id}")
	@Produces("application/json")
	public Cliente getClienteByID(@PathParam("id") final Integer id){
		return service.getClienteByID(id);
	}
	
	
	@POST
	@Path("/create")
	public void createCliente(String clienteJson){
		Gson gson = new Gson();
		Cliente cliente = gson.fromJson(clienteJson,Cliente.class);
		service.crearCliente(cliente);
	}
	
	@PUT
	@Path("/edit/{id}")
	public void editCliente(String clienteJson){
		Gson gson = new Gson();
		Cliente cliente = gson.fromJson(clienteJson,Cliente.class);
		Cliente clienteEncontrado = service.getClienteByID(cliente.getId());
		try {
			clienteEncontrado.cargarCredito(cliente.getCreditos());
		} catch (DatoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.editarCliente(clienteEncontrado);
	}
	

}