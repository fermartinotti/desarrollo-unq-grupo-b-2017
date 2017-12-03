package morfiya.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import morfiya.domain.Proveedor;
import morfiya.repositories.ProveedorDAO;

@Transactional
public class ProveedorService extends GenericService<Proveedor> {

	private static final long serialVersionUID = 2326320574811159527L;
	
	public List<Proveedor> getAll() {
		return getRepository().findAll();
	}
	
	// CON paginacion
	public List<Proveedor> getAllByPage(final int pageSize, final int pageNumber){
		return getRepository().getAllByPage(pageSize, pageNumber);
	}

	public Proveedor getProveedorByID(Integer id) {
		return getRepository().findById(id);
	}
	
	public Proveedor getProveedorByEmail(String email){
		return ((ProveedorDAO) getRepository()).findByEmail(email);
	}

	public Proveedor crearProveedor(Proveedor proveedor) {
		return getRepository().save(proveedor);
	}
	
	public void editarProveedor(Proveedor proveedor){
		getRepository().update(proveedor);
	}
	
	public void deleteProveedor(Integer id){
		getRepository().deleteById(id);
	}


}
