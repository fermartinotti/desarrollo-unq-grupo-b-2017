package morfiya.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import morfiya.domain.Cliente;
import morfiya.domain.Direccion;
import morfiya.domain.Localidad;
import morfiya.domain.LocalizacionMapa;
import morfiya.domain.builders.ClienteBuilder;
import morfiya.services.ClienteService;

@Path("/")
public class DataFakeRest {

	// private MenuService menuService;
	// private ProveedorService proveedorService;
	ClienteService service;
	
	@GET
	@Path("/load")
	@Produces("application/json")
	public Response load(){

	Direccion direccion = new Direccion(Localidad.ALMIRANTE_BROWN, "12 de octubre", 1234, new LocalizacionMapa(12, 15));

	Cliente cliente1 = new ClienteBuilder().withCuit(123456).withNombreYApellido("Diego", "Maradona").withEmail("d10s@gmail.com")
			.withTelefono("011", "42100987").withCreditosDisponibles(15.0).withDireccion(direccion).build();
	
	
	service.crearCliente(cliente1);
	
	return Response.ok().build();
	}
}
