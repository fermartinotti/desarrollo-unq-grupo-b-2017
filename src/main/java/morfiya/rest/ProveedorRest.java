package morfiya.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import morfiya.domain.Proveedor;
import morfiya.exceptions.DatoInvalidoException;
import morfiya.services.ProveedorService;

@Path("/proveedores")
@Transactional
public class ProveedorRest {

	ProveedorService service;
	

	public ProveedorService getService() {
		return service;
	}


	public void setService(ProveedorService service) {
		this.service = service;
	}


	@GET
	@Path("/todos")
	@Produces("application/json")
	public List<Proveedor> getAllProveedores(){
		return service.getAll();
		
	}
	
	@GET
	@Path("/proveedor/{id}")
	@Produces("application/json")
	public Proveedor getProveedorByID(@PathParam("id") final Integer id){
		return service.getProveedorByID(id);
	}
	
	
	@POST
	@Path("/create")
	public void createProveedor(String proveedorJson){
		Gson gson = new Gson();
		Proveedor proveedor = gson.fromJson(proveedorJson,Proveedor.class);
		service.crearProveedor(proveedor);
	}
	
	@PUT
	@Path("/editCreditos")
	public void editProveedor(String proveedorJson){
		Gson gson = new Gson();
		Proveedor proveedor = gson.fromJson(proveedorJson,Proveedor.class);
		Proveedor proveedorEncontrado = getProveedorByID(proveedor.getId());
		try {
			proveedorEncontrado.cargarCredito(proveedor.getCreditos());
		} catch (DatoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.editarProveedor(proveedorEncontrado);
	}
	

}
