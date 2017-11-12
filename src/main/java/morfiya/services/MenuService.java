package morfiya.services;

import java.io.Serializable;
import java.util.List;

import morfiya.domain.Menu;
import morfiya.repositories.*;

public class MenuService extends GenericService<Menu> {

	private static final long serialVersionUID = -7961010215734577876L;

	public List<Menu> getAll() {
		return getRepository().findAll();
	}

	public void crearMenu(Menu menu) {
		getRepository().save(menu);
	}
	
	public List<Menu> findMenuForCategory(String categoria,final Integer pageSize, final Integer pageNumber) {
		return ((MenuDAO) getRepository()).findByCategoria(categoria, pageSize, pageNumber);
	}
	
	public List<Menu> findMenuForName(Serializable nombre,final Integer pageSize, final Integer pageNumber) {
		return ((MenuDAO) getRepository()).findByName(nombre, pageSize, pageNumber);
	}
	
	public List<Menu> getAllByPage(final int pageSize, final int pageNumber){
		return getRepository().getAllByPage(pageSize, pageNumber);
	}
}