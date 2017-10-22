package morfiya.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import morfiya.domain.Menu;
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
	@Path("/getAll")
	@Produces("application/json")
	public Response getAllMenus() {
		List<Menu> menus = service.getAll();

		return Response.ok(menus).build();

	}
	
	@POST
	@Path("/create")
	public Response createMenu(String menuJson) {
		Gson gson = new Gson();
		Menu menu = gson.fromJson(menuJson, Menu.class);
		
		try {
			service.crearMenu(menu);
			return Response.ok().build();
			
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

}
