package morfiya.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import morfiya.domain.Proveedor;
import morfiya.repositories.ProveedorDAO;

public class ProveedorService extends GenericService<Proveedor> {

	private static final long serialVersionUID = 2326320574811159527L;
	
	@Transactional
	public List<Proveedor> getAll() {
		return getRepository().findAll();
	}
	
	// CON paginacion
	@Transactional
	public List<Proveedor> getAllByPage(final int pageSize, final int pageNumber){
		return getRepository().getAllByPage(pageSize, pageNumber);
	}

	@Transactional
	public Proveedor getProveedorByID(Integer id) {
		return getRepository().findById(id);
	}
	
	@Transactional
	public Proveedor getProveedorByEmail(String email){
		return ((ProveedorDAO) getRepository()).findByEmail(email);
	}

	@Transactional
	public Proveedor crearProveedor(Proveedor proveedor) {
		return getRepository().save(proveedor);
	}
	
	@Transactional
	public void editarProveedor(Proveedor proveedor){
		getRepository().update(proveedor);
	}
	
	@Transactional
	public void deleteProveedor(Integer id){
		getRepository().deleteById(id);
	}


}
