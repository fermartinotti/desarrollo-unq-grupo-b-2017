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
import morfiya.domain.Cliente;
import morfiya.domain.Menu;
import morfiya.exceptions.DatoInvalidoException;
import morfiya.services.MenuService;

@Path("/menus")
@Transactional
public class MenuRest {

	MenuService service;

	public MenuService getService() {
		return service;
	}

	public void setService(MenuService service) {
		this.service = service;
	}
	
	@GET
	@Path("/getByNombre")
	@Produces("application/json")
	public Response getMenuByName(final String nombre) {

		try {
			Menu menu = service.findMenuForName(nombre);
			return Response.ok(menu).build();
		}

		catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	

	@GET
	@Path("/getAll")
	@Produces("application/json")
	public Response getAllMenus() {
		List<Menu> menus = service.getAll();

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
