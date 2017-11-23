package morfiya.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import morfiya.adapters.ServicioGsonTypeAdapter;
import morfiya.domain.Menu;
import morfiya.domain.Servicio;
import morfiya.exceptions.DatoInvalidoException;
import morfiya.services.ServicioService;

@Path("/servicios")
public class ServicioRest {

	ServicioService service;
	private final Integer pageSize = 10;

	public ServicioService getService() {
		return service;
	}

	public void setService(ServicioService service) {
		this.service = service;
	}

	// Sin paginacion
	@GET
	@Path("/getAll")
	@Produces("application/json")
	public Response getAllServicios() {
		List<Servicio> servicios = service.getAll();

		return Response.ok(servicios).build();
	}

	// CON paginacion
	@GET
	@Path("/getAllPagination/{pageNumber}")
	@Produces("application/json")
	public Response getAllServiciosPagination(@PathParam("pageNumber") final String pageNumber) {
		List<Servicio> servicios = service.getAllByPage(pageSize, Integer.parseInt(pageNumber));

		return Response.ok(servicios).build();
	}

	// Con paginacion
	@GET
	@Path("/getByLocalidad/{localidad}/{pageNumber}")
	@Produces("application/json")
	 public Response getMenuByLocalidad(@PathParam("localidad") final String localidad, @PathParam("pageNumber") final String pageNumber) {
		try {
			List<Menu> menu = service.findMenuForLocalidad(localidad,pageSize, Integer.parseInt(pageNumber));
			return Response.ok(menu).build();
		}

		catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@POST
	@Path("/create")
	public Response createServicio(String servicioJson) {
		Gson gson = new GsonBuilder().registerTypeAdapter(Servicio.class, new ServicioGsonTypeAdapter()).create();

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode1 = mapper.createObjectNode();

		try {
			Servicio servicio = gson.fromJson(servicioJson, Servicio.class);
			service.crearServicio(servicio);
			return Response.ok().build();
		} catch (DatoInvalidoException e) {
			objectNode1.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(objectNode1.toString()).build();
		}
	}
}
