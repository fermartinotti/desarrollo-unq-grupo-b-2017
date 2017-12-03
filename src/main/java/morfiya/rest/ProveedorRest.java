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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import morfiya.adapters.MenuGsonTypeAdapter;
import morfiya.domain.Menu;
import morfiya.domain.Proveedor;
import morfiya.services.ProveedorService;
import morfiya.updates.ProveedorUpdate;

@Path("/proveedores")
public class ProveedorRest {

	private ProveedorService service;
	private final Integer pageSize = 10;

	public ProveedorService getService() {
		return service;
	}

	public void setService(ProveedorService service) {
		this.service = service;
	}

	@GET
	@Path("/getAll")
	@Produces("application/json")
	public Response getAllProveedores() {
		List<Proveedor> proveedores = service.getAll();

		return Response.ok(proveedores).build();
	}

	@GET
	@Path("/getAllPagination/{pageNumber}")
	@Produces("application/json")
	public Response getAllProveedoresPagination(@PathParam("pageNumber") final String pageNumber) {
		List<Proveedor> proveedores = service.getAllByPage(pageSize, Integer.parseInt(pageNumber));

		return Response.ok(proveedores).build();

	}

	@GET
	@Path("/getById/{id}")
	@Produces("application/json")
	public Response getProveedorByID(@PathParam("id") final Integer id) {
		try {
			Proveedor proveedor = service.getProveedorByID(id);
			return Response.ok(proveedor).build();
		}

		catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("/getByEmail/{email}")
	@Produces("application/json")
	public Response getProveedorByEmail(@PathParam("email") final String email) {
		try {
			Proveedor proveedor = service.getProveedorByEmail(email);
			return Response.ok(proveedor).build();
		}

		catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/getCreditos/{id}")
	@Produces("application/json")
	public Response getCreditosProveedor(@PathParam("id") final Integer id) {

		try {
			Proveedor proveedor = service.getProveedorByID(id);
			return Response
					.ok("Los créditos del proveedor " + proveedor.getNombre() + " son: " + proveedor.getCreditos())
					.build();
		}

		catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@POST
	@Path("/create")
	public Response createProveedor(String proveedorJson) {
		Gson gson = new Gson();
		Proveedor proveedor = gson.fromJson(proveedorJson, Proveedor.class);
		service.crearProveedor(proveedor);

		return Response.ok().build();
	}

	@PUT
	@Path("/cargarCreditos")
	public Response cargarCreditosProveedor(String proveedorJson) {
		Gson gson = new Gson();
		Proveedor proveedor = gson.fromJson(proveedorJson, Proveedor.class);

		try {
			Proveedor proveedorEncontrado = service.getProveedorByID(proveedor.getId());
			proveedorEncontrado.cargarCredito(proveedor.getCreditos());
			service.editarProveedor(proveedorEncontrado);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@PUT
	@Path("/retirarCreditos")
	public Response retirarCreditosProveedor(String proveedorJson) {
		Gson gson = new Gson();
		Proveedor proveedor = gson.fromJson(proveedorJson, Proveedor.class);

		try {
			Proveedor proveedorEncontrado = service.getProveedorByID(proveedor.getId());
			proveedorEncontrado.retirarCreditos(proveedor.getCreditos());
			service.editarProveedor(proveedorEncontrado);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	// No edito el credito ya que tiene su propio servicio
	// Edito solo el nombre
	@PUT
	@Path("/edit")
	public Response editProovedor(String proveedorJson) {
		Gson gson = new Gson();
		ProveedorUpdate proveedor = gson.fromJson(proveedorJson, ProveedorUpdate.class);

		try {
			Proveedor proveedorEncontrado = service.getProveedorByID(proveedor.getId());
			proveedorEncontrado.actualizar(proveedor);
			service.editarProveedor(proveedorEncontrado);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces("application/json")
	public Response deleteProveedor(@PathParam("id") Integer id) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode1 = mapper.createObjectNode();
		try {
			service.deleteProveedor(id);
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
	
	 @PUT
	 
	  @Path("/agregarMenu/{id}")
	 
	  public Response agregarMenu(@PathParam("id") final Integer id, String menuJson) {
		 
		 Gson gson = new GsonBuilder().registerTypeAdapter(Menu.class, new MenuGsonTypeAdapter()).create();
		 Menu menu = gson.fromJson(menuJson, Menu.class);
	 
		 try {
	 
	      Proveedor proveedorEncontrado = service.getProveedorByID(id);
	      proveedorEncontrado.agregarMenu(menu);
	      service.editarProveedor(proveedorEncontrado);
	 
	      return Response.ok().build();
	 
	    } catch (Exception e) {
	 
	      return Response.serverError().entity(e.getMessage()).build();
	 
	    }
	 
	  }  
	 
}
