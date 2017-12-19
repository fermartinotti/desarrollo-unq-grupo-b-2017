package morfiya.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.springframework.test.context.ContextConfiguration;

import com.google.gson.Gson;

import morfiya.domain.Cliente;
import morfiya.services.ClienteService;
import morfiya.updates.ClienteUpdate;

@Path("/clientes")
public class ClienteRest {

	private ClienteService service;
	private final Integer pageSize = 10;

	public ClienteService getService() {
		return service;
	}

	public void setService(ClienteService service) {
		this.service = service;
	}

	@GET
	@Path("/getAll")
	@Produces("application/json")
	public Response getAllClientes() {
		List<Cliente> clientes = service.getAll();

		return Response.ok(clientes).build();
	}

	@GET
	@Path("/getAllPagination/{pageNumber}")
	@Produces("application/json")
	public Response getAllClientesPagination(@PathParam("pageNumber") final String pageNumber) {
		List<Cliente> clientes = service.getAllByPage(pageSize, Integer.parseInt(pageNumber));

		return Response.ok(clientes).build();
	}

	@GET
	@Path("/getById/{id}")
	@Produces("application/json")
	public Response getClienteByID(@PathParam("id") final Integer id) {

		try {
			Cliente cliente = service.getClienteByID(id);
			return Response.ok(cliente).build();
		}

		catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
    
	@GET
	@Path("/getByEmail/{email}")
	@Produces("application/json")
	public Response getClienteByEmail(@PathParam("email") final String email) {
		try {
			Cliente cliente = service.getClienteByEmail(email);
			return Response.ok(cliente).build();
		}

		catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("/getCreditos/{id}")
	@Produces("application/json")
	public Response getCreditosCliente(@PathParam("id") final Integer id) {

		try {
			Cliente cliente = service.getClienteByID(id);
			return Response.ok(cliente.getCreditos()).build();
		}

		catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	

	@POST
	@Path("/create")
	@Produces("application/json")
	public Response createCliente(String clienteJson) {
		Gson gson = new Gson();
		Cliente cliente = gson.fromJson(clienteJson, Cliente.class);
		Cliente newCliente = service.crearCliente(cliente);

		return Response.ok().entity(newCliente).build();
	}

	@PUT
	@Path("/cargarCreditos")
	public Response cargarCreditosCliente(String clienteJson) {
		Gson gson = new Gson();
		Cliente cliente = gson.fromJson(clienteJson, Cliente.class);

		try {
			Cliente clienteEncontrado = service.getClienteByID(cliente.getId());
			clienteEncontrado.cargarCredito(cliente.getCreditos());
			service.editarCliente(clienteEncontrado);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@PUT
	@Path("/retirarCreditos")
	public Response retirarCreditosCliente(String clienteJson) {
		Gson gson = new Gson();
		Cliente cliente = gson.fromJson(clienteJson, Cliente.class);

		try {
			Cliente clienteEncontrado = service.getClienteByID(cliente.getId());
			clienteEncontrado.retirarCreditos(cliente.getCreditos());
			service.editarCliente(clienteEncontrado);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	
	// No edito el credito ya que tiene su propio servicio
	@PUT
	@Path("/edit")
	public Response editCliente(String clienteJson) {
		Gson gson = new Gson();
		ClienteUpdate cliente = gson.fromJson(clienteJson, ClienteUpdate.class);

		try {
			Cliente clienteEncontrado = service.getClienteByID(cliente.getId());
			clienteEncontrado.actualizar(cliente);
			service.editarCliente(clienteEncontrado);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}

	}

	@DELETE
	@Path("/delete/{id}")
	@Produces("application/json")
	public Response deleteCliente(@PathParam("id") Integer id) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode1 = mapper.createObjectNode();
		try {
			service.deleteCliente(id);
			objectNode1.put("id", new Long(id));
			return Response.ok(objectNode1.toString()).build();
		} catch (IllegalArgumentException e) {
			ObjectNode objectNode2 = mapper.createObjectNode();
			objectNode2.put("onDelete", e.getMessage());
			ArrayNode arrayNode = mapper.createArrayNode();
			arrayNode.add(objectNode2);
			objectNode1.put("errors", arrayNode);
			return Response.status(Response.Status.BAD_REQUEST).entity(objectNode1.toString()).build();
		}
	}

}