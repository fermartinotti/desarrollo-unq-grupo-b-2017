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
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import morfiya.adapters.MenuGsonTypeAdapter;
import morfiya.domain.Menu;
import morfiya.exceptions.DatoInvalidoException;
import morfiya.services.MenuService;

@Path("/menus")
@Transactional
public class MenuRest {

	MenuService service;
	private final Integer pageSize = 10;

	public MenuService getService() {
		return service;
	}

	public void setService(MenuService service) {
		this.service = service;
	}
	
    // Con paginacion 
	@GET
	@Path("/getByNombre/{nombre}/{pageNumber}")
	@Produces("application/json")
	public Response getMenuByName(@PathParam("nombre") final String nombre, @PathParam("pageNumber") final String pageNumber) {
		try {
			List<Menu> menu = service.findMenuForName(nombre, pageSize, Integer.parseInt(pageNumber));
			return Response.ok(menu).build();
		}

		catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	
    // Con paginacion 
	@GET
	@Path("/getByCategoria/{categoria}/{pageNumber}")
	@Produces("application/json")
	public Response getMenuByCategoria(@PathParam("categoria") final String categoria, @PathParam("pageNumber") final String pageNumber) {
		try {
			List<Menu> menu = service.findMenuForCategory(categoria, pageSize, Integer.parseInt(pageNumber));
			return Response.ok(menu).build();
		}

		catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	
	
	// Sin paginacion
	@GET
	@Path("/getAll")
	@Produces("application/json")
	public Response getAllMenus() {
		List<Menu> menus = service.getAll();

		return Response.ok(menus).build();
	}
	
	
	// CON paginacion
	@GET
	@Path("/getAllPagination/{pageNumber}")
	@Produces("application/json")
	public Response getAllMenusPagination(@PathParam("pageNumber") final String pageNumber) {
		List<Menu> menus = service.getAllByPage(pageSize, Integer.parseInt(pageNumber));

		return Response.ok(menus).build();
	}

	@POST
	@Path("/create")
	public Response createMenu(String menuJson) {
		Gson gson = new GsonBuilder().registerTypeAdapter(Menu.class, new MenuGsonTypeAdapter()).create();

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode1 = mapper.createObjectNode();

		try {
			Menu menu = gson.fromJson(menuJson, Menu.class);
			service.crearMenu(menu);
			return Response.ok().build();
		} catch (DatoInvalidoException e) {
			objectNode1.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(objectNode1.toString()).build();
		}
	}
}
