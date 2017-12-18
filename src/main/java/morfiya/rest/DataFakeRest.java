package morfiya.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import morfiya.domain.Categoria;
import morfiya.domain.Cliente;
import morfiya.domain.Direccion;
import morfiya.domain.Localidad;
import morfiya.domain.LocalizacionMapa;
import morfiya.domain.Menu;
import morfiya.domain.Proveedor;
import morfiya.domain.Servicio;
import morfiya.domain.builders.ClienteBuilder;
import morfiya.domain.builders.MenuBuilder;
import morfiya.domain.builders.ProveedorBuilder;
import morfiya.domain.builders.ServicioBuilder;
import morfiya.services.ClienteService;
import morfiya.services.ProveedorService;

@Path("/")
public class DataFakeRest {

	private ProveedorService serviceP;
	private ClienteService serviceC;

	public ProveedorService getServiceP() {
		return serviceP;
	}

	public void setServiceP(ProveedorService service) {
		this.serviceP = service;
	}

	public ClienteService getServiceC() {
		return serviceC;
	}

	public void setServiceC(ClienteService service) {
		this.serviceC = service;
	}

	@GET
	@Path("/load")
	@Produces("application/json")
	public Response load() {

		/////////////////////////////////////////////////// CLIENTE //////////////////////////////////////////////////////

		Direccion direccion1 = new Direccion(Localidad.ALMIRANTE_BROWN, "12 de octubre", 1234,
				new LocalizacionMapa(12, 15));
		Direccion direccion2 = new Direccion(Localidad.QUILMES, "Avenida Peron", 225, new LocalizacionMapa(22, 23));

		Cliente cliente1 = new ClienteBuilder().withCuit(123456).withNombreYApellido("Diego", "Maradona")
				.withEmail("d10s@gmail.com").withTelefono("011", "42100987").withCreditosDisponibles(15.0)
				.withDireccion(direccion1).build();

		Cliente cliente2 = new ClienteBuilder().withCuit(789123).withNombreYApellido("Juan Pablo", "Strah")
				.withEmail("strahjuanpablo@gmail.com").withTelefono("011", "42502345").withCreditosDisponibles(20.0)
				.withDireccion(direccion2).build();

		serviceC.crearCliente(cliente1);
		serviceC.crearCliente(cliente2);


		//////////////////////////////////////////// MENU /////////////////////////////////////////////////// 

		
		
		Menu menu1 = new MenuBuilder().withNombre("La mejor pizza del pais")
				.withDescripcion("Tiene la mejor muzarella de todas").withCategoria(Categoria.Pizza)
				.withValorDelivery(30.0).withFechaVigenciaDesdeYHasta("2017-12-05", "2017-12-20").withPrecio(80.00)
				.withCantidadMinima1y2(39, 50).withPrecioCantidadMinima1y2(70.00, 60.00).withCantidadMaxVtasPorDia(100)
				.build();

		Menu menu2 = new MenuBuilder().withNombre("Cerveza artesanal Irlandesa")
				.withDescripcion("Es la mejor birra del pais").withCategoria(Categoria.Cerveza).withValorDelivery(25.0)
				.withFechaVigenciaDesdeYHasta("2017-12-01", "2017-12-20").withPrecio(40.00).withCantidadMinima1y2(39, 50)
				.withPrecioCantidadMinima1y2(30.00, 25.00).withCantidadMaxVtasPorDia(100).build();
		
		Menu menu3 = new MenuBuilder().withNombre("Empanadas Morita")
				.withDescripcion("Empanadas con el mejor relleno").withCategoria(Categoria.Empanadas)
				.withValorDelivery(30.0).withFechaVigenciaDesdeYHasta("2017-12-05", "2017-12-12").withPrecio(80.00)
				.withCantidadMinima1y2(39, 50).withPrecioCantidadMinima1y2(70.00, 60.00).withCantidadMaxVtasPorDia(100)
				.build();

		Menu menu4 = new MenuBuilder().withNombre("Sushi Japones")
				.withDescripcion("El sushi numero 1 del pais").withCategoria(Categoria.Sushi).withValorDelivery(25.0)
				.withFechaVigenciaDesdeYHasta("2017-12-01", "2017-12-20").withPrecio(40.00).withCantidadMinima1y2(39, 50)
				.withPrecioCantidadMinima1y2(30.00, 25.00).withCantidadMaxVtasPorDia(100).build();
		
		
		//////////////////////////////////////////// SERVICIO /////////////////////////////////////////////////// 
		
		
		Servicio servicio1 = new ServicioBuilder().withNombre("Servicio Morfi Ya").withAgregarMenus(menu1).withAgregarMenus(menu2).withDireccion(direccion1).withDescripcion("Este es el mejor servicio del pais")
				.withLink("www.morfiya.com").withTelefono("011", "42531236").withLocalidad(Localidad.AVELLANEDA).withEmail("servicio1@hotmail.com")
				.build();
		
		Servicio servicio2 = new ServicioBuilder().withNombre("Servicio de QUILMES").withAgregarMenus(menu3).withAgregarMenus(menu4).withDireccion(direccion1).withDescripcion("Este es el mejor servicio de zona sur")
				.withLink("www.morfiya.com").withTelefono("011", "42531236").withLocalidad(Localidad.QUILMES).withEmail("servicio2@hotmail.com")
				.build();
		

		//////////////////////////// PROVEEDOR ////////////////

		Proveedor proveedor = new ProveedorBuilder().withNombre("Nicolas Robles").withServicio(servicio1)
				.withEmail("juanpablo.strah@retcon.com.ar").withCreditosDisponibles(20.00).build();
		
		Proveedor proveedor2 = new ProveedorBuilder().withNombre("Juan salvador Gaviota").withServicio(servicio2)
				.withEmail("jsg@gmail.com").withCreditosDisponibles(20.00).build();

		
		serviceP.crearProveedor(proveedor);
		serviceP.crearProveedor(proveedor2);
		
		return Response.ok().build();
	}
}
