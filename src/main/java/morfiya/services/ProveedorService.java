package morfiya.services;

import java.util.List;
import morfiya.domain.Proveedor;

public class ProveedorService extends GenericService<Proveedor> {

	private static final long serialVersionUID = 2326320574811159527L;
	
	public List<Proveedor> getAll() {
		return getRepository().findAll();

	}

	public Proveedor getProveedorByID(Integer id) {
		return getRepository().findById(id);
	}

	public void crearProveedor(Proveedor proveedor) {
		getRepository().save(proveedor);
	}
	
	public void editarProveedor(Proveedor proveedor){
		getRepository().update(proveedor);
	}


}
