package morfiya.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import morfiya.adapters.MenuGsonTypeAdapter;
import morfiya.adapters.MenuGsonTypeAdapterUpdate;
import morfiya.adapters.PedidoGsonTypeAdapter;
import morfiya.domain.Menu;
import morfiya.domain.Pedido;
import morfiya.domain.auth.AuthProfile;
import morfiya.exceptions.DatoInvalidoException;
import morfiya.services.CompraService;
import morfiya.services.MenuService;
import morfiya.updates.MenuUpdate;

@Path("/menus")
public class MenuRest {

	MenuService service;
	CompraService compraService;

	private final Integer pageSize = 10;

	public MenuService getService() {
		return service;
	}

	public void setService(MenuService service) {
		this.service = service;
	}
	
	public CompraService getCompraService() {
		return compraService;
	}

	public void setCompraService(CompraService compraService) {
		this.compraService = compraService;
	}

	// CON paginacion
	@GET
	@Path("/getAllPagination/{pageNumber}")
	@Produces("application/json")
	public Response getAllMenusPagination(@PathParam("pageNumber") final String pageNumber) {
		List<Menu> menus = service.getAllByPage(pageSize, Integer.parseInt(pageNumber));

		return Response.ok(menus).build();
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
	@Path("/getAllPedidos/{pageNumber}")
	@Produces("application/json")
	public Response getAllPedidosPagination(@PathParam("pageNumber") final String pageNumber) {
		List<Pedido> pedidos = compraService.getAllByPage(pageSize, Integer.parseInt(pageNumber));

		return Response.ok(pedidos).build();
	}
	
	// Sin paginacion
	@GET
	@Path("/getAllPedidos")
	@Produces("application/json")
	public Response getAllPedidos() {
		List<Pedido> menus = compraService.getAll();

		return Response.ok(menus).build();
	}

	// Con paginacion
	@GET
	@Path("/search")
	@Produces("application/json")
	public Response getMenuByNombreCategoriaYLocalidad(@QueryParam("nombre") final String nombre,
			@QueryParam("categoria") final String categoria, @QueryParam("localidad") final String localidad,
			@QueryParam("pageNumber") final String pageNumber) {

		try {
			if (nombre != null && categoria == null && localidad == null && pageNumber != null) {
				List<Menu> menu = service.findMenuForName(nombre, pageSize, Integer.parseInt(pageNumber));
				return Response.ok(menu).build();
			}

			if (nombre == null && categoria != null && localidad == null && pageNumber != null) {
				List<Menu> menu = service.findMenuForCategory(categoria, pageSize, Integer.parseInt(pageNumber));
				return Response.ok(menu).build();
			}

			if (nombre == null && categoria == null && localidad != null && pageNumber != null) {
				List<Menu> menu = service.findMenuForLocality(localidad, pageSize, Integer.parseInt(pageNumber));
				return Response.ok(menu).build();
			}

			if (nombre != null && categoria != null && localidad == null && pageNumber != null) {
				List<Menu> menu = service.findMenuForNameAndCategory(nombre, categoria, pageSize,
						Integer.parseInt(pageNumber));
				return Response.ok(menu).build();
			}

			if (nombre != null && categoria == null && localidad != null && pageNumber != null) {
				List<Menu> menu = service.findByNameAndLocality(nombre, localidad, pageSize,
						Integer.parseInt(pageNumber));
				return Response.ok(menu).build();
			}

			if (nombre == null && categoria != null && localidad != null && pageNumber != null) {
				List<Menu> menu = service.findByCategoryAndLocality(categoria, localidad, pageSize,
						Integer.parseInt(pageNumber));
				return Response.ok(menu).build();
			}

			if (nombre != null && categoria != null && localidad != null && pageNumber != null) {
				List<Menu> menu = service.findByNameCategoryAndLocality(nombre, categoria, localidad, pageSize,
						Integer.parseInt(pageNumber));
				return Response.ok(menu).build();
			}
			
			if(nombre == null && categoria == null && localidad == null && pageNumber != null){
				return Response.ok(service.getAllByPage(pageSize, Integer.parseInt(pageNumber))).build();
			}

			return Response.ok().build();

		}

		catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@POST
	@Path("/comprar/{cantidad}")
	@Produces("application/json")
	public Response crearPedido(@PathParam("cantidad") final Integer cantidad, String pedidoJson) {
		
		Gson gson = new GsonBuilder().registerTypeAdapter(Pedido.class, new PedidoGsonTypeAdapter()).create();
		Pedido pedido = gson.fromJson(pedidoJson, Pedido.class);
	
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode1 = mapper.createObjectNode();

		try {
			compraService.comprar(pedido, cantidad);
			return Response.ok().build();
			
		} catch (DatoInvalidoException e) {
			//return Response.serverError().entity(e.getMessage()).build();
			objectNode1.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(objectNode1.toString()).build();
		}
	}
	
	@POST
	@Path("/create")
	@Produces("application/json")
	public Response createMenu(String menuJson) {
		Gson gson = new GsonBuilder().registerTypeAdapter(Menu.class, new MenuGsonTypeAdapter()).create();

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode1 = mapper.createObjectNode();

		try {
			Menu menu = gson.fromJson(menuJson, Menu.class);
			Menu newMenu = service.crearMenu(menu);
			return Response.ok().entity(newMenu).build();
		} catch (DatoInvalidoException e) {
			objectNode1.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(objectNode1.toString()).build();
		}
	}
	
	@PUT
	@Path("/edit")
	public Response editMenu(String menuJson) {
		Gson gson = new GsonBuilder().registerTypeAdapter(MenuUpdate.class, new MenuGsonTypeAdapterUpdate()).create();
		MenuUpdate menu = gson.fromJson(menuJson, MenuUpdate.class);

		try {
			Menu menuEncontrado = service.findByID(menu.getId());
			menuEncontrado.actualizar(menu);
			service.editarMenu(menuEncontrado);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}

	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getMenu(@PathParam("id") final Integer id) {

		try {
			Menu menu = service.findByID(id);
			return Response.ok(menu).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

}
